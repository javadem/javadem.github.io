package ua.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Index;

@Entity
@Table(name="category", indexes=@Index(columnList = "_name"))
public class Category  extends AbstractClass{
	
	@Column(name="_name")
	private String nameCategory;

	@OneToMany(mappedBy="category")
	private List<TypeProduct> typeProducts = new ArrayList<>();



	public Category(String nameCategory, List<TypeProduct> typeProducts) {
		super();
		this.nameCategory = nameCategory;
		this.typeProducts = typeProducts;
	}

	public Category() {
		
	}

	public String getNameCategory() {
		return nameCategory;
	}

	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}

	public Category(String nameCategory) {
	super();
	this.nameCategory = nameCategory;
}


	public List<TypeProduct> getTypeProducts() {
		return typeProducts;
	}



	public void setTypeProducts(List<TypeProduct> typeProducts) {
		this.typeProducts = typeProducts;
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





	
}
