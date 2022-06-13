package za.co.kanban.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import za.co.kanban.model.TeamEmployee;

public interface TeamEmployeeRepository extends JpaRepository<TeamEmployee, Long> {

	public TeamEmployee findByTeamEmployeeId(Long teamEmployeeId);

}
