package com.hackathon.ps.validate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hackathon.ps.web.param.StringParam;

@Component
public class Validator {

	@Autowired
	@Qualifier("passwordRuleEngine")
	private PasswordRuleEngine passwordRuleEngine;
	
	public boolean validatePassword(String value) throws ValidationError {
		StringParam passwordParam = new StringParam(value);
		Boolean isValid = passwordRuleEngine.execute(passwordParam, passwordRuleEngine.getRules());
		return isValid;
	}
}
