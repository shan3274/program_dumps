package com.accenture.lkm.dao;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.lkm.business.bean.CarServiceBean;
import com.accenture.lkm.business.bean.PartsBean;
import com.accenture.lkm.entity.CarServiceEntity;
import com.accenture.lkm.entity.PartsEntity;


@Repository
@Transactional(value = "txManager")
public class CarServiceDaoWrapper {

	@Autowired
	private CarServiceDAO carServiceDAO;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<CarServiceBean> getAllCarServiceDetails() throws Exception{
		List<CarServiceBean> list=new ArrayList<>();
		try {
		List<CarServiceEntity> entityList=carServiceDAO.getAllCarServiceDetails();
		for(CarServiceEntity en: entityList) {
			CarServiceBean bean=convertEntityToBean(en);
			list.add(bean);
		}
		}catch(Exception e) {
			throw e;
		}
		return list;
	}
	
	public CarServiceBean registerCarforService(CarServiceBean bean) {
		CarServiceEntity entity=new CarServiceEntity();
		CarServiceBean beanret = new CarServiceBean();
		entity=carServiceDAO.save(convertBeanToEntity(bean));
		beanret=convertEntityToBean(entity);
		return beanret;
	}
	public List<PartsBean> populatePartsDetails(String carType){
		
		List<PartsBean> beanList=new ArrayList<>();
		List<PartsEntity> entityList=new ArrayList<>();
		try {
			Query query=entityManager.createQuery("select k from PartsEntity k where k.carType=?1");
			query.setParameter(1, carType);
			entityList=query.getResultList();
			for(PartsEntity entity: entityList) {
				PartsBean bean=new PartsBean();	
				BeanUtils.copyProperties(entity, bean);
			    beanList.add(bean);
		}
	}catch(Exception e) {
		throw e;
	}
		return beanList;
	}
	
	public int getPartsPrice(int partId,String carType){
		PartsEntity entity= entityManager.find(PartsEntity.class, partId);
		return entity.getPrice();
	}
	
	public long countUser(String userName) {
		Query q=entityManager.createQuery("select k from CarServiceEntity k where k.userName=?1");
		q.setParameter(1, userName);
		List<CarServiceEntity> list=q.getResultList();
		long count=0;
		for(CarServiceEntity e: list) {
			count++;
		}
		return count;
	}
	// Utility Methods.......
	public static CarServiceBean convertEntityToBean(CarServiceEntity entity) {
		CarServiceBean bean = new CarServiceBean();
		BeanUtils.copyProperties(entity, bean);
		return bean;
	}
	public static CarServiceEntity convertBeanToEntity(CarServiceBean bean) {
		CarServiceEntity entity = new CarServiceEntity();
		BeanUtils.copyProperties(bean, entity);
		return entity;
	}
	public static PartsBean convertPartEntityToBean(PartsEntity entity) {
		PartsBean bean = new PartsBean();
		BeanUtils.copyProperties(entity, bean);
		return bean;
	}
	public static PartsEntity convertPartsBeanToEntity(PartsBean bean) {
		PartsEntity entity = new PartsEntity();
		BeanUtils.copyProperties(bean, entity);
		return entity;
	}
	
}
