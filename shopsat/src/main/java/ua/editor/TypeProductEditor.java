package ua.editor;

import java.beans.PropertyEditorSupport;

import ua.entity.*;
import ua.service.*;

public class TypeProductEditor extends PropertyEditorSupport{
	
	private final TypeProductService typeProductService;

	public TypeProductEditor(TypeProductService typeProductService) {
		this.typeProductService = typeProductService;
	}


	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		TypeProduct typeProduct = typeProductService.findOne(Integer.valueOf(text));
		setValue(typeProduct);
	}


	public TypeProductService getTypeProductService() {
		return typeProductService;
	}

	
}
