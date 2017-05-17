package ua.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
import ua.entity.*;

public interface CountryRepository extends JpaRepository<Country, Integer>, JpaSpecificationExecutor<Country>{

	@Query("SELECT DISTINCT c FROM Country c  WHERE c.id=:id")
	Country findOne(@Param("id")int id);
	
	@Query("SELECT DISTINCT c FROM Country c  WHERE c.nameCountry=:name")
	Country findByName(@Param("name")String name);
	
	@Query(value="SELECT i FROM Country i "
//			, countQuery="SELECT count(i.id) FROM Country i"
			)
	Page<Country> findAll(Pageable pageable);

}
