package com.prathi.lc.dto;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserInfoDTO {

	// Server Side Validations below

	@NotBlank(message = "* Your Name cannot be blank")
	@Size(min = 3, max = 15, message = "* Your Name should have characters between 3-15")
	private String yourName;

	@NotBlank(message = "* Crush Name cannot be blank")
	@Size(min = 3, max = 15, message = "* Crush Name should have characters between 3-15")
	private String crushName;

	@AssertTrue(message = "* You should agree to use this app")
	private boolean termsAndCondition;

	public String getYourName() {
		return yourName;
	}

	public void setYourName(String yourName) {
		this.yourName = yourName;
	}

	public String getCrushName() {
		return crushName;
	}

	public void setCrushName(String crushName) {
		this.crushName = crushName;
	}

	public boolean isTermsAndCondition() {
		return termsAndCondition;
	}

	public void setTermsAndCondition(boolean termsAndCondition) {
		this.termsAndCondition = termsAndCondition;
	}

	@Override
	public String toString() {
		return "UserInfoDTO [yourName=" + yourName + ", crushName=" + crushName + ", termsAndCondition="
				+ termsAndCondition + "]";
	}

}
