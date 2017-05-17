package ua.service.specification;

import java.util.ArrayList;
import java.util.List;

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

//import ua.dto.filter.BasicFilter;
import ua.dto.filter.TypeProductFilter;

import ua.entity.TypeProduct;

public class TypeProductSpecification   implements Specification<TypeProduct>{
	
//	private final BasicFilter filter;
	
	private final TypeProductFilter filter;
	
	private final List<Predicate> predicates = new ArrayList<>();
		
	public TypeProductSpecification(TypeProductFilter filter) {
		super();
		this.filter = filter;
	}

	
	private void filterByCategory(Root<TypeProduct> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		if(!filter.getCategoryIds().isEmpty()){
			predicates.add(root.get("category").in(filter.getCategoryIds()));
		}
	}
	
	private void filterBySearch(Root<TypeProduct> root, CriteriaQuery<?> query, CriteriaBuilder cb){
		if(!filter.getSearch().isEmpty()){
			predicates.add(cb.like(root.get("nameTypeProduct"), filter.getSearch()+"%"));
		}
	}
	
	private void fetch(Root<TypeProduct> root, CriteriaQuery<?> query){
		if(query.getResultType()!=Long.class){
			root.fetch("category", JoinType.LEFT);
			
		}
	}

	@Override
	public Predicate toPredicate(Root<TypeProduct> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

		fetch(root, query);
		query.distinct(true);
		filterBySearch(root, query, cb);
		filterByCategory(root, query, cb);

		if(predicates.isEmpty())return null;
		Predicate[] array = new Predicate[predicates.size()];
		predicates.toArray(array);
		return cb.and(array);
	
	}

}
