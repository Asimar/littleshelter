package pl.karol.littleshelter.service;

import java.lang.reflect.Field;

import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.util.HtmlUtils;
import org.thymeleaf.util.StringUtils;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;

import lombok.extern.log4j.Log4j;
import pl.karol.littleshelter.entity.RestrictedData;
import pl.karol.littleshelter.entity.User;
import pl.karol.littleshelter.tool.ValidationUtil;

@Log4j
@Service
public class ValidationService {

	private NotificationService notificationService;

	public ValidationService(NotificationService notificationService) {
		this.notificationService = notificationService;
	}

	public Boolean validateRegister(User user, String confirmPassword, BindingResult bindingResult) {
		Boolean validationResult = this.baseValidation(user, bindingResult);
		if (!user.getPassword().equals(confirmPassword)) {
			notificationService.addErrorMessage("Passwords are different!");
			validationResult = true;
		}
		
		return validationResult;
	}
	
	public Boolean validateRestrictedData(RestrictedData restrictedData, BindingResult bindingResult) {
		Boolean validationResult = this.baseValidation(restrictedData, bindingResult);
		
		return validationResult;
	}
	
	private Boolean baseValidation(Object objectToValidation, BindingResult bindingResult) {
		Boolean validationResult = new Boolean(false);
		if (this.containsDangerousStrings(objectToValidation)) {
			notificationService.addErrorMessage("INSERTED DATA IS POTENTIALY DANGEROUS! please correct it.");
			validationResult = true;
		}
		if (bindingResult.hasErrors()) {
			for (FieldError error : bindingResult.getFieldErrors())
				notificationService
						.addErrorMessage(error.getField().toUpperCase().concat(": ").concat(error.getDefaultMessage()));
			validationResult = true;
		}
		
		return validationResult;
	}

	private Boolean containsDangerousStrings(Object candidate) {
		ListMultimap<Boolean, String> resultMap = ArrayListMultimap.create();
		String fieldValue = new String();
		for (Field field : candidate.getClass().getDeclaredFields()) {
			field.setAccessible(true);
			if (field.getType().isAssignableFrom(String.class)) {
				try {
					fieldValue = (String) field.get(candidate);
				} catch (Exception e) {
					log.error("cannot cast declared field to String");
				}
				resultMap.put(this.containsDangerousCharacters(fieldValue), fieldValue);

			}
		}

		return resultMap.containsKey(true);
	}

	private Boolean containsDangerousCharacters(String candidate) {
		Boolean result = new Boolean(false);
		if (!StringUtils.isEmpty(candidate)) {
			result = !candidate.equals(HtmlUtils.htmlEscape(candidate))
					|| !candidate.equals(Jsoup.clean(candidate, Whitelist.basic()))
					|| !candidate.equals(ValidationUtil.cleanDataForNoSQL(candidate));
		}
		
		return result;
	}

}
