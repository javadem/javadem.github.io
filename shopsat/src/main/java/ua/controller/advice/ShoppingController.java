package ua.controller.advice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;

import ua.dto.Quantity;
import ua.service.ProductService;

@ControllerAdvice
public class ShoppingController {
	
	@Autowired
	private ProductService productService;
	
	@ModelAttribute("quantity")
	public Quantity getQuantity(@CookieValue(defaultValue="0", name="userId") int userId){
		int count = productService.findCount(userId);
		return new Quantity(count);
	}
}
