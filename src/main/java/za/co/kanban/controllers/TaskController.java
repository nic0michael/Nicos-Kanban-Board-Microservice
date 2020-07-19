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
import za.co.kanban.dtos.TaskPersistRequest;
import za.co.kanban.model.Employee;
import za.co.kanban.model.Task;
import za.co.kanban.modules.EmployeeModule;
import za.co.kanban.modules.TaskModule;
import za.co.kanban.utils.Utils;


@Controller
@RequestMapping("/tasks")
public class TaskController {
	private static final Logger log = LoggerFactory.getLogger(TaskController.class);
	 
	
	@Autowired 
	TaskModule taskmod;

	@Autowired 
	EmployeeModule emplmod;	

	@GetMapping
	public String displayTasks(Model model) {
		List<Task> tasks = taskmod.findAll();
		model.addAttribute("projectsList", tasks);
		if(tasks!=null) {
			log.info("PROJECT_MAN : ProjectController : displayProjects : displaying :"+tasks.size()+" projects");
		}
		return "projects/list-projects";
	}
	@GetMapping("/list")
	public String displayHome(Model model) {
		List<Task> tasks = taskmod.findAll();
		if(tasks!=null) {
			log.info("PROJECT_MAN : ProjectController : displayHome : displaying :"+tasks.size()+" projects");
		}
		model.addAttribute("projectsList", tasks);
		return "projects/list-projects";
	}
	
	@GetMapping("/new")
	public String displayProjectForm(Model model) {
		TaskPersistRequest taskPersistRequest=new TaskPersistRequest();
		log.info("PROJECT_MAN : ProjectController : displayProjectForm : creating new projectPersistRequest");
//		Project project=new Project();
		model.addAttribute("taskPersistRequest",taskPersistRequest);
		List<Employee> employees = emplmod.findAll();
		List<EmployeePersistRequest> employeePersistRequests=Utils.makeEmployeePersistRequestList(employees);
		model.addAttribute("allEemployeePersistRequests", employeePersistRequests);
		log.info("PROJECT_MAN : ProjectController : displayProjectForm : displaying form");
		return "projects/new-project";
	}


	@PostMapping("/save")
	public String createTask( TaskPersistRequest taskPersistRequest,Model model) {
		log.info("PROJECT_MAN : ProjectController : createProject : saving project from  ProjectPersistRequest: "+taskPersistRequest);
		
		if(StringUtils.isNotBlank(taskPersistRequest.getTaskId())  && StringUtils.isNumeric(taskPersistRequest.getTaskId()) ) {				
			log.info("PROJECT_MAN : ProjectController : createProject : updating project");
			taskmod.update(taskPersistRequest);
		} else {
			log.info("PROJECT_MAN : ProjectController : createProject : saving new project");
			taskmod.save(taskPersistRequest);
		}
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/projects";
	}


	@GetMapping("/maakdood")
	public String removeProject(@RequestParam(value = "id") Long project_id,Model model) {
		log.info("PROJECT_MAN : ProjectController : removeProject : to update project with project_id : "+project_id);
		taskmod.delete(project_id);
		return "redirect:/projects";
	}
	
	@GetMapping("/verander")
	public String displayProjectFormToUpdate(@RequestParam(value = "id") Long taskId,Model model) {
		log.info("PROJECT_MAN : ProjectController : displayProjectFormToUpdate : to update project with project_id : "+taskId);		
		if(taskId!=null) {
			Task task=taskmod.find(taskId);
			TaskPersistRequest projectPersistRequest=Utils.convertToTaskPersistRequest(task);
			projectPersistRequest.setTaskId(""+taskId);
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