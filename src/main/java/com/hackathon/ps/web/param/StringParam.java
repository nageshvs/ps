package com.hackathon.ps.web.param;

public class StringParam extends AbstractParam{
	
	private String value;
	
	public StringParam(String value) {
		super(DataType.STRING);
		this.value = value;
		
	}
	
	@Override
	public String getTypedValue() {
		return value;
	}

}
