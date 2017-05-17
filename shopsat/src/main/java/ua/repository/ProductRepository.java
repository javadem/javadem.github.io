package ua.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



import ua.dto.filter.ProductFilter;
import ua.dto.form.ProductForm;
import ua.entity.Product;


public interface ProductRepository extends JpaRepository<Product, Integer>, JpaSpecificationExecutor<Product>{

	@Query("SELECT i FROM Product i "
			+ "LEFT JOIN FETCH i.model "
			+ "LEFT JOIN FETCH i.measure "
			)
	List<Product> findAll();
	
	
/*	@Query("SELECT DISTINCT i FROM Product i "
//			+ "LEFT JOIN FETCH i.model "
//			+ "LEFT JOIN FETCH i.measure "
			+ " WHERE i.id=:id"
			)
	ProductForm findOne(@Param("id")int id);*/
	
	@Query("SELECT DISTINCT i FROM Product i "
			+ "LEFT JOIN FETCH i.model "
			+ "LEFT JOIN FETCH i.measure "
			+ " WHERE i.id=:id"
			)
	Product findOne(@Param("id") int id);
	
	

//	@Query("SELECT  DISTINCT i FROM ProductForm i  WHERE i.id=:id")
//	ProductForm findOne(@Param("id")int id);
	
	
	@Query("SELECT DISTINCT c FROM Product c  WHERE c.nameProduct=:name")
	Product findByName(@Param("name") String name);
	
	
	@Query(value="SELECT i FROM Product i "
			+ "LEFT JOIN FETCH i.model "
			+ "LEFT JOIN FETCH i.measure "
			
			, countQuery="SELECT count(i.id) FROM Product i"
			)
	Page<Product> findAll(Pageable pageable);
	

	@Query(value="SELECT i FROM Product i "
			+ "LEFT JOIN FETCH i.model "
			+ "LEFT JOIN FETCH i.measure "

//			+ "WHERE i.model IN (SELECT m FROM Model m LEFT JOIN FETCH m.producer )"
			
			, countQuery="SELECT count(i.id) FROM Product i"
			)
	Page<Product> findAll(ProductFilter filter, Pageable pageable);
	

	
	
	@Query("SELECT sc.count FROM User u JOIN u.shopingCart sc WHERE u.id=:userId")
	Integer findCount(@Param("userId") int userId);

	@Query("SELECT p FROM Product p "
			+ "JOIN p.shopingCarts sc "
			+ "JOIN sc.users u "
			+ "WHERE u.id=:userId"
			)
	List<Product> findProductByUserId(@Param("userId") int userId);
	
	
	@Query("SELECT p FROM Product p "
//	@Query("SELECT DISTINCT p FROM Product p "
			+ "LEFT JOIN FETCH p.shopingCarts sc "
			+ "WHERE sc.id = :cartId"
			)
	List<Product> findProductByCartId(@Param("cartId") int cartId);

//	@Query("SELECT p FROM Product p LEFT JOIN ShopingCart sc WHERE sc.id =1")
//	List<Product> findProductByCartId(@Param("cartId") int cartId);

}
