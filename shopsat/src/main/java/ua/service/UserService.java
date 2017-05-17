package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CookieValue;

import ua.dto.filter.BasicFilter;
import ua.dto.filter.UserFilter;
import ua.dto.form.UserForm;
import ua.entity.User;

public interface UserService{

//	void save(User user);
	
	User findOne(int id);
//	
	void delete(int id);
	
	void update(int id, User user);
//	
	User findOne(String name);
//	
	List<User> findAll();
//	
//	Page<User> findAll(Pageable pageable);
//
//	Page<User> findAll(BasicFilter filter, Pageable pageable);

	Page<User> findAll(Pageable pageable);

//	void save(UserForm userForm);
	
//	Page<User> findAll(UserFilter filter, Pageable pageable);

//	void save(UserForm userForm);

	void save(User user);
	
	int createNewUser();
	
    User findUserByCartId(int cartId);
    
    List<User> findAllUsersByCartId(int cartId);
	
	void addToShopingCart(int userId, int productId);

//	void addToShoppingCart(int userId, int itemId);
	
	void saveWithCookie(@CookieValue(defaultValue="0", name="userId") int id, User userForm);

}
