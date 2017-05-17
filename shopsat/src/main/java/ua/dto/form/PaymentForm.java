package ua.dto.form;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;

import org.springframework.web.multipart.MultipartFile;

import ua.entity.Measure;
import ua.entity.Model;
import ua.entity.ShopingCart;
import ua.entity.User;

public class PaymentForm {
	
	private String email;
	
	
	private String amount ;
	

	private String text;
	
	
	
	public PaymentForm() {
		
	}



	public PaymentForm(String email, String amount, String text) {
		super();
		this.email = email;
		this.amount = amount;
		this.text = text;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getAmount() {
		return amount;
	}



	public void setAmount(String amount) {
		this.amount = amount;
	}



	public String getText() {
		return text;
	}



	public void setText(String text) {
		this.text = text;
	}



}
