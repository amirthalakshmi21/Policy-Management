package com.demo.bo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.dao.PolicyRespository;
import com.demo.entity.Policy;
import com.demo.exception.CustomerNameNotFoundException;
import com.demo.exception.EmptyPolicyTypeException;
import com.demo.exception.PolicyNotFoundException;

@Component
/**
*
*class
*
*/
public class PolicyBO {

			@Autowired
			PolicyRespository repolicy;
			/**
			*
			*add policy
			*
			*/
			
			public Policy insertPolicyDetails(Policy addpolicy)  {
			
				return repolicy.save(addpolicy);
			}
			
			/**
			*
			*find by id
			 * @throws PolicyNotFoundException 
			*
			*/
			public Policy findPolicyDetails(Integer id) throws PolicyNotFoundException {
				Optional<Policy> policydetails = repolicy.findById(id);
				if(policydetails.isPresent()) {
				return policydetails.get();	
				}else {
					throw new PolicyNotFoundException("Customer id- "+id+" does not exist in the table");
				}
				
			}
			/**
			*
			*find all
			*
			*/
			public List<Policy> findAllPolicyDetails() throws PolicyNotFoundException {
				try {
					return repolicy.findAll();
				} catch (Exception e) {
					throw new PolicyNotFoundException("error occured while fetching the customers");
				}
				
				
			}
			/**
			*
			*update 
			*
			*/
			public Policy updateCustomerDetails(Policy uppolicy) throws EmptyPolicyTypeException {
			    String policyType = uppolicy.getPolicyType();
			    
			    if (policyType == null || policyType.trim().isEmpty()) {
			        throw new EmptyPolicyTypeException("Policy type cannot be empty");
			    }

			    return repolicy.save(uppolicy);
			}

			


			
		

}


