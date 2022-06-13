package za.co.kanban.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "team_employee")
public class TeamEmployee {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long teamEmployeeId;

	private Long employeeId;
	private Long teamId;
	
	public TeamEmployee() {}

	public TeamEmployee( Long teamId,Long employeeId) {
		super();
		this.employeeId = employeeId;
		this.teamId = teamId;
	}

	public Long getTeamEmployeeId() {
		return teamEmployeeId;
	}

	public void setTeamEmployeeId(Long teamEmployeeId) {
		this.teamEmployeeId = teamEmployeeId;
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
		return "TeamEmployees [teamEmployeeId=" + teamEmployeeId + ", employeeId=" + employeeId + ", teamId=" + teamId
				+ "]";
	}

	
	
	
}
