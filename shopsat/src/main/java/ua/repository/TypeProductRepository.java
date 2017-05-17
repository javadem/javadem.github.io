package ua.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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
import ua.service.specification.TypeProductSpecification;
import ua.entity.*;

public interface TypeProductRepository extends JpaRepository<TypeProduct, Integer>, JpaSpecificationExecutor<TypeProduct>{

	@Query("SELECT i FROM TypeProduct i LEFT JOIN FETCH i.category ")
	List<TypeProduct> findAll();
	
	@Query("SELECT DISTINCT i FROM TypeProduct i LEFT JOIN FETCH i.category WHERE "
			+ "i.id=:id"
			)
	TypeProduct findOne(@Param("id")int id);
	
	@Query("SELECT DISTINCT c FROM TypeProduct c  WHERE c.nameTypeProduct=:name")
	TypeProduct findByName(@Param("name")String name);
	
	@Query(value="SELECT i FROM TypeProduct i "
//			, countQuery="SELECT count(i.id) FROM TypeProduct i"
			)
	Page<TypeProduct> findAll(Pageable pageable);
}
