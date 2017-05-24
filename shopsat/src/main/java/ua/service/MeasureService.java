package ua.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.dto.filter.BasicFilter;
import ua.entity.*;

public interface MeasureService {
	
	MeasureString findOne(int id);
	
	List<MeasureString> findAll();
	
	void save(MeasureString measure);
	
	void delete(int id);
	
	MeasureString findOne(String name);
	
	Page<MeasureString> findAll(Pageable pageable);

	Page<MeasureString> findAll(BasicFilter filter, Pageable pageable);
}
