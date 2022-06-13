package be.intecbrussel.kaartje.model;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Table(name = "audit")
public class Audit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long auditId;

    @NotBlank
    private String guid;

    @Column(name = "date_created", nullable = true, updatable = true)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date dateCreated;

    @NotBlank
    @Column(name = "operation_type")
    private String operationType;

    @NotBlank
    @Column(name = "request")
    private String request;

    @NotBlank
    @Column(name = "user_id")
    private String userId;

    public Audit() {
    }


    public Audit(@NotBlank String guid, Date dateCreated, @NotBlank String operationType, @NotBlank String request,
                 @NotBlank String userId) {
        super();
        this.guid = guid;
        this.dateCreated = dateCreated;
        this.operationType = operationType;
        this.request = request;
        this.userId = userId;
    }


    public Long getAuditId() {
        return auditId;
    }

    public void setAuditId(Long auditId) {
        this.auditId = auditId;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }


    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Audit [auditId=" + auditId + ", guid=" + guid + ", dateCreated=" + dateCreated + ", operationType="
                + operationType + ", request=" + request + ", userId=" + userId + "]";
    }


}
