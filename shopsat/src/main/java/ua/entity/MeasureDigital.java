package ua.entity;

public class MeasureDigital extends AbstractClass {
	
	private String nameMeasureDigital;

	public MeasureDigital() {
		
	}

	public MeasureDigital(String nameMeasureDigital) {
		super();
		this.nameMeasureDigital = nameMeasureDigital;
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
