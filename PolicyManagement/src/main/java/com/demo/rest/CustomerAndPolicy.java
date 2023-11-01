package com.demo.rest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dao.CustomerCustomized;
import com.demo.dao.PolicyCustomized;
import com.demo.dto.CustomerDTO;
import com.demo.dto.PolicyDTO;
import com.demo.entity.Customer;
import com.demo.entity.Policy;
import com.demo.exception.CustomerNotFoundException;
import com.demo.exception.EmptyPolicyTypeException;
import com.demo.exception.PolicyNotFoundException;
import com.demo.response.ResponseObject;
import com.demo.service.CustomerService;
import com.demo.service.PolicyService;

@CrossOrigin
@RestController

public class CustomerAndPolicy {

	@Autowired
	CustomerService service;

	@Autowired
	PolicyService service1;
	


	@RequestMapping(value = "/createCustomer", method = RequestMethod.POST)
	@CrossOrigin(origins = "http://localhost:3000") 
	 public ResponseObject addCustomer(@RequestBody CustomerDTO msg) {

		
       
		ResponseObject responseObject = new ResponseObject();
		
		try {
		System.out.println("name:" + msg.getName());
		System.out.println("dateOfBirth: " + msg.getDateOfBirth()); // NOPMD by ELCOT on 29/07/23, 4:39 am
		System.out.println("phoneNumber: " + msg.getPhoneNumber());
		System.out.println("gmail: " + msg.getGmail());
		System.out.println("city: " + msg.getCity());

		Customer customer = new Customer();
		customer.setName(msg.getName());
		customer.setDateOfBirth(msg.getDateOfBirth());
		customer.setPhoneNumber(msg.getPhoneNumber());
		customer.setGmail(msg.getGmail());
		customer.setCity(msg.getCity());

		Customer custom = service.insertServiceCustomer(customer);

		msg.setCustomerId(custom.getCustomerId());
		msg.setCreatedAt(custom.getCreatedAt());
		msg.setUpdatedAt(custom.getUpdatedAt());

		responseObject.setSuccessMessage("customer added successfully");
		return responseObject;
		}
		catch(Exception e) {
			responseObject.setFailureMessage("failed to add customer");
			return  responseObject;
		}
		
		  
    }
		

	@RequestMapping(value = "/fetchCustomerById", method = RequestMethod.GET)
	 @CrossOrigin(origins = "http://localhost:3000") 
	public ResponseObject fetchCustomer(@RequestParam Long customerId)  {


		ResponseObject responseObject = new ResponseObject();
		
		
			try {
				
			System.out.println("Customer Id:" + customerId);
			Customer c = service.findServiceCustomer(new Long(customerId));
			if(c == null) {
				responseObject.setFailureMessage("customer id does not exist");
				return responseObject;
			}
			CustomerDTO dto = new CustomerDTO();
			dto.setCreatedAt(c.getCreatedAt());
			dto.setUpdatedAt(c.getUpdatedAt());
			dto.setName(c.getName());
			dto.setCity(c.getCity());
			dto.setGmail(c.getGmail());
			dto.setPhoneNumber(c.getPhoneNumber());
			dto.setDateOfBirth(c.getDateOfBirth());
			dto.setCustomerId(c.getCustomerId());
			responseObject.setSuccessMessage("customer fetched successfully");
			responseObject.setCustomerList(Collections.singletonList(dto));
			
			} catch(Exception e) {
	
				responseObject.setFailureMessage("error occured while fetching the customer");
				return responseObject;
			}
			return responseObject;
		}


	@RequestMapping(value = "/findAllCustomer", method = RequestMethod.GET)
	 @CrossOrigin(origins = "http://localhost:3000") 
	public ResponseObject findAllServiceCustomer() {
		
		ResponseObject responseObject = new ResponseObject();
		
		try {
		List<Customer> customers = service.findAllServiceCustomer();
		
		if(customers.isEmpty()) {
			responseObject.setFailureMessage("no customer found");
			return responseObject;
		}
				List<CustomerDTO> dtos = new ArrayList<>();
		
		for (Customer c : customers) {
			CustomerDTO dto = new CustomerDTO();
			dto.setCustomerId(c.getCustomerId());
			dto.setName(c.getName());
			dto.setDateOfBirth(c.getDateOfBirth());
			dto.setGmail(c.getGmail());
			dto.setPhoneNumber(c.getPhoneNumber());
			dto.setCreatedAt(c.getCreatedAt());
			dto.setUpdatedAt(c.getUpdatedAt());
			dto.setCity(c.getCity());

			dtos.add(dto);

		} 
		responseObject.setSuccessMessage("customers fetched successfully");
		responseObject.setCustomerList(dtos);
		return responseObject;
		} catch (Exception e) {
			responseObject.setFailureMessage("customer does not found");
			return responseObject;
		}
		
    }
	
