package za.co.kanban.modules;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import za.co.kanban.dtos.EmployeeTeamPersistRequest;
import za.co.kanban.model.EmployeeTeam;
import za.co.kanban.repositories.EmployeeTeamRepository;
import za.co.kanban.utils.Utils;

@Component
public class EmployeeTeamModule {
	private static final Logger log = LoggerFactory.getLogger(EmployeeTeamModule.class);
	
	@Autowired 
	EmployeeTeamRepository repository;
	

public void save(EmployeeTeamPersistRequest employeeTeamPersistRequest) {
	log.info("PROJECT_MAN : EmployeeModule : save : saving employee from  EmployeePersistRequest: "+employeeTeamPersistRequest);
	EmployeeTeam employeeTeam=new EmployeeTeam();
	employeeTeam=Utils.convertToEmployee(employeeTeamPersistRequest);
	repository.save(employeeTeam);
}

public List<EmployeeTeam> findAll(){
	System.out.println("getting list of employees");
	List<EmployeeTeam> employeeTeams = (List<EmployeeTeam>) repository.findAll();
	System.out.println("got list of employeeTeams : " + employeeTeams);
	return employeeTeams;
}

}
