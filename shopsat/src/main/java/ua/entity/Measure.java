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
@Table(name="measure", indexes=@Index(columnList = "_name"))
public class Measure extends AbstractClass{
	
	@Column(name="_name")
	private String nameMeasure;
	
	@OneToMany(mappedBy="measure")
	private List<Product> products = new ArrayList<>();
	

	

	public Measure() {
		
	}


	public Measure(String nameMeasure) {
		super();
		this.nameMeasure = nameMeasure;
	}


	public String getNameMeasure() {
		return nameMeasure;
	}


	public void setNameMeasure(String nameMeasure) {
		this.nameMeasure = nameMeasure;
	}


	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
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
	public boolean equals(Object arg0) {
		// TODO Auto-generated method stub
		return super.equals(arg0);
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
