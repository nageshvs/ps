package com.hackathon.ps.validate.rule;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.hackathon.ps.validate.ValidationError;
import com.hackathon.ps.web.param.StringParam;

public class OneNumericalDigitRuleTest {

	private OneNumericalDigitRule oneNumericalDigitRule;

	@Before
	public void setUp() throws Exception {
		oneNumericalDigitRule = new OneNumericalDigitRule();
	}

	@Test
	public void testExecuteHappyPath() {
		try {
			Boolean isValid = oneNumericalDigitRule.execute(new StringParam("hackathon1"));
			Assert.assertTrue(isValid);
		} catch (ValidationError e) {
			Assert.fail("This should not fail as it is Happy Path for Min Length.");
			e.printStackTrace();
		}
	}

	@Test
	public void testExecuteHappyPathMoreThanOneNumericalDigit() {
		try {
			Boolean isValid = oneNumericalDigitRule.execute(new StringParam("hack123"));
			Assert.assertTrue(isValid);
		} catch (ValidationError e) {
			Assert.fail("This should not fail as it is Happy Path for Min Length.");
			e.printStackTrace();
		}
	}

	@Test
	public void testExecuteHappyPathAtleastOneNumericalDigit() {
		try {
			Boolean isValid = oneNumericalDigitRule.execute(new StringParam("HACK"));
			Assert.fail("This should not Pass as it is less than Min Length. isValid=" + isValid);
		} catch (ValidationError e) {
			Assert.assertEquals(e.getErrorCode(), "104");
			Assert.assertEquals(e.getErrorMessage(), "Password must contain atleast one numercial digit.");
		}
	}

}
