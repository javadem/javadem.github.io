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
@Entity
@Table(name="producer", indexes=@Index(columnList = "_name"))
public class Producer  extends AbstractClass{
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "country_id")
	private Country country;
	
	@Column(name="_name")
	private String nameProducer;
	
	@OneToMany(mappedBy="producer")
	private List<Product> products = new ArrayList<>();

	
	public Producer() {
		
	}



	public Producer(Country country, String nameProducer) {
		super();
		this.country = country;
		this.nameProducer = nameProducer;
	}


	public String getNameProducer() {
		return nameProducer;
	}



	public void setNameProducer(String nameProducer) {
		this.nameProducer = nameProducer;
	}



	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
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



	public List<Product> getProducts() {
		return products;
	}



	public void setProducts(List<Product> products) {
		this.products = products;
	}

	

	
	

	
}
