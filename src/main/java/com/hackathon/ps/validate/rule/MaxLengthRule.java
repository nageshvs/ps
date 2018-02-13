package com.hackathon.ps.validate.rule;

import com.hackathon.ps.validate.ValidationError;
import com.hackathon.ps.web.param.IParam;

public class MaxLengthRule implements IRule {

	@Override
	public boolean execute(IParam param) throws ValidationError {
		Boolean isValid = Boolean.TRUE;
		String value = (String) param.getTypedValue();
		if (value != null && value.length() > 12) {
			throw new ValidationError("101", "Password must be between 5 and 12 characters in length.");
		}
		return isValid;
	}

}
