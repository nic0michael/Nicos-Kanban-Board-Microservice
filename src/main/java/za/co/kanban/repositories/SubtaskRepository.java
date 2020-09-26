package za.co.kanban.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import za.co.kanban.model.Subtask;
import za.co.kanban.model.SubtaskKanbanItem;

public interface SubtaskRepository extends JpaRepository<Subtask, Long> {

	public Subtask findBySubtaskId(Long subtaskId);

	@Query(nativeQuery=true,value="SELECT t.status as status,t.subtask_id as id, t.name as name,t.description as description, a.name as taskName, e.fullname as assignee, t.due_date as date" + 
			" FROM subtask t" + 
			" LEFT JOIN employee e  ON t.assigned_to = e.employee_id" + 
			" LEFT JOIN status_value s  ON t.status = s.display_value" + 
			" LEFT JOIN task a ON a.task_id = t.task_id" + 
			" WHERE s.sort_order > 0" + 
			" ORDER BY s.sort_order, t.name,t.due_date")
	public List<SubtaskKanbanItem> getSubtaskKanbanItems();

	@Query(nativeQuery=true,value="SELECT t.status as status,t.subtask_id as id, t.name as name,t.description as description, a.name as taskName, e.fullname as assignee, t.due_date as date" + 
			" FROM subtask t" + 
			" LEFT JOIN employee e  ON t.assigned_to = e.employee_id" + 
			" LEFT JOIN status_value s  ON t.status = s.display_value" + 
			" LEFT JOIN task a ON a.task_id = t.task_id" + 
			" WHERE s.sort_order = 1" + 
			" ORDER BY s.sort_order, t.name,t.due_date")
	public List<SubtaskKanbanItem> getSubtaskColumn1Items();

	@Query(nativeQuery=true,value="SELECT t.status as status,t.subtask_id as id, t.name as name,t.description as description, a.name as taskName, e.fullname as assignee, t.due_date as date" + 
			" FROM subtask t" + 
			" LEFT JOIN employee e  ON t.assigned_to = e.employee_id" + 
			" LEFT JOIN status_value s  ON t.status = s.display_value" + 
			" LEFT JOIN task a ON a.task_id = t.task_id" + 
			" WHERE s.sort_order = 2" + 
			" ORDER BY s.sort_order, t.name,t.due_date")
	public List<SubtaskKanbanItem> getSubtaskColumn2Items();

	@Query(nativeQuery=true,value="SELECT t.status as status,t.subtask_id as id, t.name as name,t.description as description, a.name as taskName, e.fullname as assignee, t.due_date as date" + 
			" FROM subtask t" + 
			" LEFT JOIN employee e  ON t.assigned_to = e.employee_id" + 
			" LEFT JOIN status_value s  ON t.status = s.display_value" + 
			" LEFT JOIN task a ON a.task_id = t.task_id" + 
			" WHERE s.sort_order = 3" + 
			" ORDER BY s.sort_order, t.name,t.due_date")
	public List<SubtaskKanbanItem> getSubtaskColumn3Items();

	@Query(nativeQuery=true,value="SELECT t.status as status,t.subtask_id as id, t.name as name,t.description as description, a.name as taskName, e.fullname as assignee, t.due_date as date" + 
			" FROM subtask t" + 
			" LEFT JOIN employee e  ON t.assigned_to = e.employee_id" + 
			" LEFT JOIN status_value s  ON t.status = s.display_value" + 
			" LEFT JOIN task a ON a.task_id = t.task_id" + 
			" WHERE s.sort_order = 4" + 
			" ORDER BY s.sort_order, t.name,t.due_date")
	public List<SubtaskKanbanItem> getSubtaskColumn4Items();

	@Query(nativeQuery=true,value="SELECT t.status as status,t.subtask_id as id, t.name as name,t.description as description, a.name as taskName, e.fullname as assignee, t.due_date as date" + 
			" FROM subtask t" + 
			" LEFT JOIN employee e  ON t.assigned_to = e.employee_id" + 
			" LEFT JOIN status_value s  ON t.status = s.display_value" + 
			" LEFT JOIN task a ON a.task_id = t.task_id" + 
			" WHERE s.sort_order = 5" + 
			" ORDER BY s.sort_order, t.name,t.due_date")
	public List<SubtaskKanbanItem> getSubtaskColumn5Items();

	@Query(nativeQuery=true,value="SELECT t.status as status,t.subtask_id as id, t.name as name,t.description as description, a.name as taskName, e.fullname as assignee, t.due_date as date" + 
			" FROM subtask t" + 
			" LEFT JOIN employee e  ON t.assigned_to = e.employee_id" + 
			" LEFT JOIN status_value s  ON t.status = s.display_value" + 
			" LEFT JOIN task a ON a.task_id = t.task_id" + 
			" WHERE s.sort_order = 6" + 
			" ORDER BY s.sort_order, t.name,t.due_date")
	public List<SubtaskKanbanItem> getSubtaskColumn6Items();

}
