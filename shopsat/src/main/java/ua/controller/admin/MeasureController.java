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
import static ua.service.utils.ParamBuilder.getParams;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;

import ua.dto.filter.BasicFilter;
import ua.entity.Measure;
import ua.service.MeasureService;
import ua.validator.MeasureValidator;

@Controller
@RequestMapping("/admin/measure")
@SessionAttributes(names="measure")
public class MeasureController {
	

	@Autowired
	private MeasureService measureService;

	
	@ModelAttribute("measure")
	public Measure getForm(){
		return new Measure();
	}
	
	@ModelAttribute("filter")
	public BasicFilter getFilter(){
		return new BasicFilter();
	}
	
	@InitBinder("measure")
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new MeasureValidator(measureService));
	}
	
	@RequestMapping
	public String show(SessionStatus status, Model model, @ModelAttribute("filter") BasicFilter filter, @PageableDefault Pageable pageable){
		model.addAttribute("page", measureService.findAll(filter, pageable));
		return "admin-measure";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id, @ModelAttribute("filter") BasicFilter filter, @PageableDefault Pageable pageable){
		measureService.delete(id);
		return "redirect:/admin/measure"+getParams(pageable, filter);
	}
	
	@RequestMapping("/update/{id}")
	public String update(@PathVariable int id, Model model, @ModelAttribute("filter") BasicFilter filter, @PageableDefault Pageable pageable){
		model.addAttribute("measure", measureService.findOne(id));
//		model.addAttribute("measures", measureService.findAll());
		model.addAttribute("page", measureService.findAll(filter, pageable));
		return "admin-measure";
	}

	
	@RequestMapping(method=POST)
	public String save(@ModelAttribute("measure") @Valid Measure measure, BindingResult br, SessionStatus status, Model model, @ModelAttribute("filter") BasicFilter filter, @PageableDefault Pageable pageable){
		if(br.hasErrors()){
//	//		model.addAttribute("measures", measureService.findAll());
			model.addAttribute("page", measureService.findAll(filter, pageable));
			return "admin-measure";
		}
		measureService.save(measure);
		status.setComplete();
		return "redirect:/admin/measure"+getParams(pageable, filter);
	}

	

}
