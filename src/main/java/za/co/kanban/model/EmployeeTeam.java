package za.co.kanban.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee_team")
public class EmployeeTeam {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long employeeTeamId;
	
	private Long employeeId;
	private Long teamId;
	
	public EmployeeTeam() {}

	public EmployeeTeam(Long employeeId, Long teamId) {
		super();
		this.employeeId = employeeId;
		this.teamId = teamId;
	}

	public Long getEmployeeTeamId() {
		return employeeTeamId;
	}

	public void setEmployeeTeamId(Long employeeTeamId) {
		this.employeeTeamId = employeeTeamId;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public Long getTeamId() {
		return teamId;
	}

	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}

	@Override
	public String toString() {
		return "EmployeeTeam [employeeTeamId=" + employeeTeamId + ", employeeId=" + employeeId + ", teamId=" + teamId
				+ "]";
	}
	
	
}
