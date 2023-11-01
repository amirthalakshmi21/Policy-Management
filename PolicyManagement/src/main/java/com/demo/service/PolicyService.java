package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.demo.bo.PolicyBO;
import com.demo.entity.Customer;
import com.demo.entity.Policy;
import com.demo.exception.CustomerNotFoundException;
import com.demo.exception.EmptyPolicyTypeException;
import com.demo.exception.PolicyNotFoundException;

@Component
public class PolicyService {
	@Autowired
	PolicyBO serviceBO;
	/**
	*
	*insert
	* 
	*/
	public Policy insertServicePolicy(Policy addPolicy) {
		
		
		return serviceBO.insertPolicyDetails(addPolicy);
		
		}
	
	
	public Policy findServicePolicy(Integer id) throws PolicyNotFoundException {
		try {
			return serviceBO.findPolicyDetails(id);
		} catch (PolicyNotFoundException e) {
			throw new PolicyNotFoundException("policy id is invalid");
		}
		
	}
	/**
	*
	*find all
	 * @throws CustomerNotFoundException 
	* 
	*/
	public List<Policy> findAllServicePolicy()throws PolicyNotFoundException {
		try {
			return serviceBO.findAllPolicyDetails();
		} catch (IllegalArgumentException e) {
			throw new PolicyNotFoundException("Policy data not found");
		} 
	}
	/**
	*
	*update
	 * @throws EmptyPolicyTypeException 
	* 
	*/
	public Policy updateServicePolicy(Policy upPolicy) throws EmptyPolicyTypeException {
		try {
			return serviceBO.updateCustomerDetails(upPolicy);
		} catch (Exception e) {
			throw new EmptyPolicyTypeException("Invalid policy type");
		}
	}
	


	
}



