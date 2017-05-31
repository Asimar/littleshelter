package pl.karol.littleshelter.controller;

import org.springframework.beans.factory.annotation.Autowired;

import pl.karol.littleshelter.service.NotificationServiceImpl;

public class BaseController {

	protected NotificationServiceImpl notificationService;
	
	@Autowired
	public BaseController(NotificationServiceImpl notificationService) {
		this.notificationService = notificationService;
	}
}
