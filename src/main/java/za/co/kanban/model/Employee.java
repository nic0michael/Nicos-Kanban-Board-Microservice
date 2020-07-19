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

import org.springframework.data.annotation.CreatedDate;


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
    
    @NotBlank
	@Column(name="team_id")
	private Long teamId;
    
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
	
	@NotBlank
	@Column(name="is_enabled")
	private Boolean enabled;

	/**
     * Cascade rules set dont use ALL and REMOVE this would delete employees
     * When  the Project is saved then the Employee should also be saved .... but not deleted when Project is deleted
     * Use Lazy fetching for petter performance
     */
    @ManyToMany(cascade ={CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST},fetch=FetchType.LAZY)
    @JoinTable(name="employee_user_story",joinColumns=@JoinColumn(name="employee_id"),inverseJoinColumns=@JoinColumn(name="user_story_id"))
    private List<UserStory> userStorys;
	
	 
	public Employee() {}

	public Employee(@NotBlank String fullName, String details, String telephone, String cellphone, String email,
			String password, String authority, @NotBlank Long teamId, String idNumber, String userId,
			String skillsCategory, Date dateCreated, @NotBlank Boolean enabled) {
		super();
		this.fullName = fullName;
		this.details = details;
		this.telephone = telephone;
		this.cellphone = cellphone;
		this.email = email;
		this.password = password;
		this.authority = authority;
		this.teamId = teamId;
		this.idNumber = idNumber;
		this.userId = userId;
		this.skillsCategory = skillsCategory;
		this.dateCreated = dateCreated;
		this.enabled = enabled;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
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

	public Long getTeamId() {
		return teamId;
	}

	public void setTeamId(Long teamId) {
		this.teamId = teamId;
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


	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "Employee [fullName=" + fullName + ", details=" + details + ", telephone=" + telephone + ", cellphone="
				+ cellphone + ", email=" + email + ", password=" + password + ", authority=" + authority + ", teamId="
				+ teamId + ", idNumber=" + idNumber + ", userId=" + userId + ", skillsCategory=" + skillsCategory
				+ ", dateCreated=" + dateCreated + ", enabled=" + enabled + "]";
	}


	
}
