package com.hackathon.ps.validate.rule;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.hackathon.ps.validate.ValidationError;
import com.hackathon.ps.web.param.StringParam;

public class OneLowerCaseLetterRuleTest {

	private OneLowerCaseLetterRule oneLowerCaseLetterRule;

	@Before
	public void setUp() throws Exception {
		oneLowerCaseLetterRule = new OneLowerCaseLetterRule();
	}

	@Test
	public void testExecuteHappyPath() {
		try {
			Boolean isValid = oneLowerCaseLetterRule.execute(new StringParam("a123"));
			Assert.assertTrue(isValid);
		} catch (ValidationError e) {
			Assert.fail("This should not fail as it is Happy Path for Min Length.");
			e.printStackTrace();
		}
	}
	

	@Test
	public void testExecuteHappyPathMoreThanOneLowerCase() {
		try {
			Boolean isValid = oneLowerCaseLetterRule.execute(new StringParam("hack123"));
			Assert.assertTrue(isValid);
		} catch (ValidationError e) {
			Assert.fail("This should not fail as it is Happy Path for Min Length.");
			e.printStackTrace();
		}
	}

	@Test
	public void testExecuteHappyPathAtleastOneLowerCase() {
		try {
			Boolean isValid = oneLowerCaseLetterRule.execute(new StringParam("HACK1123"));
			Assert.fail("This should not Pass as it is less than Min Length. isValid=" + isValid);
		} catch (ValidationError e) {
			Assert.assertEquals(e.getErrorCode(), "103");
			Assert.assertEquals(e.getErrorMessage(), "Password must contain atleast one lower case letter.");
		}
	}

}
