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
public class RestrictedDataController extends BaseController {

	private UserService userService;

	private RestrictedDataService restrictedDataService;

	@Autowired
	public RestrictedDataController(UserService userService, RestrictedDataService restrictedDataService,
			NotificationService notificationService, ValidationService validationService) {
		super(notificationService, validationService);
		this.userService = userService;
		this.restrictedDataService = restrictedDataService;
	}

	@Secured("ROLE_USER")
	@RequestMapping(value = "/restrictedData", method = RequestMethod.GET)
	public String restrictedDataTable(Model model, RestrictedData dataToDelete) {
		User authUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("restrictedData", userService.findUserByEmail(authUser.getEmail()).get().getRestrictedData());
		model.addAttribute("dataToDelete", dataToDelete);
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
		log.info(restrictedData.toString());
		User authUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		log.info("Added by user: ".concat(authUser.getEmail()));
		if (validationService.validateRestrictedData(restrictedData, bindingResult)) {
			return "restrictedDataCreate";
		}
		restrictedDataService.addRestrictedData(userService.findUserByEmail(authUser.getEmail()).get(), restrictedData);
		notificationService.addInfoMessage("Restricted data created.");
		return "restrictedDataCreate";
	}
	
	@Secured("ROLE_USER")
	@RequestMapping(value="/deleteRestrictedData", method = RequestMethod.DELETE)
	public String delete(RestrictedData dataToDelete) {
		User authUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		restrictedDataService.removeRestrictedData(authUser, dataToDelete);
	    notificationService.addInfoMessage("restricted data deleted successfully.");
	    return "redirect:/restrictedData";
	}

}
