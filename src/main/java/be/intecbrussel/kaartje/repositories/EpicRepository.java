package za.co.kanban.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import za.co.kanban.model.Epic;

public interface EpicRepository extends JpaRepository<Epic, Long> {

	public Epic findByEpicId(Long epicId);

}
