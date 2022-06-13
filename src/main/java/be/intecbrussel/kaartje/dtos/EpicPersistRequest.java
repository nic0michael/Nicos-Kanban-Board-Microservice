package be.intecbrussel.kaartje.dtos;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "EpicPersistRequest")
public class EpicPersistRequest {

    private String epicId;
    private String name;
    private String description;
    private String customerReference;
    private Long customerId;
    private String due_date;
    private String dateCreated;
    private String isActive;

    public EpicPersistRequest() {
    }

    public EpicPersistRequest(String name, String description, String customerReference, Long customerId,
                              String due_date, String dateCreated, String isActive) {
        super();
        this.name = name;
        this.description = description;
        this.customerReference = customerReference;
        this.customerId = customerId;
        this.due_date = due_date;
        this.dateCreated = dateCreated;
        this.isActive = isActive;
    }

    public String getEpicId() {
        return epicId;
    }

    public void setEpicId(String epicId) {
        this.epicId = epicId;
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

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
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
        return "EpicPersistRequest [epicId=" + epicId + ", name=" + name + ", description=" + description
                + ", customerReference=" + customerReference + ", customerId=" + customerId + ", due_date=" + due_date
                + ", dateCreated=" + dateCreated + ", isActive=" + isActive + "]";
    }


}
