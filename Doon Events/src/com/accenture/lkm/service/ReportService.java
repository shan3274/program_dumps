package com.accenture.lkm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.lkm.business.bean.RegisterBean;
import com.accenture.lkm.dao.ReportDAO;
import com.accenture.lkm.entity.RegisterEntity;

@Service
public class ReportService 
{
	@Autowired
	private ReportDAO reportDAO;
	
	public List<RegisterBean> getAllDetails()
	{
		List<RegisterEntity> entityList=reportDAO.findAll();
		List<RegisterBean> list=new ArrayList<RegisterBean>();
		for(RegisterEntity e:entityList)
		{
			RegisterBean bean=convertRegisterEntityToBean(e);
			list.add(bean);
		}
		return list;
	}
	
	public RegisterBean convertRegisterEntityToBean(RegisterEntity entity)
	{
		RegisterBean bean=new RegisterBean();
		BeanUtils.copyProperties(entity, bean);
		return bean;
	}
}
