package za.co.kanban.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import za.co.kanban.dtos.EmployeePersistRequest;
import za.co.kanban.dtos.SubtaskPersistRequest;
import za.co.kanban.dtos.TaskPersistRequest;
import za.co.kanban.dtos.UserStoryPersistRequest;
import za.co.kanban.model.Employee;
import za.co.kanban.model.Subtask;
import za.co.kanban.model.Task;
import za.co.kanban.model.UserStory;



public class Utils {
	private static final Logger log = LoggerFactory.getLogger(Utils.class);

	@Value("${project.date.format}")
	static String dateUsaFormat;// 06/17/2020

	@Value("${project.date.iso.format}")
	static String dateIsoFormat;// "yyyy-MM-dd
	
	@Autowired
	private static BCryptPasswordEncoder passwordEncoder;
	
	public static String dateToString(Date dateToConvert) {
		log.info("PROJECT_MAN : Utils : dateToString : converting date:" + dateToConvert);
		if (dateUsaFormat == null) {
			dateUsaFormat = "MM/dd/yyyy";
		}
		if (dateIsoFormat == null) {
			dateUsaFormat = "yyyy-MM-dd";
		}
		DateTimeFormatter newPattern = DateTimeFormatter.ofPattern(dateUsaFormat);
		LocalDateTime datetime = dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		String dateToString = datetime.format(newPattern);
		log.info("PROJECT_MAN : Utils : dateToString : converted to :" + dateToString);
		return dateToString;
	}

