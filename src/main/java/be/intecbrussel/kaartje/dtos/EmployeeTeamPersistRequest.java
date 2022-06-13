package za.co.kanban.dtos;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "EmployeeTeamPersistRequest")
public class EmployeeTeamPersistRequest {

	private String employeeTeamId;
	private String employeeId;
	private String teamId;
	
	public EmployeeTeamPersistRequest() {}

	public EmployeeTeamPersistRequest(String employeeId, String teamId) {
		super();
		this.employeeId = employeeId;
		this.teamId = teamId;
	}

	public String getEmployeeTeamId() {
		return employeeTeamId;
	}

	public void setEmployeeTeamId(String employeeTeamId) {
		this.employeeTeamId = employeeTeamId;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getTeamId() {
		return teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

	@Override
	public String toString() {
		return "EmployeeTeamPersistRequest [employeeTeamId=" + employeeTeamId + ", employeeId=" + employeeId
				+ ", teamId=" + teamId + "]";
	}
	
	

}
