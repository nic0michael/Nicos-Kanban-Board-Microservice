package be.intecbrussel.kaartje.dtos;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ContactPersistRequest")
public class ContactPersistRequest {

    private String contactId;
    private String fullName;
    private String details;
    private String telephone;
    private String cellphone;
    private String email;
    private String customerId;
    private String dateCreated;
    private String isActive;

    public ContactPersistRequest() {
    }


    public ContactPersistRequest(String fullName, String details, String telephone, String cellphone, String email,
                                 String customerId, String dateCreated, String isActive) {
        super();
        this.fullName = fullName;
        this.details = details;
        this.telephone = telephone;
        this.cellphone = cellphone;
        this.email = email;
        this.customerId = customerId;
        this.dateCreated = dateCreated;
        this.isActive = isActive;
    }


    public String getContactId() {
        return contactId;
    }


    public void setContactId(String contactId) {
        this.contactId = contactId;
    }


    public String getFullName() {
        return fullName;
    }


    public void setFullName(String fullName) {
        this.fullName = fullName;
    }


    public String getDetails() {
        return details;
    }


    public void setDetails(String details) {
        this.details = details;
    }


    public String getTelephone() {
        return telephone;
    }


    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }


    public String getCellphone() {
        return cellphone;
    }


    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getCustomerId() {
        return customerId;
    }


    public void setCustomerId(String customerId) {
        this.customerId = customerId;
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
        return "ContactPersistRequest [contactId=" + contactId + ", fullName=" + fullName + ", details=" + details
                + ", telephone=" + telephone + ", cellphone=" + cellphone + ", email=" + email + ", customerId="
                + customerId + ", dateCreated=" + dateCreated + ", isActive=" + isActive + "]";
    }


}
