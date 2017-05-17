package ua.entity;

import java.util.ArrayList;
import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Index;

import ua.entity.Category;

@Entity
@Table(name="type_product", indexes=@Index(columnList = "_name"))
public class TypeProduct  extends AbstractClass{
	
//	@ManyToOne(fetch=FetchType.LAZY, cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "category_id")
	private Category category;
	
	@Column(name="_name")
	private String nameTypeProduct;
	
	
	@OneToMany(mappedBy="typeProduct")
	private List<Model> models = new ArrayList<>();

	
	public TypeProduct() {
		
	}
	

	public TypeProduct(Category category, String nameTypeProduct) {
		super();
		this.category = category;
		this.nameTypeProduct = nameTypeProduct;
	}


	public String getNameTypeProduct() {
		return nameTypeProduct;
	}


	public void setNameTypeProduct(String nameTypeProduct) {
		this.nameTypeProduct = nameTypeProduct;
	}


	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Model> getModels() {
		return models;
	}


	public void setModels(List<Model> models) {
		this.models = models;
	}


	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return super.getId();
	}


	@Override
	public void setId(Integer id) {
		// TODO Auto-generated method stub
		super.setId(id);
	}


	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}


	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}


	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
	}


	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	
	
}
