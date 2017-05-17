package ua.controller.admin;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;


//import ua.dto.filter.BasicFilter;
import ua.dto.filter.TypeProductFilter;
import ua.entity.Category;
import ua.service.CategoryService;


import ua.editor.CategoryEditor;

import ua.entity.TypeProduct;
import ua.service.TypeProductService;
import ua.validator.TypeProductValidator;



@Controller
@RequestMapping("/admin/typeProduct")
@SessionAttributes(names="typeProduct")
public class TypeProductController {
	
	

	@Autowired
	private TypeProductService typeProductService;
	
	@Autowired
	private CategoryService categoryService;
	
//	@Autowired
//	private ModelService modelService;
	

	@InitBinder("typeProduct")
	protected void initBinder(WebDataBinder binder){
	binder.registerCustomEditor(Category.class, new CategoryEditor(categoryService));
//	binder.registerCustomEditor(ua.entity.Model.class, new ModelEditor(modelService));
	binder.setValidator(new TypeProductValidator(typeProductService));
	}
	
	@ModelAttribute("typeProduct")
	public TypeProduct getForm(){
		return new TypeProduct();
	}
	
	@ModelAttribute("filter")
	public TypeProductFilter getFilter(){
		return new TypeProductFilter();
}
	
	@RequestMapping
	public String show(SessionStatus status, Model model, @ModelAttribute("filter") TypeProductFilter filter, @PageableDefault Pageable pageable){
//		model.addAttribute("typeProducts", typeProductService.findAll());
		model.addAttribute("categories", categoryService.findAll());
		model.addAttribute("page", typeProductService.findAll( filter, pageable));  //22
//		model.addAttribute("models", modelService.findAll());
//		model.addAttribute("typeProduct", typeProductService.findOne(id));
//		model.addAttribute("category", categoryService.findOne(id));
		return "admin-typeProduct";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id, @ModelAttribute("filter") TypeProductFilter filter, @PageableDefault Pageable pageable){
		typeProductService.delete(id);
		return "redirect:/admin/typeProduct"+getParams(pageable, filter);
	}


	@RequestMapping(method=POST)
	public String save(@ModelAttribute("typeProduct") @Valid TypeProduct typeProduct, BindingResult br, SessionStatus status, Model model, @ModelAttribute("filter") TypeProductFilter filter, @PageableDefault Pageable pageable){
		if(br.hasErrors()){
			model.addAttribute("page", typeProductService.findAll(filter, pageable));
			model.addAttribute("categories", categoryService.findAll());
			return "admin-typeProduct";
		}
		typeProductService.save(typeProduct);
		status.setComplete();
		return "redirect:/admin/typeProduct"+getParams(pageable, filter);
	}

	@RequestMapping("/update/{id}")
	public String update(@PathVariable int id, Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") TypeProductFilter filter){
		model.addAttribute("typeProduct", typeProductService.findOne(id));
//		model.addAttribute("typeProducts", typeProductService.findAll());
		model.addAttribute("page", typeProductService.findAll( filter, pageable));  //22
		model.addAttribute("category", categoryService.findOne(id));
		model.addAttribute("categories", categoryService.findAll());
		return "admin-typeProduct";
	}

	
	public static String getParams(Pageable pageable, TypeProductFilter filter){
		
		
		StringBuilder buffer = new StringBuilder();
		buffer.append("?page=");
		buffer.append(String.valueOf(pageable.getPageNumber()+1));
		buffer.append("&size=");
		buffer.append(String.valueOf(pageable.getPageSize()));
		if(pageable.getSort()!=null){
			buffer.append("&sort=");
			Sort sort = pageable.getSort();
			sort.forEach((order)->{
				buffer.append(order.getProperty());
				if(order.getDirection()!=Direction.ASC)
				buffer.append(",desc");
			});
		}
		if(!filter.getSearch().isEmpty()){
			buffer.append("&search=");
			buffer.append(filter.getSearch());
		}
		
		for(Integer id : filter.getCategoryIds()){
			buffer.append("&categoryIds=");
			buffer.append(id);
		}

		return buffer.toString();
	}
	
}
