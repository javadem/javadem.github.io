package ua.service.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import ua.dto.filter.BasicFilter;
import ua.entity.Country;

public class CountrySpecification   implements Specification<Country>{
	
		private final BasicFilter filter;

		private final List<Predicate> predicates = new ArrayList<>();
			
			public CountrySpecification(BasicFilter filter) {
				this.filter = filter;
			}


			private void filterBySearch(Root<Country> root, CriteriaQuery<?> query, CriteriaBuilder cb){
				if(!filter.getSearch().isEmpty()){
					predicates.add(cb.like(root.get("nameCountry"), filter.getSearch()+"%"));
				}
			}
			

			@Override
			public Predicate toPredicate(Root<Country> root, CriteriaQuery<?> query, CriteriaBuilder cb) {


				query.distinct(true);
				filterBySearch(root, query, cb);
				

				if(predicates.isEmpty())return null;
				Predicate[] array = new Predicate[predicates.size()];
				predicates.toArray(array);
				return cb.and(array);
			
			}
	

}
