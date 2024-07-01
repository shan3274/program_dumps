package com.accenture.lkm.business.bean;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class BurgerBean {
	@NotEmpty(message="Name Can't be empty")
	private String burgerName;
	@NotEmpty(message="Topping Can't be empty")
	private String toppingName;
	@Min(value=1, message="Quantity should be 1 atleast")
	@NotNull(message="Quantity cannot be null")
	private Integer noOfBurgers;
	public String getBurgerName() {
		return burgerName;
	}
	public void setBurgerName(String burgerName) {
		this.burgerName = burgerName;
	}
	public String getToppingName() {
		return toppingName;
	}
	public void setToppingName(String toppingName) {
		this.toppingName = toppingName;
	}
	public Integer getNoOfBurgers() {
		return noOfBurgers;
	}
	public void setNoOfBurgers(Integer noOfBurgers) {
		this.noOfBurgers = noOfBurgers;
	}
	
	
}
