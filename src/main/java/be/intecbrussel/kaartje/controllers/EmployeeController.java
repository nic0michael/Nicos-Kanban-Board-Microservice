package be.intecbrussel.kaartje.controllers;

import be.intecbrussel.kaartje.dtos.EmployeePersistRequest;
import be.intecbrussel.kaartje.dtos.EmployeeTeamPersistRequest;
import be.intecbrussel.kaartje.model.Employee;
import be.intecbrussel.kaartje.model.Team;
import be.intecbrussel.kaartje.modules.EmployeeModule;
import be.intecbrussel.kaartje.modules.EmployeeTeamModule;
import be.intecbrussel.kaartje.modules.TeamModule;
import be.intecbrussel.kaartje.utils.Utils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
@RequestMapping("/kanban-board/employees")
public class EmployeeController {
    private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);

    private final EmployeeModule employeeModule;

    private final TeamModule teamModule;

    private final EmployeeTeamModule employeeTeamModule;

    public EmployeeController(EmployeeModule employeeModule, TeamModule teamModule, EmployeeTeamModule employeeTeamModule) {
        this.employeeModule = employeeModule;
        this.teamModule = teamModule;
        this.employeeTeamModule = employeeTeamModule;
    }

    @GetMapping
    public String displayEmployees(Model model) {
        List<Employee> employees = employeeModule.findAll();
        model.addAttribute("employeesList", employees);
        return "employees/list-employees";
    }

    @GetMapping("/list")
    public String displayHome(Model model) {
        List<Employee> employees = employeeModule.findAll();
        model.addAttribute("employeesList", employees);
        return "employees/list-employees";
    }

    @GetMapping("/new")
    public String displayEmployeeForm(Model model) {
        final var employee = new Employee();
        final var employeePersistRequest = Utils.convertToEmployeePersistRequest(employee);
        final var allTeams = teamModule.findAll();
        model.addAttribute("allTeams", allTeams);
        model.addAttribute("employeeNewRequest", employeePersistRequest);
        return "employees/new-employee";
    }


    @PostMapping("/save")
    public String createEmployee(EmployeePersistRequest employeePersistRequest, Model model) {
        log.info("PROJECT_MAN : EmployeeController : createEmployee : saving employee from  EmployeePersistRequest: " + employeePersistRequest);

        if (StringUtils.isNotBlank(employeePersistRequest.getEmployeeId()) && StringUtils.isNumeric(employeePersistRequest.getEmployeeId())) {
            log.info("PROJECT_MAN : EmployeeController : createEmployee : updating employee");
            employeeModule.update(employeePersistRequest);

            EmployeeTeamPersistRequest employeeTeamPersistRequest = Utils.makeEmployeeTeamPersistRequest(employeePersistRequest);
            log.info("PROJECT_MAN : EmployeeController : createEmployee : saving new EmployeeTeam");
            employeeTeamModule.save(employeeTeamPersistRequest);

        } else {
            log.info("PROJECT_MAN : EmployeeController : createEmployee : saving new employee");
            employeeModule.save(employeePersistRequest);

            EmployeeTeamPersistRequest employeeTeamPersistRequest = Utils.makeEmployeeTeamPersistRequest(employeePersistRequest);
            log.info("PROJECT_MAN : EmployeeController : createEmployee : saving new EmployeeTeam");
            employeeTeamModule.save(employeeTeamPersistRequest);
        }
        // use a redirect to prevent duplicate submissions
        log.info("PROJECT_MAN : EmployeeController : createEmployee : redirecting to employees page");
        return "redirect:/kanban-board/employees";
    }


    @GetMapping("/remove")
    public String deleteEmployee(@RequestParam(value = "id") Long employeeId) {
        employeeModule.delete(employeeId);
        return "redirect:/projects";
    }


    @GetMapping("/change")
    public String updateEmployee(@RequestParam(value = "id") Long employeeId, Model model) {
        final var employee = employeeModule.findByEmployeeId(employeeId);
        model.addAttribute("employee", employee);
        return "redirect:/employees/new";
    }

    @GetMapping("/maakdood")
    public String removeEmployee(@RequestParam(value = "id") Long employeeId, Model model) {
        log.info("PROJECT_MAN : EmployeeController : removeEmployee : to update project with project_id : " + employeeId);
        employeeModule.delete(employeeId);
        return "redirect:/employees";
    }

    @GetMapping("/verander")
    public String displayEmployeeFormToUpdate(@RequestParam(value = "id") Long employeeId, Model model) {
        log.info("PROJECT_MAN : EmployeeController : displayEmployeetFormToUpdate : to update project with project_id : " + employeeId);
        if (employeeId != null) {
            Employee employee = employeeModule.findByEmployeeId(employeeId);
            EmployeePersistRequest employeePersistRequest = Utils.convertToEmployeePersistRequest(employee);
            log.info("PROJECT_MAN : EmployeeController : displayEmployeeFormToUpdate : created EmployeePersistRequest : " + employeePersistRequest);
            final var teams = teamModule.findAll();
            model.addAttribute("teams", teams);
            model.addAttribute("employeePersistRequest", employeePersistRequest);
        }
        log.info("PROJECT_MAN : EmployeeController : displayEmployeeFormToUpdate : displaying form");
        return "employees/new-employee";
    }

    @GetMapping("/workflow")
    public String displayEmployeetFormToWorkflow(@RequestParam(value = "id") Long employeeId, Model model) {
        log.info("PROJECT_MAN : EmployeeController : displayEmployeetFormToUpdate : to update project with project_id : " + employeeId);
        if (employeeId != null) {
            final var employee = employeeModule.findByEmployeeId(employeeId);
            final var employeePersistRequest = Utils.convertToEmployeePersistRequest(employee);
            log.info("PROJECT_MAN : EmployeeController : displayEmployeeFormToUpdate : created EmployeePersistRequest : " + employeePersistRequest);
            List<Team> teams = teamModule.findAll();
            model.addAttribute("teams", teams);
            model.addAttribute("employeePersistRequest", employeePersistRequest);
        }
        log.info("PROJECT_MAN : EmployeeController : displayEmployeeFormToUpdate : displaying form");
        return "employees/workflow-employee";
    }

}
