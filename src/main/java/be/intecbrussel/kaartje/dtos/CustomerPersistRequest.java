package za.co.kanban.dtos;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "CustomerPersistRequest")
public class CustomerPersistRequest {

	private String customerId;
    private String name;
    private String shortName;	
	private String details;
	private String telephone;	
	private String cellphone;	
	private String email;
	private String dateCreated;
	private String isActive;

	public CustomerPersistRequest() {}

	public CustomerPersistRequest(String name, String shortName, String details, String telephone, String cellphone,
			String email, String dateCreated, String isActive) {
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

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
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
		return "CustomerPersistRequest [customerId=" + customerId + ", name=" + name + ", shortName=" + shortName
				+ ", details=" + details + ", telephone=" + telephone + ", cellphone=" + cellphone + ", email=" + email
				+ ", dateCreated=" + dateCreated + ", isActive=" + isActive + "]";
	}

	
	
}
