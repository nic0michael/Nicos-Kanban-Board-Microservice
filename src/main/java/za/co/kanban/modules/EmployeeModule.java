package za.co.kanban.modules;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import za.co.kanban.dtos.EmployeePersistRequest;
import za.co.kanban.model.Employee;
import za.co.kanban.model.EmployeeUserStory;
import za.co.kanban.repositories.EmployeeRepository;
import za.co.kanban.utils.Utils;



@Component
public class EmployeeModule {
private static final Logger log = LoggerFactory.getLogger(EmployeeModule.class);

@Autowired 
EmployeeRepository repository;

public void save(EmployeePersistRequest employeePersistRequest) {
	log.info("PROJECT_MAN : EmployeeModule : save : saving employee from  EmployeePersistRequest: "+employeePersistRequest);
	Employee employee=new Employee();
	employee=Utils.convertToEmployee(employeePersistRequest,employee);
	repository.save(employee);
}

public List<Employee> findAll(){
	System.out.println("getting list of employees");
	List<Employee> employees = (List<Employee>) repository.findAll();
	System.out.println("got list of cities : " + employees);
	return employees;
}

public Employee getOne(Long employeeId) {
	Employee employee = repository.getOne(employeeId);
	return employee;
}




public Employee findByEmployeeId(Long employeeId) {
	Employee employee= repository.findByEmployeeId(employeeId);		
	return employee;
}

public void delete(Long project_id) {
	Employee employee=findByEmployeeId(project_id);
	repository.delete(employee);		
}

public void update(EmployeePersistRequest employeePersistRequest) {
	log.info("PROJECT_MAN : EmployeeModule : update : updating employee from  EmployeePersistRequest: "+employeePersistRequest);
	if(employeePersistRequest!=null) {
		Long employeeId=Long.parseLong(employeePersistRequest.getEmployeeId() );
		log.info("PROJECT_MAN : EmployeeModule : update : updating employee employeeId : "+employeeId);
		Employee employee = repository.getOne(employeeId);
		log.info("PROJECT_MAN : EmployeeModule : update : updating employee : "+employee);
		if(employee!=null) {
			employee=Utils.convertToEmployee(employeePersistRequest,employee);
			repository.save(employee);
		}
	}
	
}

public List<EmployeeUserStory> employeeUserStorys() {
 
	return repository.employeeUserStorys();
}
}
