package ua.service.implementation;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.entity.Category;
import ua.repository.CategoryRepository;
import ua.service.CategoryService;
import ua.service.specification.CategorySpecification;
import ua.dto.filter.BasicFilter;



@Service
public class CategoryServiceImpl  implements CategoryService{

	@Autowired
	private CategoryRepository categoryRepositoryServiceImpl;
	
	
	
	
	@Override
	@Transactional(readOnly=true)
	public Category findOne(int id) {
		// TODO Auto-generated method stub
		return categoryRepositoryServiceImpl.findOne(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return categoryRepositoryServiceImpl.findAll();
	}

	@Override
	public void save(Category category) {
		category.setNameCategory(category.getNameCategory().trim());
		categoryRepositoryServiceImpl.save(category);
		
	}

	@Override
	public void delete(int id) {
		categoryRepositoryServiceImpl.delete(id);
		
	}
	
	
	
	@Override
	public Category findOne(String name) {
		// TODO Auto-generated method stub
		return categoryRepositoryServiceImpl.findByName(name);
//		return null;
	}

	public CategoryRepository getCategoryRepository() {
		return categoryRepositoryServiceImpl;
	}

	public CategoryRepository getCategoryRepositoryServiceImpl() {
		return categoryRepositoryServiceImpl;
	}

	public void setCategoryRepositoryServiceImpl(CategoryRepository categoryRepositoryServiceImpl) {
		this.categoryRepositoryServiceImpl = categoryRepositoryServiceImpl;
	}

	@Override
	public Page<Category> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return categoryRepositoryServiceImpl.findAll(pageable);
	}

	@Override
	public Page<Category> findAll(BasicFilter filter, Pageable pageable) {
		// TODO Auto-generated method stub
		return categoryRepositoryServiceImpl.findAll( new CategorySpecification(filter), pageable );
	}

	

	
	
	
}
