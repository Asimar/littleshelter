package pl.karol.littleshelter.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = PasswordValidator.class)
@Target( {ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Password {
	
    String message() default "password minimum lenght is 8 characters and "
    							+ "must contains at least one small letter, one big letter, "
    							+ "one number and one special character {!,@,#,$,%,^,&,*}";
    
    Class<?>[] groups() default {};
     
    Class<? extends Payload>[] payload() default {};

}
