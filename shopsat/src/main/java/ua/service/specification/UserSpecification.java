package ua.service.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import ua.dto.filter.UserFilter;
import ua.entity.User;

public class UserSpecification    implements Specification<User>{

	private final UserFilter filter;

	private final List<Predicate> predicates = new ArrayList<>();
		
		

		public UserSpecification(UserFilter filter) {
		super();
		this.filter = filter;
		}
		
		public UserFilter getFilter() {
			return filter;
		}

		public List<Predicate> getPredicates() {
			return predicates;
		}

		private void filterBySearch(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb){
			if(!filter.getSearch().isEmpty()){
				predicates.add(cb.like(root.get("username"), filter.getSearch()+"%"));
			}
		}
		
//		private void fetch(Root<User> root, CriteriaQuery<?> query){
//			if(query.getResultType()!=Long.class){
////				root.fetch("country", JoinType.LEFT);
//				
//			}
//		}
		
		@Override
		public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

//			fetch(root, query);
			query.distinct(true);
			filterBySearch(root, query, cb);
			
			if(predicates.isEmpty())return null;
			Predicate[] array = new Predicate[predicates.size()];
			predicates.toArray(array);
			return cb.and(array);
		
		}
	
}
