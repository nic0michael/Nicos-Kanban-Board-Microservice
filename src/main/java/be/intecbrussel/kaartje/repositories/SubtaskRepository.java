package be.intecbrussel.kaartje.repositories;

import be.intecbrussel.kaartje.model.Subtask;
import be.intecbrussel.kaartje.model.SubtaskKanbanItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SubtaskRepository extends JpaRepository<Subtask, Long> {

    Subtask findBySubtaskId(Long subtaskId);

    @Query(nativeQuery = true, value = "SELECT t.status as status,t.subtask_id as subtaskId, t.name as subtaskName, a.name as taskName, e.fullname as assignedTo, t.due_date as dueDate\n" +
            " FROM subtask t\n" +
            " LEFT JOIN employee e  ON t.assigned_to = e.employee_id\n" +
            " LEFT JOIN status_value s  ON t.status = s.display_value\n" +
            " LEFT JOIN task a ON a.task_id = t.task_id\n" +
            " WHERE s.sort_order > 0\n" +
            " ORDER BY s.sort_order, t.name,t.due_date")
	List<SubtaskKanbanItem> getSubtaskKanbanItems();

}
