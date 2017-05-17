package ua.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


import ua.entity.Producer;

import ua.service.ProducerService;;


public class ProducerValidator  implements Validator{

	private final ProducerService producerServiceProducerValidator;


	
	public ProducerValidator(ProducerService producerServiceProducerValidator) {
		super();
		this.producerServiceProducerValidator = producerServiceProducerValidator;
	}
	
	

	public ProducerService getProducerServiceProducerValidator() {
		return producerServiceProducerValidator;
	}



	@Override
	public boolean supports(Class<?> clazz) {
		return Producer.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Producer producer = (Producer)target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nameProducer", "", "Can`t be empty");
		if(producerServiceProducerValidator.findOne(producer.getNameProducer())!=null){
			errors.rejectValue("nameProducer", "", "Already exist");
		}
		
	}

	
}
