package ua.entity;

import java.math.BigDecimal;

public class ValueDigital extends AbstractClass {
	
	private BigDecimal valueDigital;

	public ValueDigital() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ValueDigital(BigDecimal valueDigital) {
		super();
		this.valueDigital = valueDigital;
	}

	public BigDecimal getValueDigital() {
		return valueDigital;
	}

	public void setValueDigital(BigDecimal valueDigital) {
		this.valueDigital = valueDigital;
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
