package com.accenture.lkm.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity 
@Table(name = "Customer") 
public class CustomerEntity { 
	@Id       
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customerId;  
	
	private String customerName; 
	
	@Temporal(TemporalType.DATE) 
	private Date billingDate; 
	
	private Double bill;    
	private String customerType;
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Date getBillingDate() {
		return billingDate;
	}
	public void setBillingDate(Date billingDate) {
		this.billingDate = billingDate;
	}
	public Double getBill() {
		return bill;
	}
	public void setBill(Double bill) {
		this.bill = bill;
	}
	public String getCustomerType() {
		return customerType;
	}
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
	
	
}
