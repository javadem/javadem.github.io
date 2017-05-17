package ua.service.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import ua.dto.filter.BasicFilter;
import ua.entity.Category;

public class CategorySpecification  implements Specification<Category>{

private final BasicFilter filter;

private final List<Predicate> predicates = new ArrayList<>();
	
	public CategorySpecification(BasicFilter filter) {
		this.filter = filter;
	}


	private void filterBySearch(Root<Category> root, CriteriaQuery<?> query, CriteriaBuilder cb){
		if(!filter.getSearch().isEmpty()){
			predicates.add(cb.like(root.get("nameCategory"), filter.getSearch()+"%"));
		}
	}
	


	@Override
	public Predicate toPredicate(Root<Category> root, CriteriaQuery<?> query, CriteriaBuilder cb) {


		query.distinct(true);
		filterBySearch(root, query, cb);
		

		if(predicates.isEmpty())return null;
		Predicate[] array = new Predicate[predicates.size()];
		predicates.toArray(array);
		return cb.and(array);
	
	}
	
}
