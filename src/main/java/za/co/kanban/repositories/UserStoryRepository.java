package za.co.kanban.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import za.co.kanban.dtos.ChartData;
import za.co.kanban.model.UserStory;

public interface UserStoryRepository extends JpaRepository<UserStory, Long> {

	public UserStory findByUserStoryId(Long userStoryId);

	@Query(nativeQuery=true,value="SELECT stage as label, COUNT(*) as value " + 
			"FROM user_story " + 
			"GROUP BY stage")
	public List<ChartData> getUserStoryStatusList();

}
