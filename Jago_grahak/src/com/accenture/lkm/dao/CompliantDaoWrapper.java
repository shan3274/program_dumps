package com.accenture.lkm.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.lkm.business.bean.CompliantBean;
import com.accenture.lkm.business.bean.CompliantTypeBean;
import com.accenture.lkm.entity.CompliantEntity;
import com.accenture.lkm.entity.CompliantTypeEntity;

@Repository
@Transactional(value = "txManager")
public class CompliantDaoWrapper {
	
	@Autowired
	private CompliantDao compliantDao;

	@Autowired
	private CompliantTypeDao compliantTypeDao;
	
	@PersistenceContext
	private EntityManager manager;
	
	public void registerCompliantDetails(CompliantBean compliantBean) {
		CompliantEntity compliantEntity=convertCompliantBeanToEntity(compliantBean);
		compliantDao.save(compliantEntity);
		
	}
	
	public List<CompliantBean> getCompliantDetailsByDate(Date fromDate,Date toDate){
		List<CompliantEntity> compliantEntities=compliantDao.getCompliantDetailsByDate(fromDate, toDate);
		List<CompliantBean> compliantBeans=new ArrayList<CompliantBean>();
		for(CompliantEntity entity:compliantEntities) {
			CompliantBean bean=convertCompliantEntityToBean(entity);
			compliantBeans.add(bean);
		}
		return compliantBeans;
	}
	
	public List<CompliantTypeBean> getAllCompliantTypes(){
		List<CompliantTypeEntity> typeEntities=compliantTypeDao.findAll();
		List<CompliantTypeBean> typeBeans=new ArrayList<CompliantTypeBean>();
		for(CompliantTypeEntity entity:typeEntities) {
			CompliantTypeBean bean=convertTypeEntityToBean(entity);
			typeBeans.add(bean);
		}
		return typeBeans;
	}
	
	public int getCustomerByCompliantType(String customerName,int compliantTypeId) {
		CompliantEntity compliantEntity=compliantDao.getCustomerByCompliantType(customerName, compliantTypeId);
		if(compliantEntity!=null)
			return 1;
		else
			return 0;
	}
	
	// Utility Methods.......
	public static CompliantTypeBean convertTypeEntityToBean(CompliantTypeEntity entity) {
		CompliantTypeBean bean = new CompliantTypeBean();
		BeanUtils.copyProperties(entity, bean);
		return bean;
	}
	public static CompliantTypeEntity convertTypeBeanToEntity(CompliantTypeBean bean) {
		CompliantTypeEntity entity = new CompliantTypeEntity();
		BeanUtils.copyProperties(bean, entity);
		return entity;
	}
	public static CompliantBean convertCompliantEntityToBean(CompliantEntity entity) {
		CompliantBean bean = new CompliantBean();
		BeanUtils.copyProperties(entity, bean);
		return bean;
	}
	public static CompliantEntity convertCompliantBeanToEntity(CompliantBean bean) {
		CompliantEntity entity = new CompliantEntity();
		BeanUtils.copyProperties(bean, entity);
		return entity;
	}
}
