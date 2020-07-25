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
@Table(name = "audit")
public class Audit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long auditId;

	@Column(name="date_created", nullable = true, updatable = true)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date dateCreated;

	@NotBlank
	@Column(name="operation_type")
	private String operationType;
	
	@NotBlank
	@Column(name="request")
	private String request;
	
	@NotBlank
	@Column(name="employee_id")
	private Long employeeId;

	public Audit() {}

	public Audit(Date dateCreated, @NotBlank String operationType, @NotBlank String request,
			@NotBlank Long employeeId) {
		super();
		this.dateCreated = dateCreated;
		this.operationType = operationType;
		this.request = request;
		this.employeeId = employeeId;
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

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	@Override
	public String toString() {
		return "Audit [auditId=" + auditId + ", dateCreated=" + dateCreated + ", operationType=" + operationType
				+ ", request=" + request + ", employeeId=" + employeeId + "]";
	}

	
	
	
}
