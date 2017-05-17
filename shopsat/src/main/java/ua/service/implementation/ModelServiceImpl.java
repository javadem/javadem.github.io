package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.entity.Model;
import ua.repository.ModelRepository;
import ua.service.ModelService;
import ua.dto.filter.ModelFilter;
import ua.service.specification.ModelSpecification;

@Service
public class ModelServiceImpl implements ModelService{


	@Autowired
	private ModelRepository  repository;

	@Override
	@Transactional(readOnly=true)
	public ua.entity.Model findOne(int id) {
		// TODO Auto-generated method stub
		return repository.findOne(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Model> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public void save(ua.entity.Model model) {
		// TODO Auto-generated method stub
		repository.save(model);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		repository.delete(id);
	}

	
	
	@Override
	public Model findOne(String name) {
		return repository.findByName(name);
	}



	@Override
	public List<Model> findByTypeProductId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Model> findByProducerId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public ModelRepository getRepository() {
		return repository;
	}

	public void setRepository(ModelRepository repository) {
		this.repository = repository;
	}



	@Override
	public Page<Model> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return repository.findAll( pageable );
	}

	@Override
	public Page<Model> findAll(ModelFilter filter, Pageable pageable) {
		// TODO Auto-generated method stub
		return repository.findAll( new ModelSpecification(filter), pageable );
	}
	
	

}
