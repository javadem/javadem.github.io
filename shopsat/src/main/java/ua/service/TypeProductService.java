package ua.service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import ua.dto.filter.TypeProductFilter;
import ua.entity.TypeProduct;

public interface TypeProductService {

	TypeProduct findOne(int id);
	
	List<TypeProduct> findAll();
	
	void save(TypeProduct typeProduct);
	
	void delete(int id);
	
	TypeProduct findOne(String name);
	
	List<TypeProduct> findByCategoryId(int id);
	
//	Page<TypeProduct> findAll(Pageable pageable);

//	Page<TypeProduct> findAll(BasicFilter filter, Pageable pageable);
	
	Page<TypeProduct> findAll(TypeProductFilter filter, Pageable pageable);
}
