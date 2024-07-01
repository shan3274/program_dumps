package com.accenture.lkm.business.bean;

import java.util.Date;

public class BillBean {
	private Integer billNo;
	private String patientName;
	private Integer testId;
	private Date dateOfCollection;
	private Double paidAmount;
	
	private String testName;
	private Double balanceAmount;
	
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	public Double getBalanceAmount() {
		return balanceAmount;
	}
	public void setBalanceAmount(Double balanceAmount) {
		this.balanceAmount = balanceAmount;
	}
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
		return "BillBean [billNo=" + billNo + ", patientName=" + patientName + ", testId=" + testId
				+ ", dateOfCollection=" + dateOfCollection + ", paidAmount=" + paidAmount + "]";
	}
	
	
	
	
}
