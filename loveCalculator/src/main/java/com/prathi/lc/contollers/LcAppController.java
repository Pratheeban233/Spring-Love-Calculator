package com.prathi.lc.contollers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.prathi.lc.pojo.UserInfoDTO;
import com.prathi.lc.validator.UserNameValidator;

@Controller
public class LcAppController {
	@RequestMapping("/")
	public String showHomePage(@ModelAttribute("userInfo") UserInfoDTO userinfoDTO) {
		// new object for to load all static values
		// UserinfoDTO userInfo = new UserinfoDTO();
		// model.addAttribute("userInfo", userInfo);
		return "home-page";
	}

	// Model Attribute method
	/*
	 * @RequestMapping("/process-homepage") public String
	 * showResultPage(@ModelAttribute("userInfo") UserinfoDTO userinfoDTO) {
	 *
	 * Method:1 public String showResultPage(@RequestParam("userName") String
	 * userName1, @RequestParam ("crushName") String crushName1, Model model)
	 * 
	 * @Requestparam annotation used for dataBinding the values from queryparameter
	 * 
	 * Method:2 public String showResultPage(UserinfoDTO userinfoDTO, Model model)
	 * Using DataTransferObject for data binding
	 */

//		System.out.println("UserName is :"+userName);
//		System.out.println("Crushname is :"+crushName);
//		
//		model.addAttribute("uname",userName);
//		model.addAttribute("cname", crushName);

	// model.addAttribute("userInfo", userinfoDTO);

	@RequestMapping("/process-homepage")
	public String showResultPage(@Valid @ModelAttribute("userInfo") UserInfoDTO userinfoDTO, BindingResult result) {

		if (result.hasErrors()) {
			System.out.println("This form has  errors...");
			List<ObjectError> allErrors = result.getAllErrors();
			for (ObjectError err : allErrors)// For each
			{
				System.out.println(err);
			}
			return "home-page";
		}

		return "result-page";
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
	//	binder.addValidators(new UserNameValidator());
	}

}