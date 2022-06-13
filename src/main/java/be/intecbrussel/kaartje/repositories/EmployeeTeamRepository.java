package be.intecbrussel.kaartje.repositories;

import be.intecbrussel.kaartje.model.EmployeeTeam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeTeamRepository extends JpaRepository<EmployeeTeam, Long> {
    EmployeeTeam findByEmployeeTeamId(Long employeeTeamId);
}
