
package ua.service;

import java.security.Principal;
import java.util.List;

import ua.dto.form.ProductForm;
import ua.dto.form.ShopingCartForm;
import ua.entity.Producer;
import ua.entity.Product;
import ua.entity.ShopingCart;
import ua.entity.User;

public interface ShopingCartService {
	
//	ShopingCart findOne(int id);
	
//	ShopingCartForm findOneCartById(int id);
	
//	void save(ShopingCartForm shoppingCartForm);
	
	void save(ShopingCart shoppingCart);
	
	void delete(int id);
	
	List<ShopingCart> findAll();
	
//	void addToShoppingCart(int userId, int itemId);

	void addToShopingCart(int userId, int productId);
	
	ShopingCart findOneCartByUserId(int userId);

	List<ShopingCart> findAllCartsByUserId(int userId);

	ShopingCart findOne(int id);
	
	ShopingCart findOneCartByUserName(Principal principal);

	void deleteProductFromCart(int shopingCartId, int productId); 
//	void save(User user, Product product);

}
