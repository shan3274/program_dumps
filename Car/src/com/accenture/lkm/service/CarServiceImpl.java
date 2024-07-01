package com.accenture.lkm.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.lkm.business.bean.CarServiceBean;
import com.accenture.lkm.business.bean.PartsBean;
import com.accenture.lkm.dao.CarServiceDaoWrapper;

@Service
public class CarServiceImpl implements CarService{
	@Autowired
	private CarServiceDaoWrapper carServiceDaoWrapper;
	
	@Override
	public CarServiceBean registerCarforService(CarServiceBean bean) throws Exception {
		String userName=bean.getUserName();
		System.out.println(userName);
	    long count=carServiceDaoWrapper.countUser(userName);
	    System.out.println("count"+count);
	    if(count>3) {
	    	throw new Exception("Same user can not register more than thrice for car service");
	    }
	    else {
	    	Integer partId=bean.getPartId();
	    	Integer totalRepairCost=0;
	    	System.out.println("typre"+bean.getCarType());
	    	String carType=bean.getCarType();
	    	System.out.println("type"+carType);
	    	int price=carServiceDaoWrapper.getPartsPrice(partId,carType);
	    	System.out.println("pri"+price);
	    	if(carType.equals("Maruti")) {
	    		totalRepairCost=400+price;
	    	}
	    	else if(carType.equals("Hyundai")) {
	    		totalRepairCost=500+price;
	    }
	    bean.setTotalRepairCost(totalRepairCost);
	    
		CarServiceBean beanret = new CarServiceBean();
		beanret=carServiceDaoWrapper.registerCarforService(bean);
		System.out.println(bean);
		return beanret;
	}
	}
	
	public Map<Integer,String> populatePartsDetails(String carType){
		List<PartsBean> list=carServiceDaoWrapper.populatePartsDetails(carType);
		Map<Integer,String> carMap=new HashMap<Integer,String>();
		for(PartsBean bean:list) {
			carMap.put(bean.getPartId(), bean.getPartName());
		}
		return carMap;
	}
	@Override
	public List<CarServiceBean> getAllCarServiceDetails() throws Exception{
		List<CarServiceBean> list=new ArrayList<>();
		try {
		list=carServiceDaoWrapper.getAllCarServiceDetails();
		}catch(Exception e) {
			throw e;
		}
		return list;
	}
	
	public long countUser(String userName) {
		long count=carServiceDaoWrapper.countUser(userName);
		return count;
	}
	@Override
	public int getPartsPrice(int partId,String carType) {
		int price=carServiceDaoWrapper.getPartsPrice(partId,carType);
		return price;
	}
	
}
