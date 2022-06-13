package be.intecbrussel.kaartje.repositories;

import be.intecbrussel.kaartje.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByCustomerId(Long customerId);

}
