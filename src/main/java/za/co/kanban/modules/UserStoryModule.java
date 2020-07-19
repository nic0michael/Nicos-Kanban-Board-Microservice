package za.co.kanban.modules;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import za.co.kanban.dtos.ChartData;
import za.co.kanban.dtos.UserStoryPersistRequest;
import za.co.kanban.model.Employee;
import za.co.kanban.model.UserStory;
import za.co.kanban.repositories.UserStoryRepository;
import za.co.kanban.utils.Utils;



@Component
public class UserStoryModule {
	private static final Logger log = LoggerFactory.getLogger(UserStoryModule.class);
	
	@Autowired 
	UserStoryRepository repository;

	@Autowired 
	EmployeeModule employeeModule;

	public void save(UserStoryPersistRequest userStoryPersistRequest) {
		if(userStoryPersistRequest!=null) {
			boolean employeesFound=false;				
			UserStory userStory =Utils.convertToUserStory(userStoryPersistRequest);
			if(userStory !=null) {
				repository.save(userStory);
			}
		}
	}
	

	public void update(UserStoryPersistRequest userStoryPersistRequest) {
		log.info("PROJECT_MAN : UserStoryModule : update : userStory : "+ userStoryPersistRequest);	
		boolean employeesFound=false;
		List<Employee> employees =new ArrayList<>();
		if(userStoryPersistRequest!=null) {
			Long userStoryId=Long.parseLong(userStoryPersistRequest.getUserStoryId());
						
			if(userStoryId!=null) {
				UserStory userStory =find(userStoryId);	
				if(userStory!=null) {
					userStory =Utils.convertToUserStory(userStoryPersistRequest,userStory);
					repository.save(userStory);
				} 
			}
		}
	}
	
	public List<UserStory> findAll(){
		System.out.println("getting list of userStorys");
		List<UserStory> userStorys = (List<UserStory>) repository.findAll();
		System.out.println("got list of cities : " + userStorys);
		return userStorys;
	}
	
	public List<ChartData> getUserStoryStatusList(){
		return repository.getUserStoryStatusList();
	}
	
	


	public boolean existsById(Long userStoryId) {
		if(userStoryId!=null) {
		return repository.existsById(userStoryId);
		} else {
			return false;
		}
	}
	
	

	public List<UserStory> findAllById(Long userStoryId) {
		log.info("PROJECT_MAN : UserStoryModule : findAllById : userStoryId : "+ userStoryId);
		List<UserStory> userStorys = null;
		if(userStoryId!=null) {
			boolean res = repository.existsById(userStoryId);
			if(res) {
				log.info("PROJECT_MAN : UserStoryModule : findAllById : exists userStoryId : "+ userStoryId);
				List<Long> ids = new ArrayList();
				ids.add(userStoryId);
				userStorys = repository.findAllById(ids);
			}
			log.info("PROJECT_MAN : UserStoryModule : findAllById : userStorys found : "+ userStorys);
		}
		return userStorys;
	}


	public UserStory find(Long userStoryId) {
		log.info("PROJECT_MAN : UserStoryModule : find : find userStoryId : "+ userStoryId);
		UserStory userStory =null;
		if(userStoryId!=null) {
			List<UserStory> userStorys = findAllById( userStoryId);
			userStory = userStorys.get(0);
		}
		log.info("PROJECT_MAN : UserStoryModule : find : userStory : "+ userStory);
		return userStory;
	}
	
	

	public void delete(Long userStoryId) {
		log.info("PROJECT_MAN : UserStoryModule : delete : find userStoryId : "+ userStoryId);
		if(userStoryId!=null) {
			UserStory userStory=find(userStoryId);
			log.info("PROJECT_MAN : UserStoryModule : delete : userStory : "+ userStory);
			repository.delete(userStory);	
		}
	}

	

}
