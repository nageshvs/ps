package com.hackathon.ps.validate.rule;

import com.hackathon.ps.validate.ValidationError;
import com.hackathon.ps.web.param.IParam;

public class MinLengthRule implements IRule {

	@Override
	public boolean execute(IParam param) throws ValidationError {
		Boolean isValid = Boolean.TRUE;
		String value = (String) param.getTypedValue();
		if (value != null && value.length() < 5) {
			throw new ValidationError("102", "Password must be between 5 and 12 characters in length.");
		}
		return isValid;
	}

}
