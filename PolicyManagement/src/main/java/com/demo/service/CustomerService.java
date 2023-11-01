package com.demo.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.demo.bo.CustomerBO;
import com.demo.bo.PolicyBO;
import com.demo.dao.CustomerCustomized;
import com.demo.dao.PolicyCustomized;
import com.demo.entity.Customer;
import com.demo.entity.Policy;
import com.demo.exception.CustomerNameNotFoundException;
import com.demo.exception.CustomerNotFoundException;
import com.demo.exception.InvalidCustomerException;
import com.demo.exception.PolicyNotFoundException;
import com.example.demo.PolicyManagementApplication;


@Component
public class CustomerService {

	@Autowired
	CustomerBO serviceBO;

	static Logger log = Logger.getLogger(PolicyManagementApplication.class.getName());
	
 
	
	/**
	 * @throws CustomerNameNotFoundException 
	*
	*
	* 
	*/
	public Customer insertServiceCustomer(Customer addCustomer) throws CustomerNameNotFoundException  {
		log.info("Insert method triggered..");
		try {
			log.info("Record inserted successfully..");
			log.info("Adding customer: " + addCustomer.getName());
			return serviceBO.insertCustomerDetails(addCustomer);
		} catch (CustomerNameNotFoundException e) {
			// TODO Auto-generated catch block
			log.error("Failed to add customer: " + e.getMessage());
			throw new CustomerNameNotFoundException("Invalid");
			
		}
		
	}

	/**
	 * @throws CustomerNotFoundException 
	*
	*
	* 
	*/
	public Customer findServiceCustomer(Long id) throws CustomerNotFoundException {
		log.info("fetch by id method triggered..");
		try {
			log.info("record fetched successfully..");
			return serviceBO.findCustomerDetails(id);
		} catch (CustomerNotFoundException e) {
			log.error("error occured while fetching records ");
			throw new CustomerNotFoundException("customer id is invalid");
		}
		
	}
	        
	/**
	 * @throws CustomerNotFoundException 
	*
	*
	* 
	*/
	public List<Customer> findAllServiceCustomer() throws CustomerNotFoundException {
		log.info("fetchall method triggered..");
		try {
			log.info("fetchall method triggered..");
			return serviceBO.findAllCustomerDetails();
		} catch (IllegalArgumentException e) {
			log.error("error occured while fetching ");
			throw new CustomerNotFoundException("customers data not found");
		}
	}
	/**
	 * @throws InvalidCustomerException 
	*
	*
	* 
	*/
	public Customer updateServiceCustomer(Customer upCustomer) throws InvalidCustomerException {
		try {
			return serviceBO.updateCustomerDetails(upCustomer);
		} catch (IllegalArgumentException e) {
			throw new InvalidCustomerException("Invalid data");
		}
	}
	
	@Autowired
	CustomerBO serviceBO1;

	@Autowired
	PolicyBO serviceBO2;

	@Transactional(propagation = Propagation.REQUIRED)
	/**
	*
	*
	* 
	*/
	public void transactionalDemo(Customer cdetails, Policy pdetails) throws CustomerNameNotFoundException,PolicyNotFoundException {
		System.out.println("customerdetails add------------before");
		serviceBO1.insertCustomerDetails(cdetails);
		System.out.println("customerdetails add------------after");
		System.out.println("policydetails add------------before");
		serviceBO2.insertPolicyDetails(pdetails);
		System.out.println("customerdetails add------------after");
	}

	/**
	*
	*by id
	* 
	*/

	public List<Customer> findServiceCustomerById(long customerId1) {
		return serviceBO.findCustomerById(customerId1);

	}

	/**
	*
	*by name
	* 
	*/
	public List<Customer> findServiceCustomerByName(String name1) {
		return serviceBO.findCustomerByName(name1);
	}

	/**
	*
	*customized
	* 
	*/
	public List<CustomerCustomized> findServiceCustomerByNameCustomized(String name1) {
		return serviceBO.findCustomerNameCustomized(name1);
	}

	
	/**
	*
	*named query
	* 
	*/
	  public List<Customer> findAllOrderByNameDescending() { 
		  return  serviceBO.findAllOrderByNameDescending(); }
	
	  /**
		*
		*inner join
		* 
		*/
	  public List<Customer> findCustomerWithPolicy() { return
	  serviceBO.findCustomerWithPolicy(); }
	 

	  /**
		*
		*outer join
		* 
		*/
	  public List<Customer> findCustomerWithPoliciesLeft() { return
	  serviceBO.findCustomerWithPoliciesLeft();
	  }
	  /**
		*
		*customized join
		* 
		*/
	  public List<PolicyCustomized> findByCustomerPolicyCustomized() { return
	  serviceBO.findByCustomerPolicyCustomized(); }
	  
	 

}
