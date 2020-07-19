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
@Table(name = "contact")
public class Contact {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long contactId;
	
	@NotBlank
    @Column(name="fullname", unique=true)
	private String fullName;
	
	private String details;
	private String telephone;	
	private String cellphone;	
	private String email;
    private String password;    
    private String authority;
    
    @NotBlank
	@Column(name="customer_id")
	private Long customerd;
    

	@Column(name="date_created", nullable = true, updatable = true)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date dateCreated;
	
	@NotBlank
	@Column(name="is_active")
	private String isActive;
    
    public Contact() {}

	public Contact(@NotBlank String fullName, String details, String telephone, String cellphone, String email,
			String password, String authority, @NotBlank Long customerd, Date dateCreated, @NotBlank String isActive) {
		super();
		this.fullName = fullName;
		this.details = details;
		this.telephone = telephone;
		this.cellphone = cellphone;
		this.email = email;
		this.password = password;
		this.authority = authority;
		this.customerd = customerd;
		this.dateCreated = dateCreated;
		this.isActive = isActive;
	}



	public Long getContactId() {
		return contactId;
	}

	public void setContactId(Long contactId) {
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public Long getCustomerd() {
		return customerd;
	}

	public void setCustomerd(Long customerd) {
		this.customerd = customerd;
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
		return "Contact [fullName=" + fullName + ", details=" + details + ", telephone=" + telephone + ", cellphone="
				+ cellphone + ", email=" + email + ", password=" + password + ", authority=" + authority
				+ ", customerd=" + customerd + ", dateCreated=" + dateCreated + ", isActive=" + isActive + "]";
	}

    
	
	
}
