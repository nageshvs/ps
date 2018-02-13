package com.hackathon.ps.web.param;

public abstract class AbstractParam implements IParam {
	
	private DataType dataType;
	
	public AbstractParam(DataType dataType) {
		this.dataType = dataType;
	}

	public abstract Object getTypedValue();
		
	public DataType getDataType() {
		return this.dataType;
	}

}
