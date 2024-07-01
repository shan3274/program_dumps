package com.accenture.lkm.business.bean;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CarServiceBean {
	private Integer serviceId;
	private String carType;
	@NotNull(message="Car number is mandatory")
	private String carNumber;
public String getCarNumber() {
	return carNumber;
}

public void setCarNumber(String carNumber) {
	this.carNumber = carNumber;
}

@Size(min=5,max=10,message="username should be between 5 to 10 characters")
private String userName;
private Integer partId;
private Integer totalRepairCost;
public CarServiceBean() {
	super();
	// TODO Auto-generated constructor stub
}

	/*
	 * public CarServiceBean(Integer serviceId, String carType, String carNumber,
	 * String username, Integer partId, Integer totalRepairCost) { super();
	 * this.serviceId = serviceId; this.carType = carType; this.carNumber =
	 * carNumber; this.username = username; this.partId = partId;
	 * this.totalRepairCost = totalRepairCost; }
	 */
public Integer getServiceId() {
	return serviceId;
}
public void setServiceId(Integer serviceId) {
	this.serviceId = serviceId;
}
public String getCarType() {
	return carType;
}
public void setCarType(String carType) {
	this.carType = carType;
}

public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public Integer getPartId() {
	return partId;
}
public void setPartId(Integer partId) {
	this.partId = partId;
}
public Integer getTotalRepairCost() {
	return totalRepairCost;
}
public void setTotalRepairCost(Integer totalRepairCost) {
	this.totalRepairCost = totalRepairCost;
}

@Override
public String toString() {
	return "CarServiceBean [serviceId=" + serviceId + ", carType=" + carType + ", carNumber=" + carNumber
			+ ", userName=" + userName + ", partId=" + partId + ", totalRepairCost=" + totalRepairCost + "]";
}
	
}
