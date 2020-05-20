package com.prathi.lc.contollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.prathi.lc.dto.CommunicationDTO;
import com.prathi.lc.dto.Phone;
import com.prathi.lc.dto.UserRegisterInfoDTO;

@Controller
public class RegistrationController {
	
	@RequestMapping("/register")
	public String userRegistration(@ModelAttribute("userRegistrationInfo") UserRegisterInfoDTO userRegisterInfo)
	{
		//UserRegisterInfoDTO userRegisterInfo = new UserRegisterInfoDTO();
		//model.addAttribute("userRegistrationInfo",userRegisterInfo);
		
		System.out.println("inside userRegistration method");
		
		Phone phone = new Phone();
		phone.setCountryCode("91");;
		phone.setUserNumber("8489894594");
		
		CommunicationDTO communicationDTO = new CommunicationDTO();
		communicationDTO.setPhone(phone);
		
		userRegisterInfo.setCommunicationDTO(communicationDTO);
		
		
		return "user-registration-page";
	}
	
	@RequestMapping("/register-success")
	public String registrationDetails(@ModelAttribute("userRegistrationInfo") UserRegisterInfoDTO userRegisterInfo)
	{
		System.out.println("inside registrationDetails method");
		return "registration-success";
		
	}
}

