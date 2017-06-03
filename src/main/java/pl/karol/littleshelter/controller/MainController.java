package pl.karol.littleshelter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.karol.littleshelter.repository.UserRepository;
import pl.karol.littleshelter.service.NotificationService;
import pl.karol.littleshelter.service.ValidationService;

@Controller
public class MainController extends BaseController {

	@Autowired
	public MainController(UserRepository userRepository, NotificationService notificationService, ValidationService validationService) {
		super(notificationService, validationService);
	}

	@RequestMapping(value = "/")
	public String index() {
		notificationService.addInfoMessage("Welcom in littleshelter! We'll hope you and your data feel safety here.");
		return "index";
	}

}
