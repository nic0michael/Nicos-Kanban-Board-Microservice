package za.co.kanban.controllers;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import za.co.kanban.dtos.UserStoryPersistRequest;
import za.co.kanban.model.Customer;
import za.co.kanban.model.Epic;
import za.co.kanban.model.Team;
import za.co.kanban.model.UserStory;
import za.co.kanban.modules.EpicModule;
import za.co.kanban.modules.TeamModule;
import za.co.kanban.modules.UserStoryModule;
import za.co.kanban.utils.Utils;

@Controller
@RequestMapping("/kanban-board/userstories")
public class UserStoryController {
	private static final Logger log = LoggerFactory.getLogger(UserStoryController.class);

	@Autowired
	private UserStoryModule userStorymod;
	
	@Autowired
	private EpicModule epicmod;

	@Autowired
	private TeamModule teammod;
	
	@GetMapping
	public String displayUserStorys(Model model) {
		List<UserStory> userStoryList = userStorymod.findAll();
		model.addAttribute("userStoryList", userStoryList);
		return "userstories/list-userstories";
	}

	@GetMapping("/list")
	public String displayHome(Model model) {
		List<UserStory> userStoryList = userStorymod.findAll();
		model.addAttribute("userStoryList", userStoryList);
		return "userstories/list-userstories";
	}

	@GetMapping("/new")
	public String displayUserStoryForm(Model model) {
		UserStory userStory=new UserStory();
		UserStoryPersistRequest  userStoryPersistRequest=Utils.convertToUserStoryPersistRequest(userStory);
		List<Epic>epics =epicmod.findAll();
		List<Team>teams =teammod.findAll();
		model.addAttribute("teams", teams);
		model.addAttribute("epics", epics);
		model.addAttribute("userStoryPersistRequest", userStoryPersistRequest);
		return "userstories/new-userstory";
	}


	@PostMapping("/save")
	public String createUserStory(UserStoryPersistRequest  userStoryPersistRequest,Model model) {
		log.info("USER_STRY : UserStoryController : createUserStory : saving userStory from  UserStoryPersistRequest: "+userStoryPersistRequest);
		
		if(StringUtils.isNotBlank(userStoryPersistRequest.getUserStoryId() )  && StringUtils.isNumeric(userStoryPersistRequest.getUserStoryId()) ) {
			log.info("USER_STRY : UserStoryController : createUserStory : updating userStory");
			UserStory theUserStory=Utils.convertToUserStory(userStoryPersistRequest);
			Long userStoryId=Long.parseLong(userStoryPersistRequest.getUserStoryId());
			userStorymod.update(userStoryId,theUserStory);
		} else {
			log.info("USER_STRY : UserStoryController : createUserStory : saving new userStory");
			userStorymod.save(userStoryPersistRequest);		
		}
		// use a redirect to prevent duplicate submissions
		log.info("USER_STRY : UserStoryController : createUserStory : redirecting to userstories page");
		return "redirect:/kanban-board/userstories";
	}

	
	@GetMapping("/remove}")
	public String deleteUserStory(@RequestParam(value = "id") Long userStoryId) {
		userStorymod.delete(userStoryId);
		return "redirect:/projects";
	}
	

	@GetMapping("/change}")
	public String updateUserStory(@RequestParam(value = "id") Long userStoryId,Model model) {
		UserStory userStory=userStorymod.findByUserStoryId(userStoryId);
		model.addAttribute("userStory",userStory);
		return "redirect:/userstories/new";
	}

	@GetMapping("/maakdood")
	public String removeUserStory(@RequestParam(value = "id") Long userStoryId,Model model) {
		log.info("USER_STRY : UserStoryController : removeUserStory : to update project with project_id : "+userStoryId);
		userStorymod.delete(userStoryId);
		return "redirect:/userstories";
	}
	
	@GetMapping("/verander")
	public String displayUserStorytFormToUpdate(@RequestParam(value = "id") Long userStoryId,Model model) {
		log.info("USER_STRY : UserStoryController : displayUserStorytFormToUpdate : to update project with project_id : "+userStoryId);		
		if(userStoryId!=null) {
			UserStory userStory=userStorymod.findByUserStoryId(userStoryId);
			if(userStory.getDateCreated()==null) {
				userStory.setDateCreated(new Date());
			}
			if(userStory!=null) {
				UserStoryPersistRequest  userStoryPersistRequest=Utils.convertToUserStoryPersistRequest(userStory);
				List<Epic>epics =epicmod.findAll();
				List<Team>teams =teammod.findAll();
				model.addAttribute("teams", teams);
				model.addAttribute("epics", epics);
				log.info("USER_STRY : UserStoryController : displayUserStorytFormToUpdate : created UserStoryPersistRequest : "+userStoryPersistRequest);
				model.addAttribute("userStoryPersistRequest", userStoryPersistRequest);
			} else {
				return "redirect:/userstories";
			}
		}
		log.info("USER_STRY : UserStoryController : displayUserStorytFormToUpdate : displaying form");
		return "userstories/new-userstory";	
	}

}