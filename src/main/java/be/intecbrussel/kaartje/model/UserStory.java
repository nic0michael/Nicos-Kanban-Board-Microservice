package be.intecbrussel.kaartje.model;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;


@Entity
@Table(name = "user_story")
public class UserStory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userStoryId;

    @NotBlank
    @Column(name = "name", unique = true)
    private String name;

    @NotBlank
    private String guid;
    private String description;
    @Column(name = "customer_reference")
    private String customerReference;

    private String stage;
    private String status;

    @Column(name = "epic_id")
    private Long epicId;

    @Column(name = "assigned_to")
    private Long assignedTo;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "due_date")
    private Date dueDate;

    @Column(name = "date_created", nullable = true, updatable = true)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date dateCreated;

    @Column(name = "is_active")
    private String isActive;


//	@ManyToMany(cascade ={CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.PERSIST},fetch=FetchType.LAZY)
//    @JoinTable(name="employee_user_story",joinColumns=@JoinColumn(name="user_story_id"),inverseJoinColumns=@JoinColumn(name="employee_id"))
//    private List<Employee>employees;

    public UserStory() {
    }


    public UserStory(@NotBlank String name, @NotBlank String guid, String description, String customerReference,
                     String stage, String status, Long epicId, Long assignedTo, Date startDate, Date endDate, Date dueDate,
                     Date dateCreated, String isActive) {
        super();
        this.name = name;
        this.guid = guid;
        this.description = description;
        this.customerReference = customerReference;
        this.stage = stage;
        this.status = status;
        this.epicId = epicId;
        this.assignedTo = assignedTo;
        this.startDate = startDate;
        this.endDate = endDate;
        this.dueDate = dueDate;
        this.dateCreated = dateCreated;
        this.isActive = isActive;
    }


    public String getGuid() {
        return guid;
    }


    public void setGuid(String guid) {
        this.guid = guid;
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


    public String getStatus() {
        return status;
    }


    public void setStatus(String status) {
        this.status = status;
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


    public Date getDueDate() {
        return dueDate;
    }


    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
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
        return "UserStory [userStoryId=" + userStoryId + ", name=" + name + ", guid=" + guid + ", description="
                + description + ", customerReference=" + customerReference + ", stage=" + stage + ", status=" + status
                + ", epicId=" + epicId + ", assignedTo=" + assignedTo + ", startDate=" + startDate + ", endDate=" + endDate
                + ", dueDate=" + dueDate + ", dateCreated=" + dateCreated + ", isActive=" + isActive + "]";
    }


}
