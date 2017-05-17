package ua.dto.filter;

import java.util.ArrayList;
import java.util.List;

public class ModelFilter {


	private String search = "";
	
	private List<Integer> producerIds = new ArrayList<>();
	
	private List<Integer> typeProductIds = new ArrayList<>();
	

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public List<Integer> getProducerIds() {
		return producerIds;
	}

	public void setProducerIds(List<Integer> producerIds) {
		this.producerIds = producerIds;
	}

	public List<Integer> getTypeProductIds() {
		return typeProductIds;
	}

	public void setTypeProductIds(List<Integer> typeProductIds) {
		this.typeProductIds = typeProductIds;
	}

	
}
