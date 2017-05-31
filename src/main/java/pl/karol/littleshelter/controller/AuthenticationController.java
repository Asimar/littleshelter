package pl.karol.littleshelter.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.karol.littleshelter.object.LoginObject;
import pl.karol.littleshelter.service.AuthenticationServiceImpl;
import pl.karol.littleshelter.service.NotificationServiceImpl;

@Controller
public class AuthenticationController extends BaseController {

	private AuthenticationServiceImpl authenticationService;

	@Autowired
	public AuthenticationController(AuthenticationServiceImpl authenticationService, NotificationServiceImpl notificationService) {
		super(notificationService);
		this.authenticationService = authenticationService;
	}

	@RequestMapping("/login")
	public String login(LoginObject loginObject) {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPage(@Valid LoginObject loginObject, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			notificationService.addErrorMessage("Please fill the form correctly!");
			return "login";
		}

		if (!authenticationService.authenticate(loginObject.getEmail(), loginObject.getPassword())) {
			notificationService.addErrorMessage("Invalid login!");
			return "login";
		}

		notificationService.addInfoMessage("Login successful");
		return "redirect:/";
	}

}
