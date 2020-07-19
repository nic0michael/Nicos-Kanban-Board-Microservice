package za.co.kanban.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.kanban.model.Contact;

public interface ContactRepository  extends JpaRepository<Contact, Long> {

	public Contact findByContactId(Long contactId);

}
