package za.co.kanban.model;

import java.util.Date;

public interface SubtaskKanbanItem {

	public String getStatus();	
	public Long getId();
	public String getName();
	public String getDescription();
	public String getTaskName();
	public String getAssignee();
	public Date getDate();	
}
