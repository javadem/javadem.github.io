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
@Table(name="country", indexes=@Index(columnList = "_name"))
public class Country  extends AbstractClass{

	@Column(name="_name")
	private String nameCountry;
	
	@OneToMany(mappedBy="country")
	private List<Producer> producers = new ArrayList<>();
	

	
	
	public Country() {
		
	}


	public Country(String nameCountry) {
		super();
		this.nameCountry = nameCountry;
	}

	

	public String getNameCountry() {
		return nameCountry;
	}

	public void setNameCountry(String nameCountry) {
		this.nameCountry = nameCountry;
	}

	public List<Producer> getProducers() {
		return producers;
	}



	public void setProducers(List<Producer> producers) {
		this.producers = producers;
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
