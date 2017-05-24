package ua.controller.user;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.security.Principal;

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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.dto.filter.ProductFilter;
import ua.dto.form.PaymentForm;
import ua.dto.form.ProductForm;
import ua.editor.CategoryEditor;
import ua.editor.CountryEditor;
import ua.editor.MeasureEditor;
import ua.editor.ModelEditor;
import ua.editor.PaymentEditor;
import ua.editor.ProducerEditor;
import ua.editor.ShopingCartEditor;
import ua.editor.TypeProductEditor;
import ua.editor.UserEditor;
import ua.entity.Category;
import ua.entity.Country;
import ua.entity.Measure;
import ua.entity.Payment;
import ua.entity.Producer;
import ua.entity.Product;
import ua.entity.ShopingCart;
import ua.entity.TypeProduct;
import ua.entity.User;
import ua.service.CategoryService;
import ua.service.CountryService;
import ua.service.MeasureService;
import ua.service.ModelService;
import ua.service.PaymentService;
import ua.service.ProducerService;
import ua.service.ProductService;
import ua.service.ShopingCartService;
import ua.service.TypeProductService;
import ua.service.UserService;
import ua.validator.ProductValidator;


@Controller
@RequestMapping("/user/payment")
@SessionAttributes(names="payment")
public class PaymentUserController {

	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ModelService modelService;
	
	@Autowired
	private MeasureService measureService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ShopingCartService shopingCartService;
	
	@Autowired
	private ProducerService producerService;

	@Autowired
	private TypeProductService typeProductService;
	
	@Autowired
	private CountryService countryService;
	
	@Autowired
	private CategoryService categoryService;
	


	@InitBinder("payment")
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Payment.class, new PaymentEditor(paymentService));
		binder.registerCustomEditor(User.class, new UserEditor(userService));
		binder.registerCustomEditor(ShopingCart.class, new ShopingCartEditor(shopingCartService));
	}
	
	@ModelAttribute("payment")
	public Payment getForm(){
		return new Payment();
	}
	

	

	@RequestMapping
	public String show(SessionStatus status, Model model){	

		model.addAttribute("users", userService.findAll());
		model.addAttribute("shopingCarts", shopingCartService.findAll());
		model.addAttribute("payments", paymentService.findAll());
		status.setComplete();
		return "user-payment";
	}
	

	
	
	@RequestMapping("/delete/{paymentId}")
	public String delete( @PathVariable int paymentId, Principal principal){
		int cartId = shopingCartService.findOneCartByUserName(principal).getId().intValue();
		paymentService.delete(paymentId);
		return "redirect:/user/shopingCart/"+cartId;
	}

	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String getPayment(SessionStatus status, @PathVariable("id") int id, Model model) {
		model.addAttribute("users", userService.findAll());
		model.addAttribute("payment", paymentService.findOne(id));
		model.addAttribute("payments", paymentService.findAll());
		model.addAttribute("shopingCarts", shopingCartService.findAll());
	    status.setComplete();
	    return "user-payment";
	}

	
	@RequestMapping(method=POST)
	public String save(@ModelAttribute("payment")  @Valid Payment payment, BindingResult br, Model model, SessionStatus sessionStatus){
		if(br.hasErrors()){
			model.addAttribute("payments", paymentService.findAll());
			model.addAttribute("users", userService.findAll());
			model.addAttribute("shopingCarts", shopingCartService.findAll());
			return "user-payment";
		}
		paymentService.save(payment);
		sessionStatus.setComplete();
		return "redirect:/user/payment";
	}


	
	
	
}
