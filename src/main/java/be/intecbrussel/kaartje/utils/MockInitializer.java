package be.intecbrussel.kaartje.utils;

import be.intecbrussel.kaartje.model.Employee;
import be.intecbrussel.kaartje.model.Team;
import be.intecbrussel.kaartje.repositories.EmployeeRepository;
import be.intecbrussel.kaartje.repositories.TeamRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.time.Instant;
import java.util.Date;

import static java.lang.System.out;

@Component
public class MockInitializer implements CommandLineRunner {

    private final EmployeeRepository employeeRepository;
    private final TeamRepository teamRepository;

    public MockInitializer(final EmployeeRepository employeeRepository, final TeamRepository teamRepository) {
        this.employeeRepository = employeeRepository;
        this.teamRepository = teamRepository;
    }

    @Override
    public void run(String... args) {
        final var team = new Team(
                "Team Development",
                "Some description about the team",
                Date.from(Instant.now()),
                "TRUE"
        );

        final var savedTeam = teamRepository.save(team);
        out.println(MessageFormat.format("New team: {employee}", savedTeam.getName()));

        final var employee = new Employee(
                "John Doe",
                "Some details about the employee",
                "+32468489911928",
                "+32468489911928",
                "john@doe.com",
                "P@ssw0rd",
                "ADMIN",
                "86.01.11-677.13",
                "1",
                "Programming",
                Date.from(Instant.now()),
                savedTeam.getTeamId(),
                1
        );

        final var savedEmployee = employeeRepository.save(employee);
        out.println(MessageFormat.format("New employee: {employee}", savedEmployee.getFullName()));
    }
}
