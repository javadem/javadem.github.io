package ua.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
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

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.validation.Valid;

import ua.dto.filter.ProducerFilter;
import ua.editor.CountryEditor;
import ua.entity.Country;
import ua.entity.Producer;
import ua.service.ProducerService;
import ua.validator.ProducerValidator;
import ua.service.CountryService;



@Controller
@RequestMapping("/admin/producer")
@SessionAttributes(names="producer")
public class ProducerController {

	@Autowired
	private ProducerService producerService;
	
	@Autowired
	private CountryService countryService;
	
//	@Autowired
//	private ModelService modelService;
	
	@InitBinder("producer")
	protected void initBinder(WebDataBinder binder){
		binder.registerCustomEditor(Country.class, new CountryEditor(countryService));
//		binder.registerCustomEditor(ua.entity.Model.class, new ModelEditor(modelService));
		binder.setValidator(new ProducerValidator(producerService));
	}
	
	@ModelAttribute("producer")
	public Producer getForm(){
		return new Producer();
	}
	
	@ModelAttribute("filter")
	public ProducerFilter getFilter(){
		return new ProducerFilter();
	}
	
	@RequestMapping
	public String show(SessionStatus status, Model model, @ModelAttribute("filter") ProducerFilter filter, @PageableDefault Pageable pageable){
//		model.addAttribute("producers", producerService.findAll());
		model.addAttribute("page", producerService.findAll( filter, pageable));
		model.addAttribute("countries", countryService.findAll());
//		model.addAttribute("models", modelService.findAll());
		return "admin-producer";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id, @ModelAttribute("filter") ProducerFilter filter, @PageableDefault Pageable pageable){
		producerService.delete(id);
		return "redirect:/admin/producer"+getParams(pageable, filter);
	}
	


	
	@RequestMapping(method=POST)
	public String save(@ModelAttribute("producer") @Valid Producer form, BindingResult br, SessionStatus status, Model model, @ModelAttribute("filter") ProducerFilter filter, @PageableDefault Pageable pageable){
		if(br.hasErrors()){
	//		model.addAttribute("producers", producerService.findAll());
			model.addAttribute("page", producerService.findAll( filter, pageable));
			model.addAttribute("countries", countryService.findAll());
			return "admin-producer";
		}
		producerService.save(form);
		status.setComplete();
		return "redirect:/admin/producer"+getParams(pageable, filter);
	}


	@RequestMapping("/update/{id}")
	public String update(@PathVariable int id, Model model, @PageableDefault Pageable pageable, @ModelAttribute("filter") ProducerFilter filter){
		model.addAttribute("producer", producerService.findOne(id));
		model.addAttribute("page", producerService.findAll( filter, pageable));
	//	model.addAttribute("producers", producerService.findAll());
		model.addAttribute("country", countryService.findOne(id));
		model.addAttribute("countries", countryService.findAll());
		return "admin-producer";
	}
	
	
	public static String getParams(Pageable pageable, ProducerFilter filter){
		
		
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
		
		for(Integer id : filter.getCountryIds()){
			buffer.append("&countryIds=");
			buffer.append(id);
		}

		return buffer.toString();
	}
	
}








