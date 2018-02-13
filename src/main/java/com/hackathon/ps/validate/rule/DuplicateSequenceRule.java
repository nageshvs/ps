package com.hackathon.ps.validate.rule;

import com.hackathon.ps.validate.ValidationError;
import com.hackathon.ps.web.param.IParam;

public class DuplicateSequenceRule implements IRule {
	
	@Override
	public boolean execute(IParam param) throws ValidationError {
		Boolean isValid = Boolean.TRUE;
		String value = (String) param.getTypedValue();
		if (foundDuplicateSequence(value)) {
			throw new ValidationError("105", "Password must not contain one any sequence of characters immediately followed by same sequence.");
		}
		return isValid;
	}

	private boolean foundDuplicateSequence(String value) {
		// TODO Auto-generated method stub
		return Boolean.FALSE;
	}

}
