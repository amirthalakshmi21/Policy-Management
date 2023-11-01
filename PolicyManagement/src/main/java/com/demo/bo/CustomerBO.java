package com.demo.bo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.dao.CustomerCustomized;
import com.demo.dao.CustomerRespository;
import com.demo.dao.PolicyCustomized;
import com.demo.entity.Customer;
import com.demo.exception.CustomerNameNotFoundException;
import com.demo.exception.CustomerNotFoundException;
import com.demo.exception.InvalidCustomerException;

@Component
public class CustomerBO {

	@Autowired
	/**
	*
	*customer
	*
	*/
	CustomerRespository recustomer;

	/**
	*
	*insert
	 * @throws CustomerNameNotFoundException 
	*
	*/
	public Customer insertCustomerDetails(Customer addCustomer) throws CustomerNameNotFoundException		 {
		if(addCustomer.getName()==null|| addCustomer.getName().isEmpty()) {
			throw new CustomerNameNotFoundException("Invalid customer data can you please provide a name");
			
		}
	
	return recustomer.save(addCustomer);
	}
	


		
		
			

	/**
	*
	*find by id
	*
	*/
	public Customer findCustomerDetails(Long id) throws CustomerNotFoundException{
		Optional<Customer> custom = recustomer.findById(id);
		if(custom.isPresent()) {
			return custom.get();
		}else {
			throw new CustomerNotFoundException("Customer id- "+id+" does not exist in the table");
		}
		
		
		
	}
	/**
	*
	*find all
	*
	*/
	public List<Customer> findAllCustomerDetails() throws CustomerNotFoundException {
		try {
			return recustomer.findAll();
		} catch (Exception e) {
			throw new CustomerNotFoundException("error occured while fetching the customers");
		}
		
	}

	/**
	*
	*update
	*
	*/
	public Customer updateCustomerDetails(Customer upCustomer) throws InvalidCustomerException {
		if(upCustomer.getGmail().isEmpty()) {
			throw new InvalidCustomerException("email format is wrong");
		}
		return recustomer.save(upCustomer);
	}

	/**
	*
	*query by id
	* 
	*/
	public List<Customer> findCustomerById(long customerId1) {
		return recustomer.findCustomerById(customerId1);
	}
	/**
	*
	*query by name
	*
	*/
	public List<Customer> findCustomerByName(String name1) {
		return recustomer.findCustomerByName(name1);

	}

	/**
	*
	*customized query
	*
	*/
	public List<CustomerCustomized> findCustomerNameCustomized(String name1) {
		return recustomer.findByCustomerNameCustomized(name1);

	}

	/**
	*
	*named query
	* 
	*/
	  public List<Customer> findAllOrderByNameDescending() {
		  return recustomer.findAllOrderByNameDescending();
	  
	  }
	  
	  /**
	  *
	  *inner join
	  * 
	  */	
		  public List<Customer> findCustomerWithPolicy() { return
		  recustomer.findCustomerWithPolicy(); }
		 
	 /**
	*
	*left join
	*
	*/
	  public List<Customer> findCustomerWithPoliciesLeft() { return
	  recustomer.findCustomerWithPoliciesLeft();
	  
	} 
		
	  /**
		*
		*customized join
		* 
		*/
	  public List<PolicyCustomized> findByCustomerPolicyCustomized() { return
		  recustomer.findByCustomerPolicyCustomized(); }

		 

	
	
}
