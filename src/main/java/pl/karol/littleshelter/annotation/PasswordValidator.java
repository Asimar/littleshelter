package pl.karol.littleshelter.annotation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<Password, String> {

	@Override
	public void initialize(Password constraintAnnotation) {
	
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
			
		Pattern pattern = Pattern.compile("(?=.+[a-z])(?=.+[A-Z])(?=.+[0-9])(?=.+[!@#$%^&*]).{8,50}");
		Matcher matcher = pattern.matcher(value);
		
		return matcher.matches();
	}

}
