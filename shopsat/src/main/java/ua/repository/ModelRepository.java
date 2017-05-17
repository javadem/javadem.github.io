package ua.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import ua.dto.filter.BasicFilter;
import ua.entity.Category;
import ua.service.specification.ModelSpecification;
import ua.entity.*;

public interface ModelRepository extends JpaRepository<Model, Integer>, JpaSpecificationExecutor<Model>{

	@Query("SELECT i FROM Model i "
			+ "LEFT JOIN FETCH i.typeProduct "
			+ "LEFT JOIN FETCH i.producer")
	List<Model> findAll();
	
	@Query("SELECT DISTINCT i FROM Model i "
			+ "LEFT JOIN FETCH i.typeProduct "
			+ "LEFT JOIN FETCH i.producer "
			+ "WHERE i.id=:id")
	Model findOne(@Param("id")int id);
	
	@Query("SELECT DISTINCT c FROM Model c  "
			+ "WHERE c.nameModel=:name")
	Model findByName(@Param("name")String name);
	
	@Query(value="SELECT i FROM Model i "
//			, countQuery="SELECT count(i.id) FROM Model i"
			)
	Page<Model> findAll(Pageable pageable);
	
}