	@RequestMapping(value = "/updateCustomer/{cid}", method = RequestMethod.POST)
	@CrossOrigin(origins = "http://localhost:3000")
	public ResponseObject updateCustomer(@PathVariable("cid") long customerId, @RequestBody CustomerDTO msg) {
	    ResponseObject responseObject = new ResponseObject();

	    try {
	        // Step 1: Retrieve the existing customer
	        Customer existingCustomer = service.findServiceCustomer(customerId);

	        if (existingCustomer == null) {
	            responseObject.setFailureMessage("Customer not found");
	            return responseObject;
	        }

	        // Step 2: Update the fields of the existing customer
	        existingCustomer.setName(msg.getName());
	        existingCustomer.setPhoneNumber(msg.getPhoneNumber());
	        existingCustomer.setGmail(msg.getGmail());
	        existingCustomer.setDateOfBirth(msg.getDateOfBirth());
	        existingCustomer.setCity(msg.getCity());

	        // Step 3: Save the updated customer back to the database
	        Customer updatedCustomer = service.updateServiceCustomer(existingCustomer);

	        // Prepare the response
	        CustomerDTO updatedCustomerDTO = new CustomerDTO();
	        updatedCustomerDTO.setCustomerId(updatedCustomer.getCustomerId());
	        updatedCustomerDTO.setName(updatedCustomer.getName());
	        updatedCustomerDTO.setPhoneNumber(updatedCustomer.getPhoneNumber());
	        updatedCustomerDTO.setGmail(updatedCustomer.getGmail());
	        updatedCustomerDTO.setDateOfBirth(updatedCustomer.getDateOfBirth());
	        updatedCustomerDTO.setCity(updatedCustomer.getCity());
	        updatedCustomerDTO.setCreatedAt(updatedCustomer.getCreatedAt());
	        updatedCustomerDTO.setUpdatedAt(updatedCustomer.getUpdatedAt());

	        responseObject.setSuccessMessage("Customer updated successfully");
	        responseObject.setCustomerList(Collections.singletonList(updatedCustomerDTO));

	        return responseObject;
	    } catch (Exception e) {
	        responseObject.setFailureMessage("Failed to update customer");
	        return responseObject;
	    }
	}


	
	/*
	 * @RequestMapping(value = "/updateCustomer/{cid}", method = RequestMethod.POST)
	 * 
	 * @CrossOrigin(origins = "http://localhost:3000") public ResponseObject
	 * updateCustomer(@PathVariable("cid") long customerId, @RequestBody CustomerDTO
	 * msg) {
	 * 
	 * ResponseObject responseObject = new ResponseObject(); try {
	 * System.out.println("Name: " + msg.getName()); // NOPMD by ELCOT on 29/07/23,
	 * 4:40 am System.out.println("PhoneNumber: " + msg.getPhoneNumber());
	 * System.out.println("Gmail " + msg.getGmail());
	 * System.out.println("DateOfBirth: " + msg.getDateOfBirth());
	 * System.out.println("City: " + msg.getCity());
	 * 
	 * Customer c = service.findServiceCustomer(customerId); if(c == null) {
	 * responseObject.setFailureMessage("customer not found"); return
	 * responseObject;
	 * 
	 * }
	 * 
	 * Customer updatedCustomer = service.updateServiceCustomer(c);
	 * 
	 * CustomerDTO updatedCustomerDTO = new CustomerDTO();
	 * updatedCustomerDTO.setCustomerId(updatedCustomer.getCustomerId());
	 * updatedCustomerDTO.setName(updatedCustomer.getName());
	 * updatedCustomerDTO.setPhoneNumber(updatedCustomer.getPhoneNumber());
	 * updatedCustomerDTO.setGmail(updatedCustomer.getGmail());
	 * updatedCustomerDTO.setDateOfBirth(updatedCustomer.getDateOfBirth());
	 * updatedCustomerDTO.setCity(updatedCustomer.getCity());
	 * updatedCustomerDTO.setCreatedAt(updatedCustomer.getCreatedAt());
	 * updatedCustomerDTO.setUpdatedAt(updatedCustomer.getUpdatedAt());
	 * 
	 * responseObject.setSuccessMessage("customer updated successfully");
	 * 
	 * responseObject.setCustomerList(Collections.singletonList(updatedCustomerDTO))
	 * ;
	 * 
	 * return responseObject; } catch (Exception e) {
	 * responseObject.setFailureMessage("failed to update"); return responseObject;
	 * }
	 * 
	 * 
	 * }
	 */

	
	@RequestMapping(value = "/createPolicy", method = RequestMethod.POST)
	@CrossOrigin(origins = "http://localhost:3000")
	public ResponseObject addPolicy(@RequestBody Policy msg) throws CustomerNotFoundException, PolicyNotFoundException {
	    ResponseObject responseObject = new ResponseObject();

	    try {
	        if (msg.getPolicyType() == null || msg.getPolicyType().isEmpty()) {
	            throw new PolicyNotFoundException("Please enter policy type.");
	        }

	        System.out.println("policyType:" + msg.getPolicyType());
	        System.out.println("policyStartDate: " + msg.getPolicyStartDate());
	        System.out.println("policyEndDate: " + msg.getPolicyEndDate());
	        System.out.println("customer id:" + msg.getCustomer().getCustomerId());

	        Customer c1 = service.findServiceCustomer(msg.getCustomer().getCustomerId());
	        System.out.println("Customer Response ----> " + c1);

	        Policy policy = new Policy();
	        policy.setPolicyType(msg.getPolicyType());
	        policy.setPolicyStartDate(msg.getPolicyStartDate());
	        policy.setPolicyEndDate(msg.getPolicyEndDate());

	        Policy response = service1.insertServicePolicy(msg);
	        System.out.println("Policy Added Successfully");

	        responseObject.setSuccessMessage("Policy added successfully");
	        return responseObject;
	    } catch (PolicyNotFoundException e) {
	        responseObject.setFailureMessage(e.getMessage());
	        return responseObject;
	    } catch (Exception e) {
	        responseObject.setFailureMessage("Failed to add policy");
	        return responseObject;
	    }
	}


