package pl.karol.littleshelter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.karol.littleshelter.service.NotificationServiceImpl;

@Controller
public class MainController {
	
	private NotificationServiceImpl notificationService;
	
	@Autowired
	public MainController(NotificationServiceImpl notificationService) {
		this.notificationService = notificationService;
	}

	@RequestMapping(value = "/")
	public String index() {
		notificationService.addInfoMessage("message test");
		return "index";
	}

}
