package ua.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.springframework.web.multipart.MultipartFile;

import ua.entity.Category;

@Entity
@Table(name="product", indexes=@Index(columnList = "_name, _description, _price") )
public class Product  extends AbstractClass{
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "producer_id")
	private Producer producer;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "model_id")
	private Model model;
	

	private MeasureDigital measureDigital;
	
//	private ValueDigital valueDigital;
	

	@Column(name="_description", length = 10000)
	private String description;
	
	@Column(name="_price")
	private BigDecimal price ;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "measure_id")
	private MeasureString measure;
	
	
//	private ValueString valueString;
	

	
	@Transient
	private MultipartFile file;
	
	@Column(name = "version", nullable = true)
	@Version
	private Integer version;
	
		@ManyToMany
		@JoinTable(name="cart_product",
		joinColumns = @JoinColumn(name="product_id"),
		inverseJoinColumns = @JoinColumn(name="cart_id")
		)
	private List<ShopingCart> shopingCarts = new ArrayList<>();
	
	

	
	public Product() {
	
	}


	public Product(Producer producer, Model model, MeasureDigital measureDigital, ValueDigital valueDigital,
			String description, BigDecimal price, MeasureString measure, ValueString valueString, MultipartFile file,
			Integer version) {
		super();
		this.producer = producer;
		this.model = model;
		this.measureDigital = measureDigital;
		this.description = description;
		this.price = price;
		this.measure = measure;
		this.file = file;
		this.version = version;
	}






	public Model getModel() {
		return model;
	}
	public void setModel(Model model) {
		this.model = model;
	}
	
	
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}


	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	



	public MeasureString getMeasure() {
		return measure;
	}


	public void setMeasure(MeasureString measure) {
		this.measure = measure;
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




	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
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


	public Producer getProducer() {
		return producer;
	}


	public void setProducer(Producer producer) {
		this.producer = producer;
	}


	public MeasureDigital getMeasureDigital() {
		return measureDigital;
	}


	public void setMeasureDigital(MeasureDigital measureDigital) {
		this.measureDigital = measureDigital;
	}




	
	
}
