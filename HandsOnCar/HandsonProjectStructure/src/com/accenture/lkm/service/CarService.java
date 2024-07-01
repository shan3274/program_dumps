package com.accenture.lkm.service;

import java.util.List;
import java.util.Map;

import com.accenture.lkm.business.bean.CarServiceBean;


public interface CarService {	
	CarServiceBean registerCarforService(CarServiceBean bean)throws Exception;
	Map<Integer,String> populatePartsDetails(String carType);
	public List<CarServiceBean> getAllCarServiceDetails() throws Exception;
	int getPartsPrice(int partId, String carType);
	public long countUser(String userName) ;
}