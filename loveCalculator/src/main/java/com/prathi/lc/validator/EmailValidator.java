package com.prathi.lc.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.prathi.lc.pojo.UserRegisterInfoDTO;

@Component
public class EmailValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {

		return UserRegisterInfoDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "communicationDTO.email", "validate.email.message");
		
		String email = ((UserRegisterInfoDTO)target).getCommunicationDTO().getEmail();
		
		if(!email.endsWith("gmail.com"))
		{
			errors.rejectValue("communicationDTO.email", "validate.email.suffix");
		}
	}

}
