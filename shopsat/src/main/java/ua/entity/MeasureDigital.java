package ua.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="measureDigital", indexes=@Index(columnList = "_name"))
public class MeasureDigital extends AbstractClass {
	
	@Column(name="_name")
	private String nameMeasureDigital;
	
	@Column(name="_value")
	private BigDecimal valueMeasureDigital;
	
	@OneToMany(mappedBy="measureDigital")
	private List<Product> products = new ArrayList<>();

	public MeasureDigital() {
		
	}

	

	public MeasureDigital(String nameMeasureDigital, BigDecimal valueMeasureDigital) {
		super();
		this.nameMeasureDigital = nameMeasureDigital;
		this.valueMeasureDigital = valueMeasureDigital;
	}



	public String getNameMeasureDigital() {
		return nameMeasureDigital;
	}

	public void setNameMeasureDigital(String nameMeasureDigital) {
		this.nameMeasureDigital = nameMeasureDigital;
	}

	@Override
	public Integer getId() {
		// TODO Auto-generated method stub
		return super.getId();
	}

	@Override
	public void setId(Integer id) {
		// TODO Auto-generated method stub
		super.setId(id);
	}

	
	
	

}
