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

import za.co.kanban.dtos.TaskPersistRequest;
import za.co.kanban.model.Employee;
import za.co.kanban.model.Task;
import za.co.kanban.model.UserStory;
import za.co.kanban.modules.EmployeeModule;
import za.co.kanban.modules.TaskModule;
import za.co.kanban.modules.UserStoryModule;
import za.co.kanban.utils.Utils;


@Controller
@RequestMapping("/kanban-board/tasks")
public class TaskController {
	private static final Logger log = LoggerFactory.getLogger(TaskController.class);
	 
	
	@Autowired 
	TaskModule taskmod;

	@Autowired 
	UserStoryModule userstmod;	
	
	@Autowired 
	EmployeeModule empmod;

	@GetMapping
	public String displayTasks(Model model) {
		List<Task> tasks = taskmod.findAll();
		model.addAttribute("tasksList", tasks);
		if(tasks!=null) {
			log.info("PROJECT_MAN : TaskController : displayTasks : displaying :"+tasks.size()+" tasks");
		}
		return "tasks/list-tasks";
	}
	@GetMapping("/list")
	public String displayHome(Model model) {
		List<Task> tasks = taskmod.findAll();
		if(tasks!=null) {
			log.info("PROJECT_MAN : TaskController : displayHome : displaying :"+tasks.size()+" tasks");
		}
		model.addAttribute("tasksList", tasks);
		return "tasks/list-tasks";
	}
	
	@GetMapping("/new")
	public String displayTaskForm(Model model) {
		TaskPersistRequest taskPersistRequest=new TaskPersistRequest();
		log.info("PROJECT_MAN : TaskController : displayTaskForm : creating new taskPersistRequest");
//		Task task=new Task();
		model.addAttribute("taskPersistRequest",taskPersistRequest);
		List<UserStory> userStories = userstmod.findAll();
		List<Employee> employees = empmod.findAll();
		model.addAttribute("employees", employees);
		model.addAttribute("userStories", userStories);
		log.info("PROJECT_MAN : TaskController : displayTaskForm : displaying form");
		return "tasks/new-task";
	}

	
	@GetMapping("/board")
	public String displayTaskFBoard(Model model) {
		TaskPersistRequest taskPersistRequest=new TaskPersistRequest();
		log.info("PROJECT_MAN : TaskController : displayTaskForm : creating new taskPersistRequest");
//		Task task=new Task();
		model.addAttribute("taskPersistRequest",taskPersistRequest);
		List<UserStory> userStories = userstmod.findAll();
		List<Employee> employees = empmod.findAll();
		model.addAttribute("employees", employees);
		model.addAttribute("userStories", userStories);
		log.info("PROJECT_MAN : TaskController : displayTaskForm : displaying form");
		return "tasks/task-board";
	}

	@PostMapping("/save")
	public String createTask( TaskPersistRequest taskPersistRequest,Model model) {
		log.info("PROJECT_MAN : TaskController : createTask : saving task from  TaskPersistRequest: "+taskPersistRequest);
		
		if(StringUtils.isNotBlank(taskPersistRequest.getTaskId())  && StringUtils.isNumeric(taskPersistRequest.getTaskId()) ) {				
			log.info("PROJECT_MAN : TaskController : createTask : updating task");
			taskmod.update(taskPersistRequest);
		} else {
			log.info("PROJECT_MAN : TaskController : createTask : saving new task");
			taskmod.save(taskPersistRequest);
		}
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/kanban-board/tasks";
	}


	@GetMapping("/maakdood")
	public String removeTask(@RequestParam(value = "id") Long task_id,Model model) {
		log.info("PROJECT_MAN : TaskController : removeTask : to update task with task_id : "+task_id);
		taskmod.delete(task_id);
		return "redirect:/tasks";
	}
	
	@GetMapping("/verander")
	public String displayTaskFormToUpdate(@RequestParam(value = "id") Long taskId,Model model) {
		log.info("PROJECT_MAN : TaskController : displayTaskFormToUpdate : to update task with task_id : "+taskId);		
		if(taskId!=null) {
			Task task=taskmod.findByTaskId(taskId);
			TaskPersistRequest taskPersistRequest=Utils.convertToTaskPersistRequest(task);
			taskPersistRequest.setTaskId(""+taskId);
			log.info("PROJECT_MAN : TaskController : displayTaskFormToUpdate : creating new taskPersistRequest");
			model.addAttribute("taskPersistRequest",taskPersistRequest);
			List<UserStory> userStories = userstmod.findAll();
			 List<Employee> employees = empmod.findAll();
			model.addAttribute("employees", employees);
			model.addAttribute("userStories", userStories);
		}
		log.info("PROJECT_MAN : TaskController : displayTaskFormToUpdate : displaying form");
		return "tasks/new-task";		
	}

	
	@GetMapping("/workflow")
	public String displayTaskFormToWorkflow(@RequestParam(value = "id") Long taskId,Model model) {
		log.info("PROJECT_MAN : TaskController : displayTaskFormToUpdate : to update task with task_id : "+taskId);		
		if(taskId!=null) {
			Task task=taskmod.findByTaskId(taskId);
			TaskPersistRequest taskPersistRequest=Utils.convertToTaskPersistRequest(task);
			taskPersistRequest.setTaskId(""+taskId);
			log.info("PROJECT_MAN : TaskController : displayTaskFormToUpdate : creating new taskPersistRequest");
			model.addAttribute("taskPersistRequest",taskPersistRequest);
			List<UserStory> userStories = userstmod.findAll();
			 List<Employee> employees = empmod.findAll();
			model.addAttribute("employees", employees);
			model.addAttribute("userStories", userStories);
		}
		log.info("PROJECT_MAN : TaskController : displayTaskFormToUpdate : displaying form");
		return "tasks/workflow-task";		
	}
}