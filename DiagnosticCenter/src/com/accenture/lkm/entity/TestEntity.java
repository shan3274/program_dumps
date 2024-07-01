package com.accenture.lkm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Test")
public class TestEntity {

	@Id
	@Column(name = "testID")
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
		return "TestEntity [testId=" + testId + ", testName=" + testName + ", charges=" + charges + "]";
	}
	
	
	
}
