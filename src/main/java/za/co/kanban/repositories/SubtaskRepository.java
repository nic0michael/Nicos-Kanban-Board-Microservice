package za.co.kanban.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import za.co.kanban.model.Subtask;

public interface SubtaskRepository extends JpaRepository<Subtask, Long> {

	public Subtask findBySubtaskId(Long subtaskId);

}
