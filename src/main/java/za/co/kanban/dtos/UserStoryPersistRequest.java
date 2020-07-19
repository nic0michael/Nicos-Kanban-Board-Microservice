package za.co.kanban.dtos;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "UserStoryPersistRequest")
public class UserStoryPersistRequest {

	private String userStoryId;
    private String name;	
	private String description;
	private String customerReference;	
	private String stage;	
	private String customerId;
	private String epicId;
	private String assignedTo;
	private String startDate;
	private String endDate;
	private String dueDate;
	private String dateCreated;
	private String isActive;
	
	public UserStoryPersistRequest() {}

	public UserStoryPersistRequest(String userStoryId, String name, String description, String customerReference,
			String stage, String customerId, String epicId, String assignedTo, String startDate, String endDate,
			String dueDate, String dateCreated, String isActive) {
		super();
		this.userStoryId = userStoryId;
		this.name = name;
		this.description = description;
		this.customerReference = customerReference;
		this.stage = stage;
		this.customerId = customerId;
		this.epicId = epicId;
		this.assignedTo = assignedTo;
		this.startDate = startDate;
		this.endDate = endDate;
		this.dueDate = dueDate;
		this.dateCreated = dateCreated;
		this.isActive = isActive;
	}

	public String getUserStoryId() {
		return userStoryId;
	}

	public void setUserStoryId(String userStoryId) {
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

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getEpicId() {
		return epicId;
	}

	public void setEpicId(String epicId) {
		this.epicId = epicId;
	}

	public String getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
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
		return "UserStoryPersistRequest [userStoryId=" + userStoryId + ", name=" + name + ", description=" + description
				+ ", customerReference=" + customerReference + ", stage=" + stage + ", customerId=" + customerId
				+ ", epicId=" + epicId + ", assignedTo=" + assignedTo + ", startDate=" + startDate + ", endDate="
				+ endDate + ", dueDate=" + dueDate + ", dateCreated=" + dateCreated + ", isActive=" + isActive + "]";
	}


	
	
}
