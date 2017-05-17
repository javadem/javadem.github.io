package ua.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name="_user", indexes=@Index(columnList = "_name"))
public class User  extends AbstractClass implements UserDetails{
	
//	private static final long serialVersionUID = -8288001889276940237L;

	
	@Column(name="_name")
	private String username;
	
	@Column(name="_password")
	private String password;
	
	@Column(name="_email")
	private String email;
	
	@Enumerated
	private Role role;
	
/*	@OneToMany(mappedBy="user")
	private List<ShopingCart> shopingCarts = new ArrayList<>();*/
	
	@ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name = "shopingCart_id")
	private ShopingCart shopingCart;
	
/*	@OneToMany(mappedBy="user")
	private List<Cart> carts = new ArrayList<>();*/
	
//	@ManyToMany(mappedBy="users")
//	private List<Product> products = new ArrayList<>();
	
//	@OneToMany(mappedBy="user")
//	private List<Order> orders = new ArrayList<>();


	public User() {
	
	}
	
	public User(String username, String password, String email, Role role,
		ShopingCart shopingCart) {
	super();
	this.username = username;
	this.password = password;
	this.email = email;
	this.role = role;
	this.shopingCart = shopingCart;
}


	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
/*	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}*/



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
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> list = new ArrayList<>();
		list.add(new SimpleGrantedAuthority(role.name()));
		return list;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public ShopingCart getShopingCart() {
		return shopingCart;
	}

	public void setShopingCart(ShopingCart shopingCart) {
		this.shopingCart = shopingCart;
	}





	
}
