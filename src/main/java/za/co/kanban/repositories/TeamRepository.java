package za.co.kanban.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import za.co.kanban.model.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {

	public Team findByTeamId(Long teamId);

}