	/**
	 * 
	 * project.date.usa.format=MM/dd/yyyy
	 * project.date.iso.format=yyyy-MM-dd
	 * 
	 */
	public static Date convertStringToDate(String sDate) {		
		if (dateUsaFormat == null) {
			dateUsaFormat = "MM/dd/yyyy";
		}
		if (dateIsoFormat == null) {
			dateIsoFormat = "yyyy-MM-dd";
		}
		String dateFormt=dateUsaFormat;
		Date date = null;
		if (StringUtils.isNotEmpty(sDate)) {
			if(sDate.contains("/")) {
				dateFormt=dateUsaFormat;
			} else if(sDate.contains("-")) {
				dateFormt=dateIsoFormat;
			}
			if (sDate.length() > 10) {
				sDate = sDate.substring(0, 10);
			}
			try {
				date = new SimpleDateFormat(dateFormt).parse(sDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		log.info("PROJECT_MAN : Utils : convertStringToDate : converting date:" + date);
		return date;
	}

	public static TaskPersistRequest convertToProjectPersistRequest(Task task) {
		TaskPersistRequest persistRequest = new TaskPersistRequest();

		if (task.getTaskId() != null) {
			persistRequest.setTaskId(task.getTaskId().toString());
		}
		persistRequest.setName(task.getName());
		persistRequest.setStage(task.getStage());
		persistRequest.setDescription(task.getDescription());
		if (task.getStartDate() != null) {
			persistRequest.setStartDate(Utils.dateToString(task.getStartDate()));
		}
		if (task.getEndDate() != null) {
			persistRequest.setEndDate(Utils.dateToString(task.getEndDate()));
		}
		return persistRequest;
	}
	
	public static Task convertToProject(TaskPersistRequest subtaskPersistRequest ) {
		Task subtask=new Task();
		return convertToProject(subtaskPersistRequest, subtask);		
	}

	public static Task convertToProject(TaskPersistRequest taskPersistRequest, Task task) {
		log.info("PROJECT_MAN : Utils : convertToProject : converting projectPersistRequest:" + taskPersistRequest);		

		if (task != null && taskPersistRequest !=null) {			
			task.setName(taskPersistRequest.getName());
			task.setStage(taskPersistRequest.getStage());
			task.setDescription(taskPersistRequest.getDescription());
			
			if (taskPersistRequest.getStartDate() != null) {
				task.setStartDate(Utils.convertStringToDate(taskPersistRequest.getStartDate()));
			}
			if (taskPersistRequest.getEndDate() != null) {
				task.setEndDate(Utils.convertStringToDate(taskPersistRequest.getEndDate()));
			}
		}

		log.info("PROJECT_MAN : Utils : convertToProject :project:" + task);
		return task;
	}

	public static EmployeePersistRequest convertToEmployeePersistRequest(Employee employee) {
		log.info("PROJECT_MAN : Utils : convertToEmployeePersistRequest : Employee :" + employee);
		EmployeePersistRequest employeePersistRequest = new EmployeePersistRequest();
		if (employee.getEmployeeId() != null) {
			employeePersistRequest.setEmployeeId(employee.getEmployeeId().toString());
		}
		employeePersistRequest.setEmail(employee.getEmail());
		employeePersistRequest.setFullName(employee.getFullName());
		employeePersistRequest.setIdNumber(employee.getIdNumber());
		employeePersistRequest.setUserId(employee.getUserId());
		employeePersistRequest.setAuthority(employee.getAuthority());
		
		if (StringUtils.isNotEmpty(employee.getPassword())) {
			employeePersistRequest.setPassword(employee.getPassword());
		}
		if (employee.getEnabled()!= null && employee.getEnabled())  {	
			employeePersistRequest.setEnabled("1");
		} else {	
			employeePersistRequest.setEnabled("0");		
		}
		return employeePersistRequest;
	}
	

	public static Employee convertToEmployee(EmployeePersistRequest employeePersistRequest) {
		Employee employee = convertToEmployee( employeePersistRequest, new Employee() );
		return employee;
	}

	public static Employee convertToEmployee(EmployeePersistRequest employeePersistRequest, Employee employee) {
		log.info("PROJECT_MAN : Utils : convertToEmployee : EmployeePersistRequest :" + employeePersistRequest);
		employee.setEmail(employeePersistRequest.getEmail());
		employee.setFullName(employeePersistRequest.getFullName());
		employee.setIdNumber(employeePersistRequest.getIdNumber());
		employee.setUserId(employeePersistRequest.getUserId());
		employee.setAuthority(employeePersistRequest.getAuthority());
		
		if (StringUtils.isNotEmpty(employeePersistRequest.getPassword())) {		
			if(passwordEncoder==null) {
				passwordEncoder=new BCryptPasswordEncoder();
			}
			employee.setPassword(passwordEncoder.encode(employeePersistRequest.getPassword()));
		}		
		if (StringUtils.isNotEmpty(employeePersistRequest.getEnabled() ) && "1".equals(employeePersistRequest.getEnabled()))  {	
			employee.setEnabled(true);
		} else {	
			employee.setEnabled(false);		
		}

		log.info("PROJECT_MAN : Utils : convertToEmployee : Employee :" + employee);
		return employee;
	}

	public static List<EmployeePersistRequest> makeEmployeePersistRequestList(List<Employee> employees) {
		List<EmployeePersistRequest> employeePersistRequests = new ArrayList<>();
		for (Employee employee : employees) {
			EmployeePersistRequest employeePersistRequest = convertToEmployeePersistRequest(employee);
			employeePersistRequests.add(employeePersistRequest);
		}
		return employeePersistRequests;
	}

	public static List<Employee> makeEmployeeList(List<EmployeePersistRequest> employeePersistRequests) {
		List<Employee> employees = new ArrayList<>();
		for (EmployeePersistRequest employeePersistRequest : employeePersistRequests) {
			Employee employee = convertToEmployee(employeePersistRequest);
			employees.add(employee);
		}
		return employees;
	}

	public static SubtaskPersistRequest convertToSubtaskPersistRequest(Subtask subtask) {
		SubtaskPersistRequest subtaskPersistRequest=new SubtaskPersistRequest();
		Long subtaskId = subtask.getSubtaskId();
		String subtaskIdSt=null;
		if(subtaskId!=null) {
			subtaskIdSt=subtaskId.toString();
			subtaskPersistRequest.setSubtaskId(subtaskIdSt);
		}
		
		return subtaskPersistRequest;
	}

	public static Subtask convertToSubtask(SubtaskPersistRequest subtaskPersistRequest) {
		Subtask subtask=new Subtask();
		return convertToSubtask(subtaskPersistRequest, subtask);
	}

	public static Subtask convertToSubtask(SubtaskPersistRequest subtaskPersistRequest, Subtask subtask) {

		String subtaskIdSt = subtaskPersistRequest.getSubtaskId();
		if(StringUtils.isNoneEmpty(subtaskIdSt)&& StringUtils.isNumeric(subtaskIdSt)) {
			Long subtaskId =Long.parseLong(subtaskIdSt);
			subtask.setSubtaskId(subtaskId);
		}
		
		return subtask;
	}
	
	public static Task convertToTask(TaskPersistRequest taskPersistRequest) {
		Task task =new Task();
		return convertToTask(taskPersistRequest, task);
	}

	public static Task convertToTask(TaskPersistRequest taskPersistRequest, Task task) {
		String taskIdStr = taskPersistRequest.getTaskId();
		Long taskId=null;
		if(StringUtils.isNotEmpty(taskIdStr) && StringUtils.isNumeric(taskIdStr)) {
			taskId=Long.parseLong(taskIdStr);
			task.setTaskId(taskId);
		}
		
		return task;
	}

	public static TaskPersistRequest convertToTaskPersistRequest(Task task) {
		TaskPersistRequest taskPersistRequest=new TaskPersistRequest();
		if(task!=null) {
			Long taskId = task.getTaskId();
			if(taskId!=null) {
				taskPersistRequest.setTaskId(taskId.toString());
			}
		}
		return taskPersistRequest;
	}

	public static UserStoryPersistRequest convertToUserStoryPersistRequest(UserStory userStory) {
		UserStoryPersistRequest userStoryPersistRequest=new UserStoryPersistRequest();
		if(userStory!=null) {
			Long userStoryId = userStory.getUserStoryId();
			if(userStoryId!=null) {
				userStoryPersistRequest.setUserStoryId(userStoryId.toString());
			}
		}
		return userStoryPersistRequest;
	}

	public static UserStory convertToUserStory(UserStoryPersistRequest userStoryPersistRequest) {
		UserStory userStory=new UserStory();
		
		return convertToUserStory(userStoryPersistRequest,userStory);
	}

	public static UserStory convertToUserStory(UserStoryPersistRequest userStoryPersistRequest, UserStory userStory) {
		if(userStoryPersistRequest!=null) {
			String userStoryIdSt=userStoryPersistRequest.getUserStoryId();
			if(StringUtils.isNotEmpty(userStoryIdSt) && StringUtils.isNumeric(userStoryIdSt)) {
				Long userStoryId=Long.parseLong(userStoryIdSt);
				userStory.setUserStoryId(userStoryId);
			}
		}
		return userStory;
	}
}
