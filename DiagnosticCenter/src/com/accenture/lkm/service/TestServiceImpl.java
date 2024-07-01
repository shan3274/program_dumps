package com.accenture.lkm.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.lkm.business.bean.BillBean;
import com.accenture.lkm.business.bean.TestBean;
import com.accenture.lkm.dao.TestDAOWrapper;

@Service
public class TestServiceImpl implements TestService{
	@Autowired
	private TestDAOWrapper testDAOWrapper;

	@Override
	public List<TestBean> findAllTest() {
		// TODO Auto-generated method stub
		return testDAOWrapper.findAllTest();
	}

	@Override
	public BillBean addBillDetails(BillBean billBean) {
		// TODO Auto-generated method stub
		return testDAOWrapper.addBillDetails(billBean);
	}

	@Override
	public TestBean getTestById(Integer testId) {
		// TODO Auto-generated method stub
		return testDAOWrapper.getTestById(testId);
	}

	@Override
	public List<BillBean> getTestBillDetails(Date from, Date to) {
		// TODO Auto-generated method stub
		return testDAOWrapper.getTestBillDetails(from, to);
	}
	
	@Override
	public Map<Integer, String> populateTestMap() {
		List<TestBean> testList = findAllTest();
		Map<Integer, String> testMap = new HashMap<Integer, String>(); 
		for(TestBean bean:testList) {
			testMap.put(bean.getTestId(), bean.getTestName());
		}
		return testMap;
	}
	
}
