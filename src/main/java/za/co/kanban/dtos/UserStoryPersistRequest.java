package za.co.kanban.dtos;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "UserStoryPersistRequest")
public class UserStoryPersistRequest {

	private String userStoryId;
    private String name;	
	private String description;
	private String customerReference;	
	private String status;	
	private String customerId;
	private String epicId;
	private String assignedTo;
	private String due_date;
	private String dateCreated;
	private String isActive;
	
	public UserStoryPersistRequest() {}

	

	public UserStoryPersistRequest(String userStoryId, String name, String description, String customerReference,
			String status, String customerId, String epicId, String assignedTo, String due_date, String dateCreated,
			String isActive) {
		super();
		this.userStoryId = userStoryId;
		this.name = name;
		this.description = description;
		this.customerReference = customerReference;
		this.status = status;
		this.customerId = customerId;
		this.epicId = epicId;
		this.assignedTo = assignedTo;
		this.due_date = due_date;
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


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
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
		return "UserStoryPersistRequest [userStoryId=" + userStoryId + ", name=" + name + ", description=" + description
				+ ", customerReference=" + customerReference + ", status=" + status + ", customerId=" + customerId
				+ ", epicId=" + epicId + ", assignedTo=" + assignedTo + ", due_date=" + due_date + ", dateCreated="
				+ dateCreated + ", isActive=" + isActive + "]";
	}


	
	
}
