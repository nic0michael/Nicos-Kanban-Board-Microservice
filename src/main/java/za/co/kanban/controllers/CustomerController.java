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

import za.co.kanban.dtos.CustomerPersistRequest;
import za.co.kanban.model.Customer;
import za.co.kanban.modules.CustomerModule;
import za.co.kanban.utils.Utils;

@Controller
@RequestMapping("/customers")
public class CustomerController {
	private static final Logger log = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private CustomerModule custmod;
	
	@GetMapping
	public String displayCustomers(Model model) {
		List<Customer> customers = custmod.findAll();
		model.addAttribute("customersList", customers);
		return "customers/list-customers";
	}

	@GetMapping("/list")
	public String displayHome(Model model) {
		List<Customer> customers = custmod.findAll();
		model.addAttribute("customersList", customers);
		return "customers/list-customers";
	}

	@GetMapping("/new")
	public String displayCustomerForm(Model model) {
		Customer customer=new Customer();
		CustomerPersistRequest  customertPersistRequest=Utils.convertToCustomerersistRequest(customer);
		model.addAttribute("customertPersistRequest", customertPersistRequest);
		return "customers/new-customer";
	}


	@PostMapping("/save")
	public String createCustomer(CustomerPersistRequest  customerPersistRequest,Model model) {
		log.info("PROJECT_MAN : CustomerController : createCustomer : saving customer from  CustomerPersistRequest: "+customerPersistRequest);
		
		if(StringUtils.isNotBlank(customerPersistRequest.getCustomerId() )  && StringUtils.isNumeric(customerPersistRequest.getCustomerId()) ) {
			log.info("PROJECT_MAN : CustomerController : createCustomer : updating customer");
			Customer theCustomer=Utils.convertToCustomer(customerPersistRequest);
			Long customerId=Long.parseLong(customerPersistRequest.getCustomerId());
			custmod.update(customerId,theCustomer);
		} else {
			log.info("PROJECT_MAN : CustomerController : createCustomer : saving new customer");
			Customer customer=Utils.convertToCustomer(customerPersistRequest);
			custmod.save(customer);		
		}
		// use a redirect to prevent duplicate submissions
		log.info("PROJECT_MAN : CustomerController : createCustomer : redirecting to customers page");
		return "redirect:/customers";
	}

	
	@GetMapping("/remove}")
	public String deleteCustomer(@RequestParam(value = "id") Long customerId) {
		custmod.delete(customerId);
		return "redirect:/projects";
	}
	

	@GetMapping("/change}")
	public String updateCustomer(@RequestParam(value = "id") Long customerId,Model model) {
		Customer customer=custmod.findByCustomerId(customerId);
		model.addAttribute("customer",customer);
		return "redirect:/customers/new";
	}

	@GetMapping("/maakdood")
	public String removeCustomer(@RequestParam(value = "id") Long customerId,Model model) {
		log.info("PROJECT_MAN : CustomerController : removeCustomer : to update project with project_id : "+customerId);
		custmod.delete(customerId);
		return "redirect:/customers";
	}
	
	@GetMapping("/verander")
	public String displayCustomertFormToUpdate(@RequestParam(value = "id") Long customerId,Model model) {
		log.info("PROJECT_MAN : CustomerController : displayCustomertFormToUpdate : to update project with project_id : "+customerId);		
		if(customerId!=null) {
			Customer customer=custmod.findByCustomerId(customerId);
			CustomerPersistRequest  customertPersistRequest=Utils.convertToCustomerersistRequest(customer);
			log.info("PROJECT_MAN : CustomerController : displayCustomertFormToUpdate : created CustomerPersistRequest : "+customertPersistRequest);
			model.addAttribute("customertPersistRequest", customertPersistRequest);
		}
		log.info("PROJECT_MAN : CustomerController : displayCustomertFormToUpdate : displaying form");
		return "customers/new-customer";	
	}

}
