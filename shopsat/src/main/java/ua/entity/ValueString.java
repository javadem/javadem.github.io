package ua.entity;

public class ValueString extends AbstractClass {

	private String nameValueString;

	public ValueString() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ValueString(String nameValueString) {
		super();
		this.nameValueString = nameValueString;
	}

	public String getNameValueString() {
		return nameValueString;
	}

	public void setNameValueString(String nameValueString) {
		this.nameValueString = nameValueString;
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