	@RequestMapping(value = "/fetchPolicyById", method = RequestMethod.GET)
	public ResponseObject fetchPolicy(@RequestParam int policyId) {
	    ResponseObject responseObject = new ResponseObject();

	    try {
	        System.out.println("Policy ID: " + policyId);

	        Policy policy = service1.findServicePolicy(policyId);
	        if (policy == null) {
	            responseObject.setFailureMessage("Policy ID does not exist");
	            return responseObject;
	        }

	        // Create a PolicyDTO and populate it with policy details
	        PolicyDTO policyDTO = new PolicyDTO();
	        policyDTO.setPolicyId(policy.getPolicyId());
	        policyDTO.setPolicyType(policy.getPolicyType());
	        policyDTO.setPolicyStartDate(policy.getPolicyStartDate());
	        policyDTO.setPolicyEndDate(policy.getPolicyEndDate());
	        policyDTO.setCreatedAt(policy.getCreatedAt());
	        policyDTO.setUpdatedAt(policy.getUpdatedAt());
	        // Set other fields as needed

	        responseObject.setSuccessMessage("Policy fetched successfully...");
	        responseObject.setPolicyList(Collections.singletonList(policyDTO));
	        System.out.println("Policy fetched successfully");
	        return responseObject;
	    } catch (Exception e) {
	        responseObject.setFailureMessage("Error occurred while fetching the policy");
	        return responseObject;
	    }
	}


	/*
	 * @RequestMapping(value = "/fetchPolicyById", method = RequestMethod.GET)
	 * public PolicyDTO fetchPolicy(@RequestParam int policyId) {
	 * System.out.println("Policy Id:" + policyId); Policy p =
	 * service1.findServicePolicy(new Integer(policyId)); PolicyDTO dto = new
	 * PolicyDTO(); dto.setCreatedAt(p.getCreatedAt());
	 * dto.setUpdatedAt(p.getUpdatedAt()); dto.setPolicyId(p.getPolicyId());
	 * dto.setPolicyType(p.getPolicyType());
	 * dto.setPolicyStartDate(p.getPolicyStartDate());
	 * dto.setPolicyEndDate(p.getPolicyEndDate());
	 * 
	 * return dto;
	 * 
	 * }
	 */

	
	/*
	 * @RequestMapping(value = "/findAllPolicy", method = RequestMethod.GET) public
	 * ResponseObject findAllServicePolicy() { ResponseObject responseObject = new
	 * ResponseObject();
	 * 
	 * try { List<Policy> policies = service1.findAllServicePolicy();
	 * 
	 * if(policies.isEmpty()) { responseObject.setFailureMessage("no policy found");
	 * return responseObject; }
	 * 
	 * 
	 * List<PolicyDTO> dtos = new ArrayList<>(); for (Policy p : policies) {
	 * PolicyDTO dto = new PolicyDTO(); dto.setCreatedAt(p.getCreatedAt());
	 * dto.setUpdatedAt(p.getUpdatedAt()); dto.setPolicyId(p.getPolicyId());
	 * dto.setPolicyType(p.getPolicyType());
	 * dto.setPolicyStartDate(p.getPolicyStartDate());
	 * dto.setPolicyEndDate(p.getPolicyEndDate());
	 * 
	 * 
	 * 
	 * dtos.add(dto);
	 * 
	 * } responseObject.setSuccessMessage("policy details fetched successfully");
	 * responseObject.setPolicyList(dtos); return responseObject; } catch (Exception
	 * e) { responseObject.setFailureMessage("policy details does not found");
	 * return responseObject; } }
	 */
	 


	
	  @RequestMapping(value = "/fetchAllPolicies", method = RequestMethod.GET)
	  public List<Policy> fetchAllPolicies() throws PolicyNotFoundException { 
		  List<Policy> fetchAll = service1.findAllServicePolicy();
		  return fetchAll; 
		  }
	 
	
	  @RequestMapping(value = "/updatePolicy/{cid}", method = RequestMethod.POST)
	  public ResponseObject updatePolicy(@PathVariable("cid") int policyId, @RequestBody Policy updatedPolicy) {
	      ResponseObject responseObject = new ResponseObject();

	      try {
	          System.out.println("" + updatedPolicy.getPolicyType());

	          Policy policy1 = service1.findServicePolicy(policyId);

	          if (policy1 == null) {
	              responseObject.setFailureMessage("Policy not found");
	              return responseObject;
	          }

	          String updatedPolicyType = updatedPolicy.getPolicyType();

	          if (updatedPolicyType == null || updatedPolicyType.trim().isEmpty()) {
	              responseObject.setFailureMessage("Policy type cannot be empty");
	              return responseObject;
	          }

	          policy1.setPolicyType(updatedPolicyType);

	          Policy result = service1.updateServicePolicy(policy1);
	          responseObject.setSuccessMessage("Policy updated successfully");

	          // Include the updated policy in the response
	          responseObject.setPolicyList1(Collections.singletonList(result));

	          System.out.println("Policy updated successfully.");

	          return responseObject;
	      } catch (EmptyPolicyTypeException e) {
	          responseObject.setFailureMessage("Policy type cannot be empty");
	          return responseObject;
	      } catch (Exception e) {
	          responseObject.setFailureMessage("An error occurred while updating the policy");
	          return responseObject;
	      }
	  }

	

