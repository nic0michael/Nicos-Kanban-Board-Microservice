package be.intecbrussel.kaartje.dtos;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "TaskPersistRequest")
public class TaskPersistRequest {

    private String taskId;
    private String name;
    private String description;
    private String guid;
    private String status;
    private String assignedTo;
    private String userStoryId;
    private String storyPoints;
    private String stage; // NOTSTARTED, COMPLETED, INPROGRESS
    private String startDate;
    private String endDate;
    private String due_date;
    private String dateCreated;
    private String isActive;

    public TaskPersistRequest() {
    }


    public TaskPersistRequest(String name, String description, String guid, String status, String assignedTo,
                              String userStoryId, String storyPoints, String stage, String startDate, String endDate, String due_date,
                              String dateCreated, String isActive) {
        super();
        this.name = name;
        this.description = description;
        this.guid = guid;
        this.status = status;
        this.assignedTo = assignedTo;
        this.userStoryId = userStoryId;
        this.storyPoints = storyPoints;
        this.stage = stage;
        this.startDate = startDate;
        this.endDate = endDate;
        this.due_date = due_date;
        this.dateCreated = dateCreated;
        this.isActive = isActive;
    }


    public String getGuid() {
        return guid;
    }


    public void setGuid(String guid) {
        this.guid = guid;
    }


    public String getTaskId() {
        return taskId;
    }


    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }


    public String getStage() {
        return stage;
    }


    public void setStage(String stage) {
        this.stage = stage;
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

    public String getUserStoryId() {
        return userStoryId;
    }

    public void setUserStoryId(String userStoryId) {
        this.userStoryId = userStoryId;
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
        return "TaskPersistRequest [taskId=" + taskId + ", name=" + name + ", description=" + description + ", guid="
                + guid + ", status=" + status + ", assignedTo=" + assignedTo + ", userStoryId=" + userStoryId
                + ", storyPoints=" + storyPoints + ", stage=" + stage + ", startDate=" + startDate + ", endDate="
                + endDate + ", due_date=" + due_date + ", dateCreated=" + dateCreated + ", isActive=" + isActive + "]";
    }


}
