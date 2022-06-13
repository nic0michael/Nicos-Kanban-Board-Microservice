package be.intecbrussel.kaartje.controllers;

import be.intecbrussel.kaartje.dtos.TeamPersistRequest;
import be.intecbrussel.kaartje.model.Team;
import be.intecbrussel.kaartje.modules.TeamModule;
import be.intecbrussel.kaartje.utils.Utils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/kanban-board/teams")
public class TeamController {
    private static final Logger log = LoggerFactory.getLogger(TeamController.class);

    @Autowired
    private TeamModule custmod;

    @GetMapping
    public String displayTeams(Model model) {
        List<Team> teams = custmod.findAll();
        model.addAttribute("teamsList", teams);
        return "teams/list-teams";
    }

    @GetMapping("/list")
    public String displayHome(Model model) {
        List<Team> teams = custmod.findAll();
        model.addAttribute("teamsList", teams);
        return "teams/list-teams";
    }

    @GetMapping("/new")
    public String displayTeamForm(Model model) {
        Team team = new Team();
        TeamPersistRequest teamtPersistRequest = Utils.convertToTeamPersistRequest(team);
        model.addAttribute("teamtPersistRequest", teamtPersistRequest);
        return "teams/new-team";
    }


    @PostMapping("/save")
    public String createTeam(TeamPersistRequest teamPersistRequest, Model model) {
        log.info("PROJECT_MAN : TeamController : createTeam : saving team from  TeamPersistRequest: " + teamPersistRequest);

        if (StringUtils.isNotBlank(teamPersistRequest.getTeamId()) && StringUtils.isNumeric(teamPersistRequest.getTeamId())) {
            log.info("PROJECT_MAN : TeamController : createTeam : updating team");
            Team theTeam = Utils.convertToTeam(teamPersistRequest);
            Long teamId = Long.parseLong(teamPersistRequest.getTeamId());
            custmod.update(teamId, theTeam);
        } else {
            log.info("PROJECT_MAN : TeamController : createTeam : saving new team");
            Team team = Utils.convertToTeam(teamPersistRequest);
            custmod.save(team);
        }
        // use a redirect to prevent duplicate submissions
        log.info("PROJECT_MAN : TeamController : createTeam : redirecting to teams page");
        return "redirect:/kanban-board/teams";
    }


    @GetMapping("/remove}")
    public String deleteTeam(@RequestParam(value = "id") Long teamId) {
        custmod.delete(teamId);
        return "redirect:/projects";
    }


    @GetMapping("/change}")
    public String updateTeam(@RequestParam(value = "id") Long teamId, Model model) {
        Team team = custmod.findByTeamId(teamId);
        model.addAttribute("team", team);
        return "redirect:/teams/new";
    }

    @GetMapping("/maakdood")
    public String removeTeam(@RequestParam(value = "id") Long teamId, Model model) {
        log.info("PROJECT_MAN : TeamController : removeTeam : to update project with project_id : " + teamId);
        custmod.delete(teamId);
        return "redirect:/teams";
    }

    @GetMapping("/verander")
    public String displayTeamtFormToUpdate(@RequestParam(value = "id") Long teamId, Model model) {
        log.info("PROJECT_MAN : TeamController : displayTeamtFormToUpdate : to update project with project_id : " + teamId);
        if (teamId != null) {
            Team team = custmod.findByTeamId(teamId);
            TeamPersistRequest teamtPersistRequest = Utils.convertToTeamPersistRequest(team);
            model.addAttribute("teamtPersistRequest", teamtPersistRequest);
            log.info("PROJECT_MAN : TeamController : displayTeamtFormToUpdate : created TeamPersistRequest : " + teamtPersistRequest);
        }
        log.info("PROJECT_MAN : TeamController : displayTeamtFormToUpdate : displaying form");
        return "teams/new-team";
    }

}
