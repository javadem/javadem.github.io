package ua.service.implementation;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.dto.form.ShopingCartForm;
import ua.entity.Product;
import ua.entity.ShopingCart;
import ua.entity.User;
import ua.repository.MeasureRepository;
import ua.repository.ModelRepository;
import ua.repository.ProductRepository;
import ua.repository.ShopingCartRepository;
import ua.repository.UserRepository;
import ua.service.FileWriter;
import ua.service.ShopingCartService;

@Service
public class ShopingCartServiceImpl implements ShopingCartService{
	
	@Autowired
	private ProductRepository  productRepository;
	
	@Autowired
	private ShopingCartRepository  shopingCartRepository;
	
	@Autowired
	private UserRepository  userRepository;
	
	
	public ShopingCartServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ShopingCartServiceImpl(ProductRepository productRepository,
			ShopingCartRepository shopingCartRepository,
			UserRepository userRepository) {
		super();
		this.productRepository = productRepository;
		this.shopingCartRepository = shopingCartRepository;
		this.userRepository = userRepository;
	}


	public ProductRepository getProductRepository() {
		return productRepository;
	}

	public void setProductRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public ShopingCartRepository getShopingCartRepository() {
		return shopingCartRepository;
	}

	public void setShopingCartRepository(ShopingCartRepository shopingCartRepository) {
		this.shopingCartRepository = shopingCartRepository;
	}

	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}


	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		shopingCartRepository.delete(id);
	}

	
	
	@Override
	public ShopingCart findOne(int id) {
		// TODO Auto-generated method stub
		return shopingCartRepository.findOne(id);
	}



	@Override
	public void save(ShopingCart shoppingCart) {
		// TODO Auto-generated method stub
		shopingCartRepository.save(shoppingCart);
	}

	@Override
	public List<ShopingCart> findAll() {
		// TODO Auto-generated method stub
		return shopingCartRepository.findAll();
	}
	
	@Override
	@Transactional
	public void addToShopingCart(int userId, int productId) {
		
		User user = userRepository.findOne(userId);
		ShopingCart cart = user.getShopingCart();
		if(cart==null){
			cart = shopingCartRepository.save(new ShopingCart());
			user.setShopingCart(cart);
		}

		Product product = productRepository.findOne(productId);
		
		cart.add(product);
	}
	
	

	@Override
	public void deleteProductFromCart(int shopingCartId, int productId) {
		// TODO Auto-generated method stub

		ShopingCart shopingCart = shopingCartRepository.findOne(shopingCartId);

		List<Product> productsOld = shopingCart.getProducts();

		Iterator<Product> iterator = productsOld.iterator();
		while (iterator.hasNext()) {
			Product product = iterator.next();

			if(product.getId()==productId) {

			iterator.remove();
			
			System.out.println(product);
			
			String amountAfterDelete = (new BigDecimal(shopingCart.getAmount())).subtract(product.getPrice()).toString();
		shopingCart.setAmount(amountAfterDelete);
			shopingCartRepository.save(shopingCart);
			return;
			}
		}
	}

	
	@Override
	public List<ShopingCart> findAllCartsByUserId(int userId) {
		
		return shopingCartRepository.findAllCartsUserId(userId);
	}
	

	@Override
	public ShopingCart findOneCartByUserId(int userId) {
		// TODO Auto-generated method stub
		return shopingCartRepository.findOneCartUserId(userId);
	}



	@Override
	public ShopingCart findOneCartByUserName(Principal principal) {
		// TODO Auto-generated method stub
		String userName = principal.getName();
		return shopingCartRepository.findOneCartUserName(userName);
	}


	
	

}
