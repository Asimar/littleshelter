package pl.karol.littleshelter.service;

import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.util.HtmlUtils;

import lombok.extern.log4j.Log4j;
import pl.karol.littleshelter.entity.User;

@Log4j
@Service
public class ValidationService {
	
	private NotificationService notificationService;
	
	public ValidationService(NotificationService notificationService) {
		this.notificationService = notificationService;
	}
	
	public Boolean validateRegister(User user, String confirmPassword, BindingResult bindingResult) {
		if (!user.getPassword().equals(confirmPassword)) {
			notificationService.addErrorMessage("Passwords are different!");
			String springhtmlutil = HtmlUtils.htmlEscape(confirmPassword);
			String jsoup = Jsoup.clean(confirmPassword, Whitelist.basic());
			log.warn(springhtmlutil);
			log.warn(jsoup);
			return true;
			
		}
		if (bindingResult.hasErrors()) {
			for (FieldError error : bindingResult.getFieldErrors())			
				notificationService.addErrorMessage(error.getField().toUpperCase().concat(": ").concat(error.getDefaultMessage()));
			return true;
		}
		return false;
	}

}
