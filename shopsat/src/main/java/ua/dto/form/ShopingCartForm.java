package ua.dto.form;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.springframework.web.multipart.MultipartFile;

import ua.entity.Measure;
import ua.entity.Model;
import ua.entity.Product;
import ua.entity.ShopingCart;
import ua.entity.User;

public class ShopingCartForm {
	
	
	private List<User> users  = new ArrayList<User>();
	
	
	private List<Product> products  = new ArrayList<Product>() ;
	
	private int id;
	
	private int count;
	
	
	private String amount ;
	
	
	public ShopingCartForm() {
		
	}


	public ShopingCartForm(List<User> users, List<Product> products, int id,
			int count, String amount) {
		super();
		this.users = users;
		this.products = products;
		this.id = id;
		this.count = count;
		this.amount = amount;
	}


	public List<User> getUsers() {
		return users;
	}


	public void setUsers(List<User> users) {
		this.users = users;
	}


	public List<Product> getProducts() {
		return products;
	}


	public void setProducts(List<Product> products) {
		this.products = products;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	public String getAmount() {
		return amount;
	}


	public void setAmount(String amount) {
		this.amount = amount;
	}

	



}
