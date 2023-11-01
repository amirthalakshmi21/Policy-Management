package com.demo.dto;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

public class CustomerDTO {
	private Long customerId;
	
	private String name;
	
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date dateOfBirth;
	
	private long phoneNumber;
	
	private String gmail;
	
	private String city ;

	private Date createdAt;
	
	private Date updatedAt;
	
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

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getGmail() {
		return gmail;
	}

	public void setGmail(String gmail) {
		this.gmail = gmail;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "CustomerDTO [customerId=" + customerId + ", name=" + name + ", dateOfBirth=" + dateOfBirth
				+ ", phoneNumber=" + phoneNumber + ", gmail=" + gmail + ", city=" + city + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + "]";
	}

	
	
	

}
