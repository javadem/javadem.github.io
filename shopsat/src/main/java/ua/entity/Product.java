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
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "model_id")
	private Model model;
	
	@Column(name="_name")
	private String nameProduct;

	@Column(name="_description", length = 10000)
	private String description;
	
	@Column(name="_price")
	private BigDecimal price ;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "measure_id")
	private Measure measure;
	
//	@Column(name="_count")
//	private Integer count;
	
	@Transient
	private MultipartFile file;
	
	@Column(name = "version", nullable = true)
	@Version
	private Integer version;
	
/*	@ManyToMany
	(fetch = FetchType.EAGER, mappedBy="products")*/
/*	@JoinTable(name="product_shopingCart",
	joinColumns=@JoinColumn(name="id_product", referencedColumnName="id"),
	inverseJoinColumns=@JoinColumn(name="id_shopingCart", referencedColumnName="id"))
*/		@ManyToMany
		@JoinTable(name="cart_product",
		joinColumns = @JoinColumn(name="product_id"),
		inverseJoinColumns = @JoinColumn(name="cart_id")
		)
	private List<ShopingCart> shopingCarts = new ArrayList<>();
	
	

	
	public Product() {
	
	}



	public Product(Model model, String nameProduct, String description,
		BigDecimal price, Measure measure, MultipartFile file, Integer version,
		List<ShopingCart> shopingCarts) {
	super();
	this.model = model;
	this.nameProduct = nameProduct;
	this.description = description;
	this.price = price;
	this.measure = measure;
	this.file = file;
	this.version = version;
	this.shopingCarts = shopingCarts;
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

	



	public Measure getMeasure() {
		return measure;
	}


	public void setMeasure(Measure measure) {
		this.measure = measure;
	}


	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
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



/*	public List<User> getUsers() {
		return users;
	}



	public void setUsers(List<User> users) {
		this.users = users;
	}*/

	
	
}
