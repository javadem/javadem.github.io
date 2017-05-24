package ua.service.implementation;

import java.math.BigDecimal;
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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.dto.form.PaymentForm;
import ua.entity.Payment;
import ua.entity.Product;
import ua.entity.Role;
import ua.entity.ShopingCart;
import ua.repository.PaymentRepository;
import ua.repository.ShopingCartRepository;
import ua.service.PaymentService;
import ua.service.ShopingCartService;
import ua.service.UserService;
import ua.service.implementation.ProductServiceImpl;

@Service
//@Repository("PaymentService")
public class PaymentServiceImpl implements PaymentService {


	@Autowired
	private PaymentRepository  paymentRepository;
	
	@Autowired
	private ShopingCartService shopingCartService ;
	
	@Autowired
	private UserService userService;
	
	

	public PaymentServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public PaymentServiceImpl(PaymentRepository paymentRepository) {
		super();
		this.paymentRepository = paymentRepository;
	}



	public PaymentServiceImpl(PaymentRepository paymentRepository,
			ShopingCartService shopingCartService) {
		super();
		this.paymentRepository = paymentRepository;
		this.shopingCartService = shopingCartService;
	}



	public PaymentRepository getPaymentRepository() {
		return paymentRepository;
	}



	public void setPaymentRepository(PaymentRepository paymentRepository) {
		this.paymentRepository = paymentRepository;
	}

	

	public ShopingCartService getShopingCartService() {
		return shopingCartService;
	}



	public void setShopingCartService(ShopingCartService shopingCartService) {
		this.shopingCartService = shopingCartService;
	}



	@Override
	@Transactional(readOnly=true)
	public Payment findOne(int id) {
		// TODO Auto-generated method stub
		return paymentRepository.findOne(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Payment> findAll() {
		// TODO Auto-generated method stub
		return paymentRepository.findAll();
	}
	


	@Override
	public Payment findOnePaymentByCartId(int id) {
		// TODO Auto-generated method stub
		return paymentRepository.findOnePaymentByCartId(id);
	}



	@Override
	public List<Payment> findAllPaymentsByCartId(int id) {
		// TODO Auto-generated method stub
		return paymentRepository.findAllPaymentsByCartId(id);
	}



	@Override
	@Transactional
	public Payment save(Payment payment) {
		// TODO Auto-generated method stub
		Payment savedPayment = paymentRepository.saveAndFlush(payment);
		return savedPayment;
	}



	@Override
	@Transactional(readOnly=true)
	public Payment save(int id) {
		// TODO Auto-generated method stub
//		ShopingCart shopingCart = shopingCartRepository.findOne(id);
		Payment payment = new Payment();
//		payment.setAmount(new PaymentServiceImpl().calculateAmount(id));
		payment.setAmount(new ShopingCartServiceImpl().findOne(id).getAmount());
		payment.setText("abrakadabtaabrakadabtaabrakadabta");
		payment.setEmail(new UserServiceImpl().findUserByCartId(id).getEmail());
		paymentRepository.save(payment);
		return payment;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		paymentRepository.delete(id);
	}

	
/*	@Override
	public String createNewPayment(int id) {
		// TODO Auto-generated method stub
		return null;
	}*/



	@Transactional
//	public String createNewPayment(int id){
		public String createNewPayment(int id){	
	if((shopingCartService.findOne(id).getProducts().isEmpty() )){
		
		System.out.println("Додайте товар в корзину");
		return "redirect:/user/product";
		} else {
			if(userService.findUserByCartId(id).getRole()==Role.ROLE_ANONYMOUS){
//////////	
/*				HttpSession mySession = request.getSession();
				System.out.println(mySession.getId());	
			List <Product> tempList =	shopingCartService.findOne(id).getProducts() ;		*/
			}else{
				if((paymentRepository.findOnePaymentByCartId(id)==null)){
				Payment payment = new Payment();
				payment.setEmail(userService.findUserByCartId(id).getEmail());
				payment.setAmount(shopingCartService.findOne(id).getAmount());
				payment.setText("Вітаємо з покупкою! Оплатити кошти в сумі "+payment.getAmount()+" грн можна на банківський рахунок № 1234 5678 9010 1112 . "
						+ "Копію замовлення буде відправлено на Вашу електронну пошту "+payment.getEmail());
				payment.setShopingCart(shopingCartService.findOne(id));
				sendMail("Замовлення "+id, payment.getEmail(), payment.getText());
				paymentRepository.save(payment);
				
				}
			}
			}
		int paymentId = paymentRepository.findOnePaymentByCartId(id).getId().intValue();
		
		return "redirect:/user/payment/"+paymentId;
	}

	public void sendMail(String content, String email, String mailBody) {
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
				return new PasswordAuthentication( "mail@com.ua" , "password12" );
		}
		});
		try {
		MimeMessage message = new MimeMessage(session);
		message.setFrom(new InternetAddress( "mail@com.ua" ));
		message.addRecipient(Message.RecipientType. TO , new InternetAddress(
		email));
		message.setSubject(content, "UTF-8");
		message.setText(mailBody);
		Transport.send(message);
		} catch (MessagingException е) {
		е.printStackTrace();
		}
	}
	
}
