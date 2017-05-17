package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.dto.filter.BasicFilter;


import ua.service.specification.CountrySpecification;

import ua.entity.Country;
import ua.repository.CountryRepository;
import ua.service.CountryService;


@Service
public class CountryServiceImpl implements CountryService{
	
	@Autowired
	private CountryRepository  repository;

	@Override
	@Transactional(readOnly=true)
	public Country findOne(int id) {
		// TODO Auto-generated method stub
		return repository.findOne(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Country> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public void save(Country country) {
		// TODO Auto-generated method stub
		repository.save(country);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		repository.delete(id);
	}
	
	@Override
	public Country findOne(String name) {
		return repository.findByName(name);
	}

	public CountryRepository getRepository() {
		return repository;
	}

	public void setRepository(CountryRepository repository) {
		this.repository = repository;
	}

	@Override
	public Page<Country> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return repository.findAll(pageable);
	}

	@Override
	public Page<Country> findAll(BasicFilter filter, Pageable pageable) {
		// TODO Auto-generated method stub
		return repository.findAll( new CountrySpecification(filter), pageable );
	}


	
	

}
