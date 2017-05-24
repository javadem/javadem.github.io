package ua.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ua.entity.MeasureString;

public interface MeasureRepository extends JpaRepository<MeasureString, Integer>, JpaSpecificationExecutor<MeasureString>{
	
	@Query("SELECT DISTINCT c FROM Measure c  WHERE c.id=:id")
	MeasureString findOne(@Param("id")int id);
	
	@Query("SELECT i FROM Measure i ")
	List<MeasureString> findAll();
	
	@Query("SELECT DISTINCT c FROM Measure c  WHERE c.nameMeasure=:name")
	MeasureString findByName(@Param("name")String name);
	
	@Query(value="SELECT i FROM Measure i "
//			, countQuery="SELECT count(i.id) FROM Measure i"
			)
	Page<MeasureString> findAll(Pageable pageable);

}
