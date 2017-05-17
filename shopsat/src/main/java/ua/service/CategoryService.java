package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



import ua.dto.filter.BasicFilter;
import ua.entity.Category;



public interface CategoryService {
	
	Category findOne(int id);
	
	List<Category> findAll();
	
	void save(Category category);
	
	void delete(int id);
	
	Category findOne(String name);
	
	Page<Category> findAll(Pageable pageable);

	Page<Category> findAll(BasicFilter filter, Pageable pageable);


}
