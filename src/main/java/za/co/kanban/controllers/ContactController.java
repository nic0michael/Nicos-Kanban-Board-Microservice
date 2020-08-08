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

import za.co.kanban.dtos.ContactPersistRequest;
import za.co.kanban.model.Contact;
import za.co.kanban.modules.ContactModule;
import za.co.kanban.utils.Utils;


@Controller
@RequestMapping("/contacts")
public class ContactController {
	private static final Logger log = LoggerFactory.getLogger(ContactController.class);

	@Autowired
	private ContactModule custmod;
	
	@GetMapping
	public String displayContacts(Model model) {
		List<Contact> contacts = custmod.findAll();
		model.addAttribute("contactsList", contacts);
		return "contacts/list-contacts";
	}

	@GetMapping("/list")
	public String displayHome(Model model) {
		List<Contact> contacts = custmod.findAll();
		model.addAttribute("contactsList", contacts);
		return "contacts/list-contacts";
	}

	@GetMapping("/new")
	public String displayContactForm(Model model) {
		Contact contact=new Contact();
		ContactPersistRequest  contacttPersistRequest=Utils.convertToContactPersistRequest(contact);
		model.addAttribute("contacttPersistRequest", contacttPersistRequest);
		return "contacts/new-contact";
	}


	@PostMapping("/save")
	public String createContact(ContactPersistRequest  contactPersistRequest,Model model) {
		log.info("PROJECT_MAN : ContactController : createContact : saving contact from  ContactPersistRequest: "+contactPersistRequest);
		
		if(StringUtils.isNotBlank(contactPersistRequest.getContactId() )  && StringUtils.isNumeric(contactPersistRequest.getContactId()) ) {
			log.info("PROJECT_MAN : ContactController : createContact : updating contact");
			Contact theContact=Utils.convertToContact(contactPersistRequest);
			Long contactId=Long.parseLong(contactPersistRequest.getContactId());
			custmod.update(contactId,theContact);
		} else {
			log.info("PROJECT_MAN : ContactController : createContact : saving new contact");
			Contact contact=Utils.convertToContact(contactPersistRequest);
			custmod.save(contact);		
		}
		// use a redirect to prevent duplicate submissions
		log.info("PROJECT_MAN : ContactController : createContact : redirecting to contacts page");
		return "redirect:/contacts";
	}

	
	@GetMapping("/remove}")
	public String deleteContact(@RequestParam(value = "id") Long contactId) {
		custmod.delete(contactId);
		return "redirect:/projects";
	}
	

	@GetMapping("/change}")
	public String updateContact(@RequestParam(value = "id") Long contactId,Model model) {
		Contact contact=custmod.findByContactId(contactId);
		model.addAttribute("contact",contact);
		return "redirect:/contacts/new";
	}

	@GetMapping("/maakdood")
	public String removeContact(@RequestParam(value = "id") Long contactId,Model model) {
		log.info("PROJECT_MAN : ContactController : removeContact : to update project with project_id : "+contactId);
		custmod.delete(contactId);
		return "redirect:/contacts";
	}
	
	@GetMapping("/verander")
	public String displayContacttFormToUpdate(@RequestParam(value = "id") Long contactId,Model model) {
		log.info("PROJECT_MAN : ContactController : displayContacttFormToUpdate : to update project with project_id : "+contactId);		
		if(contactId!=null) {
			Contact contact=custmod.findByContactId(contactId);
			ContactPersistRequest  contacttPersistRequest=Utils.convertToContactPersistRequest(contact);
			log.info("PROJECT_MAN : ContactController : displayContacttFormToUpdate : created ContactPersistRequest : "+contacttPersistRequest);
			model.addAttribute("contacttPersistRequest", contacttPersistRequest);
		}
		log.info("PROJECT_MAN : ContactController : displayContacttFormToUpdate : displaying form");
		return "contacts/new-contact";	
	}

}
