package com.prathi.lc.contollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.prathi.lc.pojo.EmailDTO;

@Controller
public class EmailController {
	
	@RequestMapping("/sendEmail")
	public String sendEmail(@ModelAttribute("emailDto")EmailDTO emailDTO)
	{
		return "send-email-page";
	}

	@RequestMapping("/process-Email")
	public String processEmail(@ModelAttribute("email")EmailDTO emailDTO)
	{
		return "process-email-page";
	}
}
