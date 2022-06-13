package be.intecbrussel.kaartje.model;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name = "team")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teamId;

    @NotBlank
    @Column(name = "name", unique = true)
    private String name;

    private String description;

    @Column(name = "date_created", nullable = true, updatable = true)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date dateCreated;

    @NotBlank
    @Column(name = "is_active")
    private String isActive;

    public Team() {
    }

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
        return "Team [teamId=" + teamId + ", name=" + name + ", description=" + description + ", dateCreated="
                + dateCreated + ", isActive=" + isActive + "]";
    }


}
