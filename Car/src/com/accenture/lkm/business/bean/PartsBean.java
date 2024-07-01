package com.accenture.lkm.business.bean;

import javax.validation.constraints.NotNull;

public class PartsBean {
	private Integer partId;
	private Integer price;
@NotNull(message="Please select the parts")
private String partName;
private String carType;
public PartsBean() {
	super();
	// TODO Auto-generated constructor stub
}
public PartsBean(Integer partId, Integer price, String partName, String carType) {
	super();
	this.partId = partId;
	this.price = price;
	this.partName = partName;
	this.carType = carType;
}
public Integer getPartId() {
	return partId;
}
public void setPartId(Integer partId) {
	this.partId = partId;
}
public Integer getPrice() {
	return price;
}
public void setPrice(Integer price) {
	this.price = price;
}
public String getPartName() {
	return partName;
}
public void setPartName(String partName) {
	this.partName = partName;
}
public String getCarType() {
	return carType;
}
public void setCarType(String carType) {
	this.carType = carType;
}
@Override
public String toString() {
	return "PartsBean [partId=" + partId + ", price=" + price + ", partName=" + partName + ", carType=" + carType + "]";
}
}
