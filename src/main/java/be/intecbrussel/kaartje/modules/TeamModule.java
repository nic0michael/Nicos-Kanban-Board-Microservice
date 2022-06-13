package be.intecbrussel.kaartje.modules;

import be.intecbrussel.kaartje.model.Team;
import be.intecbrussel.kaartje.repositories.TeamRepository;
import be.intecbrussel.kaartje.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TeamModule {
    private static final Logger log = LoggerFactory.getLogger(TeamModule.class);

    @Autowired
    TeamRepository repository;

    public List<Team> findAll() {
        System.out.println("getting list of Teams");
        List<Team> teamList = repository.findAll();
        return teamList;
    }

    public Team findByTeamId(Long teamId) {
        System.out.println("Finding team teamId: " + teamId);
        Team team = null;
        if (teamId != null) {
            team = repository.findByTeamId(teamId);
        }
        return team;
    }

    public void delete(Long teamId) {
        System.out.println("Deleting team teamId: " + teamId);
        Team team = null;
        if (teamId != null) {
            team = findByTeamId(teamId);
            if (team != null) {
                repository.delete(team);
            }
        }
    }

    public void save(Team team) {
        if (team != null) {
            Long teamId = team.getTeamId();
            System.out.println("Saving team teamId: " + teamId);
            repository.save(team);
        }
    }


    public void update(Long teamId, Team theTeam) {
        if (theTeam != null && teamId != null) {
            Team team = findByTeamId(teamId);
            team = Utils.updateTeam(team, theTeam);
            System.out.println("Saving Team teamId: " + teamId);
            repository.save(team);
        }
    }
}