package com.prathi.lc.contollers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.prathi.lc.pojo.CommunicationDTO;
import com.prathi.lc.pojo.Phone;
import com.prathi.lc.pojo.UserRegisterInfoDTO;
import com.prathi.lc.propertyeditor.NameFormatEditor;
import com.prathi.lc.validator.EmailValidator;
import com.prathi.lc.validator.UserNameValidator;

@Controller
public class RegistrationController {

	@Autowired
	private EmailValidator emailvalidator;

	@RequestMapping("/register")
	public String userRegistration(@ModelAttribute("userRegistrationInfo") UserRegisterInfoDTO userRegisterInfo) {
		// UserRegisterInfoDTO userRegisterInfo = new UserRegisterInfoDTO();
		// model.addAttribute("userRegistrationInfo",userRegisterInfo);

		System.out.println("inside userRegistration method");

		/*
		 * Phone phone = new Phone(); phone.setCountryCode("91"); ;
		 * phone.setUserNumber("8489894594");
		 * 
		 * CommunicationDTO communicationDTO = new CommunicationDTO();
		 * communicationDTO.setPhone(phone);
		 * 
		 * userRegisterInfo.setCommunicationDTO(communicationDTO);
		 */

		return "user-registration-page";
	}

	@RequestMapping("/register-success")
	public String registrationDetails(
			@Valid @ModelAttribute("userRegistrationInfo") UserRegisterInfoDTO userRegisterInfo, BindingResult result) {
		System.out.println("inside registrationDetails method");
		System.out.println(
				"User Entered Mobile Number::" + "|" + userRegisterInfo.getCommunicationDTO().getPhone() + "|");

		// calling email validator here
		 emailvalidator.validate(userRegisterInfo, result);

		if (result.hasErrors()) {
			List<ObjectError> allErrors = result.getAllErrors();

			for (ObjectError error : allErrors) {
				System.out.println(error);
			}
			return "user-registration-page";
		}

		return "registration-success";

	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		System.out.println("Inside the initBinder method...");
		// binder.setDisallowedFields("name");

		StringTrimmerEditor stringEditor = new StringTrimmerEditor(true);
		binder.registerCustomEditor(String.class, "name", stringEditor);

		NameFormatEditor nameEditor = new NameFormatEditor();
		binder.registerCustomEditor(String.class, "name", nameEditor);

		// add validators here
		// UserNameValidator userNameValidator = new UserNameValidator();
		// binder.addValidators(userNameValidator);
		binder.addValidators(new UserNameValidator());
		binder.addValidators(new EmailValidator());

	}
}
