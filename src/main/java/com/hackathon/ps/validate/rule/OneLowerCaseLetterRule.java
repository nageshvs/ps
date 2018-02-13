package com.hackathon.ps.validate.rule;

import java.util.regex.Pattern;

import com.hackathon.ps.validate.ValidationError;
import com.hackathon.ps.web.param.IParam;

public class OneLowerCaseLetterRule implements IRule {
	
	public static final String ONE_LOWER_CASE_REG_EX = "^[a-z0-9]+$";

	@Override
	public boolean execute(IParam param) throws ValidationError {
		Boolean isValid = Boolean.TRUE;
		String value = (String) param.getTypedValue();
		if (value != null && !match(value)) {
			throw new ValidationError("103", "Password must contain atleast one lower case letter.");
		}
		return isValid;
	}

	private boolean match(String value) {
		return Pattern.matches(ONE_LOWER_CASE_REG_EX, value);
	}

}
