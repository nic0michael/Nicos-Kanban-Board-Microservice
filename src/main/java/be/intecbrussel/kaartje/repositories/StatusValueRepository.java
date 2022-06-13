package be.intecbrussel.kaartje.repositories;

import be.intecbrussel.kaartje.model.StatusValue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusValueRepository extends JpaRepository<StatusValue, Long> {

    StatusValue findByStatusValueId(Long subtaskId);

}
