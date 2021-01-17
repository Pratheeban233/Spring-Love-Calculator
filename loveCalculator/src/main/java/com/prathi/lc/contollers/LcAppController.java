package com.prathi.lc.contollers;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.prathi.lc.pojo.UserInfoDTO;
import com.prathi.lc.validator.UserNameValidator;

@Controller
@SessionAttributes("userInfo")
public class LcAppController {
	@RequestMapping("/")
	//public String showHomePage(@ModelAttribute("userInfo") UserInfoDTO userinfoDTO)
	//@ModelAttribute will not work when using session attribute
	public String showHomePage(Model model) {
	
		model.addAttribute("userInfo", new UserInfoDTO());
		return "home-page";
	}


	@RequestMapping("/process-homepage")
	public String showResultPage(@Valid @ModelAttribute("userInfo") UserInfoDTO userinfoDTO, 
			BindingResult result, HttpServletRequest request) {

		if (result.hasErrors()) {
			System.out.println("This form has  errors...");
			List<ObjectError> allErrors = result.getAllErrors();
			for (ObjectError err : allErrors)// For each
			{
				System.out.println(err);
			}
			return "home-page";
		}
		//Introduced cookies
	/*	Cookie userCookie = new Cookie("userName", userinfoDTO.getUserName());
		userCookie.setMaxAge(60*60*24);
		respose.addCookie(userCookie); */
		
		HttpSession session = request.getSession();
		session.setAttribute("userName", userinfoDTO.getUserName());

		return "result-page";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
	//	binder.addValidators(new UserNameValidator());
	}

}