package za.co.kanban.model;
import java.util.Objects;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name = "task")
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long taskId;
	
	@NotBlank
    @Column(name="name", unique=true)
    private String name;
	
	private String description;
	private String status;	

	@Column(name="assigned_to")
	private Long assignedTo;

	@Column(name="user_story_id")
	private Long userStoryId;
	
	@Column(name="story_points")
	private Integer storyPoints;

	@Column(name="due_date")
	private Date due_date;
	
	private String stage; // NOTSTARTED, COMPLETED, INPROGRESS

	@Column(name="start_date")
	private Date startDate;

	@Column(name="end_date")
	private Date endDate;

	@Column(name="date_created", nullable = true, updatable = true)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date dateCreated;
	
	@Column(name="is_active")
	private String isActive;
	
	public Task() {}


	public Task(@NotBlank String name, String description, String status, @NotBlank Long assignedTo,
			@NotBlank Long userStoryId, Integer storyPoints, Date due_date, String stage, Date startDate, Date endDate,
			Date dateCreated, @NotBlank String isActive) {
		super();
		this.name = name;
		this.description = description;
		this.status = status;
		this.assignedTo = assignedTo;
		this.userStoryId = userStoryId;
		this.storyPoints = storyPoints;
		this.due_date = due_date;
		this.stage = stage;
		this.startDate = startDate;
		this.endDate = endDate;
		this.dateCreated = dateCreated;
		this.isActive = isActive;
	}


	public String getStage() {
		return stage;
	}


	public void setStage(String stage) {
		this.stage = stage;
	}


	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public Date getEndDate() {
		return endDate;
	}


	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long subtaskId) {
		this.taskId = subtaskId;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(Long assignedTo) {
		this.assignedTo = assignedTo;
	}

	public Long getUserStoryId() {
		return userStoryId;
	}

	public void setUserStoryId(Long userStoryId) {
		this.userStoryId = userStoryId;
	}

	public Integer getStoryPoints() {
		return storyPoints;
	}

	public void setStoryPoints(Integer storyPoints) {
		this.storyPoints = storyPoints;
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
		return "Task [taskId=" + taskId + ", name=" + name + ", description=" + description + ", status=" + status
				+ ", assignedTo=" + assignedTo + ", userStoryId=" + userStoryId + ", storyPoints=" + storyPoints
				+ ", due_date=" + due_date + ", stage=" + stage + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", dateCreated=" + dateCreated + ", isActive=" + isActive + "]";
	}





	
	
}
