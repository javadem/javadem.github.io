package ua.validator;


import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.entity.Category;
import ua.service.CategoryService;


public class CategoryValidator implements Validator{

	private final CategoryService categoryServiceCategoryValidator;


	public CategoryValidator(CategoryService categoryServiceCategoryValidator) {
		super();
		this.categoryServiceCategoryValidator = categoryServiceCategoryValidator;
	}

	public CategoryService getCategoryServiceCategoryValidator() {
		return categoryServiceCategoryValidator;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.equals(Category.class);
	}
	
	
	@Override
	public void validate(Object target, Errors errors) {
		Category category = (Category) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nameCategory", "", "Can`t be empty");

		if(categoryServiceCategoryValidator.findOne(category.getNameCategory())!=null){
			errors.rejectValue("nameCategory", "", "Already exist");
		}
	}

	
}
