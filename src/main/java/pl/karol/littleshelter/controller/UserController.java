package pl.karol.littleshelter.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.karol.littleshelter.object.LoginObject;
import pl.karol.littleshelter.service.NotificationService;
import pl.karol.littleshelter.service.RestrictedDataServiceImpl;
import pl.karol.littleshelter.service.UserServiceImpl;

@Controller
public class UserController {

	private UserServiceImpl userService;
	
	private NotificationService notificationService;
	
	@Autowired
	public UserController(UserServiceImpl userService, NotificationService notificationService) {
		this.userService = userService;
		this.notificationService = notificationService;
	}
	
	@RequestMapping(value = "/users")
	public String userTable(Model model) {
		
		model.addAttribute("users", userService.getUsers());
		return "userTable";
	}
	
}
