package com.hackathon.ps.validate;

public class ValidationError extends Exception {

	private static final long serialVersionUID = 1L;
	private String errorMessage;
	private String errorCode;

	public ValidationError(String errorCode, String errorMessage) {
		super("errorCode=" + errorCode + ", errorMessage=" + errorMessage);
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	@Override
	public String toString() {
		return "ValidationError [ errorCode=" + errorCode + ", errorMessage=" + errorMessage + "]";
	}

}
