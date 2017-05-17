package ua.controller.user;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.dto.filter.UserFilter;
import ua.editor.ShopingCartEditor;
import ua.entity.ShopingCart;
import ua.entity.User;
import ua.service.ShopingCartService;
import ua.service.UserService;
import ua.validator.UserValidator;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/user")
@SessionAttributes(names="user")
public class UserUserController {

	

	@Autowired
	private UserService userService ;
	
	@Autowired
	private ShopingCartService shopingCartService ;
	
	@ModelAttribute("user")
	public User getForm(){
		return new User();
	}
	
	
	@InitBinder("user")
	protected void initBinder(WebDataBinder binder) {
//		binder.registerCustomEditor(User.class, new UserEditor(userService));
		binder.registerCustomEditor(ShopingCart.class, new ShopingCartEditor(shopingCartService));
		binder.setValidator(new UserValidator(userService));
	}
	

	
	@RequestMapping
	public String show(Principal principal, Model model){
//	public String show(Model model, @PageableDefault Pageable pageable){	
//	public String show(Model model, @ModelAttribute("filter") UserFilter filter, @PageableDefault Pageable pageable){
		try {
			if(principal.getName()==null){return "/login";}
		
		else {
		model.addAttribute("user", userService.findOne(principal.getName()));
		model.addAttribute("shopingCarts", shopingCartService.findAll());
//		model.addAttribute("users", userService.findAll());
//		model.addAttribute("page", userService.findAll( pageable));
//		model.addAttribute("page", userService.findAll( filter, pageable));
		}
		} catch (Exception e) {
			// TODO: handle exception
			
		}
		return "user-user";
	}
	
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id){
//	public String delete(@PathVariable int id,  @PageableDefault Pageable pageable){
//	public String delete(@PathVariable int id, @ModelAttribute("filter") UserFilter filter, @PageableDefault Pageable pageable){
		userService.delete(id);
	return "redirect:/user/user";
//		return "redirect:/user/user"+getParams(pageable);
///			return "redirect:/admin/user"+getParams(pageable, filter);
}
//	
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String update(@PathVariable int id, @ModelAttribute("user")  User user, BindingResult br, SessionStatus status, Model model){
		if(br.hasErrors()){
			model.addAttribute("users", userService.findAll());
			model.addAttribute("shopingCarts", shopingCartService.findAll());
//			model.addAttribute("page", userService.findAll( pageable));
//			model.addAttribute("page", userService.findAll( filter, pageable));
			return "user-user";
		}
		userService.update(id, user);
//		userService.saveWithCookie(id, user);
		status.setComplete();
//		return "redirect:/admin/user"+getParams(pageable, filter);
//		return "redirect:/user/user"+getParams(pageable);
		return "redirect:/user/user"+id;
	}
	
/*	@RequestMapping(value = "/update/{id}")
	public String update(@PathVariable int id, Model model){
		System.out.println("AAAAAAAAAAAAAA");

		System.out.println("BBBBBBBBBBBBBB");
//		userService.update(id);
		model.addAttribute("user", userService.findOne(id));
//		model.addAttribute("users", userService.findAll());
		model.addAttribute("shopingCarts", shopingCartService.findAll());
//		userService.saveWithCookie(id, user);
		System.out.println(userService.findOne(id).getUsername());
		System.out.println("CCCCCCCCCCCCC");
//		status.setComplete();
		System.out.println("DDDDDDDDDDDDDDDDDDD");
		return "redirect:/login";
	}*/
	
	
	
	@RequestMapping(method=POST)
//	public String save(@CookieValue(value="id", name="userId") int id, @ModelAttribute("user") @Valid User user, BindingResult br, SessionStatus status, Model model){
//	public String save(@ModelAttribute("userForm") @Valid User user, BindingResult br, SessionStatus status, Model model,  @PageableDefault Pageable pageable){	
	public String save(@ModelAttribute("user") @Valid User user, BindingResult br, SessionStatus status, Model model, @ModelAttribute("filter") UserFilter filter, @PageableDefault Pageable pageable){
		if(br.hasErrors()){
			model.addAttribute("users", userService.findAll());
			model.addAttribute("shopingCarts", shopingCartService.findAll());
//			model.addAttribute("page", userService.findAll( pageable));
//			model.addAttribute("page", userService.findAll( filter, pageable));
			return "user-user";
		}
		userService.save( user);
//		userService.saveWithCookie(id, user);
		status.setComplete();
//		return "redirect:/admin/user"+getParams(pageable, filter);
//		return "redirect:/user/user"+getParams(pageable);
		return "redirect:/user/user";
	}


	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String getUser(@PathVariable("id") int id, Model model) {
		model.addAttribute("user", userService.findOne(id));
		model.addAttribute("shopingCarts", shopingCartService.findAllCartsByUserId(id));
	    return "user-userUnit";
	}

	

	
}
