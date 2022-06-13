package za.co.kanban.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import za.co.kanban.model.StatusValue;

public interface StatusValueRepository extends JpaRepository<StatusValue, Long> {

	public StatusValue findByStatusValueId(Long subtaskId);

}
