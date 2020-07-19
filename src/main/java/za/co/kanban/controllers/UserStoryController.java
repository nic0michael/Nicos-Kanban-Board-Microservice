package za.co.kanban.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

import za.co.kanban.dtos.EmployeePersistRequest;
import za.co.kanban.dtos.UserStoryPersistRequest;
import za.co.kanban.dtos.UserStoryPersistRequest;
import za.co.kanban.model.Employee;
import za.co.kanban.model.UserStory;
import za.co.kanban.model.UserStory;
import za.co.kanban.modules.EmployeeModule;
import za.co.kanban.modules.UserStoryModule;
import za.co.kanban.modules.UserStoryModule;
import za.co.kanban.utils.Utils;


@Controller
@RequestMapping("/userstories")
public class UserStoryController {
private static final Logger log = LoggerFactory.getLogger(UserStoryController.class);


@Autowired 
UserStoryModule userStorymod;

@Autowired 
EmployeeModule emplmod;	

@GetMapping
public String displayUserStorys(Model model) {
	List<UserStory> userStorys = userStorymod.findAll();
	model.addAttribute("projectsList", userStorys);
	if(userStorys!=null) {
		log.info("PROJECT_MAN : ProjectController : displayProjects : displaying :"+userStorys.size()+" projects");
	}
	return "projects/list-projects";
}
@GetMapping("/list")
public String displayHome(Model model) {
	List<UserStory> userStorys = userStorymod.findAll();
	if(userStorys!=null) {
		log.info("PROJECT_MAN : ProjectController : displayHome : displaying :"+userStorys.size()+" projects");
	}
	model.addAttribute("projectsList", userStorys);
	return "projects/list-projects";
}

@GetMapping("/new")
public String displayProjectForm(Model model) {
	UserStoryPersistRequest userStoryPersistRequest=new UserStoryPersistRequest();
	log.info("PROJECT_MAN : ProjectController : displayProjectForm : creating new projectPersistRequest");
//	Project project=new Project();
	model.addAttribute("userStoryPersistRequest",userStoryPersistRequest);
	List<Employee> employees = emplmod.findAll();
	List<EmployeePersistRequest> employeePersistRequests=Utils.makeEmployeePersistRequestList(employees);
	model.addAttribute("allEemployeePersistRequests", employeePersistRequests);
	log.info("PROJECT_MAN : ProjectController : displayProjectForm : displaying form");
	return "projects/new-project";
}


@PostMapping("/save")
public String createUserStory( UserStoryPersistRequest userStoryPersistRequest,Model model) {
	log.info("PROJECT_MAN : ProjectController : createProject : saving project from  ProjectPersistRequest: "+userStoryPersistRequest);
	
	if(StringUtils.isNotBlank(userStoryPersistRequest.getUserStoryId())  && StringUtils.isNumeric(userStoryPersistRequest.getUserStoryId()) ) {				
		log.info("PROJECT_MAN : ProjectController : createProject : updating project");
		userStorymod.update(userStoryPersistRequest);
	} else {
		log.info("PROJECT_MAN : ProjectController : createProject : saving new project");
		userStorymod.save(userStoryPersistRequest);
	}
	
	// use a redirect to prevent duplicate submissions
	return "redirect:/projects";
}


@GetMapping("/maakdood")
public String removeProject(@RequestParam(value = "id") Long project_id,Model model) {
	log.info("PROJECT_MAN : ProjectController : removeProject : to update project with project_id : "+project_id);
	userStorymod.delete(project_id);
	return "redirect:/projects";
}

@GetMapping("/verander")
public String displayProjectFormToUpdate(@RequestParam(value = "id") Long userStoryId,Model model) {
	log.info("PROJECT_MAN : ProjectController : displayProjectFormToUpdate : to update project with project_id : "+userStoryId);		
	if(userStoryId!=null) {
		UserStory userStory=userStorymod.find(userStoryId);
		UserStoryPersistRequest projectPersistRequest=Utils.convertToUserStoryPersistRequest(userStory);
		projectPersistRequest.setUserStoryId(""+userStoryId);
		log.info("PROJECT_MAN : ProjectController : displayProjectFormToUpdate : creating new projectPersistRequest");
		model.addAttribute("projectPersistRequest",projectPersistRequest);
		List<Employee> employees = emplmod.findAll();
		List<EmployeePersistRequest> employeePersistRequests=Utils.makeEmployeePersistRequestList(employees);
		model.addAttribute("allEemployeePersistRequests", employeePersistRequests);
	}
	log.info("PROJECT_MAN : ProjectController : displayProjectFormToUpdate : displaying form");
	return "projects/new-project";		
}
}
