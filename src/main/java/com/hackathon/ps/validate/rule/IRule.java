package com.hackathon.ps.validate.rule;

import com.hackathon.ps.validate.ValidationError;
import com.hackathon.ps.web.param.IParam;

public interface IRule {
	
	public boolean execute(IParam param) throws ValidationError;

}
