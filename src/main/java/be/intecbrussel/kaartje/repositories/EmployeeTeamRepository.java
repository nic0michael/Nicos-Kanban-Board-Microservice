package za.co.kanban.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import za.co.kanban.model.EmployeeTeam;

public interface EmployeeTeamRepository extends JpaRepository<EmployeeTeam, Long> {
	public  EmployeeTeam findByEmployeeTeamId(Long employeeTeamId);
}
