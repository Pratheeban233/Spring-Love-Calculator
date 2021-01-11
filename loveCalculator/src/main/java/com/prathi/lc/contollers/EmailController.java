package com.prathi.lc.contollers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.prathi.lc.pojo.EmailDTO;

@Controller
public class EmailController {
	
	@RequestMapping("/sendEmail/{userName}")
	public String sendEmail(@PathVariable("userName") String user, @ModelAttribute("emailDto")EmailDTO emailDTO, Model model)
	{
		model.addAttribute("user", user);
		return "send-email-page";
	}

	@RequestMapping("/process-Email")
	public String processEmail(@ModelAttribute("email")EmailDTO emailDTO)
	{
		return "process-email-page";
	}
}
