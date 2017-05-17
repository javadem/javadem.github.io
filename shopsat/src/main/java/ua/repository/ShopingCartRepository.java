package ua.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.entity.Model;
import ua.entity.Product;
import ua.entity.ShopingCart;

public interface ShopingCartRepository extends JpaRepository<ShopingCart, Integer>{
	
//	@Query("SELECT DISTINCT i FROM Product i "
////			+ "LEFT JOIN FETCH i.model "
////			+ "LEFT JOIN FETCH i.measure "
//			+ " WHERE i.id=:id"
//			)
//	Product findOne(@Param("id")int id);
	
	
	@Query("SELECT i FROM ShopingCart i "
			+ "LEFT JOIN i.products p "
			+ "LEFT JOIN i.users u"
			)
	List<ShopingCart> findAll();
	
	@Query("SELECT DISTINCT sc FROM ShopingCart sc "
			+ "LEFT JOIN sc.products p "
			+ "LEFT JOIN sc.users u "
//			+ "LEFT JOIN sc.count c "
			+ "WHERE sc.id=:id")
	ShopingCart findOne(@Param("id")int id);
	
/*	@Query("SELECT DISTINCT i FROM ShopingCart i  WHERE i.id=:id" )
	ShopingCart findOne(@Param("id")int id);*/
	
	@Query("SELECT  i FROM ShopingCart i "
			+ "JOIN i.users u "
			+ "WHERE u.id=:id" 
			)
	List<ShopingCart> findAllCartsUserId(@Param("id")int id);
	
	
	@Query("SELECT  i FROM ShopingCart i "
			+ "JOIN i.users u "
			+ "WHERE u.id=:id" 
			)
	ShopingCart findOneCartUserId(@Param("id")int id);
	
	
	@Query("SELECT  i FROM ShopingCart i "
			+ "JOIN i.users u "
			+ "WHERE u.username=:name" 
			)
	ShopingCart findOneCartUserName(@Param("name")String name);
	
}
