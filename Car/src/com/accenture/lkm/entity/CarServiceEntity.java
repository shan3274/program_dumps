package com.accenture.lkm.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="carservice")
public class CarServiceEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Integer serviceId;
	
	private String carType;
	private String carNumber;
	private String userName;
	private Integer partId;
	private Integer totalRepairCost;
	public CarServiceEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CarServiceEntity(Integer serviceId, String carType, String carNumber, String userName, Integer partId,
			Integer totalRepairCost) {
		super();
		this.serviceId = serviceId;
		this.carType = carType;
		this.carNumber = carNumber;
		this.userName = userName;
		this.partId = partId;
		this.totalRepairCost = totalRepairCost;
	}
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
	public String getCarNumber() {
		return carNumber;
	}
	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
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
		return "CarServiceEntity [serviceId=" + serviceId + ", carType=" + carType + ", carNumber=" + carNumber
				+ ", userName=" + userName + ", partId=" + partId + ", totalRepairCost=" + totalRepairCost + "]";
	}
	
}
