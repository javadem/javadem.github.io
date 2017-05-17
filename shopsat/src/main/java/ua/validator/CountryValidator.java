package ua.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.entity.Country;
import ua.service.CountryService;

public class CountryValidator implements Validator{
	
	private final CountryService countryServiceCountryValidator;

	public CountryValidator(CountryService countryServiceCountryValidator) {
		super();
		this.countryServiceCountryValidator = countryServiceCountryValidator;
	}

	public CountryService getCountryServiceCountryValidator() {
		return countryServiceCountryValidator;
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Country.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Country country = (Country)target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nameCountry", "", "Can`t be empty");
		if(countryServiceCountryValidator.findOne(country.getNameCountry())!=null){
			errors.rejectValue("nameCountry", "", "Already exist");
		}
		
	}

	
}
