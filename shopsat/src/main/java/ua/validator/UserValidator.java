package ua.validator;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.entity.User;
import ua.service.UserService;

public class UserValidator   implements Validator{

	private final UserService userService;

	private  static Pattern pattern = Pattern.compile("^([0-9a-zA-Z]{4,16}+)$");
	private  static Pattern pattern2 = Pattern.compile("^[a-zA-Z]{1}[a-zA-Z\\d\\u002E\\u005F]+@([a-zA-Z]+\\u002E){1,2}(([a-zA-Z]{2,5}))+$");
	
	
	
	public UserValidator(UserService userService) {
	super();
	this.userService = userService;
}

	public UserService getUserService() {
		return userService;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User)target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "", "username Can`t be empty");
		if(userService.findOne(user.getUsername())!=null){
			errors.rejectValue("username", "", "Already exist");
		}
		if(!pattern.matcher(user.getUsername()).matches()){
			errors.rejectValue("username", "", "username Wrong format, only letters and digits");
		}
		
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "", "password Can`t be empty");
		if(!pattern.matcher(user.getPassword()).matches()){
			errors.rejectValue("password", "", "password Wrong format, only letters and digits");
		}
		
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "", "email Can`t be empty");
		if(userService.findOne(user.getEmail())!=null){
			errors.rejectValue("email", "", "Already exist");
		}
		if(!pattern2.matcher(user.getEmail()).matches()){
			errors.rejectValue("email", "", "email Wrong format, only letters and digits");
		}
	}

}