	//id
	    @RequestMapping(value = "/greaterThanGivenId", method = RequestMethod.GET)
	    @CrossOrigin(origins = "http://localhost:3000")
	    public List<Customer> getCustomersById(@RequestParam Long customerId) {
	        List<Customer> greaterThan = service.findServiceCustomerById(customerId);
	        return greaterThan;
	    }

		/*
		 * @RequestMapping(value = "/greaterThanGivenId", method = RequestMethod.GET)
		 * 
		 * @CrossOrigin(origins = "http://localhost:3000") public ResponseObject
		 * getCustomersById(@RequestParam Long customerId) { List<Customer> greaterThan
		 * = service.findServiceCustomerById(customerId);
		 * 
		 * return new ResponseObject();
		 * 
		 * }
		 */

	//name
	 @RequestMapping(value = "/findByName", method = RequestMethod.GET)
	 @CrossOrigin(origins = "http://localhost:3000") 
	    public ResponseObject findCustomerByName(@RequestParam String name) {
	        List<Customer> byname = service.findServiceCustomerByName(name);
	      
	            return new ResponseObject();
	        
	    }

	 //customized
	 @RequestMapping(value = "/findByNameCustomized", method = RequestMethod.GET)
	 @CrossOrigin(origins = "http://localhost:3000") 
	    public ResponseObject findCustomerByNameCustomized(@RequestParam String name) {
	        List<CustomerCustomized> customized = service.findServiceCustomerByNameCustomized(name);
	        
	            return new ResponseObject();
	        
	    }

	 //named query Descending order
	 @RequestMapping(value = "/findAllOrderByNameDescending", method = RequestMethod.GET)
	 @CrossOrigin(origins = "http://localhost:3000") 
	    public ResponseObject findAllOrderByNameDescending() {
	        List<Customer> descending = service.findAllOrderByNameDescending();
	   
	        
	            return new ResponseObject();
	       
	    }
	 
	  //inner join
	 @RequestMapping(value = "/findCustomerWithPolicy", method = RequestMethod.GET)
	    public ResponseObject findCustomerWithPolicy() {
	        List<Customer> customerpolicy = service.findCustomerWithPolicy();
	       
	            return new ResponseObject();
	       
	    }
	  
	  //left join
	 @RequestMapping(value = "/findCustomerWithPoliciesLeft", method = RequestMethod.GET)
	    public ResponseObject findCustomerWithPoliciesLeft() {
	        List<Customer> leftjoin = service.findCustomerWithPoliciesLeft();
	      
	            return new ResponseObject();
	        
	    }

	  //customized join
	 @RequestMapping(value = "/findByCustomerPolicyCustomized", method = RequestMethod.GET)
	    public ResponseObject findByCustomerPolicyCustomized() {
	        List<PolicyCustomized> customized = service.findByCustomerPolicyCustomized();
	        
	            return new ResponseObject();
	        
	    }
	 
	
}