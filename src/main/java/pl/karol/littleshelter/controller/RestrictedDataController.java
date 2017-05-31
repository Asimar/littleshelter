package pl.karol.littleshelter.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.log4j.Log4j;
import pl.karol.littleshelter.entity.RestrictedData;
import pl.karol.littleshelter.service.NotificationServiceImpl;
import pl.karol.littleshelter.service.RestrictedDataServiceImpl;
import pl.karol.littleshelter.service.UserServiceImpl;

@Log4j
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
	
	@RequestMapping(value = "/createRestrictedData")
	public String restrictedDataCreate(RestrictedData restrictedData) {
		
		return "restrictedDataCreate";
	}
	
	@RequestMapping(value = "/createRestrictedData", method = RequestMethod.POST)
	public String loginPage(@Valid RestrictedData restrictedData, BindingResult bindingResult) {
		log.info("Restricted data added by user: ${replaceByuserId}");
		restrictedDtaService.addRestrictedData(userService.findUserByEmail("a").get(), restrictedData);
		notificationService.addInfoMessage("Restricted data created");
		return "restrictedDataCreate";
	}
	
}
