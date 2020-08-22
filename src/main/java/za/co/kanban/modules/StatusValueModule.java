package za.co.kanban.modules;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import za.co.kanban.model.StatusValue;
import za.co.kanban.repositories.StatusValueRepository;

@Component
public class StatusValueModule {
	private static final Logger log = LoggerFactory.getLogger(StatusValueModule.class);
	
	@Autowired 
	StatusValueRepository repository;
	

	public List<StatusValue> findAll(){
		System.out.println("getting list of StatusValues");
		List<StatusValue> statusValues = (List<StatusValue>) repository.findAll();
		System.out.println("got list of status values : " + statusValues);
		return statusValues;
	}

}
