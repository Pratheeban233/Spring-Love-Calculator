package com.prathi.lc.formatters;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.prathi.lc.dto.Phone;

/*
 * @ implement the formatter.. need to register the formatter in the appconfig 
 * 
 */

public class PhoneNumberFormatter implements Formatter<Phone> {

	@Override
	public String print(Phone phone, Locale locale) {
		System.out.println("inside PhoneNumberFormatter.print method");

		// for display the saved or loaded data
		return phone.getCountryCode() + "-" + phone.getUserNumber();
	}

	@Override
	public Phone parse(String completePhoneNumber, Locale locale) throws ParseException {

		System.out.println("inside PhoneNumberFormatter.parse method");

		// Logic here
		String[] phoneNumber = completePhoneNumber.split("-");
		Phone phone = new Phone();
		int index = completePhoneNumber.indexOf('-');

		if (index == -1)// to check '-' contains or not (return -1 index does not contain in the string)
		{
			if (!completePhoneNumber.contains("-") && completePhoneNumber.length() == 12) {
				phone.setCountryCode(completePhoneNumber.substring(0, 2));
				phone.setUserNumber(completePhoneNumber.substring(2));
			} else {
				phone.setCountryCode("91");
				phone.setUserNumber(phoneNumber[0]);
			}
		} else {
			boolean flag = completePhoneNumber.startsWith("-");
			// if phonenumber start with '-'
			if (flag) {
				phone.setCountryCode("91");
				phone.setUserNumber(phoneNumber[1]);
			} else {
				phone.setCountryCode(phoneNumber[0]);
				phone.setUserNumber(phoneNumber[1]);
			}
		}
		return phone;
	}

}
