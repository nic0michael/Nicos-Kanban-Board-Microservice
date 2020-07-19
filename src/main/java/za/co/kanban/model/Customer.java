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
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerId;
	
	@NotBlank
    @Column(name="name", unique=true)
    private String name;

	@NotBlank
    @Column(name="short_name", unique=true)
    private String shortName;	

	private String details;
	private String telephone;	
	private String cellphone;	
	private String email;

	@Column(name="date_created", nullable = true, updatable = true)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date dateCreated;
	
	@NotBlank
	@Column(name="is_active")
	private String isActive;

	public Customer() {}

	public Customer(@NotBlank String name, @NotBlank String shortName, String details, String telephone,
			String cellphone, String email, Date dateCreated, @NotBlank String isActive) {
		super();
		this.name = name;
		this.shortName = shortName;
		this.details = details;
		this.telephone = telephone;
		this.cellphone = cellphone;
		this.email = email;
		this.dateCreated = dateCreated;
		this.isActive = isActive;
	}



	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
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
		return "Customer [name=" + name + ", shortName=" + shortName + ", details=" + details + ", telephone="
				+ telephone + ", cellphone=" + cellphone + ", email=" + email + ", dateCreated=" + dateCreated
				+ ", isActive=" + isActive + "]";
	}

	
}
