package be.intecbrussel.kaartje.repositories;

import be.intecbrussel.kaartje.model.Audit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditRepository extends JpaRepository<Audit, Long> {

    Audit findByAuditId(Long auditId);

}