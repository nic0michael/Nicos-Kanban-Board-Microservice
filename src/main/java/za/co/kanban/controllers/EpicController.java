package za.co.kanban.controllers;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import za.co.kanban.dtos.EpicPersistRequest;
import za.co.kanban.model.Epic;
import za.co.kanban.modules.EpicModule;
import za.co.kanban.utils.Utils;

@Controller
@RequestMapping("/epics")
public class EpicController {
	private static final Logger log = LoggerFactory.getLogger(EpicController.class);

	@Autowired
	private EpicModule custmod;
	
	@GetMapping
	public String displayEpics(Model model) {
		List<Epic> epics = custmod.findAll();
		model.addAttribute("epicsList", epics);
		return "epics/list-epics";
	}

	@GetMapping("/list")
	public String displayHome(Model model) {
		List<Epic> epics = custmod.findAll();
		model.addAttribute("epicsList", epics);
		return "epics/list-epics";
	}

	@GetMapping("/new")
	public String displayEpicForm(Model model) {
		Epic epic=new Epic();
		EpicPersistRequest  epictPersistRequest=Utils.convertToEpicPersistRequest(epic);
		model.addAttribute("epictPersistRequest", epictPersistRequest);
		return "epics/new-epic";
	}


	@PostMapping("/save")
	public String createEpic(EpicPersistRequest  epicPersistRequest,Model model) {
		log.info("PROJECT_MAN : EpicController : createEpic : saving epic from  EpicPersistRequest: "+epicPersistRequest);
		
		if(StringUtils.isNotBlank(epicPersistRequest.getEpicId() )  && StringUtils.isNumeric(epicPersistRequest.getEpicId()) ) {
			log.info("PROJECT_MAN : EpicController : createEpic : updating epic");
			Epic theEpic=Utils.convertToEpic(epicPersistRequest);
			Long epicId=Long.parseLong(epicPersistRequest.getEpicId());
			custmod.update(epicId,theEpic);
		} else {
			log.info("PROJECT_MAN : EpicController : createEpic : saving new epic");
			Epic epic=Utils.convertToEpic(epicPersistRequest);
			custmod.save(epic);		
		}
		// use a redirect to prevent duplicate submissions
		log.info("PROJECT_MAN : EpicController : createEpic : redirecting to epics page");
		return "redirect:/epics";
	}

	
	@GetMapping("/remove}")
	public String deleteEpic(@RequestParam(value = "id") Long epicId) {
		custmod.delete(epicId);
		return "redirect:/projects";
	}
	

	@GetMapping("/change}")
	public String updateEpic(@RequestParam(value = "id") Long epicId,Model model) {
		Epic epic=custmod.findByEpicId(epicId);
		model.addAttribute("epic",epic);
		return "redirect:/epics/new";
	}

	@GetMapping("/maakdood")
	public String removeEpic(@RequestParam(value = "id") Long epicId,Model model) {
		log.info("PROJECT_MAN : EpicController : removeEpic : to update project with project_id : "+epicId);
		custmod.delete(epicId);
		return "redirect:/epics";
	}
	
	@GetMapping("/verander")
	public String displayEpictFormToUpdate(@RequestParam(value = "id") Long epicId,Model model) {
		log.info("PROJECT_MAN : EpicController : displayEpictFormToUpdate : to update project with project_id : "+epicId);		
		if(epicId!=null) {
			Epic epic=custmod.findByEpicId(epicId);
			EpicPersistRequest  epictPersistRequest=Utils.convertToEpicPersistRequest(epic);
			log.info("PROJECT_MAN : EpicController : displayEpictFormToUpdate : created EpicPersistRequest : "+epictPersistRequest);
			model.addAttribute("epictPersistRequest", epictPersistRequest);
		}
		log.info("PROJECT_MAN : EpicController : displayEpictFormToUpdate : displaying form");
		return "epics/new-epic";	
	}

}