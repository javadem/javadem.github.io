package ua.editor;

import java.beans.PropertyEditorSupport;

import ua.dto.form.ShopingCartForm;
import ua.entity.*;
import ua.service.*;


public class ShopingCartEditor  extends PropertyEditorSupport{

	private final ShopingCartService shopingCartService;

	
	
	public ShopingCartEditor(ShopingCartService shopingCartService) {
		super();
		this.shopingCartService = shopingCartService;
	}

	public ShopingCartService getShopingCartService() {
		return shopingCartService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		ShopingCart shopingCart = shopingCartService.findOne(Integer.valueOf(text));
		setValue(shopingCart);
	}

	
	
	
}
