package com.demo.entity;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonBackReference;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Policy")
@EntityListeners(AuditingEntityListener.class)
public class Policy {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int policyId;
		public int getPolicyId() {
			return policyId;
		}

		public void setPolicyId(int policyId) {
			this.policyId = policyId;
		}


		@Column(name = "policyType")
		private String policyType;
		public String getPolicyType() {
			return policyType;
		}

		public void setPolicyType(String policyType) {
			this.policyType = policyType;
		}

		@NotNull
		@Column(nullable = false)
		@Temporal(TemporalType.DATE)
		private Date policyStartDate;
		
		

		public Date getPolicyStartDate() {
			return policyStartDate;
		}

		public void setPolicyStartDate(Date policyStartDate) {
			this.policyStartDate = policyStartDate;
		}


		@NotNull
		@Column(nullable = false)
		@Temporal(TemporalType.DATE)
		private Date policyEndDate;

		
		
		public Date getPolicyEndDate() {
			return policyEndDate;
		}

		public void setPolicyEndDate(Date policyEndDate) {
			this.policyEndDate = policyEndDate;
		}


		@Column(nullable = false, updatable = false)
		@Temporal(TemporalType.TIMESTAMP)
		@CreatedDate
		private Date createdAt;

		public Date getCreatedAt() {
			return createdAt;
		}

		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}

		@Column(nullable = false)
		@Temporal(TemporalType.TIMESTAMP)
		@LastModifiedDate
		private Date updatedAt;

		public Date getUpdatedAt() {
			return updatedAt;
		}

		public void setUpdatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
		}


		@JsonBackReference
		@ManyToOne(fetch = FetchType.EAGER)
		@JoinColumn(name = "customerId",unique = false,nullable = false,referencedColumnName = "customerId")
		Customer customer;
		
		

		public Customer getCustomer() {
			return customer;
		}

		public void setCustomer(Customer customer) {
			this.customer = customer;
		}

		@Override
		public String toString() {
			return "Policy [policyId=" + policyId + ", policyType=" + policyType + ", policyStartDate="
					+ policyStartDate + ", policyEndDate=" + policyEndDate + ", createdAt=" + createdAt + ", updatedAt="
					+ updatedAt + "]";
		}

		

		
		
	}



