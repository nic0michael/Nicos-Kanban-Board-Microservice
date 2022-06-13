package be.intecbrussel.kaartje.repositories;

import be.intecbrussel.kaartje.model.Epic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EpicRepository extends JpaRepository<Epic, Long> {

    Epic findByEpicId(Long epicId);

}
