package com.accenture.lkm.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.accenture.lkm.business.bean.BurgerBean;

@Service
public class BurgerService {
	private Map<String,Double> burgers;
	private Map<String,Double> toppings;
	
	public Map<String,Double> getBurgerDetails()throws Exception{
		Map<String,Double> burgerMap = new HashMap<String,Double>();
		burgerMap.put("Veg-Burger", 100.00);
		burgerMap.put("Chicken-Burger", 200.00);
		burgerMap.put("Veg-CrunchBurger", 150.00);
		burgerMap.put("Chicken-CrunchBurger", 250.00);
		burgers = burgerMap;
		return burgers;
	}
	
	public Map<String,Double> getToppingDetails()throws Exception{
		Map<String,Double> toppingMap = new HashMap<String,Double>();
		toppingMap.put("Cheese", 70.00);
		toppingMap.put("Dip", 50.00);
		toppingMap.put("Sauce", 30.00);
		toppings = toppingMap;
		return toppings;
	}
	
	public double calculateTotalCost(BurgerBean burgerBean)throws Exception{
		double price =0.0;
		if(burgers.containsKey(burgerBean.getBurgerName())) {
			if(toppings.containsKey(burgerBean.getToppingName())) {
				price = burgerBean.getNoOfBurgers()*(burgers.get(burgerBean.getBurgerName()) + toppings.get(burgerBean.getToppingName()));
			}
		}
		return price;
	}
}
