package za.co.kanban.modules;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import za.co.kanban.model.Contact;
import za.co.kanban.repositories.ContactRepository;

@Component
public class ContactModule {
	private static final Logger log = LoggerFactory.getLogger(ContactModule.class);
	
	@Autowired
	ContactRepository repository;

	public List<Contact> findAll() {
		System.out.println("getting list of Contacts");
		List<Contact> contactList = repository.findAll();
		return contactList;
	}

	public Contact findByContactId(Long contactId) {
		System.out.println("Finding contact contactId: "+contactId);
		Contact contact =null;
		if(contactId != null) {
			contact = repository.findByContactId(contactId);
		}
		return contact;
	}

	public void delete(Long contactId) {
		System.out.println("Deleting contact contactId: "+contactId);
		Contact contact =null;
		if(contactId != null) {
			contact = findByContactId(contactId);
			if(contact != null) {
				repository.delete(contact);
			}
		}		
	}
	
	public void save(Contact contact) {
		if(contact != null) {
			Long contactId = contact.getContactId();
			System.out.println("Saving contact contactId: "+contactId);
			repository.save(contact);
		}		
	}

}