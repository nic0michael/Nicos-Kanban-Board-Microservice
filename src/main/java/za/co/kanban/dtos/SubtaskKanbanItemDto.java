package za.co.kanban.dtos;

public class SubtaskKanbanItemDto {
	private String status;
	private String sSubtaskId;
	private String subtaskName;
	private String description;
	private String taskName;
	private String assignedTo;
	private String dueDate;	
	
	public SubtaskKanbanItemDto() {}

	public SubtaskKanbanItemDto(String status, String sSubtaskId, String subtaskName, String description,
			String taskName, String assignedTo, String dueDate) {
		super();
		this.status = status;
		this.sSubtaskId = sSubtaskId;
		this.subtaskName = subtaskName;
		this.description = description;
		this.taskName = taskName;
		this.assignedTo = assignedTo;
		this.dueDate = dueDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getsSubtaskId() {
		return sSubtaskId;
	}

	public void setsSubtaskId(String sSubtaskId) {
		this.sSubtaskId = sSubtaskId;
	}

	public String getSubtaskName() {
		return subtaskName;
	}

	public void setSubtaskName(String subtaskName) {
		this.subtaskName = subtaskName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	@Override
	public String toString() {
		return "SubtaskKanbanItemDto [status=" + status + ", sSubtaskId=" + sSubtaskId + ", subtaskName=" + subtaskName
				+ ", description=" + description + ", taskName=" + taskName + ", assignedTo=" + assignedTo
				+ ", dueDate=" + dueDate + "]";
	}
	
	

}
