package com.accenture.lkm.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.accenture.lkm.business.bean.BillBean;
import com.accenture.lkm.business.bean.TestBean;

public interface TestService {	
	List<TestBean> findAllTest();
	BillBean addBillDetails(BillBean billBean);
	TestBean getTestById(Integer testId);
	List<BillBean> getTestBillDetails(Date from, Date to);
	
	Map<Integer, String> populateTestMap();
}