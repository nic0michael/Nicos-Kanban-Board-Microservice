package za.co.kanban.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import za.co.kanban.model.Audit;

public interface AuditRepository  extends JpaRepository<Audit, Long> {

	public Audit findByAuditId(Long auditId);

}