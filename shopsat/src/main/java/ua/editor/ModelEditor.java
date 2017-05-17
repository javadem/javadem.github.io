package ua.editor;

import java.beans.PropertyEditorSupport;


import ua.service.*;

public class ModelEditor extends PropertyEditorSupport{
	
	private final ModelService modelService;

	public ModelEditor(ModelService modelService) {
		super();
		this.modelService = modelService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		ua.entity.Model model = modelService.findOne(Integer.valueOf(text));
		setValue(model);
	}

	public ModelService getModelService() {
		return modelService;
	}
	
	

}
