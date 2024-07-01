package com.accenture.lkm.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "parts")
public class PartsEntity {
	@Id
	private Integer partId;
	private Integer price;
	private String partName;
	private String carType;

	public PartsEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PartsEntity(Integer partId, Integer price, String partName, String carType) {
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
		return "PartsEntity [partId=" + partId + ", price=" + price + ", partName=" + partName + ", carType=" + carType
				+ "]";
	}
}
