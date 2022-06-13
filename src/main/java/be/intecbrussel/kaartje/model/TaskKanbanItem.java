package za.co.kanban.model;

public interface TaskKanbanItem {

	public String getStatus();
	public String getTaskId();
	public String getTaskName();
	public String getUserStoryName();
	public String getAssignedTo();
	public String getDueDate();	
	
}
