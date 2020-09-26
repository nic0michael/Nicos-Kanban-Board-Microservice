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
import za.co.kanban.dtos.KanbanRow;
import za.co.kanban.dtos.SubtaskPersistRequest;
import za.co.kanban.model.Employee;
import za.co.kanban.model.StatusValue;
import za.co.kanban.model.Subtask;
import za.co.kanban.model.SubtaskKanbanItem;
import za.co.kanban.model.Task;
import za.co.kanban.modules.EmployeeModule;
import za.co.kanban.modules.StatusValueModule;
import za.co.kanban.modules.SubtaskModule;
import za.co.kanban.modules.TaskModule;
import za.co.kanban.utils.Utils;


@Controller
@RequestMapping("/kanban-board/subtasks")
public class SubtaskController {
	private static final Logger log = LoggerFactory.getLogger(SubtaskController.class);
	 
	
	@Autowired 
	SubtaskModule subtaskmod;

	@Autowired 
	EmployeeModule emplmod;	
	
	@Autowired 
	TaskModule taskmod;

	@Autowired 
	StatusValueModule statusmod;

	@GetMapping
	public String displaySubtasks(Model model) {
		List<Subtask> subtasks = subtaskmod.findAll();
		if(subtasks!=null) {
			log.info("PROJECT_MAN : SubtaskController : displayHome : displaying :"+subtasks.size()+" subtasks");
		}
		model.addAttribute("subtasks", subtasks);
		return "subtasks/list-subtasks";
	}
	@GetMapping("/list")
	public String displayHome(Model model) {
		List<Subtask> subtasks = subtaskmod.findAll();
		if(subtasks!=null) {
			log.info("PROJECT_MAN : SubtaskController : displayHome : displaying :"+subtasks.size()+" subtasks");
		}
		model.addAttribute("subtasks", subtasks);
		return "subtasks/list-subtasks";
	}

	@GetMapping("/board")
	public String displaySubtaskBoard(Model model) {
		
		String column1Name=getColumnDisplayValue(1);
		String column2Name=getColumnDisplayValue(2);
		String column3Name=getColumnDisplayValue(3);
		String column4Name=getColumnDisplayValue(4);
		String column5Name=getColumnDisplayValue(5);
		String column6Name=getColumnDisplayValue(6);
		
		List<KanbanRow> columns = subtaskmod.getKanbanRows();

		model.addAttribute("columns", columns);
		model.addAttribute("column1Name", column1Name);
		model.addAttribute("column2Name", column2Name);
		model.addAttribute("column3Name", column3Name);
		model.addAttribute("column4Name", column4Name);
		model.addAttribute("column5Name", column5Name);
		model.addAttribute("column6Name", column6Name);
		return "subtasks/subtask-board";
	}
	
	@GetMapping("/new")
	public String displaySubtaskForm(Model model) {
		SubtaskPersistRequest subtaskPersistRequest=new SubtaskPersistRequest();
		log.info("PROJECT_MAN : SubtaskController : displaySubtaskForm : creating new subtaskPersistRequest");
//		Subtask subtask=new Subtask();
		model.addAttribute("subtaskPersistRequest",subtaskPersistRequest);
		List<Employee> employees = emplmod.findAll();
		List<Task> tasks = taskmod.findAll();
		List<StatusValue>statusValues=statusmod.findAll();
		model.addAttribute("statusValues", statusValues);
		model.addAttribute("employees", employees);
		model.addAttribute("tasks", tasks);
		log.info("PROJECT_MAN : SubtaskController : displaySubtaskForm : displaying form");
		return "subtasks/new-subtask";
	}


	

	@PostMapping("/save")
	public String createSubtask( SubtaskPersistRequest subtaskPersistRequest,Model model) {
		log.info("PROJECT_MAN : SubtaskController : createSubtask : saving subtask from  SubtaskPersistRequest: ->"+subtaskPersistRequest);
		
		if(StringUtils.isNotBlank(subtaskPersistRequest.getSubtaskId() )  && StringUtils.isNumeric(subtaskPersistRequest.getSubtaskId()) ) {				
			log.info("PROJECT_MAN : SubtaskController : createSubtask : updating subtask");
			subtaskmod.update(subtaskPersistRequest);
		} else {
			log.info("PROJECT_MAN : SubtaskController : createSubtask : saving new subtask");
			subtaskmod.save(subtaskPersistRequest);
		}
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/kanban-board/subtasks";
	}


	@GetMapping("/maakdood")
	public String removeSubtask(@RequestParam(value = "id") Long subtask_id,Model model) {
		log.info("PROJECT_MAN : SubtaskController : removeSubtask : to update subtask with subtask_id : "+subtask_id);
		subtaskmod.delete(subtask_id);
		return "redirect:/subtasks";
	}
	
	@GetMapping("/verander")
	public String displaySubtaskFormToUpdate(@RequestParam(value = "id") Long subtaskId,Model model) {
		log.info("PROJECT_MAN : SubtaskController : displaySubtaskFormToUpdate : to update subtask with subtask_id : "+subtaskId);		
		if(subtaskId!=null) {
			Subtask subtask=subtaskmod.findBySubtaskId(subtaskId);
			SubtaskPersistRequest subtaskPersistRequest=Utils.convertToSubtaskPersistRequest(subtask);
			subtaskPersistRequest.setSubtaskId(""+subtaskId);
			log.info("PROJECT_MAN : SubtaskController : displaySubtaskFormToUpdate : creating new subtaskPersistRequest");
			model.addAttribute("subtaskPersistRequest",subtaskPersistRequest);
			List<Employee> employees = emplmod.findAll();
			List<Task> tasks = taskmod.findAll();
			List<StatusValue>statusValues=statusmod.findAll();
			model.addAttribute("statusValues", statusValues);
			model.addAttribute("employees", employees);
			model.addAttribute("tasks", tasks);
		}
		log.info("PROJECT_MAN : SubtaskController : displaySubtaskFormToUpdate : displaying form");
		return "subtasks/new-subtask";		
	}

	
	@GetMapping("/workflow")
	public String displaySubtaskFormToUWorkflow(@RequestParam(value = "id") Long subtaskId,Model model) {
		log.info("PROJECT_MAN : SubtaskController : displaySubtaskFormToUpdate : to update subtask with subtask_id : "+subtaskId);		
		if(subtaskId!=null) {
			Subtask subtask=subtaskmod.findBySubtaskId(subtaskId);
			SubtaskPersistRequest subtaskPersistRequest=Utils.convertToSubtaskPersistRequest(subtask);
			subtaskPersistRequest.setSubtaskId(""+subtaskId);
			log.info("PROJECT_MAN : SubtaskController : displaySubtaskFormToUpdate : creating new subtaskPersistRequest");
			model.addAttribute("subtaskPersistRequest",subtaskPersistRequest);
			List<Employee> employees = emplmod.findAll();
			List<Task> tasks = taskmod.findAll();
			List<StatusValue>statusValues=statusmod.findAll();
			model.addAttribute("statusValues", statusValues);
			model.addAttribute("employees", employees);
			model.addAttribute("tasks", tasks);
		}
		log.info("PROJECT_MAN : SubtaskController : displaySubtaskFormToUpdate : displaying form");
		return "subtasks/workflow-subtask";		
	}

	
	private  String getColumnDisplayValue(int sortOrder) {
		return statusmod.getColumnDisplayValue(sortOrder);
	}
}
