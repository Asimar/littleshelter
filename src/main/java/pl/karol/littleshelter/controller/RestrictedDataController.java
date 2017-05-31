package pl.karol.littleshelter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.karol.littleshelter.service.NotificationServiceImpl;
import pl.karol.littleshelter.service.RestrictedDataServiceImpl;
import pl.karol.littleshelter.service.UserServiceImpl;

@Controller
public class RestrictedDataController extends BaseController{

	private UserServiceImpl userService;
	
	private RestrictedDataServiceImpl restrictedDtaService;
	
	@Autowired
	public RestrictedDataController(UserServiceImpl userService, RestrictedDataServiceImpl restrictedDataService, NotificationServiceImpl notificationService) {
		super(notificationService);
		this.userService = userService;
		this.restrictedDtaService = restrictedDataService;
	}
	
	@RequestMapping(value = "/restrictedData")
	public String restrictedDataTable(Model model) {
		
		model.addAttribute("restrictedData", userService.findUserByEmail("a").get().getRestrictedData());
		return "restrictedDataTable";
	}
	
}
