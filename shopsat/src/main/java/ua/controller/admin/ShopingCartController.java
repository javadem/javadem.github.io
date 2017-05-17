package ua.controller.admin;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.dto.filter.ShopingCartFilter;
import ua.dto.filter.UserFilter;
import ua.dto.form.ProductForm;
import ua.dto.form.ShopingCartForm;
import ua.editor.MeasureEditor;
import ua.editor.ModelEditor;
import ua.editor.ProductEditor;
import ua.editor.ShopingCartEditor;
import ua.editor.UserEditor;
import ua.entity.Measure;
import ua.entity.Product;
import ua.entity.ShopingCart;
import ua.entity.User;
import ua.service.MeasureService;
import ua.service.ModelService;
import ua.service.ProductService;
import ua.service.ShopingCartService;
import ua.service.UserService;
import ua.validator.ProductValidator;

@Controller
@RequestMapping(value="/admin/shopingCart")
@SessionAttributes(names="shopingCart")
public class ShopingCartController {
	
	@Autowired
	private ShopingCartService shopingCartService ;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private UserService userService;
	
	
	
	public ShopingCartController() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	public ShopingCartController(ShopingCartService shopingCartService,
			ProductService productService, UserService userService) {
		super();
		this.shopingCartService = shopingCartService;
		this.productService = productService;
		this.userService = userService;
	}




	@InitBinder("shopingCart")
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(ShopingCart.class, new ShopingCartEditor(shopingCartService));
		binder.registerCustomEditor(Product.class, new ProductEditor(productService));
		binder.registerCustomEditor(User.class, new UserEditor(userService));
	}

	@ModelAttribute("shopingCart")
	public ShopingCart getForm(){
		return new ShopingCart();
	}
	
	@ModelAttribute("filter")
	public ShopingCartFilter getFilter(){
		return new ShopingCartFilter();
	}
	

	@RequestMapping
	public String show(SessionStatus status, Model model){
		model.addAttribute("products", productService.findAll());
		model.addAttribute("shopingCarts", shopingCartService.findAll());
		model.addAttribute("users", userService.findAll());
		return "admin-shopingCart";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id){
		shopingCartService.delete(id);
	return "redirect:/admin/shopingCart";
	}
	


	@RequestMapping(method=POST)
	public String save(@ModelAttribute("shopingCart") ShopingCart shopingCart, BindingResult br, SessionStatus status, Model model){
		if(br.hasErrors()){
			model.addAttribute("products", productService.findAll());
			model.addAttribute("shopingCarts", shopingCartService.findAll());
			model.addAttribute("users", userService.findAll());
			return "admin-shopingCart";
		}
			//		System.out.println("111111111111111");
		shopingCartService.save(shopingCart);
//		System.out.println("222222222222");
		status.setComplete();
//		System.out.println("3333333333333333");
		return "redirect:/admin/shopingCart";
		
	}

/*	@RequestMapping(method=POST)
	public String save(@RequestParam User user, @RequestParam Product product){
		shopingCartService.save(user, product);
		return "redirect:/admin/shopingCart";
	}*/
	
	
	@RequestMapping("/update/{id}")
	public String update(@PathVariable int id, Model model){
		model.addAttribute("shopingCart", shopingCartService.findOne(id));
		model.addAttribute("users", userService.findAll());
		model.addAttribute("products", productService.findAll());
		return "admin-shopingCart";
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String getShopingCart(SessionStatus status, @PathVariable("id") int id, Model model) {
	    model.addAttribute("shopingCart", shopingCartService.findOne(id));
	    model.addAttribute("products", productService.findProductsByCartId(id));
//		model.addAttribute("shopingCarts", shopingCartService.findAll());
		model.addAttribute("user", userService.findUserByCartId(id));
//		model.addAttribute("users", userService.findUserByCartId(id));
//	    model.addAttribute("product", productService.findById(id));
	    status.setComplete();
	    return "admin-shopingCartUnit";
	}

	@RequestMapping("/deleteProductFromCart/{id}")
	public String deleteProductFromCart(@PathVariable int id){
//		productService.;
	return "redirect:/admin/shopingCartUnit";
	}
	
	/*@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String getShopingCartUser(SessionStatus status, @PathVariable("id") int id, Model model) {
	    model.addAttribute("shopingCart", shopingCartService.findOne(id));
	    model.addAttribute("products", productService.findProductsByCartId(id));
//		model.addAttribute("shopingCarts", shopingCartService.findAll());
		model.addAttribute("user", userService.findUserByCartId(id));
//		model.addAttribute("users", userService.findUserByCartId(id));
//	    model.addAttribute("product", productService.findById(id));
	    status.setComplete();
	    return "user-shopingCartUnit";
	}*/

}
