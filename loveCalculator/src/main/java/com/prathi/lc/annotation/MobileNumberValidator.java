package com.prathi.lc.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.prathi.lc.pojo.Phone;

public class MobileNumberValidator implements ConstraintValidator<Mobile, Phone> {

	@Override
	public void initialize(Mobile constraintAnnotation) {
		System.out.println("PhoenNumber intialized here....");
	}

	@Override
	public boolean isValid(Phone phone, ConstraintValidatorContext context) {
		System.out.println("Inside Mobile annotation");

		if (phone == null) {
			return false;
		}
		if (phone.getCountryCode().length() != 2 || phone.getUserNumber().length() != 10) {
			return false;
		}
		return true;
	}

}
