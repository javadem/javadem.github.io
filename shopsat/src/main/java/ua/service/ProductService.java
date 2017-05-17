package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.web.multipart.MultipartFile;

import ua.dto.form.ProductForm;
import ua.entity.Product;
import ua.dto.filter.ProductFilter;

public interface ProductService {

//	Product findOne(int id);
	
	List<Product> findAll();
	
//	void save(Product product);
	
//	void update(Product product);
	
	void delete(int id);
	
	void update(int id);
	
	Product findOne(String name);
	
	Product findOneProductById(int id);
	
//	Product findOne(int id);
	
	ProductForm findOne(int id);
	
	void save(ProductForm productForm);
	

	
	Page<Product> findAll(ProductFilter filter, Pageable pageable);

//	int findCount(int id);

	List<Product> findByUserId(int userId);
	
//	void save(ProductForm productForm, MultipartFile image);

//	List<Product> addProductToOrder(ProductForm productForm);

//	List<Product> addToOrder(Product product);

	List<Product> addToOrder(int id);

	int findCount(int id);

	List<Product> findProductsByCartId(int cartId);
	
//	void update(int id);

	

	
}
