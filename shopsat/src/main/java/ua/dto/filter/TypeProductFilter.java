package ua.dto.filter;

import java.util.ArrayList;
import java.util.List;

public class TypeProductFilter {


	private String search = "";
	
	private List<Integer> categoryIds = new ArrayList<>();
	
	

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public List<Integer> getCategoryIds() {
		return categoryIds;
	}

	public void setCategoryIds(List<Integer> categoryIds) {
		this.categoryIds = categoryIds;
	}

	
	
	
	
	
}
