package za.co.kanban.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import za.co.kanban.model.TaskKanbanItem;
import za.co.kanban.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

	public Task findByTaskId(Long taskId);
	

	@Query(nativeQuery=true,value="SELECT t.status as status,t.task_id as taskId, t.name as taskName,t.description as description,u.name as userStoryName,  e.fullname as assignedTo, t.due_date as dueDate" + 
			" FROM task t" + 
			" LEFT JOIN employee e ON t.assigned_to = e.employee_id" + 
			" LEFT JOIN status_value s ON t.status = s.display_value" + 
			" LEFT JOIN user_story u ON u.user_story_id = t.user_story_id" + 
			" WHERE s.sort_order > 0" + 
			" ORDER BY s.sort_order, t.name,t.due_date")
	public List<TaskKanbanItem> getTaskBanbanitems();
	

	@Query(nativeQuery=true,value="SELECT t.status as status,t.task_id as taskId, t.name as taskName,t.description as description,u.name as userStoryName,  e.fullname as assignedTo, t.due_date as dueDate" + 
			" FROM task t\n" + 
			" LEFT JOIN employee e ON t.assigned_to = e.employee_id" + 
			" LEFT JOIN status_value s ON t.status = s.display_value" + 
			" LEFT JOIN user_story u ON u.user_story_id = t.user_story_id" + 
			" WHERE s.sort_order = 1" + 
			" ORDER BY s.sort_order, t.name,t.due_date")
	public List<TaskKanbanItem> getTaskColumn1Items();
	

	@Query(nativeQuery=true,value="SELECT t.status as status,t.task_id as taskId, t.name as taskName,t.description as description,u.name as userStoryName,  e.fullname as assignedTo, t.due_date as dueDate" + 
			" FROM task t\n" + 
			" LEFT JOIN employee e ON t.assigned_to = e.employee_id" + 
			" LEFT JOIN status_value s ON t.status = s.display_value" + 
			" LEFT JOIN user_story u ON u.user_story_id = t.user_story_id" + 
			" WHERE s.sort_order = 2" + 
			" ORDER BY s.sort_order, t.name,t.due_date")
	public List<TaskKanbanItem> getTaskColumn2Items();
	

	@Query(nativeQuery=true,value="SELECT t.status as status,t.task_id as taskId, t.name as taskName,t.description as description,u.name as userStoryName,  e.fullname as assignedTo, t.due_date as dueDate" + 
			" FROM task t\n" + 
			" LEFT JOIN employee e ON t.assigned_to = e.employee_id" + 
			" LEFT JOIN status_value s ON t.status = s.display_value" + 
			" LEFT JOIN user_story u ON u.user_story_id = t.user_story_id" + 
			" WHERE s.sort_order = 3" + 
			" ORDER BY s.sort_order, t.name,t.due_date")
	public List<TaskKanbanItem> getTaskColumn3Items();
	

	@Query(nativeQuery=true,value="SELECT t.status as status,t.task_id as taskId, t.name as taskName,t.description as description,u.name as userStoryName,  e.fullname as assignedTo, t.due_date as dueDate" + 
			" FROM task t\n" + 
			" LEFT JOIN employee e ON t.assigned_to = e.employee_id" + 
			" LEFT JOIN status_value s ON t.status = s.display_value" + 
			" LEFT JOIN user_story u ON u.user_story_id = t.user_story_id" + 
			" WHERE s.sort_order = 4" + 
			" ORDER BY s.sort_order, t.name,t.due_date")
	public List<TaskKanbanItem> getTaskColumn4Items();
	

	@Query(nativeQuery=true,value="SELECT t.status as status,t.task_id as taskId, t.name as taskName,t.description as description,u.name as userStoryName,  e.fullname as assignedTo, t.due_date as dueDate" + 
			" FROM task t\n" + 
			" LEFT JOIN employee e ON t.assigned_to = e.employee_id" + 
			" LEFT JOIN status_value s ON t.status = s.display_value" + 
			" LEFT JOIN user_story u ON u.user_story_id = t.user_story_id" + 
			" WHERE s.sort_order = 5" + 
			" ORDER BY s.sort_order, t.name,t.due_date")
	public List<TaskKanbanItem> getTaskColumn5Items();
	

	@Query(nativeQuery=true,value="SELECT t.status as status,t.task_id as taskId, t.name as taskName,t.description as description,u.name as userStoryName,  e.fullname as assignedTo, t.due_date as dueDate" + 
			" FROM task t\n" + 
			" LEFT JOIN employee e ON t.assigned_to = e.employee_id" + 
			" LEFT JOIN status_value s ON t.status = s.display_value" + 
			" LEFT JOIN user_story u ON u.user_story_id = t.user_story_id" + 
			" WHERE s.sort_order = 6" + 
			" ORDER BY s.sort_order, t.name,t.due_date")
	public List<TaskKanbanItem> getTaskColumn6Items();
	

}
