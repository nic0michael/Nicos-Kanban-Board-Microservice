package za.co.kanban.model;
import java.util.Objects;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.lang.NonNull;


@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long employeeId;
	
	@NotBlank
    @Column(name="fullname", unique=true)
	private String fullName;
	
	private String details;
	private String telephone;	
	private String cellphone;	
	private String email;
    private String password;    
    private String authority;    
    
    @Column(name="id_number", unique=true)
	private String idNumber;
	
    @Column(name="user_id", unique=true)
    private String userId;    

    @Column(name="skills_category")
    private String skillsCategory;

	@Column(name="date_created", nullable = true, updatable = true)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date dateCreated;
	

	private Long teamId;
	
	@NonNull
	private Integer enabled;

	 
	public Employee() {}


	public Employee(@NotBlank String fullName, String details, String telephone, String cellphone, String email,
			String password, String authority, String idNumber, String userId, String skillsCategory, Date dateCreated,
			Long teamId, Integer enabled) {
		super();
		this.fullName = fullName;
		this.details = details;
		this.telephone = telephone;
		this.cellphone = cellphone;
		this.email = email;
		this.password = password;
		this.authority = authority;
		this.idNumber = idNumber;
		this.userId = userId;
		this.skillsCategory = skillsCategory;
		this.dateCreated = dateCreated;
		this.teamId = teamId;
		this.enabled = enabled;
	}


	public Long getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}


	public String getFullName() {
		return fullName.toUpperCase();
	}


	public void setFullName(String fullName) {
		if(StringUtils.isNotEmpty(fullName)) {
			this.fullName = fullName.toUpperCase();
		}
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


	public String getIdNumber() {
		return idNumber;
	}


	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
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


	public Date getDateCreated() {
		return dateCreated;
	}


	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}


	public Long getTeamId() {
		return teamId;
	}


	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}


	public Integer getEnabled() {
		return enabled;
	}


	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}


	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", fullName=" + fullName + ", details=" + details + ", telephone="
				+ telephone + ", cellphone=" + cellphone + ", email=" + email + ", password=" + password
				+ ", authority=" + authority + ", idNumber=" + idNumber + ", userId=" + userId + ", skillsCategory="
				+ skillsCategory + ", dateCreated=" + dateCreated + ", teamId=" + teamId + ", enabled=" + enabled + "]";
	}




	
}
