package za.co.kanban.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import za.co.kanban.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

	public Task findByTaskId(Long taskId);

}
