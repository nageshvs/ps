package com.hackathon.ps.validate.rule;

import java.util.regex.Pattern;

import com.hackathon.ps.validate.ValidationError;
import com.hackathon.ps.web.param.IParam;

public class OneNumericalDigitRule implements IRule {
	
	public static final String ONE_NUMERICAL_DIGIT_REG_EX = "^[a-z0-9]+$";

	@Override
	public boolean execute(IParam param) throws ValidationError {
		Boolean isValid = Boolean.TRUE;
		String value = (String) param.getTypedValue();
		if (value != null && !match(value)) {
			throw new ValidationError("104", "Password must contain atleast one numercial digit.");
		}
		return isValid;
	}

	private boolean match(String value) {
		return Pattern.matches(ONE_NUMERICAL_DIGIT_REG_EX, value);
	}

}
