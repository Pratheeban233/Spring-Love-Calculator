package com.prathi.lc.contollers;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.prathi.lc.dto.UserRegisterInfoDTO;
import com.prathi.lc.validator.UserNameValidator;

public class LoginContoller 
{
	@RequestMapping("/")
	public String registrationDetails(@ModelAttribute("userRegistrationInfo") UserRegisterInfoDTO userRegisterInfo)
	{
		return "login-page";
		
	}
	
}
