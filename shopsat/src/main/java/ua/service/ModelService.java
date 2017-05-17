package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import ua.dto.filter.ModelFilter;
import ua.entity.Model;

public interface ModelService {

	ua.entity.Model findOne(int id);
	
	List<Model> findAll();
	
//	void save( ua.entity.Model model);
	void save( Model model);
	
	void delete(int id);
	
	Model findOne(String name);
	
	List<Model> findByTypeProductId(int id);
	
	List<Model> findByProducerId(int id);
	
	Page<Model> findAll(Pageable pageable);
//
//	Page<Model> findAll(BasicFilter filter, Pageable pageable);
	
	Page<Model> findAll(ModelFilter filter, Pageable pageable);

	

	
	
}
