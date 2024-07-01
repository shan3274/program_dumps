package com.accenture.lkm.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.lkm.business.bean.BillBean;
import com.accenture.lkm.business.bean.TestBean;
import com.accenture.lkm.entity.BillEntity;
import com.accenture.lkm.entity.TestEntity;

@Repository
@Transactional(value = "txManager")
public class TestDAOWrapper {

	@Autowired
	private TestDAO testDAO;
	@Autowired
	private BillDAO billDAO;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	// Utility Methods.......
	public static BillBean convertBillEntityToBean(BillEntity entity) {
		BillBean bean = new BillBean();
		BeanUtils.copyProperties(entity, bean);
		return bean;
	}
	public static BillEntity convertBillBeanToEntity(BillBean bean) {
		BillEntity entity = new BillEntity();
		BeanUtils.copyProperties(bean, entity);
		return entity;
	}
	public static TestBean convertTestEntityToBean(TestEntity entity) {
		TestBean customerBean = new TestBean();
		BeanUtils.copyProperties(entity, customerBean);
		return customerBean;
	}
	public static TestEntity convertTestBeanToEntity(TestBean bean) {
		TestEntity entity = new TestEntity();
		BeanUtils.copyProperties(bean, entity);
		return entity;
	}
	
	
	public List<TestBean> findAllTest() {
		List<TestEntity> entityList = testDAO.findAllTestDetails();
		List<TestBean> beanList = null;
		if (entityList != null) {
			beanList = new ArrayList<TestBean>();
			for(TestEntity entity: entityList) {
				beanList.add(convertTestEntityToBean(entity));
			}
		}
		
		return beanList;
		
	}
	
	public BillBean addBillDetails(BillBean billBean) {
		BillEntity billEntity = convertBillBeanToEntity(billBean);
		entityManager.persist(billEntity);
//		billDAO.save(billEntity);
		return convertBillEntityToBean(billEntity);
	}
	
	public TestBean getTestById(Integer testId) {
		TestEntity testEntity = entityManager.find(TestEntity.class, testId);
		return convertTestEntityToBean(testEntity);
	}
	
	public List<BillBean> getTestBillDetails(Date from, Date to) {
		Query query = entityManager.createQuery("select k from BillEntity k where k.dateOfCollection between ?1 and ?2");
		query.setParameter(1, from);
		query.setParameter(2, to);
		
		List<BillBean> beanList = null;
		List<BillEntity> entityList = query.getResultList();
		if (entityList != null) {
			beanList = new ArrayList<BillBean>();
			for (BillEntity entity:entityList) {
				beanList.add(convertBillEntityToBean(entity));
			}
		}
		return beanList;
		
	}
	
}
