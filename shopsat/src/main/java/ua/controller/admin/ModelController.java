package ua.controller.admin;

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

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.validation.Valid;

//import static ua.service.utils.ParamBuilder.getParams;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;

import ua.dto.filter.ModelFilter;
import ua.service.ModelService;
import ua.validator.ModelValidator;

import ua.editor.*;
import ua.entity.*;
import ua.service.*;



@Controller
@RequestMapping("/admin/model")
@SessionAttributes(names="model")
public class ModelController {

	@Autowired
	private ModelService modelService;
	
	@Autowired
	private TypeProductService typeProductService;
	
	@Autowired
	private ProducerService producerService;
	
	@InitBinder("model")
	protected void initBinder(WebDataBinder binder){
		binder.registerCustomEditor(TypeProduct.class, new TypeProductEditor(typeProductService));
		binder.registerCustomEditor(Producer.class, new ProducerEditor(producerService));
		binder.setValidator(new ModelValidator(modelService));
	}
	
	@ModelAttribute("model")
	public ua.entity.Model getForm(){
		return new ua.entity.Model();
	}
	
	@ModelAttribute("filter")
	public ModelFilter getFilter(){
		return new ModelFilter();
	}
	
	@RequestMapping
	public String show(Model model, @ModelAttribute("filter") ModelFilter filter, @PageableDefault Pageable pageable){
//		modelSpring.addAttribute("models", modelService.findAll());
		model.addAttribute("page", modelService.findAll( filter, pageable));
		model.addAttribute("producers", producerService.findAll());
		model.addAttribute("typeProducts", typeProductService.findAll());
		return "admin-model";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id, @ModelAttribute("filter") ModelFilter filter, @PageableDefault Pageable pageable){
		modelService.delete(id);
		return "redirect:/admin/model"+getParams(pageable, filter);
	}
	

	
	@RequestMapping(method=POST)
	public String save(@ModelAttribute("model") @Valid ua.entity.Model form, BindingResult br, SessionStatus status, Model model, @ModelAttribute("filter") ModelFilter filter, @PageableDefault Pageable pageable){
		if(br.hasErrors()){
//			model.addAttribute("models", modelService.findAll());
			model.addAttribute("page", modelService.findAll( filter, pageable));
			model.addAttribute("producers", producerService.findAll());
			model.addAttribute("typeProducts", typeProductService.findAll());
			return "admin-model"+getParams(pageable, filter);
		}
		modelService.save(form);
		status.setComplete();
		return "redirect:/admin/model"+getParams(pageable, filter);
	}

	
	@RequestMapping("/update/{id}")
	public String update(@PathVariable int id, Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") ModelFilter filter){
		model.addAttribute("model", modelService.findOne(id));
//		model.addAttribute("models", modelService.findAll());
		model.addAttribute("page", modelService.findAll( filter, pageable));
		model.addAttribute("typeProduct", typeProductService.findOne(id));
		model.addAttribute("typeProducts", typeProductService.findAll());
		model.addAttribute("producer", producerService.findOne(id));
		model.addAttribute("producers", producerService.findAll());
		return "admin-model";
	}


public static String getParams(Pageable pageable, ModelFilter filter){
		
		
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
		
		for(Integer id : filter.getProducerIds()){
			buffer.append("&producerIds=");
			buffer.append(id);
		}
		
		for(Integer id : filter.getTypeProductIds()){
			buffer.append("&typeProductIds=");
			buffer.append(id);
		}

		return buffer.toString();
	}
	
}
