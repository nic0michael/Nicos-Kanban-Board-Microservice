package be.intecbrussel.kaartje.model;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name = "epic")
public class Epic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long epicId;

    @NotBlank
    @Column(name = "name", unique = true)
    private String name;

    private String description;

    @Column(name = "customer_reference")
    private String customerReference;

    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "due_date")
    private Date due_date;

    @Column(name = "date_created", nullable = true, updatable = true)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date dateCreated;

    @NotBlank
    @Column(name = "is_active")
    private String isActive;

    public Epic() {
    }

    public Epic(@NotBlank String name, String description, String customerReference, @NotBlank Long customerId,
                Date due_date, Date dateCreated, @NotBlank String isActive) {
        super();
        this.name = name;
        this.description = description;
        this.customerReference = customerReference;
        this.customerId = customerId;
        this.due_date = due_date;
        this.dateCreated = dateCreated;
        this.isActive = isActive;
    }


    public Long getEpicId() {
        return epicId;
    }

    public void setEpicId(Long epicId) {
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
        return "Epic [epicId=" + epicId + ", name=" + name + ", description=" + description + ", customerReference="
                + customerReference + ", customerId=" + customerId + ", due_date=" + due_date + ", dateCreated="
                + dateCreated + ", isActive=" + isActive + "]";
    }


}
