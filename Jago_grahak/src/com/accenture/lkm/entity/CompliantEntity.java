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
@Table(name = "Compliant")
public class CompliantEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer compliantId;
	private String customerName;
	private String description;
	@Temporal(TemporalType.DATE)
	private Date dateOfIncidence;
	private Double amount;
	private Integer compliantTypeId;
	public Integer getCompliantId() {
		return compliantId;
	}
	public void setCompliantId(Integer compliantId) {
		this.compliantId = compliantId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDateOfIncidence() {
		return dateOfIncidence;
	}
	public void setDateOfIncidence(Date dateOfIncidence) {
		this.dateOfIncidence = dateOfIncidence;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Integer getCompliantTypeId() {
		return compliantTypeId;
	}
	public void setCompliantTypeId(Integer compliantTypeId) {
		this.compliantTypeId = compliantTypeId;
	}
	
}
