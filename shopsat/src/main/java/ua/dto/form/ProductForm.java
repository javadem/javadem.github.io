package ua.dto.form;


import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import ua.entity.Measure;
import ua.entity.Model;
import ua.entity.ShopingCart;
import ua.entity.User;

public class ProductForm {
	
	
	private Model model;
	
	private String nameProduct;

	private String description;
	
	private String price ;
	
	private Measure measure;
	
	private int id;

	private MultipartFile file;
	
	private String version;
	
	private List<ShopingCart> shopingCarts = new ArrayList<>();
	
//	private List<User> users = new ArrayList<>();
	
	
	public ProductForm() {
		
	}


	public ProductForm(Model model, String nameProduct, String description,
		String price, Measure measure, int id, MultipartFile file,
		String version) {
	super();
	this.model = model;
	this.nameProduct = nameProduct;
	this.description = description;
	this.price = price;
	this.measure = measure;
	this.id = id;
	this.file = file;
	this.version = version;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	

	public String getVersion() {
		return version;
	}



	public void setVersion(String version) {
		this.version = version;
	}



	public Measure getMeasure() {
		return measure;
	}



	public void setMeasure(Measure measure) {
		this.measure = measure;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public MultipartFile getFile() {
		return file;
	}



	public void setFile(MultipartFile file) {
		this.file = file;
	}


	public List<ShopingCart> getShopingCarts() {
		return shopingCarts;
	}


	public void setShopingCarts(List<ShopingCart> shopingCarts) {
		this.shopingCarts = shopingCarts;
	}


	

}
