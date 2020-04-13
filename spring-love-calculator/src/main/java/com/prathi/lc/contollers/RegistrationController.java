package com.prathi.lc.contollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.prathi.lc.dto.UserRegisterInfoDTO;

@Controller
public class RegistrationController {
	
	@RequestMapping("/register")
	public String userRegistration(@ModelAttribute("userRegistrationInfo") UserRegisterInfoDTO userRegisterInfo)
	{
		//UserRegisterInfoDTO userRegisterInfo = new UserRegisterInfoDTO();
		//model.addAttribute("userRegistrationInfo",userRegisterInfo);
		return "user-registration-page";
	}
	
	@RequestMapping("/register-success")
	public String registrationDetails(@ModelAttribute("userRegistrationInfo") UserRegisterInfoDTO userRegisterInfo)
	{
		return "registration-success";
		
	}
}

