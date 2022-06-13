package be.intecbrussel.kaartje.repositories;

import be.intecbrussel.kaartje.dtos.ChartData;
import be.intecbrussel.kaartje.model.UserStory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserStoryRepository extends JpaRepository<UserStory, Long> {

    UserStory findByUserStoryId(Long userStoryId);

    @Query(nativeQuery = true, value = "SELECT stage as label, COUNT(*) as value " +
            "FROM user_story " +
            "GROUP BY stage")
	List<ChartData> getUserStoryStatusList();

}
