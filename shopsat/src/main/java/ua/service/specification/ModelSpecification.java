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

import ua.dto.filter.ModelFilter;
import ua.entity.Model;

public class ModelSpecification  implements Specification<Model> {
	
	private final ModelFilter filter;
		
	private final List<Predicate> predicates = new ArrayList<>();

	public ModelSpecification(ModelFilter filter) {
	super();
	this.filter = filter;
	}

	private void filterByTypeProduct(Root<Model> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		if(!filter.getTypeProductIds().isEmpty()){
			predicates.add(root.get("typeProduct").in(filter.getTypeProductIds()));
		}
	}
	
	private void filterByProducer(Root<Model> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		if(!filter.getProducerIds().isEmpty()){
			predicates.add(root.get("producer").in(filter.getProducerIds()));
		}
	}
	
	private void filterBySearch(Root<Model> root, CriteriaQuery<?> query, CriteriaBuilder cb){
		if(!filter.getSearch().isEmpty()){
			predicates.add(cb.like(root.get("nameModel"), filter.getSearch()+"%"));
		}
	}
	
	private void fetch(Root<Model> root, CriteriaQuery<?> query){
		if(query.getResultType()!=Long.class){
			root.fetch("typeProduct", JoinType.LEFT);
			root.fetch("producer", JoinType.LEFT);
			
		}
	}

	@Override
	public Predicate toPredicate(Root<Model> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

		fetch(root, query);
		query.distinct(true);
		filterBySearch(root, query, cb);
		filterByProducer(root, query, cb);
		filterByTypeProduct(root, query, cb);

		if(predicates.isEmpty())return null;
		Predicate[] array = new Predicate[predicates.size()];
		predicates.toArray(array);
		return cb.and(array);
	
	}
	

}
