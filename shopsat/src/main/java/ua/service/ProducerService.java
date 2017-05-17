package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import ua.dto.filter.ProducerFilter;
import ua.entity.Producer;

public interface ProducerService {

	Producer findOne(int id);
	
	List<Producer> findAll();
	
	void save(Producer producer);
	
	void delete(int id);
	
	Producer findOne(String name);
	
	List<Producer> findByCountryId(int id);
	
//	Page<Producer> findAll(Pageable pageable);
//
//	Page<Producer> findAll(BasicFilter filter, Pageable pageable);
	
	Page<Producer> findAll(ProducerFilter filter, Pageable pageable);
	
	
}
