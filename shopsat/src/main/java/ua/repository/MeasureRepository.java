package ua.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ua.entity.Measure;

public interface MeasureRepository extends JpaRepository<Measure, Integer>, JpaSpecificationExecutor<Measure>{
	
	@Query("SELECT DISTINCT c FROM Measure c  WHERE c.id=:id")
	Measure findOne(@Param("id")int id);
	
	@Query("SELECT i FROM Measure i ")
	List<Measure> findAll();
	
	@Query("SELECT DISTINCT c FROM Measure c  WHERE c.nameMeasure=:name")
	Measure findByName(@Param("name")String name);
	
	@Query(value="SELECT i FROM Measure i "
//			, countQuery="SELECT count(i.id) FROM Measure i"
			)
	Page<Measure> findAll(Pageable pageable);

}
