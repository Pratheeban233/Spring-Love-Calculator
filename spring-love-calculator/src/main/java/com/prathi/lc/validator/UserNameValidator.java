package com.prathi.lc.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.prathi.lc.dto.UserRegisterInfoDTO;

public class UserNameValidator implements Validator {

	// check if the userNamevalidator supports a given object
	@Override
	public boolean supports(Class<?> clazz) {

		return UserRegisterInfoDTO.class.equals(clazz);
	}

	// our validation logic
	@Override
	public void validate(Object target, Errors errors) {
		// check null
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "userName.empty");

		String userName = ((UserRegisterInfoDTO) target).getUserName();
		// should contain a '_'
		if (!userName.contains("_")) {
			errors.rejectValue("userName", "userName.contain");
		} 
	}
}
