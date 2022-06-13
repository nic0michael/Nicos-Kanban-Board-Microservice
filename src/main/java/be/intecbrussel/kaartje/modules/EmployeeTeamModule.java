package be.intecbrussel.kaartje.modules;

import be.intecbrussel.kaartje.dtos.EmployeeTeamPersistRequest;
import be.intecbrussel.kaartje.model.EmployeeTeam;
import be.intecbrussel.kaartje.repositories.EmployeeTeamRepository;
import be.intecbrussel.kaartje.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeTeamModule {
    private static final Logger log = LoggerFactory.getLogger(EmployeeTeamModule.class);

    @Autowired
    EmployeeTeamRepository repository;


    public void save(EmployeeTeamPersistRequest employeeTeamPersistRequest) {
        log.info("PROJECT_MAN : EmployeeModule : save : saving employee from  EmployeePersistRequest: " + employeeTeamPersistRequest);
        EmployeeTeam employeeTeam = new EmployeeTeam();
        employeeTeam = Utils.convertToEmployee(employeeTeamPersistRequest);
        repository.save(employeeTeam);
    }

    public List<EmployeeTeam> findAll() {
        System.out.println("getting list of employees");
        List<EmployeeTeam> employeeTeams = repository.findAll();
        System.out.println("got list of employeeTeams : " + employeeTeams);
        return employeeTeams;
    }

}
