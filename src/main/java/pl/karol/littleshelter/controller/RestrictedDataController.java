package pl.karol.littleshelter.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.log4j.Log4j;
import pl.karol.littleshelter.entity.RestrictedData;
import pl.karol.littleshelter.entity.User;
import pl.karol.littleshelter.service.NotificationService;
import pl.karol.littleshelter.service.RestrictedDataService;
import pl.karol.littleshelter.service.UserService;
import pl.karol.littleshelter.service.ValidationService;

@Log4j
@Controller
public class RestrictedDataController extends BaseController{

	private UserService userService;
	
	private RestrictedDataService restrictedDtaService;
	
	@Autowired
	public RestrictedDataController(UserService userService, RestrictedDataService restrictedDataService, 
									NotificationService notificationService, ValidationService validationService) {
		super(notificationService, validationService);
		this.userService = userService;
		this.restrictedDtaService = restrictedDataService;
	}
	
	@Secured("ROLE_USER")
	@RequestMapping(value = "/restrictedData", method = RequestMethod.GET)
	public String restrictedDataTable(Model model) {
		User authUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("restrictedData", userService.findUserByEmail(authUser.getEmail()).get().getRestrictedData());
		return "restrictedDataTable";
	}
	
	@Secured("ROLE_USER")
	@RequestMapping(value = "/createRestrictedData", method = RequestMethod.GET)
	public String restrictedDataCreatePage(RestrictedData restrictedData) {	
		return "restrictedDataCreate";
	}
	
	@Secured("ROLE_USER")
	@RequestMapping(value = "/createRestrictedData", method = RequestMethod.POST)
	public String createRestrictedData(@Valid RestrictedData restrictedData, BindingResult bindingResult) {
		log.info("Restricted data added by user: ${replaceByuserId}");
		User authUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		restrictedDtaService.addRestrictedData(userService.findUserByEmail(authUser.getEmail()).get(), restrictedData);
		notificationService.addInfoMessage("Restricted data created.");
		return "restrictedDataCreate";
	}
	
}
