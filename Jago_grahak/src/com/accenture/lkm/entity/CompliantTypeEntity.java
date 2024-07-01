package com.accenture.lkm.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CompliantType")
public class CompliantTypeEntity {

	@Id
	private Integer compliantTypeId;
	private String compliantTypeName;
	public Integer getCompliantTypeId() {
		return compliantTypeId;
	}
	public void setCompliantTypeId(Integer compliantTypeId) {
		this.compliantTypeId = compliantTypeId;
	}
	public String getCompliantTypeName() {
		return compliantTypeName;
	}
	public void setCompliantTypeName(String compliantTypeName) {
		this.compliantTypeName = compliantTypeName;
	}
	

}
