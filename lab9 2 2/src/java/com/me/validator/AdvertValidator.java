package com.me.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.me.pojo.Advert;
import org.springframework.validation.ValidationUtils;

@Component
public class AdvertValidator implements Validator {

	public boolean supports(Class aClass) {
		return aClass.equals(Advert.class);
	}

	public void validate(Object obj, Errors errors) {
		Advert newAdvert = (Advert) obj;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "error.invalid.title", "title Required");
                ValidationUtils.rejectIfEmptyOrWhitespace(errors, "message", "error.invalid.message", "message Required");
                ValidationUtils.rejectIfEmptyOrWhitespace(errors, "categories", "error.invalid.categories", "categories Required");
                
	}
}
