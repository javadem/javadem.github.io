package ua.editor;

import java.beans.PropertyEditorSupport;

import ua.dto.form.ProductForm;
import ua.entity.*;
import ua.service.*;

public class ProductEditor  extends PropertyEditorSupport{
	
	private final ProductService productService;

	public ProductEditor(ProductService productService) {
		super();
		this.productService = productService;
	}
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		ProductForm product = productService.findOne(Integer.valueOf(text));
		setValue(product);
	}

	public ProductService getProductService() {
		return productService;
	}

	
}
