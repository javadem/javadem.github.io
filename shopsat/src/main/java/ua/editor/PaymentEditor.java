package ua.editor;

import java.beans.PropertyEditorSupport;

import ua.entity.*;
import ua.service.*;


public class PaymentEditor  extends PropertyEditorSupport{

	private final PaymentService paymentService;

	public PaymentEditor(PaymentService paymentService) {
		super();
		this.paymentService = paymentService;
	}

	public PaymentService getPaymentService() {
		return paymentService;
	}

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		Payment payment = paymentService.findOne(Integer.valueOf(text));
		setValue(payment);
	}
	
	

	
	
}
