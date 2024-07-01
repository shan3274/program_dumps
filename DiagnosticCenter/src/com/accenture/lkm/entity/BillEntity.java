package com.accenture.lkm.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "Bill")
public class BillEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer billNo;
	@NotEmpty
	private String patientName;
	@Column(name = "testID")
	private Integer testId;
	@Temporal(TemporalType.DATE)
	private Date dateOfCollection;
	private Double paidAmount;
	public Integer getBillNo() {
		return billNo;
	}
	public void setBillNo(Integer billNo) {
		this.billNo = billNo;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public Integer getTestId() {
		return testId;
	}
	public void setTestId(Integer testId) {
		this.testId = testId;
	}
	public Date getDateOfCollection() {
		return dateOfCollection;
	}
	public void setDateOfCollection(Date dateOfCollection) {
		this.dateOfCollection = dateOfCollection;
	}
	public Double getPaidAmount() {
		return paidAmount;
	}
	public void setPaidAmount(Double paidAmount) {
		this.paidAmount = paidAmount;
	}
	@Override
	public String toString() {
		return "BillEntity [billNo=" + billNo + ", patientName=" + patientName + ", testId=" + testId
				+ ", dateOfCollection=" + dateOfCollection + ", paidAmount=" + paidAmount + "]";
	}
	
	
}
