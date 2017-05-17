package ua.validator;


import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;





import ua.dto.form.PaymentForm;
import ua.service.PaymentService;


public class PaymentValidator  implements Validator{

	private final PaymentService paymentService;
	
//	private  ProductService productServiceProductValidator;

	private final static Pattern PATTERN = Pattern.compile("^([0-9]{1,18}\\.[0-9]{0,2})|([0-9]{1,18}\\,[0-9]{0,2})$");

	
	
	
	public PaymentValidator(PaymentService paymentService) {
	super();
	this.paymentService = paymentService;
	}

	public PaymentService getPaymentService() {
		return paymentService;
	}



	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return clazz.equals(PaymentForm.class);
	}


	@Override
	public void validate(Object target, Errors errors) {
		PaymentForm paymentForm = (PaymentForm) target;
		
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "text",  "", "text can`t be empty");
//		if(productServiceProductValidator.findOne(productForm.getNameProduct())!=null){
//			errors.rejectValue("description", "", "Already exist");
//		}
		
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "amount", "", "amount can`t be empty");
		if(!PATTERN.matcher(paymentForm.getAmount()).matches()){
			errors.rejectValue("amount", "", "Wrong format, only 2 digits after separator");
		}
	}
/*		@Override
		public void validate(Object target, Errors errors) {
			ProductForm productForm = (ProductForm) target;
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nameProduct",  "", "Name product can`t be empty");
			if(productServiceProductValidator.findOne(productForm.getNameProduct())!=null){
				errors.rejectValue("nameProduct", "", "Already exist");
			}
			
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description",  "", "Description can`t be empty");
//			if(productServiceProductValidator.findOne(productForm.getNameProduct())!=null){
//				errors.rejectValue("description", "", "Already exist");
//			}
			
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "", "Price can`t be empty");
			if(!PATTERN.matcher(productForm.getPrice()).matches()){
				errors.rejectValue("price", "", "Wrong format, only 2 digits after separator");
			}*/
		
		
	
	
}
