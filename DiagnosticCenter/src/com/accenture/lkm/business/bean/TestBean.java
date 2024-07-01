package com.accenture.lkm.business.bean;


public class TestBean {
	private Integer testId;
	private String testName;
	private Double charges;
	public Integer getTestId() {
		return testId;
	}
	public void setTestId(Integer testId) {
		this.testId = testId;
	}
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	public Double getCharges() {
		return charges;
	}
	public void setCharges(Double charges) {
		this.charges = charges;
	}
	@Override
	public String toString() {
		return "TestBean [testId=" + testId + ", testName=" + testName + ", charges=" + charges + "]";
	}
	
	
}
