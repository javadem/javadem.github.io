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
	

//	@Inject
//	public ProductController(ProductService productService, ModelService modelService, MeasureService measureService) {
//		super();
//		this.productService = productService;
//		this.modelService = modelService;
//		this.measureService = measureService;
//	}

	@InitBinder("payment")
	protected void initBinder(WebDataBinder binder) {
//		binder.registerCustomEditor(ua.entity.Model.class, new ModelEditor(modelService));
//		binder.registerCustomEditor(Measure.class, new MeasureEditor(measureService));
		binder.registerCustomEditor(Payment.class, new PaymentEditor(paymentService));
		binder.registerCustomEditor(User.class, new UserEditor(userService));
		binder.registerCustomEditor(ShopingCart.class, new ShopingCartEditor(shopingCartService));
//		binder.registerCustomEditor(Producer.class, new ProducerEditor(producerService));
//		binder.registerCustomEditor(TypeProduct.class, new TypeProductEditor(typeProductService));
//		binder.registerCustomEditor(Country.class, new CountryEditor(countryService));
//		binder.registerCustomEditor(Category.class, new CategoryEditor(categoryService));
//		binder.registerCustomEditor(ProductForm.class,new ProductValidator(productService));
//		binder.setValidator(new ProductValidator());
	}
	
	@ModelAttribute("payment")
	public Payment getForm(){
		return new Payment();
	}
	
	/*@ModelAttribute("filter")
	public PaymentFilter getFilter(){
		return new ProductFilter();
	}*/
	

	@RequestMapping
//	public String show(Model model, @PageableDefault Pageable pageable){
	public String show(SessionStatus status, Model model){	

//		model.addAttribute("page", productService.findAll( filter, pageable));
//		model.addAttribute("models", modelService.findAll());
//		model.addAttribute("measures", measureService.findAll());
//		model.addAttribute("listProducts", productService.findAll());
//		model.addAttribute("producers", producerService.findAll());
//		model.addAttribute("typeProducts", typeProductService.findAll());
//		model.addAttribute("countries", countryService.findAll());
//		model.addAttribute("categories", categoryService.findAll());
		model.addAttribute("users", userService.findAll());
		model.addAttribute("shopingCarts", shopingCartService.findAll());
		model.addAttribute("payments", paymentService.findAll());
//		model.addAllAttributes("shopingCarts", shopingCartService.findAll());
//		model.addAttribute("measures", measureService.findAll(pageble));
//		model.addAttribute("products", productService.findAll());
//		model.addAttribute("page", productService.findAll( pageable));
//		model.addAttribute("measures", measureService.findAll(pageble));
		status.setComplete();
		return "user-payment";
	}
	
/*	@RequestMapping
//	public String show(Model model, @PageableDefault Pageable pageable){
	public String showAdmin(SessionStatus status, Model model){	

//		model.addAttribute("page", productService.findAll( filter, pageable));
//		model.addAttribute("models", modelService.findAll());
//		model.addAttribute("measures", measureService.findAll());
//		model.addAttribute("listProducts", productService.findAll());
//		model.addAttribute("producers", producerService.findAll());
//		model.addAttribute("typeProducts", typeProductService.findAll());
//		model.addAttribute("countries", countryService.findAll());
//		model.addAttribute("categories", categoryService.findAll());
		model.addAttribute("users", userService.findAll());
		model.addAttribute("shopingCarts", shopingCartService.findAll());
		model.addAttribute("payments", paymentService.findAll());
//		model.addAllAttributes("shopingCarts", shopingCartService.findAll());
//		model.addAttribute("measures", measureService.findAll(pageble));
//		model.addAttribute("products", productService.findAll());
//		model.addAttribute("page", productService.findAll( pageable));
//		model.addAttribute("measures", measureService.findAll(pageble));
		status.setComplete();
		return "admin-payment";
	}*/
	
	
	
	@RequestMapping("/delete/{paymentId}")
	public String delete( @PathVariable int paymentId, Principal principal){
//	public String delete(@PathVariable int id,  @PageableDefault Pageable pageable){	
		int cartId = shopingCartService.findOneCartByUserName(principal).getId().intValue();
		paymentService.delete(paymentId);
		return "redirect:/user/shopingCart/"+cartId;
//		return "redirect:/user/product"+getParams(pageable);
//		return "redirect:/user/product";
	}

	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String getPayment(SessionStatus status, @PathVariable("id") int id, Model model) {
//	    model.addAttribute("product", productService.findOne(id));
//	    model.addAttribute("models", modelService.findAll());
//		model.addAttribute("measures", measureService.findAll());
//		model.addAttribute("listProducts", productService.findAll());
//		model.addAttribute("producers", producerService.findAll());
//		model.addAttribute("typeProducts", typeProductService.findAll());
//		model.addAttribute("countries", countryService.findAll());
//		model.addAttribute("categories", categoryService.findAll());
		model.addAttribute("users", userService.findAll());
		model.addAttribute("payment", paymentService.findOne(id));
		model.addAttribute("payments", paymentService.findAll());
		model.addAttribute("shopingCarts", shopingCartService.findAll());
//	    model.addAttribute("product", productService.findById(id));
	    status.setComplete();
	    return "user-payment";
	}

	
	@RequestMapping(method=POST)
	public String save(@ModelAttribute("payment")  @Valid Payment payment, BindingResult br, Model model, SessionStatus sessionStatus){
//	public String save(@ModelAttribute("product") @Valid ProductForm productForm, BindingResult br, SessionStatus status, Model model,  @PageableDefault Pageable pageable){
//	public String save(@ModelAttribute("product") @Valid ProductForm productForm, BindingResult br, Model model, SessionStatus sessionStatus, @ModelAttribute("filter") ProductFilter filter, @PageableDefault Pageable pageable){
//	public String save(@ModelAttribute("filter") @Valid ProductForm productForm, BindingResult br, SessionStatus status, Model model, @ModelAttribute("filter") ProductFilter filter, @PageableDefault Pageable pageable){
		if(br.hasErrors()){
//			model.addAttribute("products", productService.findAll());
//			model.addAttribute("page", productService.findAll( pageable));
			model.addAttribute("payments", paymentService.findAll());
			model.addAttribute("users", userService.findAll());
//			model.addAttribute("models", modelService.findAll());
////			model.addAttribute("models", product.getModel());
//			model.addAttribute("measures", measureService.findAll());
//			model.addAttribute("producers", producerService.findAll());
//			model.addAttribute("typeProducts", typeProductService.findAll());
//			model.addAttribute("countries", countryService.findAll());
//			model.addAttribute("categories", categoryService.findAll());
			model.addAttribute("shopingCarts", shopingCartService.findAll());
//			model.addAttribute("models", product.getModel());
			return "user-payment";
		}
		paymentService.save(payment);
		sessionStatus.setComplete();
//		return "redirect:/user/product";
//		return "redirect:/user/product"+getParams(pageable);
		return "redirect:/user/payment";
	}


	
}
