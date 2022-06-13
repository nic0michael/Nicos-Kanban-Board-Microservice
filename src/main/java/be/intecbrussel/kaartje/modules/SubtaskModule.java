package za.co.kanban.modules;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import za.co.kanban.dtos.SubtaskPersistRequest;
import za.co.kanban.model.Employee;
import za.co.kanban.model.Subtask;
import za.co.kanban.model.SubtaskKanbanItem;
import za.co.kanban.repositories.SubtaskRepository;
import za.co.kanban.utils.Utils;



@Component
public class SubtaskModule {
	private static final Logger log = LoggerFactory.getLogger(SubtaskModule.class);
	
	@Autowired 
	SubtaskRepository repository;

	@Autowired 
	EmployeeModule employeeModule;

	public List<SubtaskKanbanItem>  getSubtaskKanbanItems(){
		return repository.getSubtaskKanbanItems();
	}
	
	public void save(SubtaskPersistRequest subtaskPersistRequest) {
		if(subtaskPersistRequest!=null) {
			boolean employeesFound=false;				
			Subtask subtask =Utils.convertToSubtask(subtaskPersistRequest);
			if(subtask !=null) {
				subtask.setDateCreated(new Date());
				repository.save(subtask);
			}
		}
	}
	

	public void update(SubtaskPersistRequest subtaskPersistRequest) {
		log.info("PROJECT_MAN : SubtaskModule : update : subtask : "+ subtaskPersistRequest);	
		boolean employeesFound=false;
		List<Employee> employees =new ArrayList<>();
		Subtask foundSubtask=null;
		log.info("PROJECT_MAN : SubtaskModule : update : subtaskPersistRequest : "+ subtaskPersistRequest);
		if(subtaskPersistRequest!=null) {
			
			Long subtaskId=Long.parseLong(subtaskPersistRequest.getSubtaskId());			
						
			if(subtaskId!=null) {		
				foundSubtask=findBySubtaskId(subtaskId);	
				Subtask subtask =null;
				if(foundSubtask!=null) {
					log.info("PROJECT_MAN : SubtaskModule : update : found  Subtask: "+ foundSubtask);
					subtask =Utils.convertToSubtask(subtaskPersistRequest,foundSubtask);
					log.info("PROJECT_MAN : SubtaskModule : update : saving  Subtask: "+ subtask);
					repository.save(subtask);
				} else {
					subtask =Utils.convertToSubtask(subtaskPersistRequest,new Subtask());
					log.info("PROJECT_MAN : SubtaskModule : update : saving  new Subtask: "+ subtask);
					repository.save(subtask);
				}
			}
		}
	}
	
	public List<Subtask> findAll(){
		System.out.println("getting list of subtasks");
		List<Subtask> subtasks = (List<Subtask>) repository.findAll();
		System.out.println("got list of subtasks : " + subtasks);
		return subtasks;
	}
		


	public boolean existsById(Long subtaskId) {
		if(subtaskId!=null) {
		return repository.existsById(subtaskId);
		} else {
			return false;
		}
	}
	
	

	public List<Subtask> findAllById(Long subtaskId) {
		log.info("PROJECT_MAN : SubtaskModule : findAllById : subtaskId : "+ subtaskId);
		List<Subtask> subtasks = null;
		if(subtaskId!=null) {
			boolean res = repository.existsById(subtaskId);
			if(res) {
				log.info("PROJECT_MAN : SubtaskModule : findAllById : exists subtaskId : "+ subtaskId);
				List<Long> ids = new ArrayList();
				ids.add(subtaskId);
				subtasks = repository.findAllById(ids);
			}
			log.info("PROJECT_MAN : SubtaskModule : findAllById : subtasks found : "+ subtasks);
		}
		return subtasks;
	}


	public Subtask findBySubtaskId(Long subtaskId) {
		log.info("PROJECT_MAN : SubtaskModule : find : find subtaskId : "+ subtaskId);
		Subtask subtask =null;
		if(subtaskId!=null) {
			List<Subtask> subtasks = findAllById( subtaskId);
			if(subtasks!=null && ! subtasks.isEmpty()) {
				subtask = subtasks.get(0);
			}
		}
		log.info("PROJECT_MAN : SubtaskModule : find : subtask : "+ subtask);
		return subtask;
	}
	
	

	public void delete(Long subtaskId) {
		log.info("PROJECT_MAN : SubtaskModule : delete : find subtaskId : "+ subtaskId);
		if(subtaskId!=null) {
			Subtask subtask=findBySubtaskId(subtaskId);
			log.info("PROJECT_MAN : SubtaskModule : delete : subtask : "+ subtask);
			repository.delete(subtask);	
		}
	}


	public void update(Long subtaskId,Subtask theSubtask) {
		if(theSubtask != null && subtaskId!=null) {
			Subtask subtask =findBySubtaskId(subtaskId);
			subtask =Utils.updateSubtask(subtask,theSubtask);
			System.out.println("Saving Epic epicId: "+subtaskId);
			repository.save(subtask);
		}		
	}

}
