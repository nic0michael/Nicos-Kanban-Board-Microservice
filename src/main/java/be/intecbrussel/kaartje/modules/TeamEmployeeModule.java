package be.intecbrussel.kaartje.modules;

import be.intecbrussel.kaartje.model.TeamEmployee;
import be.intecbrussel.kaartje.repositories.TeamEmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TeamEmployeeModule {
    private static final Logger log = LoggerFactory.getLogger(TeamEmployeeModule.class);

    @Autowired
    TeamEmployeeRepository repository;

    public List<TeamEmployee> findAll() {
        System.out.println("getting list of Teams");
        List<TeamEmployee> teamEmployeeList = repository.findAll();
        return teamEmployeeList;
    }

    public TeamEmployee findByTeamId(Long teamEmployeeId) {
        System.out.println("Finding team teamId: " + teamEmployeeId);
        TeamEmployee teamEmployee = null;
        if (teamEmployeeId != null) {
            teamEmployee = repository.findByTeamEmployeeId(teamEmployeeId);
        }
        return teamEmployee;
    }

    public void delete(Long teamEmployeeId) {
        System.out.println("Deleting team teamId: " + teamEmployeeId);
        TeamEmployee teamEmployee = null;
        if (teamEmployeeId != null) {
            teamEmployee = findByTeamId(teamEmployeeId);
            if (teamEmployee != null) {
                repository.delete(teamEmployee);
            }
        }
    }

    public void save(TeamEmployee teamEmployee) {
        if (teamEmployee != null) {
            Long teamEmployeeId = teamEmployee.getTeamEmployeeId();
            System.out.println("Saving team teamId: " + teamEmployeeId);
            repository.save(teamEmployee);
        }
    }

}
