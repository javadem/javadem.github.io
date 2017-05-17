package ua.dto.form;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ua.entity.Product;
import ua.entity.Role;
import ua.entity.ShopingCart;

public class UserForm {
	

	private int id;
	
//	 @NotNull
//	 @Size(min=4, max=30)
	private String username;
	
//	 @NotNull
//	 @Size(min=4, max=30)
	private String password;
	
//	 @NotNull
//	 @Size(min=4, max=30)
	private String email;
	

	private Role role;
	
	
	private ShopingCart shopingCart;
//	private List<Product> products = new ArrayList<>();


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}


	public UserForm() {
		super();
		// TODO Auto-generated constructor stub
	}


/*	public List<Product> getProducts() {
		return products;
	}


	public void setProducts(List<Product> products) {
		this.products = products;
	}
*/

	@Override
	public String toString() {
		return "UserForm [username=" + username + ", email=" + email + "]";
	}
	
	
	

}
