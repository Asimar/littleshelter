package pl.karol.littleshelter.controller;

import org.springframework.beans.factory.annotation.Autowired;

import pl.karol.littleshelter.service.NotificationService;
import pl.karol.littleshelter.service.ValidationService;

public class BaseController {

	protected NotificationService notificationService;
	
	protected ValidationService validationService;
	
	@Autowired
	public BaseController(NotificationService notificationService, ValidationService validationService) {
		this.notificationService = notificationService;
		this.validationService = validationService;
	}
	
}
