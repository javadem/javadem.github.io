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
import ua.entity.Producer;
import ua.service.specification.ProducerSpecification;

public interface ProducerRepository extends JpaRepository<Producer, Integer>, JpaSpecificationExecutor<Producer>{

	@Query("SELECT i FROM Producer i LEFT JOIN FETCH i.country ")
	List<Producer> findAll();
	
	@Query("SELECT DISTINCT c FROM Producer c LEFT JOIN FETCH c.country WHERE "
			+ "c.id=:id"
			)
	Producer findOne(@Param("id")int id);
	
	@Query("SELECT DISTINCT c FROM Producer c  WHERE c.nameProducer=:name")
	Producer findByName(@Param("name")String name);
	
	@Query(value="SELECT i FROM Producer i "
//			, countQuery="SELECT count(i.id) FROM Producer i"
			)
	Page<Producer> findAll(Pageable pageable);
	
}
