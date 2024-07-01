package com.accenture.lkm.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.lkm.business.bean.PizzaBean;
import com.accenture.lkm.business.bean.PizzaOrderBean;
import com.accenture.lkm.dao.PizzaDAOWrapper;

@Service
public class PizzaServiceImpl implements PizzaService{
	
	@Autowired
	private PizzaDAOWrapper pizzaDAOWrapper;

	@Override
	public List<PizzaOrderBean> getOrderDetails(Double fromBill, Double toBill) throws Exception {
		List<PizzaOrderBean> list=pizzaDAOWrapper.getOrderDetails(fromBill, toBill);
		if(list.isEmpty() || list==null) {
			throw new Exception("No Pizza Order Found within this Bill Range");
		}
		return list;
	}

	@Override
	public PizzaOrderBean addPizzaOrderDetails(PizzaOrderBean bean) {
		double unitprice = pizzaDAOWrapper.getPizzaPrice(bean.getPizzaId());
		double totalBill = unitprice*bean.getNumberOfPiecesOrdered();
		bean.setBill(totalBill);
		return pizzaDAOWrapper.addPizzaOrderDetails(bean);
	}

	@Override
	public Map<Integer, String> findAllPizzaDetails() {
			List<PizzaBean> pizzaList = pizzaDAOWrapper.findAllPizzaDetails();
			Map<Integer, String> pizzaMap=new HashMap<Integer, String>();
			for(PizzaBean bean:pizzaList) {
				pizzaMap.put(bean.getPizzaId(), bean.getPizzaName());
			}
		return pizzaMap;
	}
	
}
