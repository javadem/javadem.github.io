package ua.editor;

import java.beans.PropertyEditorSupport;

import ua.entity.*;
import ua.service.*;


public class MeasureEditor  extends PropertyEditorSupport{
	
	private final MeasureService measureService;

	public MeasureEditor(MeasureService measureService) {
		super();
		this.measureService = measureService;
	}
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Measure measure = measureService.findOne(Integer.valueOf(text));
		setValue(measure);
	}

	public MeasureService getMeasureService() {
		return measureService;
	}

	
}
