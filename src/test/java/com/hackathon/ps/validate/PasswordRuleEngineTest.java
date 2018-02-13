package com.hackathon.ps.validate;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.hackathon.ps.validate.rule.DuplicateSequenceRule;
import com.hackathon.ps.validate.rule.IRule;
import com.hackathon.ps.validate.rule.MaxLengthRule;
import com.hackathon.ps.validate.rule.MinLengthRule;
import com.hackathon.ps.validate.rule.OneLowerCaseLetterRule;
import com.hackathon.ps.validate.rule.OneNumericalDigitRule;
import com.hackathon.ps.web.param.StringParam;

public class PasswordRuleEngineTest {

	private PasswordRuleEngine passwordRuleEngine;

	@Before
	public void setUp() throws Exception {
		passwordRuleEngine = new PasswordRuleEngine();
	}

	@Test
	public void testExecute() {
		StringParam password = new StringParam("hack123");
		try {
			passwordRuleEngine.execute(password, passwordRuleEngine.getRules());
		} catch (ValidationError e) {
			fail("Should not fail as it is Happy Path. \r\n" + e.toString());
		}
	}

	@Test
	public void testGetRules() {
		List<IRule> ruleList = passwordRuleEngine.getRules();
		Boolean isValid = Boolean.TRUE;
		for (IRule rule : ruleList) {
			if (rule instanceof MinLengthRule || (rule instanceof MaxLengthRule)
					|| (rule instanceof OneLowerCaseLetterRule) || (rule instanceof OneNumericalDigitRule)
					|| (rule instanceof DuplicateSequenceRule)) {

			} else {
				isValid = Boolean.FALSE;
				fail("One of the Rule is not defined as part of Password Rules. Rule =" + rule.getClass().getName());
				break;
			}
		}
		Assert.assertTrue(isValid);

	}

}
