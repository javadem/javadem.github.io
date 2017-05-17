package ua.service.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;

import org.springframework.data.jpa.domain.Specification;

import ua.dto.filter.ProductFilter;
import ua.entity.Producer;
import ua.entity.Product;


public class ProductSpecification   implements Specification<Product>{
	
	private final ProductFilter filter;
	
	private final List<Predicate> predicates = new ArrayList<>();
	
	
	public ProductSpecification(ProductFilter filter) {
		this.filter = filter;
	}

	
	
	public ProductFilter getFilter() {
		return filter;
	}



	public List<Predicate> getPredicates() {
		return predicates;
	}



	private void filterByModel(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		if(!filter.getModelIds().isEmpty()){
			predicates.add(root.get("model").in(filter.getModelIds()));
			
		}
	}
	
	private void filterByPrice(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder cb){
		if(filter.getMax()!=null&&filter.getMin()!=null){
			predicates.add(cb.between(root.get("price"), filter.getMin(), filter.getMax()));
		} else if(filter.getMax()!=null){
			predicates.add(cb.lessThanOrEqualTo(root.get("price"), filter.getMax()));
		} else if(filter.getMin()!=null){
			predicates.add(cb.greaterThanOrEqualTo(root.get("price"), filter.getMin()));
		}
	}

	private void filterBySearch(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder cb){
		if(!filter.getSearch().isEmpty()){
			predicates.add(cb.like(root.get("nameProduct"), filter.getSearch()+"%"));
		}
	}
	
	
	
	
	
	
	private void filterByDescription(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder cb){
		if(!filter.getDescription().isEmpty()){
			predicates.add(cb.like(root.get("description"), filter.getDescription()+"%"));
		}
	}
	
	
	private void filterByMeasure(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		if(!filter.getMeasureIds().isEmpty()){
			predicates.add(root.get("measure").in(filter.getMeasureIds()));
		}
	}
	

	
	private void filterByCategory(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		if(!filter.getCategoryIds().isEmpty()){
			predicates.add(root.get("model").get("typeProduct").get("category").in(filter.getCategoryIds()));
		}
	}

	
	private void filterByCountry(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		if(!filter.getCountryIds().isEmpty()){
			predicates.add(root.get("model").get("producer").get("country").in(filter.getCountryIds()));
		}
	}
	
	
	private void filterByTypeProduct(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		if(!filter.getTypeProductIds().isEmpty()){
			predicates.add(root.get("model").get("typeProduct").in(filter.getTypeProductIds()));
		}
	}

	
	private void filterByProducer(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		if(!filter.getProducerIds().isEmpty()){
			
			predicates.add(root.get("model").get("producer").in(filter.getProducerIds()));
		}
	}
	
	
	private void fetch(Root<Product> root, CriteriaQuery<?> query){
		if(query.getResultType()!=Long.class){
			root.fetch("model", JoinType.LEFT);
			root.fetch("measure", JoinType.LEFT);
		}
	}
	
	@Override
	public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		
		fetch(root, query);
		query.distinct(true);
		filterBySearch(root, query, cb);
		filterByDescription(root, query, cb);
		filterByPrice(root, query, cb);
		filterByModel(root, query, cb);
		filterByMeasure(root, query, cb);
		
		filterByCategory(root, query, cb);
		filterByCountry(root, query, cb);
		filterByTypeProduct(root, query, cb);
		
		filterByProducer(root, query, cb);

		if(predicates.isEmpty())return null;
		Predicate[] array = new Predicate[predicates.size()];
		predicates.toArray(array);
		return cb.and(array);

	
	}
	

}
