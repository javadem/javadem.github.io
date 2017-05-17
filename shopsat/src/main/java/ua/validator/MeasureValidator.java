package ua.validator;


import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.entity.Measure;
import ua.service.MeasureService;

public class MeasureValidator  implements Validator{

	private final MeasureService measureServiceMeasureValidator;

	public MeasureValidator(MeasureService measureServiceMeasureValidator) {
		super();
		this.measureServiceMeasureValidator = measureServiceMeasureValidator;
	}


	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(Measure.class);
	}
	
	
	@Override
	public void validate(Object target, Errors errors) {
		Measure measure = (Measure) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nameMeasure", "", "Can`t be empty");
		if(measureServiceMeasureValidator.findOne(measure.getNameMeasure())!=null){
			errors.rejectValue("nameMeasure", "", "Already exist");
		}
	}


	public MeasureService getMeasureServiceMeasureValidator() {
		return measureServiceMeasureValidator;
	}

	
}
