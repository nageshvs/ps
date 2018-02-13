package com.hackathon.ps.validate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.hackathon.ps.validate.rule.DuplicateSequenceRule;
import com.hackathon.ps.validate.rule.IRule;
import com.hackathon.ps.validate.rule.MaxLengthRule;
import com.hackathon.ps.validate.rule.MinLengthRule;
import com.hackathon.ps.validate.rule.OneLowerCaseLetterRule;
import com.hackathon.ps.validate.rule.OneNumericalDigitRule;
import com.hackathon.ps.web.param.IParam;


@Component
@Qualifier("passwordRuleEngine")
public class PasswordRuleEngine implements IRuleEngine {

	@Override
	public boolean execute(IParam param, List<IRule> rulesList) throws ValidationError {
		for (IRule rule : rulesList) {
			rule.execute(param);
		}
		return true;
	}

	private List<IRule> getRulesList() {
		List<IRule> rulesList = new ArrayList<IRule>();
		rulesList.add(new MinLengthRule());
		rulesList.add(new MaxLengthRule());
		rulesList.add(new OneLowerCaseLetterRule());
		rulesList.add(new OneNumericalDigitRule());
		rulesList.add(new DuplicateSequenceRule());
		return Collections.unmodifiableList(rulesList);
	}
	
	public List<IRule> getRules() {
		return Collections.unmodifiableList(getRulesList());
	}

}
