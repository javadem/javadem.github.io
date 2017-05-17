package ua.dto.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


public class ProductFilter {

	private static final Pattern PEATTERN = Pattern.compile("[0-9]+");
	
//	private final static Pattern PATTERN = Pattern.compile("^([0-9]{1,18}\\.[0-9]{0,2})|([0-9]{1,18}\\,[0-9]{0,2}|([0-9]{1,18}))$");

	private String search = "";

	private String description = "";
	
	private String maxPrice = "";
	
	private String minPrice = "";
	
	private Integer max;
	
	private Integer min;
	
	private List<Integer> modelIds = new ArrayList<>();
	
	private List<Integer> measureIds = new ArrayList<>();

	private List<Integer> categoryIds = new ArrayList<>();

	private List<Integer> typeProductIds = new ArrayList<>();

	private List<Integer> countryIds = new ArrayList<>();

	private List<Integer> producerIds = new ArrayList<>();
	

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public String getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(String maxPrice) {
		if(PEATTERN.matcher(maxPrice).matches())max = Integer.valueOf(maxPrice);
		this.maxPrice = maxPrice;
	}

	public String getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(String minPrice) {
		if(PEATTERN.matcher(minPrice).matches())min = Integer.valueOf(minPrice);
		this.minPrice = minPrice;
	}

	public Integer getMax() {
		return max;
	}

	public void setMax(Integer max) {
		this.max = max;
	}

	public Integer getMin() {
		return min;
	}

	public void setMin(Integer min) {
		this.min = min;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}



	public List<Integer> getMeasureIds() {
		return measureIds;
	}

	public void setMeasureIds(List<Integer> measureIds) {
		this.measureIds = measureIds;
	}

	public List<Integer> getModelIds() {
		return modelIds;
	}

	public void setModelIds(List<Integer> modelIds) {
		this.modelIds = modelIds;
	}

	public List<Integer> getCategoryIds() {
		return categoryIds;
	}

	public void setCategoryIds(List<Integer> categoryIds) {
		this.categoryIds = categoryIds;
	}

	public List<Integer> getTypeProductIds() {
		return typeProductIds;
	}

	public void setTypeProductIds(List<Integer> typeProductIds) {
		this.typeProductIds = typeProductIds;
	}

	public List<Integer> getCountryIds() {
		return countryIds;
	}

	public void setCountryIds(List<Integer> countryIds) {
		this.countryIds = countryIds;
	}

	public List<Integer> getProducerIds() {
		return producerIds;
	}

	public void setProducerIds(List<Integer> producerIds) {
		this.producerIds = producerIds;
	}

	

}
