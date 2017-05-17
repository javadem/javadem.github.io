package ua.service.specification;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import org.springframework.data.jpa.domain.Specification;
import java.util.ArrayList;
import java.util.List;
import ua.dto.filter.BasicFilter;
import ua.dto.filter.ProducerFilter;
import ua.entity.Producer;

public class ProducerSpecification  implements Specification<Producer> {
	
	private final ProducerFilter filter;
		
	private final List<Predicate> predicates = new ArrayList<>();

	public ProducerSpecification(ProducerFilter filter) {
	super();
	this.filter = filter;
	}

	private void filterByCountry(Root<Producer> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		if(!filter.getCountryIds().isEmpty()){
			predicates.add(root.get("country").in(filter.getCountryIds()));
		}
	}
	
	private void filterBySearch(Root<Producer> root, CriteriaQuery<?> query, CriteriaBuilder cb){
		if(!filter.getSearch().isEmpty()){
			predicates.add(cb.like(root.get("nameProducer"), filter.getSearch()+"%"));
		}
	}
	
	private void fetch(Root<Producer> root, CriteriaQuery<?> query){
		if(query.getResultType()!=Long.class){
			root.fetch("country", JoinType.LEFT);
			
		}
	}

	@Override
	public Predicate toPredicate(Root<Producer> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

		fetch(root, query);
		query.distinct(true);
		filterBySearch(root, query, cb);
		filterByCountry(root, query, cb);

		if(predicates.isEmpty())return null;
		Predicate[] array = new Predicate[predicates.size()];
		predicates.toArray(array);
		return cb.and(array);
	
	}
	

}
