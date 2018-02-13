package com.hackathon.ps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hackathon.ps.validate.ValidationError;
import com.hackathon.ps.validate.Validator;

@RestController
@RequestMapping("/ps")
public class PasswordController {

	@Autowired
	private Validator validator;

	@RequestMapping("/validate")
	public boolean validate(@RequestParam("pwd") String password) throws ValidationError {
		Boolean isValid = validator.validatePassword(password);
		System.out.println("Hello validate");
		return isValid;
	}

	@RequestMapping("/verify")
	public boolean validator() {
		System.out.println("Hello");
		return Boolean.TRUE;
	}
	
}
