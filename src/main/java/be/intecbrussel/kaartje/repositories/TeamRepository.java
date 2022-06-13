package be.intecbrussel.kaartje.repositories;

import be.intecbrussel.kaartje.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {

    Team findByTeamId(Long teamId);

}
