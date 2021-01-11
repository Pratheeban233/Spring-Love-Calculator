package com.prathi.lc.annotation;

import java.util.Arrays;
import java.util.Iterator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.passay.DigitCharacterRule;
import org.passay.LengthRule;
import org.passay.PasswordData;
import org.passay.PasswordValidator;
import org.passay.RuleResult;
import org.passay.SpecialCharacterRule;
import org.passay.UppercaseCharacterRule;
import org.passay.WhitespaceRule;

import com.prathi.lc.pojo.ValidationForm;

public class PasswordValidation implements ConstraintValidator<validatePassword, char[]> {

	@Override
	public void initialize(validatePassword constraintAnnotation) {
		System.out.println("validPassword initialized...");
	}

	@Override
	public boolean isValid(char[] password, ConstraintValidatorContext context) {
		ValidationForm res = new ValidationForm();
		PasswordValidator validator = new PasswordValidator(Arrays.asList(new LengthRule(8, 30),
				new UppercaseCharacterRule(1), new DigitCharacterRule(1), new SpecialCharacterRule(1),
				// new NumericalSequenceRule(3,false),
				// new NumericalSequenceRule(),
				// new AlphabeticalSequenceRule(3,false),
				// new QwertySequenceRule(3,false),
				new WhitespaceRule()));
		RuleResult result = validator.validate(new PasswordData(String.valueOf(password)));
		if (result.isValid()) {
			return true;
		} else {
			System.out.println("invalid password::" + validator.getMessages(result));

			res.setPasswordValidation(validator.getMessages(result));
			if (!validator.getMessages(result).isEmpty()) {

				Iterator<String> iterator = validator.getMessages(result).iterator();

				while (iterator.hasNext()) {
					System.out.println("Iterator result is::" + iterator.next());
				}
			}
			System.out.println("getter::" + res.getPasswordValidation());
			return false;
		}
	}
}
