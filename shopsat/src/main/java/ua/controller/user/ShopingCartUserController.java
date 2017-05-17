package ua.controller.user;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
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
import org.springframework.web.bind.support.SessionStatus;

import ua.dto.filter.ShopingCartFilter;
import ua.dto.filter.UserFilter;
import ua.dto.form.ProductForm;
import ua.dto.form.ShopingCartForm;
import ua.editor.MeasureEditor;
import ua.editor.ModelEditor;
import ua.editor.PaymentEditor;
import ua.editor.ProductEditor;
import ua.editor.ShopingCartEditor;
import ua.editor.UserEditor;
import ua.entity.Measure;
import ua.entity.Payment;
import ua.entity.Product;
import ua.entity.ShopingCart;
import ua.entity.User;
import ua.service.MeasureService;
import ua.service.ModelService;
import ua.service.PaymentService;
import ua.service.ProductService;
import ua.service.ShopingCartService;
import ua.service.UserService;
import ua.service.implementation.PaymentServiceImpl;
import ua.service.implementation.ShopingCartServiceImpl;
import ua.service.implementation.UserServiceImpl;
import ua.validator.ProductValidator;
import ua.validator.ShopingCartValidator;

@Controller
@RequestMapping(value="/user/shopingCart")
public class ShopingCartUserController {
	
	@Autowired
	private ShopingCartService shopingCartService ;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PaymentService paymentService;

	@InitBinder("shopingCart")
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(ShopingCart.class, new ShopingCartEditor(shopingCartService));
//		binder.setValidator(new ShopingCartValidator(shopingCartService));
		binder.registerCustomEditor(Product.class, new ProductEditor(productService));
		binder.registerCustomEditor(User.class, new UserEditor(userService));
		binder.registerCustomEditor(Payment.class, new PaymentEditor(paymentService));
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
	public String show(Model model){
		model.addAttribute("products", productService.findAll());
		model.addAttribute("shopingCarts", shopingCartService.findAll());
		model.addAttribute("users", userService.findAll());
		model.addAttribute("payments", paymentService.findAll());
		return "user-shopingCart";
	}
	
	
/*		@RequestMapping
	public String addUserFromForm(@ModelAttribute("userForm") @Valid User user, BindingResult br){
		if(br.hasErrors()){
//			model.addAttribute("users", userService.findAll());
			return "admin-user";
		}
		userService.save(user);
//		status.setComplete();
		return "redirect:/admin/user";	
	}*/
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id){
		userService.delete(id);
	return "redirect:/user/shopingCart";
	}
//	
	
	@RequestMapping("/update/{id}")
	public String update(@PathVariable int id, Model model){
		model.addAttribute("users", userService.findAll());
		return "user-shopingCart";
	}
	
	
	
	@RequestMapping(method=POST)
	public String save(@ModelAttribute("shopingCart") @Valid ShopingCart shopingCart, BindingResult br, SessionStatus status, Model model){
		if(br.hasErrors()){
//			model.addAttribute("shopingCarts", userService.findAll());
			model.addAttribute("products", productService.findAll());
			model.addAttribute("shopingCarts", shopingCartService.findAll());
			model.addAttribute("users", userService.findAll());
			model.addAttribute("payments", paymentService.findAll());
			return "user-shopingCart";
		}
		shopingCartService.save(shopingCart);
		status.setComplete();
		return "redirect:/user/shopingCart";
	}
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String getShopingCart(SessionStatus status, @PathVariable("id") int id, Model model) {
	    model.addAttribute("shopingCart", shopingCartService.findOne(id));
	    model.addAttribute("products", productService.findProductsByCartId(id));
//		model.addAttribute("shopingCarts", shopingCartService.findAll());
		model.addAttribute("user", userService.findUserByCartId(id));
		model.addAttribute("payments", paymentService.findAll());
//		model.addAttribute("users", userService.findUserByCartId(id));
//	    model.addAttribute("product", productService.findById(id));
	    status.setComplete();
	    return "user-shopingCartUnit";
	}
	
	
	@RequestMapping("/createPayment/{id}")
	public String createPayment(@PathVariable int id){
		if(!(shopingCartService.findOne(id).getProducts().isEmpty() )){
			if((paymentService.findOnePaymentByCartId(id)==null)){
			Payment payment = new Payment();
			payment.setEmail(userService.findUserByCartId(id).getEmail());
			payment.setAmount(shopingCartService.findOne(id).getAmount());
			payment.setText("Вітаємо з покупкою! Оплатити кошти в сумі "+payment.getAmount()+" грн можна на банківський рахунок № 1234 5678 9010 1112 . "
					+ "Копію замовлення буде відправлено на Вашу електронну пошту "+payment.getEmail());
			payment.setShopingCart(shopingCartService.findOne(id));
			paymentService.save(payment);
			}
		} else {
			System.out.println("Додайте товар в корзину");
			return "redirect:/user/product";
		}
		int paymentId = paymentService.findOnePaymentByCartId(id).getId().intValue();
		
		return "redirect:/user/payment/"+paymentId;

	}
	
	
	@RequestMapping("/{shopingCartId}/deleteProductFromCart/{productId}")
	public String deleteProductFromCart(@PathVariable int shopingCartId, @PathVariable int productId){
		shopingCartService.deleteProductFromCart(shopingCartId, productId);
		return "redirect:/user/shopingCart/{shopingCartId}";
	}
	
	
/*	public void sendMail(String content, String email, String mailBody) {
		Properties properties = System.getProperties();
		
	
		properties.setProperty("mail.smtp.starttls.enable", "true");
		properties.setProperty("mail.smtp.auth", "true");
		properties.setProperty("mail.smtp.port", "465");
		properties.setProperty("mail.smtp.host", "smtp.gmail.com");
		properties.setProperty("mail.smtp.socketFactory.port", "465");
		properties.setProperty("mail.smtp.socketFactory.class",
		"javax.net.ssl.SSLSocketFactory");
		Session session = Session.getDefaultInstance(properties,
		new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication( USERNAME , PASSWORD );
		}
		});
		try {
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress( USERNAME ));
		message.addRecipient(Message.RecipientType. TO , new InternetAddress(
		email));
		message.setSubject(content, "UTF-8");
		message.setText(mailBody);
		Transport.send(message);
		} catch (MessagingException е) {
		е.printStackTrace();
		}
	}*/
	
}
