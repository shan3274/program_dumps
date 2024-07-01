package com.accenture.lkm.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.lkm.business.bean.CompliantBean;
import com.accenture.lkm.business.bean.CompliantTypeBean;
import com.accenture.lkm.dao.CompliantDaoWrapper;
import com.accenture.lkm.entity.CompliantTypeEntity;

@Service
public class CompliantServiceImpl implements CompliantService{

	@Autowired
	CompliantDaoWrapper compliantDaoWrapper;
	
	@Override
	public void registerCompliantDetails(CompliantBean compliantBean) throws Exception {
		// TODO Auto-generated method stub
		int status=compliantDaoWrapper.getCustomerByCompliantType(compliantBean.getCustomerName(), compliantBean.getCompliantTypeId());
		if(status==1) {
			throw new Exception("Hi "+compliantBean.getCustomerName()+", you already submitted a compliant with same compliant type");
		}
		else {
			compliantDaoWrapper.registerCompliantDetails(compliantBean);
		}
	}

	@Override
	public List<CompliantBean> getCompliantDetailsByDate(Date fromDate, Date toDate) {
		// TODO Auto-generated method stub
		List<CompliantBean> compliantBeans=compliantDaoWrapper.getCompliantDetailsByDate(fromDate, toDate);
		return compliantBeans;
	}

	@Override
	public Map<Integer, String> getAllCompliantTypes() {
		// TODO Auto-generated method stub
		Map<Integer,String> typeMap=new HashMap<Integer, String>();
		List<CompliantTypeBean> typeList=compliantDaoWrapper.getAllCompliantTypes();
		for(CompliantTypeBean bean:typeList) {
			typeMap.put(bean.getCompliantTypeId(),bean.getCompliantTypeName());
		}
		return typeMap;
	}
	
}
