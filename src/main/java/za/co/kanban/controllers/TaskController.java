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
import za.co.kanban.model.StatusValue;
import za.co.kanban.model.Task;
import za.co.kanban.model.TaskKanbanItem;
import za.co.kanban.model.UserStory;
import za.co.kanban.modules.EmployeeModule;
import za.co.kanban.modules.StatusValueModule;
import za.co.kanban.modules.TaskModule;
import za.co.kanban.modules.UserStoryModule;
import za.co.kanban.repositories.StatusValueRepository;
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

	@Autowired 
	StatusValueModule statusmod;
	
	
	
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
		List<StatusValue>statusValues=statusmod.findAll();
		model.addAttribute("statusValues", statusValues);
		model.addAttribute("employees", employees);
		model.addAttribute("userStories", userStories);
		log.info("PROJECT_MAN : TaskController : displayTaskForm : displaying form");
		return "tasks/new-task";
	}

	
	@GetMapping("/board")
	public String displayTaskFBoard(Model model) {
		String column1Name=getColumnDisplayValue(1);
		String column2Name=getColumnDisplayValue(2);
		String column3Name=getColumnDisplayValue(3);
		String column4Name=getColumnDisplayValue(4);
		String column5Name=getColumnDisplayValue(5);
		String column6Name=getColumnDisplayValue(6);
		
		List<TaskKanbanItem> taskBanbanitems=taskmod.getTaskBanbanitems();
		List<TaskKanbanItem> column1=taskmod.getTaskColumn1Items();
		List<TaskKanbanItem> column2=taskmod.getTaskColumn2Items();
		List<TaskKanbanItem> column3=taskmod.getTaskColumn3Items();
		List<TaskKanbanItem> column4=taskmod.getTaskColumn4Items();
		List<TaskKanbanItem> column5=taskmod.getTaskColumn5Items();
		List<TaskKanbanItem> column6=taskmod.getTaskColumn6Items();
		if(taskBanbanitems!=null) {
			log.info("PROJECT_MAN : TaskController : displayHome : displaying :"+taskBanbanitems.size()+" task Banban items");
		}
		model.addAttribute("taskBanbanitems", taskBanbanitems);
		model.addAttribute("column1Name", column1Name);
		model.addAttribute("column2Name", column2Name);
		model.addAttribute("column3Name", column3Name);
		model.addAttribute("column4Name", column4Name);
		model.addAttribute("column5Name", column5Name);
		model.addAttribute("column6Name", column6Name);
		model.addAttribute("column1", column1);
		model.addAttribute("column2", column2);
		model.addAttribute("column3", column3);
		model.addAttribute("column4", column4);
		model.addAttribute("column5", column5);
		model.addAttribute("column6", column6);
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
			List<StatusValue>statusValues=statusmod.findAll();
			model.addAttribute("statusValues", statusValues);
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
			List<StatusValue>statusValues=statusmod.findAll();
			model.addAttribute("statusValues", statusValues);
			model.addAttribute("employees", employees);
			model.addAttribute("userStories", userStories);
		}
		log.info("PROJECT_MAN : TaskController : displayTaskFormToUpdate : displaying form");
		return "tasks/workflow-task";		
	}
	
	private  String getColumnDisplayValue(int sortOrder) {
		return statusmod.getColumnDisplayValue(sortOrder);
	}
}