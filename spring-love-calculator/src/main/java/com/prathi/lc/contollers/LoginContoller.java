package com.prathi.lc.contollers;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.prathi.lc.dto.UserRegisterInfoDTO;

public class LoginContoller 
{
	@RequestMapping("/")
	public String registrationDetails(@ModelAttribute("userRegistrationInfo") UserRegisterInfoDTO userRegisterInfo)
	{
		return "login-page";
		
	}
}
