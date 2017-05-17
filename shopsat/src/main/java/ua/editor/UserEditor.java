package ua.editor;

import java.beans.PropertyEditorSupport;

import ua.entity.User;
import ua.service.UserService;

public class UserEditor   extends PropertyEditorSupport{

	private final UserService userService;



	public UserEditor(UserService userService) {
		super();
		this.userService = userService;
	}

	
	
	public UserService getUserService() {
		return userService;
	}



	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		User user = userService.findOne(Integer.valueOf(text));
		setValue(user);
	}

	
	
}
