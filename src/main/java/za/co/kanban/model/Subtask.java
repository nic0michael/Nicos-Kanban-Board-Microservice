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
@Table(name = "subtask")
public class Subtask {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long subtaskId;
	
	@NotBlank
    @Column(name="name", unique=true)
    private String name;
	
	private String description;
	private String status;

	@NotBlank
	@Column(name="assigned_to")
	private Long assignedTo;
	
	@NotBlank
	@Column(name="tasks_id")
	private Long tasksId;
	
	@Column(name="story_points")
	private Integer storyPoints;

	@Column(name="due_date")
	private Date due_date;

	@Column(name="date_created", nullable = true, updatable = true)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date dateCreated;
	
	@NotBlank
	@Column(name="is_active")
	private String isActive;
	
	public Subtask() {}

	public Subtask(@NotBlank String name, String description, String status, @NotBlank Long assignedTo,
			@NotBlank Long tasksId, Integer storyPoints, Date due_date, Date dateCreated, @NotBlank String isActive) {
		super();
		this.name = name;
		this.description = description;
		this.status = status;
		this.assignedTo = assignedTo;
		this.tasksId = tasksId;
		this.storyPoints = storyPoints;
		this.due_date = due_date;
		this.dateCreated = dateCreated;
		this.isActive = isActive;
	}



	public Long getSubtaskId() {
		return subtaskId;
	}

	public void setSubtaskId(Long subtaskId) {
		this.subtaskId = subtaskId;
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

	public Long getTasksId() {
		return tasksId;
	}

	public void setTasksId(Long tasksId) {
		this.tasksId = tasksId;
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
		return "Subtask [subtaskId=" + subtaskId + ", name=" + name + ", description=" + description + ", status="
				+ status + ", assignedTo=" + assignedTo + ", tasksId=" + tasksId + ", storyPoints=" + storyPoints
				+ ", due_date=" + due_date + ", dateCreated=" + dateCreated + ", isActive=" + isActive + "]";
	}

	
	
}
