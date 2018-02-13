package com.hackathon.ps.validate;

import java.util.List;

import com.hackathon.ps.validate.rule.IRule;
import com.hackathon.ps.web.param.IParam;

public interface IRuleEngine {

	public boolean execute(IParam param, List<IRule> rulesList) throws ValidationError;

}
