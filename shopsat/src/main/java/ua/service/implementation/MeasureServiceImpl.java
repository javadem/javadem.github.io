package ua.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.dto.filter.BasicFilter;
import ua.entity.MeasureString;
import ua.repository.MeasureRepository;
import ua.service.MeasureService;
import ua.service.specification.MeasureSpecification;

@Service
public class MeasureServiceImpl implements MeasureService{


	@Autowired
	private MeasureRepository  measureRepository;

	@Override
	@Transactional(readOnly=true)
	public MeasureString findOne(int id) {
		// TODO Auto-generated method stub
		return measureRepository.findOne(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<MeasureString> findAll() {
		// TODO Auto-generated method stub
		return measureRepository.findAll();
	}

	@Override
	public void save(MeasureString measure) {
		// TODO Auto-generated method stub
		measureRepository.save(measure);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		measureRepository.delete(id);
	}

	
	
	@Override
	public MeasureString findOne(String name) {
		return measureRepository.findByName(name);
	}



	public MeasureRepository getRepository() {
		return measureRepository;
	}

	public void setRepository(MeasureRepository measureRepository) {
		this.measureRepository = measureRepository;
	}

	@Override
	public Page<MeasureString> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return measureRepository.findAll(pageable);
	}

	@Override
	public Page<MeasureString> findAll(BasicFilter filter, Pageable pageable) {
		// TODO Auto-generated method stub
		return measureRepository.findAll(new MeasureSpecification(filter), pageable);
	}

	public MeasureRepository getMeasureRepository() {
		return measureRepository;
	}

	public void setMeasureRepository(MeasureRepository measureRepository) {
		this.measureRepository = measureRepository;
	}

	
	
}
