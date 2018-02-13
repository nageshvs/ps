package com.hackathon.ps.validate.rule;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.hackathon.ps.validate.ValidationError;
import com.hackathon.ps.web.param.StringParam;

public class MaxLengthRuleTest {

	private MaxLengthRule maxLengthRule;

	@Before
	public void setUp() throws Exception {
		maxLengthRule = new MaxLengthRule();
	}

	@Test
	public void testExecuteHappyPath() {
		try {
			Boolean isValid = maxLengthRule.execute(new StringParam("nageshhack12"));
			Assert.assertTrue(isValid);
		} catch (ValidationError e) {
			Assert.fail("This should not fail as it is Happy Path for Max Length.");
			e.printStackTrace();
		}
	}

	@Test
	public void testExecuteMoreThanMax() {
		try {
			Boolean isValid = maxLengthRule.execute(new StringParam("nageshhack123"));
			Assert.fail("This should not Pass as it exceeds Max Length. isValid=" + isValid);
		} catch (ValidationError e) {
			Assert.assertEquals(e.getErrorCode(), "101");
			Assert.assertEquals(e.getErrorMessage(), "Password must be between 5 and 12 characters in length.");
		}
	}

}
