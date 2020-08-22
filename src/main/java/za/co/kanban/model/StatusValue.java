package za.co.kanban.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "status_value")
public class StatusValue {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long statusValueId;
	
	@NotBlank
    @Column(name="display_value", unique=true)
    private String displayValue;
	

    @Column(name="sort_order")
	private int sortOrder;
	
	private String description;

	public StatusValue() {}

	public StatusValue(@NotBlank String displayValue, int sortOrder, String description) {
		super();
		this.displayValue = displayValue;
		this.sortOrder = sortOrder;
		this.description = description;
	}

	public Long getStatusValueId() {
		return statusValueId;
	}

	public void setStatusValueId(Long statusValueId) {
		this.statusValueId = statusValueId;
	}

	public String getDisplayValue() {
		return displayValue;
	}

	public void setDisplayValue(String displayValue) {
		this.displayValue = displayValue;
	}

	public int getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(int sortOrder) {
		this.sortOrder = sortOrder;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "StatusValue [statusValueId=" + statusValueId + ", displayValue=" + displayValue + ", sortOrder="
				+ sortOrder + ", description=" + description + "]";
	}
	
}
