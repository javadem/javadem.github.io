package ua.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.dto.filter.BasicFilter;
import ua.entity.Category;
import ua.service.specification.CategorySpecification;

//@Component
public interface CategoryRepository extends JpaRepository<Category,  Integer>, JpaSpecificationExecutor<Category>{

	@Query("SELECT DISTINCT c FROM Category c  WHERE c.id=:id")
	Category findOne(@Param("id")int id);
	
	
	@Query("SELECT  c FROM Category c")
	List<Category> findAll();
	

	@Query("SELECT DISTINCT c FROM Category c  WHERE c.nameCategory=:name")
	Category findByName(@Param("name")String name);
	
	
	@Query(value="SELECT i FROM Category i "
//			, countQuery="SELECT count(i.id) FROM Category i"
			)
	Page<Category> findAll(Pageable pageable);
	

	
//	@Query(value="SELECT i FROM Category i "
//			, countQuery="SELECT count(i.id) FROM Category i"
//			)
//	Page<Category> findAll( CategorySpecification categorySpecification,  Pageable pageable);
}
