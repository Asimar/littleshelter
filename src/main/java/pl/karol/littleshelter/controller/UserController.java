package pl.karol.littleshelter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	@RequestMapping(value = "/users")
	public String userTable(Model model) {
		
		model.addAttribute("users", userService.getUsers());
		return "userTable";
	}
	
}
