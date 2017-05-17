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
@Table(name="model", indexes=@Index(columnList = "_name"))
public class Model  extends AbstractClass{
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "producer_id")
	private Producer producer;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "typeProduct_id")
	private TypeProduct typeProduct ;
	
	@Column(name="_name")
	private String nameModel;
		
	@OneToMany(mappedBy="model")
	private List<Product> products = new ArrayList<>();

	

	public Model() {
		
	}




	public Model(Producer producer, TypeProduct typeProduct, String nameModel) {
		super();
		this.producer = producer;
		this.typeProduct = typeProduct;
		this.nameModel = nameModel;
	}




	public Producer getProducer() {
		return producer;
	}




	public void setProducer(Producer producer) {
		this.producer = producer;
	}




	public TypeProduct getTypeProduct() {
		return typeProduct;
	}




	public void setTypeProduct(TypeProduct typeProduct) {
		this.typeProduct = typeProduct;
	}




	public String getNameModel() {
		return nameModel;
	}




	public void setNameModel(String nameModel) {
		this.nameModel = nameModel;
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
