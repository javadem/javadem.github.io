package ua.service.implementation;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import ua.repository.CategoryRepository;
import ua.dto.filter.TypeProductFilter;
import ua.service.specification.TypeProductSpecification;
import ua.entity.TypeProduct;
import ua.repository.TypeProductRepository;
import ua.service.TypeProductService;

@Service
public class TypeProductServiceImpl implements TypeProductService{

	

	@Autowired
	private TypeProductRepository  typeProductRepository;
	
	@Autowired
	private CategoryRepository  categoryRepositoryTypeProductServiceImpl;

	@Override
	@Transactional(readOnly=true)
	public TypeProduct findOne(int id) {
		return typeProductRepository.findOne(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<TypeProduct> findAll() {
		return typeProductRepository.findAll();
	}

	@Override
	public void save(TypeProduct typeProduct) {
		typeProductRepository.save(typeProduct);
	}

	@Override
	public void delete(int id) {
		typeProductRepository.delete(id);
	}
	
	@Override
	public TypeProduct findOne(String name) {
		return typeProductRepository.findByName(name);
	}

	@Override
	public List<TypeProduct> findByCategoryId(int id) {
		// TODO Auto-generated method stub
		return null;
	}



	public TypeProductRepository getTypeProductRepository() {
		return typeProductRepository;
	}

	public void setTypeProductRepository(TypeProductRepository typeProductRepository) {
		this.typeProductRepository = typeProductRepository;
	}

	public CategoryRepository getCategoryRepositoryTypeProductServiceImpl() {
		return categoryRepositoryTypeProductServiceImpl;
	}

	public void setCategoryRepositoryTypeProductServiceImpl(CategoryRepository categoryRepositoryTypeProductServiceImpl) {
		this.categoryRepositoryTypeProductServiceImpl = categoryRepositoryTypeProductServiceImpl;
	}


	@Override
	public Page<TypeProduct> findAll(TypeProductFilter filter, Pageable pageable) {
		// TODO Auto-generated method stub
		return typeProductRepository.findAll(new TypeProductSpecification(filter), pageable);
	}
	
	
	
}
