package ua.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.entity.Model;
import ua.service.ModelService;


public class ModelValidator implements Validator {

	private final ModelService modelServiceModelValidator;



	public ModelValidator(ModelService modelServiceModelValidator) {
		super();
		this.modelServiceModelValidator = modelServiceModelValidator;
	}


	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(Model.class);
	}
	
	
	@Override
	public void validate(Object target, Errors errors) {
		Model model = (Model) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nameModel", "", "Can`t be empty");
		if(modelServiceModelValidator.findOne(model.getNameModel())!=null){
			errors.rejectValue("nameModel", "", "Already exist");
		}
	}


	public ModelService getModelServiceModelValidator() {
		return modelServiceModelValidator;
	}

	
}
