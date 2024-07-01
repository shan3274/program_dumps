package com.accenture.lkm.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.accenture.lkm.business.bean.CompliantBean;

public interface CompliantService {	
	void registerCompliantDetails(CompliantBean compliantBean) throws Exception;
	List<CompliantBean> getCompliantDetailsByDate(Date fromDate,Date toDate);
	Map<Integer,String> getAllCompliantTypes();
}