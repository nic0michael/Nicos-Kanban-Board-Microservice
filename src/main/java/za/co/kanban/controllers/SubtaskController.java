package za.co.kanban.controllers;

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
import za.co.kanban.dtos.SubtaskPersistRequest;
import za.co.kanban.model.Employee;
import za.co.kanban.model.Subtask;
import za.co.kanban.modules.EmployeeModule;
import za.co.kanban.modules.SubtaskModule;
import za.co.kanban.utils.Utils;


@Controller
@RequestMapping("/subtasks")
public class SubtaskController {
	private static final Logger log = LoggerFactory.getLogger(SubtaskController.class);
	 
	
	@Autowired 
	SubtaskModule subtaskmod;

	@Autowired 
	EmployeeModule emplmod;	

	@GetMapping
	public String displaySubtasks(Model model) {
		List<Subtask> subtasks = subtaskmod.findAll();
		model.addAttribute("projectsList", subtasks);
		if(subtasks!=null) {
			log.info("PROJECT_MAN : ProjectController : displayProjects : displaying :"+subtasks.size()+" projects");
		}
		return "projects/list-projects";
	}
	@GetMapping("/list")
	public String displayHome(Model model) {
		List<Subtask> subtasks = subtaskmod.findAll();
		if(subtasks!=null) {
			log.info("PROJECT_MAN : ProjectController : displayHome : displaying :"+subtasks.size()+" projects");
		}
		model.addAttribute("projectsList", subtasks);
		return "projects/list-projects";
	}
	
	@GetMapping("/new")
	public String displayProjectForm(Model model) {
		SubtaskPersistRequest subtaskPersistRequest=new SubtaskPersistRequest();
		log.info("PROJECT_MAN : ProjectController : displayProjectForm : creating new projectPersistRequest");
//		Project project=new Project();
		model.addAttribute("subtaskPersistRequest",subtaskPersistRequest);
		List<Employee> employees = emplmod.findAll();
		List<EmployeePersistRequest> employeePersistRequests=Utils.makeEmployeePersistRequestList(employees);
		model.addAttribute("allEemployeePersistRequests", employeePersistRequests);
		log.info("PROJECT_MAN : ProjectController : displayProjectForm : displaying form");
		return "projects/new-project";
	}


	@PostMapping("/save")
	public String createSubtask( SubtaskPersistRequest subtaskPersistRequest,Model model) {
		log.info("PROJECT_MAN : ProjectController : createProject : saving project from  ProjectPersistRequest: "+subtaskPersistRequest);
		
		if(StringUtils.isNotBlank(subtaskPersistRequest.getSubtaskId())  && StringUtils.isNumeric(subtaskPersistRequest.getSubtaskId()) ) {				
			log.info("PROJECT_MAN : ProjectController : createProject : updating project");
			subtaskmod.update(subtaskPersistRequest);
		} else {
			log.info("PROJECT_MAN : ProjectController : createProject : saving new project");
			subtaskmod.save(subtaskPersistRequest);
		}
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/projects";
	}


	@GetMapping("/maakdood")
	public String removeProject(@RequestParam(value = "id") Long project_id,Model model) {
		log.info("PROJECT_MAN : ProjectController : removeProject : to update project with project_id : "+project_id);
		subtaskmod.delete(project_id);
		return "redirect:/projects";
	}
	
	@GetMapping("/verander")
	public String displayProjectFormToUpdate(@RequestParam(value = "id") Long subtaskId,Model model) {
		log.info("PROJECT_MAN : ProjectController : displayProjectFormToUpdate : to update project with project_id : "+subtaskId);		
		if(subtaskId!=null) {
			Subtask subtask=subtaskmod.find(subtaskId);
			SubtaskPersistRequest projectPersistRequest=Utils.convertToSubtaskPersistRequest(subtask);
			projectPersistRequest.setSubtaskId(""+subtaskId);
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
