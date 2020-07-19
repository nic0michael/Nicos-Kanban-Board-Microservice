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
@Table(name = "team")
public class Team {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long teamId;
	
	@NotBlank
    @Column(name="name", unique=true)
    private String name;

	private String description;
	
	@Column(name="date_created", nullable = true, updatable = true)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date dateCreated;
	
	@NotBlank
	@Column(name="is_active")
	private String isActive;
	
	public Team() {}

	public Team(@NotBlank String name, String description, Date dateCreated, @NotBlank String isActive) {
		super();
		this.name = name;
		this.description = description;
		this.dateCreated = dateCreated;
		this.isActive = isActive;
	}



	public Long getTeamId() {
		return teamId;
	}

	public void setTeamId(Long teamId) {
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
		return "Team [name=" + name + ", description=" + description + ", dateCreated=" + dateCreated + ", isActive="
				+ isActive + "]";
	}
	
	
}
