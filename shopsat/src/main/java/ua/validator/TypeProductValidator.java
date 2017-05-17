package ua.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.entity.TypeProduct;
import ua.service.TypeProductService;


public class TypeProductValidator  implements Validator{
	
	private final TypeProductService typeProductServiceTypeProductValidator;

	
	
	public TypeProductValidator(TypeProductService typeProductServiceTypeProductValidator) {
		super();
		this.typeProductServiceTypeProductValidator = typeProductServiceTypeProductValidator;
	}

	
	
	public TypeProductService getTypeProductServiceTypeProductValidator() {
		return typeProductServiceTypeProductValidator;
	}



	@Override
	public boolean supports(Class<?> clazz) {
		return TypeProduct.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		TypeProduct typeProduct = (TypeProduct)target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nameTypeProduct", "", "Can`t be empty");
		if(typeProductServiceTypeProductValidator.findOne(typeProduct.getNameTypeProduct())!=null){
			errors.rejectValue("nameTypeProduct", "", "Already exist");
		}
		
	}


}
