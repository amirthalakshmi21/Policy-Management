package com.demo.response;

import java.util.List;

import com.demo.dao.CustomerCustomized;
import com.demo.dto.CustomerDTO;
import com.demo.dto.PolicyDTO;
import com.demo.entity.Customer;
import com.demo.entity.Policy;

public class ResponseObject {
   String successMessage;
   String failureMessage;
   
  private List<CustomerDTO> customerList;
  
	    public void setCustomerList(List<CustomerDTO> customerList) {
	this.customerList = customerList;
}
		private List<PolicyDTO> policyList;

	    public List<PolicyDTO> getPolicyList() {
	        return policyList;
	    }

	    public void setPolicyList(List<PolicyDTO> list) {
	        this.policyList = list;
	    }
	    private List<Policy> policyList1;
	    

public List<Policy> getPolicyList1() {
			return policyList1;
		}

		public void setPolicyList1(List<Policy> singletonList) {
			this.policyList1 = policyList1;
		}

public String getSuccessMessage() {
	return successMessage;
}
public void setSuccessMessage(String successMessage) {
	this.successMessage = successMessage;
}
public String getFailureMessage() {
	return failureMessage;
}
public void setFailureMessage(String failureMessage) {
	this.failureMessage = failureMessage;
}

public List<CustomerDTO> getCustomerList() {
	return customerList;
}




public void setCustomizedList(List<CustomerCustomized> customized) {
	// TODO Auto-generated method stub
	
}




}







   