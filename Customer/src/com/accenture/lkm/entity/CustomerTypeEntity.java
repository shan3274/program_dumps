package com.accenture.lkm.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name = "CustomerTypes")
public class CustomerTypeEntity {
	@Id       
	private String customerType;
	private Double minimumBill;      
	private Double maximumBill;
	
	public String getCustomerType() {
		return customerType;
	}
	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
	public Double getMinimumBill() {
		return minimumBill;
	}
	public void setMinimumBill(Double minimumBill) {
		this.minimumBill = minimumBill;
	}
	public Double getMaximumBill() {
		return maximumBill;
	}
	public void setMaximumBill(Double maximumBill) {
		this.maximumBill = maximumBill;
	}
	
}
