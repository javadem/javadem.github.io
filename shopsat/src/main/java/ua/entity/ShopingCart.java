package ua.entity;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;


@Entity
@Table(name="shopingCart"/*, indexes=@Index(columnList = "_name")*/)
public class ShopingCart extends AbstractClass{

	
	
	@OneToMany(mappedBy="shopingCart", fetch = FetchType.LAZY)
	private List<User> users  = new ArrayList<User>();
	
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="cart_product", 
    joinColumns = @JoinColumn(name="cart_id"),
    inverseJoinColumns = @JoinColumn(name="product_id"))
	private List<Product> products ;
	
	
	@Column(name="_count")
	private int count;
	
	@Column(name="_amount")
	private String amount = "0.00";
	
	@OneToOne(mappedBy="shopingCart")
	@JoinColumn(name = "payment_id")
	private Payment payment;
	
/*	@OneToMany(mappedBy="shopingCart", fetch = FetchType.LAZY)
	private List<Payment> payments  = new ArrayList<Payment>();*/
	

	public ShopingCart() {
		
	}

	public ShopingCart(List<User> users, List<Product> products, int count) {
		super();
		this.users = users;
		this.products = new ArrayList<Product>() ;
		this.count = count;
	}



	public ShopingCart(List<User> users, List<Product> products, int count,
			String amount) {
		super();
		this.users = users;
		this.products = products;
		this.count = count;
		this.amount = amount;
	}
	
	

public ShopingCart(List<User> users, List<Product> products, int count,
			String amount, Payment payment) {
		super();
		this.users = users;
		this.products = products;
		this.count = count;
		this.amount = amount;
		this.payment = payment;
	}

/*	public ShopingCart(List<User> users, List<Product> products, int count,
			String amount, List<Payment> payments) {
		super();
		this.users = users;
		this.products = products;
		this.count = count;
		this.amount = amount;
		this.payments = payments;
	}*/

	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}



	public List<Product> getProducts() {
		return products;
	}



	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public void add(Product product) {
		// TODO Auto-generated method stub
		products.add(product);
//		count = products.size();
		count = 1;
		amount = (new BigDecimal(amount).add(product.getPrice())).toString();

	}
	
	public void deleteProductFromCart(int id) {
		// TODO Auto-generated method stub
		
/*		List<Product> products = 
		products.;
//		count = products.size();
		count = 1;
		amount = (new BigDecimal(amount).add(product.getPrice())).toString();*/

	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
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

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}



}
