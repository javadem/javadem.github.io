package ua.controller.admin;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.inject.Inject;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import static ua.service.utils.ParamBuilder.getParams;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;



import ua.dto.filter.BasicFilter;
import ua.entity.Category;
import ua.service.CategoryService;
import ua.validator.CategoryValidator;


@Controller
@RequestMapping("/admin/category")
@SessionAttributes(names="category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
//	@Autowired
//	private TypeProductService typeProductService;
	
	
	@Inject
	public CategoryController(CategoryService categoryService) {
		super();
		this.categoryService = categoryService;
	}


	
	public CategoryService getCategoryService() {
		return categoryService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	
	@InitBinder("category")
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new CategoryValidator(categoryService));
	}
	
	@ModelAttribute("category")
	public Category getForm(){
		return new Category();
	}
	
	@ModelAttribute("filter")
	public BasicFilter getFilter(){
		return new BasicFilter();
}
	
	@RequestMapping
	public String show(SessionStatus status, Model model, @ModelAttribute("filter") BasicFilter filter, @PageableDefault Pageable pageable){
//		model.addAttribute("categories", categoryService.findAll());
//		model.addAttribute("page", categoryService.findAll(pageable));
		model.addAttribute("page", categoryService.findAll( filter, pageable));
		return "admin-category";
	}


	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id, @ModelAttribute("filter") BasicFilter filter, @PageableDefault Pageable pageable){
		categoryService.delete(id);
		return "redirect:/admin/category"+getParams(pageable, filter);
	}

	
	@RequestMapping(method=POST)
	public String save(@ModelAttribute("category") @Valid Category form, BindingResult br, SessionStatus status, Model model, @ModelAttribute("filter") BasicFilter filter, @PageableDefault Pageable pageable){
		if(br.hasErrors()){
//			model.addAttribute("categories", categoryService.findAll());
			model.addAttribute("page", categoryService.findAll( filter, pageable));
			return "admin-category";
		}
		categoryService.save(form);
		status.setComplete();
		return "redirect:/admin/category"+getParams(pageable, filter);
	}

	@RequestMapping("/update/{id}")
	public String update(@PathVariable int id, Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") BasicFilter filter){
		model.addAttribute("category",categoryService.findOne(id));
//		model.addAttribute("categories", categoryService.findAll());
		model.addAttribute("page", categoryService.findAll( filter, pageable));
		return "admin-category";
	}
	
	
	


	
	
}