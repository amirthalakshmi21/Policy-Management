package com.demo.dto;

import java.util.Date;

public class PolicyDTO {
	
	 private int policyId;
	    private String policyType;
	    private Date policyStartDate;
	    private Date policyEndDate;
	    private Date createdAt;
	    private Date updatedAt;
		public int getPolicyId() {
			return policyId;
		}
		public void setPolicyId(int policyId) {
			this.policyId = policyId;
		}
		public String getPolicyType() {
			return policyType;
		}
		public void setPolicyType(String policyType) {
			this.policyType = policyType;
		}
		public Date getPolicyStartDate() {
			return policyStartDate;
		}
		public void setPolicyStartDate(Date policyStartDate) {
			this.policyStartDate = policyStartDate;
		}
		public Date getPolicyEndDate() {
			return policyEndDate;
		}
		public void setPolicyEndDate(Date policyEndDate) {
			this.policyEndDate = policyEndDate;
		}
		public Date getCreatedAt() {
			return createdAt;
		}
		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}
		public Date getUpdatedAt() {
			return updatedAt;
		}
		public void setUpdatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
		}
		@Override
		public String toString() {
			return "PolicyDTO [policyId=" + policyId + ", policyType=" + policyType + ", policyStartDate="
					+ policyStartDate + ", policyEndDate=" + policyEndDate + ", createdAt=" + createdAt + ", updatedAt="
					+ updatedAt + "]";
		}
		
	    
}