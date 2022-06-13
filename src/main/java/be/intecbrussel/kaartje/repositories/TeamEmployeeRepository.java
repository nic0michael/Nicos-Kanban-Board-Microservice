package be.intecbrussel.kaartje.repositories;

import be.intecbrussel.kaartje.model.TeamEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamEmployeeRepository extends JpaRepository<TeamEmployee, Long> {

    TeamEmployee findByTeamEmployeeId(Long teamEmployeeId);

}
