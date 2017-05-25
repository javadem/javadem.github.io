package ua.entity;

import java.math.BigDecimal;

public class MeasureDigital extends AbstractClass {
	
	private String nameMeasureDigital;
	
	private BigDecimal valueMeasureDigital;

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
