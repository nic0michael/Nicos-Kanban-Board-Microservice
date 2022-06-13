package be.intecbrussel.kaartje.modules;

import be.intecbrussel.kaartje.dtos.EmployeePersistRequest;
import be.intecbrussel.kaartje.model.Employee;
import be.intecbrussel.kaartje.model.EmployeeUserStory;
import be.intecbrussel.kaartje.repositories.EmployeeRepository;
import be.intecbrussel.kaartje.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class EmployeeModule {
    private static final Logger log = LoggerFactory.getLogger(EmployeeModule.class);

    @Autowired
    EmployeeRepository repository;

    public void save(EmployeePersistRequest employeePersistRequest) {
        log.info("PROJECT_MAN : EmployeeModule : save : saving employee from  EmployeePersistRequest: " + employeePersistRequest);
        Employee employee = new Employee();
        employee = Utils.convertToEmployee(employeePersistRequest, employee);
        repository.save(employee);
    }

    public List<Employee> findAll() {
        System.out.println("getting list of employees");
        List<Employee> employees = repository.findAll();
        System.out.println("got list of employees : " + employees);
        return employees;
    }

    public Employee getOne(Long employeeId) {
        Employee employee = repository.getOne(employeeId);
        return employee;
    }


    public Employee findByEmployeeId(Long employeeId) {
        Employee employee = repository.findByEmployeeId(employeeId);
        return employee;
    }

    public void delete(Long project_id) {
        Employee employee = findByEmployeeId(project_id);
        repository.delete(employee);
    }

    public void update(EmployeePersistRequest employeePersistRequest) {
        log.info("PROJECT_MAN : EmployeeModule : update : updating employee from  EmployeePersistRequest: " + employeePersistRequest);
        if (employeePersistRequest != null) {
            Long employeeId = Long.parseLong(employeePersistRequest.getEmployeeId());
            log.info("PROJECT_MAN : EmployeeModule : update : updating employee employeeId : " + employeeId);
            Employee employee = repository.getOne(employeeId);
            log.info("PROJECT_MAN : EmployeeModule : update : updating employee : " + employee);
            if (employee != null) {
                employee = Utils.convertToEmployee(employeePersistRequest, employee);
                repository.save(employee);
            }
        }

    }

    public List<EmployeeUserStory> employeeUserStorys() {

        return repository.employeeUserStorys();
    }
}
