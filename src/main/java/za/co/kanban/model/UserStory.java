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
@Table(name = "user_story")
public class UserStory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userStoryId;
	
	@NotBlank
    @Column(name="name", unique=true)
    private String name;
	
	private String description;
	@Column(name="customer_reference")
	private String customerReference;	

	private String stage;		
	
	@NotBlank
	@Column(name="customer_id")
	private Long customerId;

	@NotBlank
	@Column(name="epic_id")
	private Long epicId;

	@NotBlank
	@Column(name="assigned_to")
	private Long assignedTo;

	@Column(name="due_date")
	private Date due_date;

	@Column(name="date_created", nullable = true, updatable = true)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date dateCreated;
	
	@NotBlank
	@Column(name="is_active")
	private String isActive;
	
	

	@ManyToMany(cascade ={CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST},fetch=FetchType.LAZY)
    @JoinTable(name="employee_user_story",joinColumns=@JoinColumn(name="user_story_id"),inverseJoinColumns=@JoinColumn(name="employee_id"))
    private List<Employee>employees;
	
	public UserStory() {}

	public UserStory(@NotBlank String name, String description, String customerReference, String stage,
			@NotBlank Long customerId, @NotBlank Long epicId, @NotBlank Long assignedTo, Date due_date, Date dateCreated,
			@NotBlank String isActive) {
		super();
		this.name = name;
		this.description = description;
		this.customerReference = customerReference;
		this.stage = stage;
		this.customerId = customerId;
		this.epicId = epicId;
		this.assignedTo = assignedTo;
		this.due_date = due_date;
		this.dateCreated = dateCreated;
		this.isActive = isActive;
	}



	public Long getUserStoryId() {
		return userStoryId;
	}

	public void setUserStoryId(Long userStoryId) {
		this.userStoryId = userStoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCustomerReference() {
		return customerReference;
	}

	public void setCustomerReference(String customerReference) {
		this.customerReference = customerReference;
	}

	public String getStage() {
		return stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Long getEpicId() {
		return epicId;
	}

	public void setEpicId(Long epicId) {
		this.epicId = epicId;
	}

	public Long getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(Long assignedTo) {
		this.assignedTo = assignedTo;
	}

	public Date getDue_date() {
		return due_date;
	}

	public void setDue_date(Date due_date) {
		this.due_date = due_date;
	}



	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "UserStory [userStoryId=" + userStoryId + ", name=" + name + ", description=" + description
				+ ", customerReference=" + customerReference + ", stage=" + stage + ", customerId=" + customerId
				+ ", epicId=" + epicId + ", assignedTo=" + assignedTo + ", due_date=" + due_date + ", dateCreated="
				+ dateCreated + ", isActive=" + isActive + "]";
	}


	
	
}
