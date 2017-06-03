package pl.karol.littleshelter.annotation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, String> {

	@Override
	public void initialize(PhoneNumber constraintAnnotation) {
	
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		Pattern pattern = Pattern.compile("^\\+?[0-9\\s]{5,16}$");
		Matcher matcher = pattern.matcher(value);
		
		return matcher.matches();
	}

}
