package za.co.kanban.dtos;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "SubtaskPersistRequest")
public class SubtaskPersistRequest {

	private String subtaskId;
	private String taskId;
    private String name;	
	private String description;
	private String status;
	private String assignedTo;
	private String storyPoints;
	private String due_date;
	private String dateCreated;
	private String isActive;
	
	public SubtaskPersistRequest() {}

	public SubtaskPersistRequest(String taskId, String name, String description, String status, String assignedTo,
			String storyPoints, String due_date, String dateCreated, String isActive) {
		super();
		this.taskId = taskId;
		this.name = name;
		this.description = description;
		this.status = status;
		this.assignedTo = assignedTo;
		this.storyPoints = storyPoints;
		this.due_date = due_date;
		this.dateCreated = dateCreated;
		this.isActive = isActive;
	}

	public String getSubtaskId() {
		return subtaskId;
	}

	public void setSubtaskId(String subtaskId) {
		this.subtaskId = subtaskId;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
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

	public String getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}

	public String getStoryPoints() {
		return storyPoints;
	}

	public void setStoryPoints(String storyPoints) {
		this.storyPoints = storyPoints;
	}

	public String getDue_date() {
		return due_date;
	}

	public void setDue_date(String due_date) {
		this.due_date = due_date;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
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
		return "SubtaskPersistRequest [subtaskId=" + subtaskId + ", taskId=" + taskId + ", name=" + name
				+ ", description=" + description + ", status=" + status + ", assignedTo=" + assignedTo
				+ ", storyPoints=" + storyPoints + ", due_date=" + due_date + ", dateCreated=" + dateCreated
				+ ", isActive=" + isActive + "]";
	}




	
}
