package com.hackathon.ps.validate.rule;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.hackathon.ps.validate.ValidationError;
import com.hackathon.ps.web.param.StringParam;

public class MinLengthRuleTest {

	private MinLengthRule minLengthRule;

	@Before
	public void setUp() throws Exception {
		minLengthRule = new MinLengthRule();
	}

	@Test
	public void testExecuteHappyPath() {
		try {
			Boolean isValid = minLengthRule.execute(new StringParam("hack12"));
			Assert.assertTrue(isValid);
		} catch (ValidationError e) {
			Assert.fail("This should not fail as it is Happy Path for Min Length.");
			e.printStackTrace();
		}
	}

	@Test
	public void testExecuteMoreThanMax() {
		try {
			Boolean isValid = minLengthRule.execute(new StringParam("hac1"));
			Assert.fail("This should not Pass as it is less than Min Length. isValid=" + isValid);
		} catch (ValidationError e) {
			Assert.assertEquals(e.getErrorCode(), "102");
			Assert.assertEquals(e.getErrorMessage(), "Password must be between 5 and 12 characters in length.");
		}
	}

}
