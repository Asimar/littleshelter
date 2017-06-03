package pl.karol.littleshelter.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.karol.littleshelter.entity.User;
import pl.karol.littleshelter.service.NotificationServiceImpl;
import pl.karol.littleshelter.service.UserServiceImpl;

@Controller
public class UserController extends BaseController{

	private UserServiceImpl userService;
	
	@Autowired
	public UserController(UserServiceImpl userService, NotificationServiceImpl notificationService) {
		super(notificationService);
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
	public String register(@Valid User user, BindingResult bindingResult) {
		if (userService.register(user)) {
			notificationService.addInfoMessage("Register successful");
		} else {
			notificationService.addErrorMessage("You are already registered");
		}
		return "register";
	}
	
}
