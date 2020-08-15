package za.co.kanban.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import za.co.kanban.dtos.ContactPersistRequest;
import za.co.kanban.dtos.CustomerPersistRequest;
import za.co.kanban.dtos.EmployeePersistRequest;
import za.co.kanban.dtos.EmployeeTeamPersistRequest;
import za.co.kanban.dtos.EpicPersistRequest;
import za.co.kanban.dtos.SubtaskPersistRequest;
import za.co.kanban.dtos.TaskPersistRequest;
import za.co.kanban.dtos.TeamPersistRequest;
import za.co.kanban.dtos.UserStoryPersistRequest;
import za.co.kanban.model.Customer;
import za.co.kanban.model.Employee;
import za.co.kanban.model.EmployeeTeam;
import za.co.kanban.model.Epic;
import za.co.kanban.model.Subtask;
import za.co.kanban.model.Task;
import za.co.kanban.model.Team;
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
		String dateToString=null;
		log.info("PROJECT_MAN : Utils : dateToString : converting date:" + dateToConvert);
		if (dateUsaFormat == null) {
			dateUsaFormat = "MM/dd/yyyy";
		}
		if (dateIsoFormat == null) {
			dateUsaFormat = "yyyy-MM-dd";
		}
		if(dateToConvert!=null) {
			DateTimeFormatter newPattern = DateTimeFormatter.ofPattern(dateUsaFormat);
			LocalDateTime datetime = dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
			dateToString = datetime.format(newPattern);
		}
		log.info("PROJECT_MAN : Utils : dateToString : converted to :" + dateToString);
		return dateToString;
	}

	/**
	 * 
	 * project.date.usa.format=MM/dd/yyyy project.date.iso.format=yyyy-MM-dd
	 * 
	 */
	public static Date convertStringToDate(String sDate) {
		String saDateFormat = "dd/MM/yyyy";
		if (dateUsaFormat == null) {
			dateUsaFormat = "MM/dd/yyyy";
		}
		if (dateIsoFormat == null) {
			dateIsoFormat = "yyyy-MM-dd";
		}
		String dateFormt = dateUsaFormat;
		Date date = null;
		if (StringUtils.isNotEmpty(sDate)) {
			if (sDate.contains("/")) {
				dateFormt = dateUsaFormat;
				try {
					date = new SimpleDateFormat(dateFormt).parse(sDate);
				} catch (ParseException e) {
					dateFormt =saDateFormat;
				}
			} else if (sDate.contains("-")) {
				dateFormt = dateIsoFormat;
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
	



	

	////////////////////// CUSTOMER /////////////////////////

	public static List<CustomerPersistRequest> makeCustomerPersistRequestList(List<Customer> customers) {
		List<CustomerPersistRequest> customerPersistRequests = new ArrayList<>();
		for (Customer customer : customers) {
			CustomerPersistRequest customerPersistRequest = convertToCustomerPersistRequest(customer);
			customerPersistRequests.add(customerPersistRequest);
		}
		return customerPersistRequests;
	}

	public static List<Customer> makeCustomerList(List<CustomerPersistRequest> customerPersistRequests ) {
		List<Customer> customers = new ArrayList<>();
		for (CustomerPersistRequest customerPersistRequest : customerPersistRequests) {
			Customer customer = convertToCustomer(customerPersistRequest);
			customers.add(customer);
		}
		return customers;
	}
	


	public static CustomerPersistRequest convertToCustomerPersistRequest(Customer customer) {
		CustomerPersistRequest customerPersistRequest=new CustomerPersistRequest();

		if (customer.getCustomerId() != null) {
			customerPersistRequest.setCustomerId(customer.getCustomerId().toString());
		}
	    customerPersistRequest.setName(customer.getName().toUpperCase());
	    customerPersistRequest.setShortName(customer.getShortName().toUpperCase());
	    customerPersistRequest.setTelephone(customer.getTelephone());
	    customerPersistRequest.setCellphone(customer.getCellphone());
	    customerPersistRequest.setEmail(customer.getEmail());	    
		customerPersistRequest.setDetails(customer.getDetails());

		if (customer.getDateCreated() != null) {
			customerPersistRequest.setDateCreated(Utils.dateToString(customer.getDateCreated()));
		}
		
		customerPersistRequest.setIsActive(customer.getIsActive());
		return customerPersistRequest;
	}

	public static Customer convertToCustomer(CustomerPersistRequest customerPersistRequest) {
		Customer customer =new Customer();

		customer.setName(customerPersistRequest.getName().toUpperCase());
		customer.setShortName(customerPersistRequest.getShortName().toUpperCase());
		customer.setTelephone(customerPersistRequest.getTelephone());
		customer.setCellphone(customerPersistRequest.getCellphone());
		customer.setEmail(customerPersistRequest.getEmail());	    
		customer.setDetails(customerPersistRequest.getDetails());	

		if (customerPersistRequest.getDateCreated() != null) {
			customer.setDateCreated(Utils.convertStringToDate(customerPersistRequest.getDateCreated()));
		}
		
		customer.setIsActive(customerPersistRequest.getIsActive());
		
		return customer;
	}


	public static Customer updateCustomer(Customer customer, Customer theCustomer) {

		customer.setName(theCustomer.getName());	
		customer.setShortName(theCustomer.getShortName());
		customer.setTelephone(theCustomer.getTelephone());
		customer.setCellphone(theCustomer.getCellphone());
		customer.setEmail(theCustomer.getEmail());	    
		customer.setDetails(theCustomer.getDetails());	
		customer.setDateCreated(theCustomer.getDateCreated());		
		customer.setIsActive(theCustomer.getIsActive());
		
		return customer;
	}
	

	
	//////////////////// EMPLOYEE /////////////

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


	public static EmployeePersistRequest convertToEmployeePersistRequest(Employee employee) {
		log.info("PROJECT_MAN : Utils : convertToEmployeePersistRequest : Employee :" + employee);
		EmployeePersistRequest employeePersistRequest = new EmployeePersistRequest();
		if (employee.getEmployeeId() != null) {
			employeePersistRequest.setEmployeeId(employee.getEmployeeId().toString());
		}
		if (employee.getTeamId() != null) {
			employeePersistRequest.setTeamId(employee.getTeamId().toString());
		}
		if (employee.getFullName() != null) {
			employeePersistRequest.setFullName(employee.getFullName().toUpperCase());
		}
		if (employee.getIdNumber() != null) {
			employeePersistRequest.setIdNumber(employee.getIdNumber());
		}
		if (employee.getDetails() != null) {
			employeePersistRequest.setDetails(employee.getDetails());
		}
		if (employee.getTelephone() != null) {
			employeePersistRequest.setTelephone(employee.getTelephone());
		}
		if (employee.getCellphone() != null) {
			employeePersistRequest.setCellphone(employee.getCellphone());
		}
		if (employee.getEmail() != null) {
			employeePersistRequest.setEmail(employee.getEmail());
		}
		if (employee.getPassword() != null) {
		    employeePersistRequest.setPassword(employee.getPassword());
		}
		if (employee.getAuthority() != null) {
		    employeePersistRequest.setAuthority(employee.getAuthority());
		}
		if (employee.getUserId() != null) {
		    employeePersistRequest.setUserId(employee.getUserId());
		}
		if (employee.getSkillsCategory() != null) {
		    employeePersistRequest.setSkillsCategory(employee.getSkillsCategory());
		}
		if (employee.getDateCreated() != null) {
		    employeePersistRequest.setDateCreated(dateToString(employee.getDateCreated()));
		}

		if (employee.getEnabled() != null && employee.getEnabled()==1) {
			employeePersistRequest.setEnabled("1");
		} else {
			employeePersistRequest.setEnabled("0");
		}
		return employeePersistRequest;
	}



	public static Employee convertToEmployee(EmployeePersistRequest employeePersistRequest) {
		Employee employee = convertToEmployee(employeePersistRequest, new Employee());
		return employee;
	}

	public static Employee convertToEmployee(EmployeePersistRequest employeePersistRequest, Employee employee) {
		log.info("PROJECT_MAN : Utils : convertToEmployee : EmployeePersistRequest :" + employeePersistRequest);
		employee.setFullName(employeePersistRequest.getFullName().toUpperCase());
		employee.setIdNumber(employeePersistRequest.getIdNumber());
		employee.setDetails(employeePersistRequest.getDetails());
		employee.setTelephone(employeePersistRequest.getTelephone());
		employee.setCellphone(employeePersistRequest.getCellphone());
		employee.setEmail(employeePersistRequest.getEmail());
	    employee.setPassword(employeePersistRequest.getPassword());
	    employee.setAuthority(employeePersistRequest.getAuthority());
	    employee.setUserId(employeePersistRequest.getUserId());
	    employee.setSkillsCategory(employeePersistRequest.getSkillsCategory());
	    
	    if(StringUtils.isNotEmpty(employeePersistRequest.getDateCreated())){
	    	employee.setDateCreated(convertStringToDate(employeePersistRequest.getDateCreated()));
	    }

	    if(StringUtils.isNotEmpty(employeePersistRequest.getEmployeeId()) 
				&& StringUtils.isNumeric(employeePersistRequest.getEmployeeId())){
			Long employeeId=Long.parseLong(employeePersistRequest.getEmployeeId());
	    	employee.setEmployeeId(employeeId);
	    }
	    

	    if(StringUtils.isNotEmpty(employeePersistRequest.getTeamId()) 
				&& StringUtils.isNumeric(employeePersistRequest.getTeamId())){
	    	Long teamId=Long.parseLong(employeePersistRequest.getTeamId());
	    	employee.setTeamId(teamId);
	    }
		


		if (StringUtils.isNotEmpty(employeePersistRequest.getPassword())) {
			if (passwordEncoder == null) {
				passwordEncoder = new BCryptPasswordEncoder();
			}
			employee.setPassword(passwordEncoder.encode(employeePersistRequest.getPassword()));
		}
		if (StringUtils.isNotEmpty(employeePersistRequest.getEnabled())
				&& "1".equals(employeePersistRequest.getEnabled())) {
			employee.setEnabled(1);
		} else {
			employee.setEnabled(0);
		}

		log.info("PROJECT_MAN : Utils : convertToEmployee : Employee :" + employee);
		return employee;
	}
	
	
	////////////////////// EPIC /////////////////////////

	public static List<EpicPersistRequest> makeEpicPersistRequestList(List<Epic> epics) {
		List<EpicPersistRequest> epicPersistRequests = new ArrayList<>();
		for (Epic epic : epics) {
			EpicPersistRequest epicPersistRequest = convertToEpicPersistRequest(epic);
			epicPersistRequests.add(epicPersistRequest);
		}
		return epicPersistRequests;
	}

	public static List<Epic> makeEpicList(List<EpicPersistRequest> epicPersistRequests ) {
		List<Epic> userstories = new ArrayList<>();
		for (EpicPersistRequest epicPersistRequest : epicPersistRequests) {
			Epic epic = convertToEpic(epicPersistRequest);
			userstories.add(epic);
		}
		return userstories;
	}
	


	public static EpicPersistRequest convertToEpicPersistRequest(Epic epic) {
		EpicPersistRequest epicPersistRequest=new EpicPersistRequest();
		if (epic.getEpicId() != null) {
			epicPersistRequest.setEpicId(epic.getEpicId().toString());
		}
	    epicPersistRequest.setName(epic.getName());	
		epicPersistRequest.setDescription(epic.getDescription());
		epicPersistRequest.setCustomerReference(epic.getCustomerReference());	
		epicPersistRequest.setCustomerId(epic.getCustomerId());
		

		if (epic.getDue_date() != null) {
			epicPersistRequest.setDue_date(Utils.dateToString(epic.getDue_date()));
		}		

		if (epic.getDateCreated() != null) {
			epicPersistRequest.setDateCreated(Utils.dateToString(epic.getDateCreated()));
		}
		
		epicPersistRequest.setIsActive(epic.getIsActive());
		return epicPersistRequest;
	}

	public static Epic convertToEpic(EpicPersistRequest epicPersistRequest) {
		Epic epic =new Epic();

	    epic.setName(epicPersistRequest.getName());	
		epic.setDescription(epicPersistRequest.getDescription());
		epic.setCustomerReference(epicPersistRequest.getCustomerReference());	
		epic.setCustomerId(epicPersistRequest.getCustomerId());
		

		if (epicPersistRequest.getDue_date() != null) {
			epic.setDue_date(Utils.convertStringToDate(epicPersistRequest.getDue_date()));
		}		

		if (epicPersistRequest.getDateCreated() != null) {
			epic.setDateCreated(Utils.convertStringToDate(epicPersistRequest.getDateCreated()));
		}
		
		epic.setIsActive(epicPersistRequest.getIsActive());
		
		return epic;
	}


	public static Epic updateEpic(Epic epic, Epic theEpic) {
	    epic.setName(theEpic.getName());	
		epic.setDescription(theEpic.getDescription());
		epic.setCustomerReference(theEpic.getCustomerReference());	
		epic.setCustomerId(theEpic.getCustomerId());
		epic.setDue_date(theEpic.getDue_date());
		epic.setDateCreated(theEpic.getDateCreated());
		epic.setIsActive(theEpic.getIsActive());
		
		return epic;
	}
	
	////////////////////// USER STORY ///////////////////
	

	public static List<UserStoryPersistRequest> makeUserStoryPersistRequestList(List<UserStory> userstories) {
		List<UserStoryPersistRequest> userStoryPersistRequests = new ArrayList<>();
		for (UserStory userstory : userstories) {
			UserStoryPersistRequest userStoryPersistRequest = convertToUserStoryPersistRequest(userstory);
			userStoryPersistRequests.add(userStoryPersistRequest);
		}
		return userStoryPersistRequests;
	}

	public static List<UserStory> makeUserStoryList(List<UserStoryPersistRequest> userStoryPersistRequests ) {
		List<UserStory> userstories = new ArrayList<>();
		for (UserStoryPersistRequest userStoryPersistRequest : userStoryPersistRequests) {
			UserStory userStory = convertToUserStory(userStoryPersistRequest);
			userstories.add(userStory);
		}
		return userstories;
	}


	public static UserStoryPersistRequest convertToProjectPersistRequest(UserStory userStory) {
		return convertToUserStoryPersistRequest(userStory);
	}


	public static UserStoryPersistRequest convertToUserStoryPersistRequest(UserStory userStory) {
		UserStoryPersistRequest persistRequest = new UserStoryPersistRequest();

		if (userStory.getUserStoryId() != null) {
			persistRequest.setUserStoryId(userStory.getUserStoryId().toString());
		}			
	    persistRequest.setName	     (userStory.getName	     ());
		persistRequest.setDescription(userStory.getDescription());
		persistRequest.setCustomerReference(userStory.getCustomerReference());
		persistRequest.setStage	 (userStory.getStage	 ());
		persistRequest.setIsActive   (userStory.getIsActive   ());	
		
		if(userStory.getAssignedTo()!=null) {
			persistRequest.setAssignedTo (userStory.getAssignedTo().toString());
		}
		if(userStory.getUserStoryId()!=null) {
			persistRequest.setUserStoryId(userStory.getUserStoryId().toString());
		}	

		if (userStory.getDueDate() != null) {
			persistRequest.setDueDate(Utils.dateToString(userStory.getDueDate()));
		}
		if (userStory.getStartDate() != null) {
			persistRequest.setStartDate(Utils.dateToString(userStory.getStartDate()));
		}
		if (userStory.getEndDate() != null) {
			persistRequest.setEndDate(Utils.dateToString(userStory.getEndDate()));
		}
		if (userStory.getDateCreated() != null) {
			persistRequest.setDateCreated(Utils.dateToString(userStory.getDateCreated()));
		}
		return persistRequest;
	}

	public static UserStory convertToUserStory(UserStoryPersistRequest userStoryPersistRequest) {
		UserStory userStory = new UserStory();

		return convertToUserStory(userStoryPersistRequest, userStory);
	}

	public static UserStory convertToUserStory(UserStoryPersistRequest userStoryPersistRequest, UserStory userStory) {
		if (userStoryPersistRequest != null && userStory!=null) {		

			userStory.setName	     (userStoryPersistRequest.getName	     ());
			userStory.setDescription(userStoryPersistRequest.getDescription());
			userStory.setCustomerReference(userStoryPersistRequest.getCustomerReference());
			userStory.setStage	 (userStoryPersistRequest.getStage	 ());
			userStory.setIsActive   (userStoryPersistRequest.getIsActive   ());	

			
			if(StringUtils.isNotEmpty(userStoryPersistRequest.getUserStoryId()) 
					&& StringUtils.isNumeric(userStoryPersistRequest.getUserStoryId())){
				Long userStoryId=Long.parseLong(userStoryPersistRequest.getUserStoryId ());
				userStory.setUserStoryId(userStoryId);
			}	
			
			if(StringUtils.isNotEmpty(userStoryPersistRequest.getAssignedTo()) 
					&& StringUtils.isNumeric(userStoryPersistRequest.getAssignedTo())){
				Long assignedTo=Long.parseLong(userStoryPersistRequest.getAssignedTo ());	
				userStory.setAssignedTo (assignedTo);
			}
			

			if(StringUtils.isNotEmpty(userStoryPersistRequest.getUserStoryId()) 
					&& StringUtils.isNumeric(userStoryPersistRequest.getUserStoryId())){
				Long userStoryId=Long.parseLong(userStoryPersistRequest.getUserStoryId ());	
				userStory.setUserStoryId (userStoryId);
			}

			if (userStoryPersistRequest.getDueDate() != null) {
				userStory.setDueDate(Utils.convertStringToDate(userStoryPersistRequest.getDueDate()));
			}
			if (userStoryPersistRequest.getStartDate() != null) {
				userStory.setStartDate(Utils.convertStringToDate(userStoryPersistRequest.getStartDate()));
			}
			if (userStoryPersistRequest.getEndDate() != null) {
				userStory.setEndDate(Utils.convertStringToDate(userStoryPersistRequest.getEndDate()));
			}
			if (userStoryPersistRequest.getDateCreated() != null) {
				userStory.setDateCreated(Utils.convertStringToDate(userStoryPersistRequest.getDateCreated()));
			}
		}
		return userStory;
	}
	

	public static UserStory updateUserStory(UserStory userStory, UserStory theUserStory) {
		userStory.setName	     (theUserStory.getName	     ());
		userStory.setDescription(theUserStory.getDescription());
		userStory.setCustomerReference(theUserStory.getCustomerReference());
		userStory.setStage	 (theUserStory.getStage	 ());
		userStory.setIsActive   (theUserStory.getIsActive   ());	
		userStory.setUserStoryId(theUserStory.getUserStoryId());
		userStory.setAssignedTo (theUserStory.getAssignedTo());	
		userStory.setDueDate(theUserStory.getDueDate());
		userStory.setStartDate(theUserStory.getStartDate());
		userStory.setEndDate(theUserStory.getEndDate());
		userStory.setDateCreated(theUserStory.getDateCreated());
		
		return userStory;
	}
	/////////////////////////// TASK /////////////////
	

	public static List<TaskPersistRequest> makeTaskPersistRequestList(List<Task> tasks) {
		List<TaskPersistRequest> taskPersistRequests = new ArrayList<>();
		for (Task task : tasks) {
			TaskPersistRequest taskPersistRequest = convertToTaskPersistRequest(task);
			taskPersistRequests.add(taskPersistRequest);
		}
		return taskPersistRequests;
	}

	public static List<Task> makeTaskList(List<TaskPersistRequest> taskPersistRequests ) {
		List<Task> tasks = new ArrayList<>();
		for (TaskPersistRequest taskPersistRequest : taskPersistRequests) {
			Task task = convertToTask(taskPersistRequest);
			tasks.add(task);
		}
		return tasks;
	}

	public static TaskPersistRequest convertToTaskPersistRequest(Task task) {

		TaskPersistRequest persistRequest = new TaskPersistRequest();

		if (task.getTaskId() != null) {
			persistRequest.setTaskId(task.getTaskId().toString());
		}			
	    persistRequest.setName	     (task.getName	     ());
		persistRequest.setDescription(task.getDescription());
		persistRequest.setStatus	 (task.getStatus	 ());
		persistRequest.setIsActive   (task.getIsActive   ());	
		persistRequest.setStage      (task.getStage      ());
		
		if(task.getAssignedTo()!=null) {
			persistRequest.setAssignedTo (task.getAssignedTo().toString());
		}
		if(task.getUserStoryId()!=null) {
			persistRequest.setUserStoryId(task.getUserStoryId().toString());
		}
		if(task.getStoryPoints()!=null) {
			persistRequest.setStoryPoints(task.getStoryPoints().toString());
		}		

		if (task.getDue_date() != null) {
			persistRequest.setDue_date(Utils.dateToString(task.getDue_date()));
		}
		if (task.getStartDate() != null) {
			persistRequest.setStartDate(Utils.dateToString(task.getStartDate()));
		}
		if (task.getEndDate() != null) {
			persistRequest.setEndDate(Utils.dateToString(task.getEndDate()));
		}
		if (task.getDateCreated() != null) {
			persistRequest.setDateCreated(Utils.dateToString(task.getDateCreated()));
		}
		return persistRequest;
	}
	public static Task convertToTask(TaskPersistRequest taskPersistRequest) {
		Task task = new Task();
		return convertToTask(taskPersistRequest, task);
	}

	public static Task convertToTask(TaskPersistRequest taskPersistRequest, Task task) {
		log.info("PROJECT_MAN : Utils : convertToProject : converting projectPersistRequest:" + taskPersistRequest);		

		if (task != null && taskPersistRequest !=null) {			

		    task.setName(taskPersistRequest.getName());
			task.setDescription(taskPersistRequest.getDescription());
			task.setStatus(taskPersistRequest.getStatus());
			task.setIsActive(taskPersistRequest.getIsActive());	
			task.setStage(taskPersistRequest.getStage());			

			if(StringUtils.isNotEmpty(taskPersistRequest.getUserStoryId ()) 
					&& StringUtils.isNumeric(taskPersistRequest.getUserStoryId ())){
				Long userStoryId=Long.parseLong(taskPersistRequest.getUserStoryId ());
				task.setUserStoryId(userStoryId);
			}

			if(StringUtils.isNotEmpty(taskPersistRequest.getStoryPoints()) 
					&& StringUtils.isNumeric(taskPersistRequest.getStoryPoints())){
				Integer storyPoints=Integer.parseInt(taskPersistRequest.getStoryPoints());
				task.setStoryPoints(storyPoints);
			}
			
			if(StringUtils.isNotEmpty(taskPersistRequest.getStartDate())){
				task.setStartDate(convertStringToDate(taskPersistRequest.getStartDate()));
			}

			if(StringUtils.isNotEmpty(taskPersistRequest.getEndDate())){
				task.setEndDate(convertStringToDate(taskPersistRequest.getEndDate()));
			}

			if(StringUtils.isNotEmpty(taskPersistRequest.getDue_date())){
				task.setDue_date(convertStringToDate(taskPersistRequest.getDue_date()));
			}

			if(StringUtils.isNotEmpty(taskPersistRequest.getDateCreated())){
				task.setDateCreated(convertStringToDate(taskPersistRequest.getDateCreated()));
			}			

			if(StringUtils.isNotEmpty(taskPersistRequest.getAssignedTo ()) 
					&& StringUtils.isNumeric(taskPersistRequest.getAssignedTo ())){
				Long subtaskId=Long.parseLong(taskPersistRequest.getAssignedTo ());
				task.setAssignedTo(subtaskId);
			}
			if(StringUtils.isNotEmpty(taskPersistRequest.getTaskId()) && StringUtils.isNumeric(taskPersistRequest.getTaskId())){
				Long subtaskId=Long.parseLong(taskPersistRequest.getTaskId());
				task.setTaskId(subtaskId);
			}
			
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
	

	public static Task updateTask(Task task, Task theTask) {

	    task.setName(theTask.getName());
		task.setDescription(theTask.getDescription());
		task.setStatus(theTask.getStatus());
		task.setIsActive(theTask.getIsActive());	
		task.setStage(theTask.getStage());	
		task.setUserStoryId(theTask.getUserStoryId());
		task.setStoryPoints(theTask.getStoryPoints());
		task.setStartDate(theTask.getStartDate());
		task.setEndDate(theTask.getEndDate());
		task.setDue_date(theTask.getDue_date());
		task.setDateCreated(theTask.getDateCreated());
		task.setAssignedTo(theTask.getAssignedTo());	
		task.setTaskId(theTask.getTaskId());
		task.setStartDate(theTask.getStartDate());
		task.setEndDate(theTask.getEndDate());
		
		return task;
	}

//////////////////// SUBTASK ///////////////////////

	public static List<SubtaskPersistRequest> makeSubtaskPersistRequestList(List<Subtask> subtasks) {
		List<SubtaskPersistRequest> subtaskPersistRequests = new ArrayList<>();
		for (Subtask subtask : subtasks) {
			SubtaskPersistRequest subtaskPersistRequest = convertToSubtaskPersistRequest(subtask);
			subtaskPersistRequests.add(subtaskPersistRequest);
		}
		return subtaskPersistRequests;
	}

	public static List<Subtask> makeSubtaskList(List<SubtaskPersistRequest> subtaskPersistRequests ) {
		List<Subtask> subtasks = new ArrayList<>();
		for (SubtaskPersistRequest subtaskPersistRequest : subtaskPersistRequests) {
			Subtask subtask = convertToSubtask(subtaskPersistRequest);
			subtasks.add(subtask);
		}
		return subtasks;
	}
	
	
	public static SubtaskPersistRequest convertToSubtaskPersistRequest(Subtask subtask) {
		SubtaskPersistRequest subtaskPersistRequest = new SubtaskPersistRequest();

		if (subtask.getSubtaskId() != null) {
			subtaskPersistRequest.setSubtaskId(subtask.getSubtaskId().toString());
		}

		subtaskPersistRequest.setName(subtask.getName()); 
		subtaskPersistRequest.setDescription(subtask.getDescription()); 
		subtaskPersistRequest.setIsActive(subtask.getIsActive()); 
		
		if(subtask.getAssignedTo()!=null){
			subtaskPersistRequest.setAssignedTo(subtask.getAssignedTo().toString()); 
		}
		if(subtask.getStoryPoints()!=null){
			subtaskPersistRequest.setStoryPoints(subtask.getStoryPoints().toString()); 
		}
		if(subtask.getDue_date()!=null){
			subtaskPersistRequest.setDue_date(dateToString(subtask.getDue_date())); 
		}
		if(subtask.getDateCreated()!=null){
			subtaskPersistRequest.setDateCreated(dateToString(subtask.getDateCreated()));
		}
		

		return subtaskPersistRequest;
	}

	public static Subtask convertToSubtask(SubtaskPersistRequest subtaskPersistRequest) {
		Subtask subtask = new Subtask();		
		
		return convertToSubtask(subtaskPersistRequest, subtask);
	}

	public static Subtask convertToSubtask(SubtaskPersistRequest subtaskPersistRequest, Subtask subtask) {

	    subtask.setName(subtaskPersistRequest.getName()); 
		subtask.setDescription(subtaskPersistRequest.getDescription()); 
		subtask.setIsActive(subtaskPersistRequest.getIsActive()); 

		if(StringUtils.isNotEmpty(subtaskPersistRequest.getSubtaskId())
			&& StringUtils.isNumeric(subtaskPersistRequest.getSubtaskId())){			
			Long subtaskId=Long.parseLong(subtaskPersistRequest.getSubtaskId());
			subtask.setSubtaskId(subtaskId); 
		}
		
		if(StringUtils.isNotEmpty(subtaskPersistRequest.getAssignedTo())
			&& StringUtils.isNumeric(subtaskPersistRequest.getAssignedTo())){			
			Long assignedTo=Long.parseLong(subtaskPersistRequest.getAssignedTo());
			subtask.setAssignedTo(assignedTo); 
		}
		if(StringUtils.isNotEmpty(subtaskPersistRequest.getStoryPoints())
				&& StringUtils.isNumeric(subtaskPersistRequest.getStoryPoints())){			
				Integer storyPoints=Integer.parseInt(subtaskPersistRequest.getStoryPoints());
			subtask.setStoryPoints(storyPoints); 
		}
		if(StringUtils.isNotEmpty(subtaskPersistRequest.getDue_date())){
			subtask.setDue_date(convertStringToDate(subtaskPersistRequest.getDue_date())); 
		}
		if(StringUtils.isNotEmpty(subtaskPersistRequest.getDateCreated())){
			subtask.setDateCreated(convertStringToDate(subtaskPersistRequest.getDateCreated()));
		}

		return subtask;
	}


	public static Subtask updateSubtask(Subtask subtask, Subtask theSubtask) {

	    subtask.setName(theSubtask.getName()); 
		subtask.setDescription(theSubtask.getDescription()); 
		subtask.setIsActive(theSubtask.getIsActive());
		subtask.setAssignedTo(theSubtask.getAssignedTo()); 
		subtask.setStoryPoints(theSubtask.getStoryPoints()); 
		subtask.setDue_date(theSubtask.getDue_date());
		subtask.setDateCreated(theSubtask.getDateCreated());

		return subtask;
	}
	////////////////////// TEAM /////////////////////////

	public static List<TeamPersistRequest> makeTeamPersistRequestList(List<Team> teams) {
		List<TeamPersistRequest> teamPersistRequests = new ArrayList<>();
		for (Team team : teams) {
			TeamPersistRequest teamPersistRequest = convertToTeamPersistRequest(team);
			teamPersistRequests.add(teamPersistRequest);
		}
		return teamPersistRequests;
	}

	public static List<Team> makeTeamList(List<TeamPersistRequest> teamPersistRequests ) {
		List<Team> userstories = new ArrayList<>();
		for (TeamPersistRequest teamPersistRequest : teamPersistRequests) {
			Team epic = convertToTeam(teamPersistRequest);
			userstories.add(epic);
		}
		return userstories;
	}
	


	public static TeamPersistRequest convertToTeamPersistRequest(Team team) {
		TeamPersistRequest teamPersistRequest=new TeamPersistRequest();

		if (team.getTeamId() != null) {
			teamPersistRequest.setTeamId(team.getTeamId().toString());
		}
	    teamPersistRequest.setName(team.getName());	
		teamPersistRequest.setDescription(team.getDescription());

		if (team.getDateCreated() != null) {
			teamPersistRequest.setDateCreated(Utils.dateToString(team.getDateCreated()));
		}
		
		teamPersistRequest.setIsActive(team.getIsActive());
		return teamPersistRequest;
	}

	public static Team convertToTeam(TeamPersistRequest teamPersistRequest) {
		Team team =new Team();

	    team.setName(teamPersistRequest.getName());	
		team.setDescription(teamPersistRequest.getDescription());	

		if (teamPersistRequest.getDateCreated() != null) {
			team.setDateCreated(Utils.convertStringToDate(teamPersistRequest.getDateCreated()));
		}
		
		team.setIsActive(teamPersistRequest.getIsActive());
		
		return team;
	}

	public static Team updateTeam(Team team, Team theTeam) {

	    team.setName(theTeam.getName());	
		team.setDescription(theTeam.getDescription());	
		team.setDateCreated(theTeam.getDateCreated());
		team.setIsActive(theTeam.getIsActive());
		
		return team;
	}

	public static EmployeeTeam convertToEmployee(EmployeeTeamPersistRequest employeeTeamPersistRequest) {
		EmployeeTeam employeeTeam=new EmployeeTeam();		

	    if(StringUtils.isNotEmpty(employeeTeamPersistRequest.getEmployeeId()) 
				&& StringUtils.isNumeric(employeeTeamPersistRequest.getEmployeeId())){
			Long employeeId=Long.parseLong(employeeTeamPersistRequest.getEmployeeId());
			employeeTeam.setEmployeeId(employeeId);
	    }

	    if(StringUtils.isNotEmpty(employeeTeamPersistRequest.getTeamId()) 
				&& StringUtils.isNumeric(employeeTeamPersistRequest.getTeamId())){
	    	Long teamId=Long.parseLong(employeeTeamPersistRequest.getTeamId());
			employeeTeam.setTeamId(teamId);
	    }

		return employeeTeam;
	}



	////////////////////// EMPLOYEE TEAM /////////////////////////

	public static EmployeeTeamPersistRequest makeEmployeeTeamPersistRequest(EmployeePersistRequest employeePersistRequest) {
		EmployeeTeamPersistRequest employeeTeamPersistRequest=new EmployeeTeamPersistRequest();

	    if(StringUtils.isNotEmpty(employeePersistRequest.getEmployeeId()) 
				&& StringUtils.isNumeric(employeePersistRequest.getEmployeeId())){
			employeeTeamPersistRequest.setEmployeeId(employeePersistRequest.getEmployeeId());
	    }	    

	    if(StringUtils.isNotEmpty(employeePersistRequest.getTeamId()) 
				&& StringUtils.isNumeric(employeePersistRequest.getTeamId())){
	    	employeeTeamPersistRequest.setTeamId(employeePersistRequest.getTeamId());
	    }
		
		return employeeTeamPersistRequest;
	}









}
