package com.accenture.lkm.business.bean;

import java.util.Date; 
import javax.persistence.Temporal; 
import javax.persistence.TemporalType; public class CustomerBean {       
	private int customerId;       
	private String customerName;       
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
	@Override
	public String toString() {
		return "CustomerBean [customerId=" + customerId + ", customerName=" + customerName + ", billingDate="
				+ billingDate + ", bill=" + bill + ", customerType=" + customerType + "]";
	}       
	
}