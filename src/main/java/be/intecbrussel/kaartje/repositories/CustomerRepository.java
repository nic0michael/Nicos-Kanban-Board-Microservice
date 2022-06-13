package za.co.kanban.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import za.co.kanban.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

	public Customer findByCustomerId(Long customerId);

}
