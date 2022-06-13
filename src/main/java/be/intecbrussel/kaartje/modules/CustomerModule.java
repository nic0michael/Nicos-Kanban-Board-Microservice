package be.intecbrussel.kaartje.modules;

import be.intecbrussel.kaartje.model.Customer;
import be.intecbrussel.kaartje.repositories.CustomerRepository;
import be.intecbrussel.kaartje.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerModule {
    private static final Logger log = LoggerFactory.getLogger(CustomerModule.class);

    @Autowired
    CustomerRepository repository;

    public List<Customer> findAll() {
        System.out.println("getting list of Customers");
        List<Customer> customerList = repository.findAll();
        return customerList;
    }

    public Customer findByCustomerId(Long customerId) {
        System.out.println("Finding customer customerId: " + customerId);
        Customer customer = null;
        if (customerId != null) {
            customer = repository.findByCustomerId(customerId);
        }
        return customer;
    }

    public void delete(Long customerId) {
        System.out.println("Deleting customer customerId: " + customerId);
        Customer customer = null;
        if (customerId != null) {
            customer = findByCustomerId(customerId);
            if (customer != null) {
                repository.delete(customer);
            }
        }
    }

    public void save(Customer customer) {
        if (customer != null) {
            Long customerId = customer.getCustomerId();
            System.out.println("Saving customer customerId: " + customerId);
            repository.save(customer);
        }
    }

    public void update(Long contactId, Customer theCustomer) {
        if (theCustomer != null && contactId != null) {
            Customer customer = findByCustomerId(contactId);
            customer = Utils.updateCustomer(customer, theCustomer);
            System.out.println("Saving contact contactId: " + contactId);
            repository.save(customer);
        }
    }

}