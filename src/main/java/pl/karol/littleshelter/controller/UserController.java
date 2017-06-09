package pl.karol.littleshelter.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.log4j.Log4j;
import pl.karol.littleshelter.entity.User;
import pl.karol.littleshelter.service.NotificationService;
import pl.karol.littleshelter.service.UserService;
import pl.karol.littleshelter.service.ValidationService;

@Log4j
@Controller
public class UserController extends BaseController {

	private UserService userService;

	@Autowired
	public UserController(UserService userService, NotificationService notificationService, ValidationService validationService) {
		super(notificationService, validationService);
		this.userService = userService;
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerPage(User user) {
		return "register";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		return "login";
	}

	@Secured("ROLE_ADMIN")
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String userTable(Model model) {
		model.addAttribute("users", userService.getUsers());
		return "userTable";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(String confirmPassword, @Valid User user, BindingResult bindingResult) {

		log.info(user.toString());
		if (validationService.validateRegister(user, confirmPassword, bindingResult)) {
			return "register";
		} else if (userService.register(user)) {
			notificationService.addInfoMessage("Register successful! You can now login.");
		} else {
			notificationService.addErrorMessage("You are already registered!");
		}

		return "register";
	}

	@Secured("ROLE_ADMIN")
	@RequestMapping(value="/deleteUser/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable String id) {
	    userService.deleteUser(id);
	    notificationService.addInfoMessage("User deleted successfully.");
	    return "redirect:/users";
	}

}
