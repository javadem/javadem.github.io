package ua.controller.user;

import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static ua.service.utils.ParamBuilder.getParams;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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

import ua.dto.filter.BasicFilter;
import ua.entity.Category;
import ua.service.CategoryService;
import ua.validator.CategoryValidator;

@Controller
@RequestMapping("/user/category")
@SessionAttributes(names="category")
public class CategoryUserController {
	
	@Autowired
	private CategoryService categoryService;
	
	
	public CategoryUserController(CategoryService categoryService) {
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
		return "user-category";
	}

	
//	@RequestMapping(method=POST)
//	public String save(@ModelAttribute("categoryUser") @Valid Category form, BindingResult br, SessionStatus status, Model model, @ModelAttribute("filter") BasicFilter filter, @PageableDefault Pageable pageable){
//		if(br.hasErrors()){
////			model.addAttribute("categories", categoryService.findAll());
//			model.addAttribute("page", categoryService.findAll( filter, pageable));
//			return "admin-category";
//		}
//		categoryService.save(form);
//		status.setComplete();
//		return "redirect:/admin/category"+getParams(pageable, filter);
//	}



}
