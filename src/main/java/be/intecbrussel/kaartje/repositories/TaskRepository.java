package be.intecbrussel.kaartje.repositories;

import be.intecbrussel.kaartje.model.Task;
import be.intecbrussel.kaartje.model.TaskKanbanItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    Task findByTaskId(Long taskId);


    @Query(nativeQuery = true, value = "SELECT t.status as status,t.task_id as taskId, t.name as taskName,u.name as userStoryName,  e.fullname as assignedTo, t.due_date as dueDate" +
            " FROM task t\n" +
            " LEFT JOIN employee e ON t.assigned_to = e.employee_id" +
            " LEFT JOIN status_value s ON t.status = s.display_value" +
            " LEFT JOIN user_story u ON u.user_story_id = t.user_story_id" +
            " WHERE s.sort_order > 0" +
            " ORDER BY s.sort_order, t.name,t.due_date")
    List<TaskKanbanItem> getTaskItems();

}
