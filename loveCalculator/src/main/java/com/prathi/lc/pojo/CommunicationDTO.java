package com.prathi.lc.pojo;

import javax.validation.constraints.Email;

import com.prathi.lc.annotation.Mobile;

public class CommunicationDTO {
	
	//@Email(regexp = "^[\\w-\\+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$", message = "{validate.email.message}")
	private String email;
	@Mobile 
	private Phone phone;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Phone getPhone() {
		return phone;
	}
	public void setPhone(Phone phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "CommunicationDTO [email=" + email + ", phone=" + phone + "]";
	}
	
}
