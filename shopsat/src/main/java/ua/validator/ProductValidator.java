package ua.validator;


import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


import ua.service.ProductService;

import ua.dto.form.ProductForm;

public class ProductValidator  implements Validator{

	private final ProductService productServiceProductValidator;
	
//	private  ProductService productServiceProductValidator;

	private final static Pattern PATTERN = Pattern.compile("^([0-9]{1,18}\\.[0-9]{0,2})|([0-9]{1,18}\\,[0-9]{0,2})$");



	public ProductValidator(ProductService productServiceProductValidator) {
		super();
		this.productServiceProductValidator = productServiceProductValidator;
	}



	public ProductService getProductServiceProductValidator() {
		return productServiceProductValidator;
	}



	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(ProductForm.class);
	}


	@Override
	public void validate(Object target, Errors errors) {
		ProductForm productForm = (ProductForm) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nameProduct",  "", "Name product can`t be empty");
		if(productServiceProductValidator.findOne(productForm.getNameProduct())!=null){
			errors.rejectValue("nameProduct", "", "Already exist");
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description",  "", "Description can`t be empty");
//		if(productServiceProductValidator.findOne(productForm.getNameProduct())!=null){
//			errors.rejectValue("description", "", "Already exist");
//		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "price", "", "Price can`t be empty");
		if(!PATTERN.matcher(productForm.getPrice()).matches()){
			errors.rejectValue("price", "", "Wrong format, only 2 digits after separator");
		}
		
	}
	
	
}
