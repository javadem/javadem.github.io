package ua.controller.admin;

import static org.springframework.web.bind.annotation.RequestMethod.POST;






import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;






import ua.dto.filter.UserFilter;
import ua.editor.ProducerEditor;
import ua.editor.ShopingCartEditor;
import ua.editor.UserEditor;
import ua.entity.Producer;
import ua.entity.ShopingCart;
import ua.entity.User;
import ua.service.ShopingCartService;
import ua.service.UserService;
import ua.validator.UserValidator;


@Controller
@RequestMapping("/admin/user")
@SessionAttributes(names="user")
public class UserController {

	

		@Autowired
		private UserService userService ;
		
		@Autowired
		private ShopingCartService shopingCartService ;
		
		@ModelAttribute("user")
		public User getForm(){
			return new User();
		}
		
		@ModelAttribute("filter")
		public UserFilter getFilter(){
			return new UserFilter();
		}
		
		@InitBinder("user")
		protected void initBinder(WebDataBinder binder) {
//			binder.registerCustomEditor(User.class, new UserEditor(userService));
			binder.registerCustomEditor(ShopingCart.class, new ShopingCartEditor(shopingCartService));
			binder.setValidator(new UserValidator(userService));
		}
		

		
		@RequestMapping
		public String show(Model model){
//		public String show(Model model, @PageableDefault Pageable pageable){	
//		public String show(Model model, @ModelAttribute("filter") UserFilter filter, @PageableDefault Pageable pageable){
			
			model.addAttribute("users", userService.findAll());
			model.addAttribute("shopingCarts", shopingCartService.findAll());
//			model.addAttribute("page", userService.findAll( pageable));
//			model.addAttribute("page", userService.findAll( filter, pageable));
			return "admin-user";
		}
		
		
/*		@RequestMapping
		public String addUserFromForm(@ModelAttribute("userForm") @Valid User user, BindingResult br){
			if(br.hasErrors()){
//				model.addAttribute("users", userService.findAll());
				return "admin-user";
			}
			userService.save(user);
//			status.setComplete();
			return "redirect:/admin/user";	
		}*/
		
		@RequestMapping("/delete/{id}")
		public String delete(@PathVariable int id){
//		public String delete(@PathVariable int id,  @PageableDefault Pageable pageable){
//		public String delete(@PathVariable int id, @ModelAttribute("filter") UserFilter filter, @PageableDefault Pageable pageable){
			userService.delete(id);
		return "redirect:/admin/user";
//			return "redirect:/admin/user"+getParams(pageable);
///			return "redirect:/admin/user"+getParams(pageable, filter);
	}
//		
		@RequestMapping("/update/{id}")
		public String update(@PathVariable int id, Model model){
//		public String update(@PathVariable int id, Model model,  @PageableDefault Pageable pageable){
//		public String update(@PathVariable int id, Model model, @ModelAttribute("filter") UserFilter filter, @PageableDefault Pageable pageable){
			model.addAttribute("user", userService.findOne(id));
			model.addAttribute("shopingCarts", shopingCartService.findAll());
//			model.addAttribute("users", userService.findAll());
//			model.addAttribute("page", userService.findAll( pageable));
//			model.addAttribute("page", userService.findAll( filter, pageable));
			return "admin-user";
		}
		
		
		
		@RequestMapping(method=POST)
		public String save(@CookieValue(value="id", name="userId") int id, @ModelAttribute("user") @Valid User user, BindingResult br, SessionStatus status, Model model){
//		public String save(@ModelAttribute("user") @Valid User user, BindingResult br, SessionStatus status, Model model,  @PageableDefault Pageable pageable){	
//		public String save(@ModelAttribute("user") @Valid User user, BindingResult br, SessionStatus status, Model model, @ModelAttribute("filter") UserFilter filter, @PageableDefault Pageable pageable){
			if(br.hasErrors()){
				model.addAttribute("users", userService.findAll());
				model.addAttribute("shopingCarts", shopingCartService.findAll());
//				model.addAttribute("page", userService.findAll( pageable));
//				model.addAttribute("page", userService.findAll( filter, pageable));
				return "admin-user";
			}
			userService.saveWithCookie(id, user);
			status.setComplete();
//			return "redirect:/admin/user"+getParams(pageable, filter);
//			return "redirect:/admin/user"+getParams(pageable);
			return "redirect:/admin/user";
		}

		
		@RequestMapping(value = "/{id}", method = RequestMethod.GET)
		public String getUser(@PathVariable("id") int id, Model model) {
			model.addAttribute("user", userService.findOne(id));
			model.addAttribute("shopingCarts", shopingCartService.findAllCartsByUserId(id));
		    return "admin-userUnit";
		}
		
/*		
		public static String getParams(Pageable pageable, UserFilter filter){
			
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


			return buffer.toString();
		}
		
		
		public static String getParams(Pageable pageable){
			
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
			
			return buffer.toString();
		}*/
	
}
