package ua.service.implementation;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.engine.transaction.jta.platform.internal.SynchronizationRegistryBasedSynchronizationStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CookieValue;

import ua.dto.filter.UserFilter;
import ua.dto.form.UserForm;
import ua.entity.Product;
import ua.entity.Role;
import ua.entity.ShopingCart;
import ua.entity.User;
import ua.repository.ProductRepository;
import ua.repository.ShopingCartRepository;
import ua.repository.UserRepository;
import ua.service.UserService;
import ua.service.specification.UserSpecification;
import ua.validator.UserValidator;

@Repository
@Transactional
@Service("userDetailsService")
public class UserServiceImpl implements UserDetailsService, UserService, Principal {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private ShopingCartRepository shopingCartRepository;
	
	
	
	
	
	public UserServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

	public UserServiceImpl(UserRepository userRepository,
			ProductRepository productRepository, BCryptPasswordEncoder encoder,
			ShopingCartRepository shopingCartRepository) {
		super();
		this.userRepository = userRepository;
		this.productRepository = productRepository;
		this.encoder = encoder;
		this.shopingCartRepository = shopingCartRepository;
	}




	public UserRepository getUserRepository() {
		return userRepository;
	}




	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}




	public ProductRepository getProductRepository() {
		return productRepository;
	}




	public void setProductRepository(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}




	public BCryptPasswordEncoder getEncoder() {
		return encoder;
	}




	public void setEncoder(BCryptPasswordEncoder encoder) {
		this.encoder = encoder;
	}




	public ShopingCartRepository getShopingCartRepository() {
		return shopingCartRepository;
	}




	public void setShopingCartRepository(ShopingCartRepository shopingCartRepository) {
		this.shopingCartRepository = shopingCartRepository;
	}




	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		return userRepository.findByUsername(username);
	}
	
	
	
	
	
		@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}




		@Override
		@Transactional
	public int createNewUser() {
		// TODO Auto-generated method stub
			User newUser = new User();
			System.out.println(newUser.getId());
//			newUser.setRole(Role.ROLE_USER);
			newUser.setRole(Role.ROLE_ANONYMOUS);
			newUser.setShopingCart(new ShopingCart());
			return userRepository.saveAndFlush(newUser).getId();
	}


	@Override
	@Transactional
	public void save(User userForm) {
		User user = new User();
		user.setEmail(userForm.getEmail());
		user.setUsername(userForm.getUsername());
		user.setPassword(encoder.encode(userForm.getPassword()));
		user.setRole(Role.ROLE_USER);
		user.setShopingCart(new ShopingCart());
//		user.getShopingCart().setProducts(products);
//		user.setShopingCart(userForm.getShopingCart());
//		user.setShopingCart(shopingCartRepository.findOne(id));
		userRepository.save(user);
	}
	
	
	
/*	@Override
	public void save(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		user.setRole(Role.ROLE_USER);
		user.setEmail(user.getEmail());
		user.setUsername(user.getUsername());
		user.setShopingCart(new ShopingCart());
		userRepository.save(user);
	}*/






	@Override
	@Transactional
	public void saveWithCookie(@CookieValue(value="id", name="userId") int id, User userForm) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setEmail(userForm.getEmail());
		user.setUsername(userForm.getUsername());
		user.setPassword(encoder.encode(userForm.getPassword()));
		user.setRole(Role.ROLE_USER);
//		user.setShopingCart(new ShopingCart());
//		user.setShopingCart(userForm.getShopingCart());
		user.setShopingCart(new ShopingCart());
//		HttpServletRequest httpServletRequest;
//		Cookie cookie[] = httpServletRequest.getCookies();
		System.out.println(id);
		user.getShopingCart().setProducts(shopingCartRepository.findOne(id).getProducts());
		userRepository.save(user);
	}




	@Override
	@Transactional
	public void update(int id, User userForm) {
		// TODO Auto-generated method stub
		System.out.println(userForm.getUsername());
		User user = userRepository.findOne(id);
		user.setEmail(userForm.getEmail());
		user.setPassword(userForm.getPassword());
		user.setUsername(userForm.getUsername());
		System.out.println(user.getUsername());
		user.setId(id);
		System.out.println("eeeeeeeeeeeeeeeeeee");
		userRepository.save(user);
		System.out.println("ffffffffffffffffff");
	}




	@PostConstruct
	public void admin(){
		User user = userRepository.findByUsername("admin");
		if(user==null){
			user = new User();
			user.setEmail("admin@com.ua");
			user.setPassword(encoder.encode("admin"));
			user.setRole(Role.ROLE_ADMIN);
			user.setUsername("admin");
			user.setShopingCart(new ShopingCart());
			userRepository.save(user);
		}
	}


	
	@Override
	@Transactional(readOnly=true)
	public User findOne(int id) {
		// TODO Auto-generated method stub
		return userRepository.findOne(id);
	}

	@Override
	@Transactional(readOnly=true)
	public User findOne(String name) {
		// TODO Auto-generated method stub
		return userRepository.findByUsername(name);
	}

	@Override
	@Transactional(readOnly=true)
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Page<User> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return userRepository.findAll( pageable);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		userRepository.delete(id);
	}

	
	@Override
	public User findUserByCartId(int cartId) {
		// TODO Auto-generated method stub
		return userRepository.findOneUserByCartId(cartId);
	}

	@Override
	@Transactional
	public void addToShopingCart(int userId, int productId) {
	
		System.out.println(userId);
		User user = userRepository.findOne(userId);
		ShopingCart cart = user.getShopingCart();
		if(cart==null){
			cart = shopingCartRepository.save(new ShopingCart());
			user.setShopingCart(cart);
		}
//		int amountCommon = cart.getAmountCommon();
		Product product = productRepository.findOne(productId);
		cart.add(product);

	}




	@Override
	public List<User> findAllUsersByCartId(int cartId) {
		// TODO Auto-generated method stub
		return userRepository.findAllUsersByCartId(cartId);
	}


	
}