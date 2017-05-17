package ua.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.dto.filter.BasicFilter;
import ua.entity.*;

public interface MeasureService {
	
	Measure findOne(int id);
	
	List<Measure> findAll();
	
	void save(Measure measure);
	
	void delete(int id);
	
	Measure findOne(String name);
	
	Page<Measure> findAll(Pageable pageable);

	Page<Measure> findAll(BasicFilter filter, Pageable pageable);
}
