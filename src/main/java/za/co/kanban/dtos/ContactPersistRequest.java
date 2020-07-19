package za.co.kanban.dtos;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ContactPersistRequest")
public class ContactPersistRequest {

	private String fullName;	
	private String details;
	private String telephone;	
	private String cellphone;	
	private String email;
    private String password;    
    private String authority;
	private String customerd;
	private String dateCreated;
	private String isActive;
    
    public ContactPersistRequest() {}

	public ContactPersistRequest(String fullName, String details, String telephone, String cellphone, String email,
			String password, String authority, String customerd, String dateCreated, String isActive) {
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

	public String getCustomerd() {
		return customerd;
	}

	public void setCustomerd(String customerd) {
		this.customerd = customerd;
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
		return "ContactPersistRequest [fullName=" + fullName + ", details=" + details + ", telephone=" + telephone
				+ ", cellphone=" + cellphone + ", email=" + email + ", password=" + password + ", authority="
				+ authority + ", customerd=" + customerd + ", dateCreated=" + dateCreated + ", isActive=" + isActive
				+ "]";
	}

	
	
}
