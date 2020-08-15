package za.co.kanban.dtos;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "EmployeePersistRequest")
public class EmployeePersistRequest {

	private String employeeId;
	private String fullName;
	private String idNumber;
	private String details;
	private String telephone;	
	private String cellphone;	
	private String email;
    private String password;    
    private String authority;
    private String userId;  
    private String skillsCategory;
    private String dateCreated;
    private String teamId;
	private String enabled;
	
	public EmployeePersistRequest() {}

	public EmployeePersistRequest(String fullName, String idNumber, String details, String telephone, String cellphone,
			String email, String password, String authority, String userId, String skillsCategory, String dateCreated,
			String teamId, String enabled) {
		super();
		this.fullName = fullName;
		this.idNumber = idNumber;
		this.details = details;
		this.telephone = telephone;
		this.cellphone = cellphone;
		this.email = email;
		this.password = password;
		this.authority = authority;
		this.userId = userId;
		this.skillsCategory = skillsCategory;
		this.dateCreated = dateCreated;
		this.teamId = teamId;
		this.enabled = enabled;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getSkillsCategory() {
		return skillsCategory;
	}

	public void setSkillsCategory(String skillsCategory) {
		this.skillsCategory = skillsCategory;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getTeamId() {
		return teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "EmployeePersistRequest [employeeId=" + employeeId + ", fullName=" + fullName + ", idNumber=" + idNumber
				+ ", details=" + details + ", telephone=" + telephone + ", cellphone=" + cellphone + ", email=" + email
				+ ", password=" + password + ", authority=" + authority + ", userId=" + userId + ", skillsCategory="
				+ skillsCategory + ", dateCreated=" + dateCreated + ", teamId=" + teamId + ", enabled=" + enabled + "]";
	}




	






	
}
