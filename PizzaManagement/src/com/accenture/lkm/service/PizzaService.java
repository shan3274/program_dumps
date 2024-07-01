package com.accenture.lkm.service;

import java.util.List;
import java.util.Map;

import com.accenture.lkm.business.bean.PizzaOrderBean;

public interface PizzaService {	
	List<PizzaOrderBean> getOrderDetails(Double fromBill,Double toBill)throws Exception;
	PizzaOrderBean addPizzaOrderDetails(PizzaOrderBean bean);
	Map<Integer,String> findAllPizzaDetails();
}