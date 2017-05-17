package ua.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	
	@Query("SELECT i FROM User i ")
	List<User> findAll();
	
	@Query("SELECT DISTINCT c FROM User c  WHERE c.id=:id")
	User findOne(@Param("id")int id);
	
	@Query("SELECT DISTINCT c FROM User c  WHERE c.username=:username")
	User findByUsername(@Param("username")String username);

	@Query(value="SELECT i FROM User i ")
	Page<User> findAll(Pageable pageable);

	
	@Query("SELECT DISTINCT u FROM User u  "
			+ "LEFT JOIN FETCH u.shopingCart sc "
			+ "WHERE sc.id=:id"
			)
	User findOneUserByCartId(@Param("id")int id);
	
	@Query("SELECT  u FROM User u  "
			+ "LEFT JOIN FETCH u.shopingCart sc "
			+ "WHERE sc.id=:id"
			)
	List<User> findAllUsersByCartId(@Param("id")int id);

//	@Query(value="SELECT i FROM User i ")
//	Page<User> findAll(UserSpecification userSpecification, Pageable pageable);


}
