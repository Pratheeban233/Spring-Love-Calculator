package com.prathi.lc.pojo;

import java.util.List;

public class ValidationForm {

	private List<String> passwordValidation;

	public List<String> getPasswordValidation() {
		return passwordValidation;
	}

	public void setPasswordValidation(List<String> passwordValidation) {
		this.passwordValidation = passwordValidation;
	}

	@Override
	public String toString() {
		return "ValidationForm [passwordValidation=" + passwordValidation + "]";
	}

}
