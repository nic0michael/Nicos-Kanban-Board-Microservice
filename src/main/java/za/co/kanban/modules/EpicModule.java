package za.co.kanban.modules;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import za.co.kanban.model.Epic;
import za.co.kanban.repositories.EpicRepository;

@Component
public class EpicModule {
	private static final Logger log = LoggerFactory.getLogger(EpicModule.class);
	
	@Autowired
	EpicRepository repository;

	public List<Epic> findAll() {
		System.out.println("getting list of Epics");
		List<Epic> epicList = repository.findAll();
		return epicList;
	}

	public Epic findByEpicId(Long epicId) {
		System.out.println("Finding epic epicId: "+epicId);
		Epic epic =null;
		if(epicId != null) {
			epic = repository.findByEpicId(epicId);
		}
		return epic;
	}

	public void delete(Long epicId) {
		System.out.println("Deleting epic epicId: "+epicId);
		Epic epic =null;
		if(epicId != null) {
			epic = findByEpicId(epicId);
			if(epic != null) {
				repository.delete(epic);
			}
		}		
	}
	
	public void save(Epic epic) {
		if(epic != null) {
			Long epicId = epic.getEpicId();
			System.out.println("Saving epic epicId: "+epicId);
			repository.save(epic);
		}		
	}

}