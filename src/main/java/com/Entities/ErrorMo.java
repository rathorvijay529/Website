package com.Entities;

public class ErrorMo {

	private int errorCode;
	private String errorString;

	public ErrorMo(int errorCode, String errorString) {
		super();
		this.errorCode = errorCode;
		this.errorString = errorString;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorString() {
		return errorString;
	}

	public void setErrorString(String errorString) {
		this.errorString = errorString;
	}

}
