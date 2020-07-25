package za.co.kanban.dtos;
import javax.validation.constraints.NotBlank;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "TeamPersistRequest")
public class TeamPersistRequest {

	private String teamId;
    private String name;
	private String description;	
	private String dateCreated;
	private String isActive;
	
	public TeamPersistRequest() {}

	public TeamPersistRequest(@NotBlank String name, String description, String dateCreated, @NotBlank String isActive) {
		super();
		this.name = name;
		this.description = description;
		this.dateCreated = dateCreated;
		this.isActive = isActive;
	}


	public String getTeamId() {
		return teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
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
		return "TeamPersistRequest [teamId=" + teamId + ", name=" + name + ", description=" + description
				+ ", dateCreated=" + dateCreated + ", isActive=" + isActive + "]";
	}


	
	
}
