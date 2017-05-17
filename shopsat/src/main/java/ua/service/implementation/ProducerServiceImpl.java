package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.entity.Producer;
import ua.repository.ProducerRepository;
import ua.service.ProducerService;
import ua.dto.filter.ProducerFilter;
import ua.service.specification.ProducerSpecification;

@Service
public class ProducerServiceImpl implements ProducerService{


	@Autowired
	private ProducerRepository  repository;

	@Override
	@Transactional(readOnly=true)
	public Producer findOne(int id) {
		// TODO Auto-generated method stub
		return repository.findOne(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Producer> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public void save(Producer producer) {
		// TODO Auto-generated method stub
		repository.save(producer);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		repository.delete(id);
	}

	@Override
	public Producer findOne(String name) {
		return repository.findByName(name);
	}
	
	

	@Override
	public List<Producer> findByCountryId(int id) {
		// TODO Auto-generated method stub
		return null;
	}



	public ProducerRepository getRepository() {
		return repository;
	}

	public void setRepository(ProducerRepository repository) {
		this.repository = repository;
	}



	@Override
	public Page<Producer> findAll(ProducerFilter filter, Pageable pageable) {
		// TODO Auto-generated method stub
		return repository.findAll( new ProducerSpecification(filter), pageable );
	}

	
	
}
