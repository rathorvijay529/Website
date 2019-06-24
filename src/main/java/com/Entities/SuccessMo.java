package com.Entities;

public class SuccessMo {

	private int successCode;
	private String successDes;

	public SuccessMo(int successCode, String successDes) {
		this.successCode=successCode;
		this.successDes=successDes;
	}

	public int getSuccessCode() {
		return successCode;
	}

	public void setSuccessCode(int successCode) {
		this.successCode = successCode;
	}

	public String getSuccessDes() {
		return successDes;
	}

	public void setSuccessDes(String successDes) {
		this.successDes = successDes;
	}

}
