package pl.karol.littleshelter.annotation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements ConstraintValidator<Email, String> {

	@Override
	public void initialize(Email constraintAnnotation) {

	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		Pattern pattern = Pattern.compile("^[A-Za-z0-9+_.-]+@[a-zA-Z0-9.-]+$");
		Matcher matcher = pattern.matcher(value);
		
		return matcher.matches();
	}

}
