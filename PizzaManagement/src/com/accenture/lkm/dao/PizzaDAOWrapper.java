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

import com.accenture.lkm.business.bean.PizzaBean;
import com.accenture.lkm.business.bean.PizzaOrderBean;
import com.accenture.lkm.entity.PizzaEntity;
import com.accenture.lkm.entity.PizzaOrderEntity;

@Repository
@Transactional(value = "txManager")
public class PizzaDAOWrapper {

	//JPA Data
	@Autowired
	private PizzaDAO pizzaDAO;
	@Autowired
	private PizzaOrderDAO pizzaOrderDAO;
	
	//JPA
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<PizzaBean> findAllPizzaDetails(){
		List<PizzaBean> pizzaList = null;
		List<PizzaEntity> pizzaEntitiesList=pizzaDAO.findAllPizzaDetails();
		if(!pizzaEntitiesList.isEmpty() || pizzaEntitiesList != null) {
			pizzaList = new ArrayList<PizzaBean>();
			for(PizzaEntity entity:pizzaEntitiesList) {
				PizzaBean bean = convertEntityToBean(entity);
				pizzaList.add(bean);
			}
		}		
		return pizzaList;
	}
	public PizzaOrderBean addPizzaOrderDetails(PizzaOrderBean bean){
		PizzaOrderEntity entity=convertOrderBeanToEntity(bean);
		entity=pizzaOrderDAO.save(entity);
		bean.setOrderId(entity.getOrderId());
		return bean;
	}
	public Double getPizzaPrice(Integer pizzaId) {
		Query query = entityManager.createQuery("select e.price from PizzaEntity e where e.pizzaId=?1");
		query.setParameter(1, pizzaId);
		Double price=(Double) query.getSingleResult();
		return price;
	}
	public List<PizzaOrderBean> getOrderDetails(Double fromBill,Double toBill){
		List<PizzaOrderBean> pizzaOrderList = null;
		Query query = entityManager.createQuery("select p from PizzaOrderEntity p where p.bill BETWEEN ?1 and ?2");
		query.setParameter(1, fromBill);
		query.setParameter(2, toBill);
		List<PizzaOrderEntity> pizzaEntitiesList= query.getResultList();
		if(!pizzaEntitiesList.isEmpty() || pizzaEntitiesList != null) {
		pizzaOrderList=new ArrayList<PizzaOrderBean>();
			for(PizzaOrderEntity entity: pizzaEntitiesList) {
				PizzaOrderBean bean = convertOrderEntityToBean(entity);
				pizzaOrderList.add(bean);
			}
		}
		return pizzaOrderList;
		
	}
	// Utility Methods.......
	public static PizzaBean convertEntityToBean(PizzaEntity entity) {
		PizzaBean pizzaBean = new PizzaBean();
		BeanUtils.copyProperties(entity, pizzaBean);
		return pizzaBean;
	}
	public static PizzaEntity convertBeanToEntity(PizzaBean bean) {
		PizzaEntity entity = new PizzaEntity();
		BeanUtils.copyProperties(bean, entity);
		return entity;
	}
	public static PizzaOrderBean convertOrderEntityToBean(PizzaOrderEntity entity) {
		PizzaOrderBean bean = new PizzaOrderBean();
		BeanUtils.copyProperties(entity, bean);
		return bean;
	}
	public static PizzaOrderEntity convertOrderBeanToEntity(PizzaOrderBean bean) {
		PizzaOrderEntity entity = new PizzaOrderEntity();
		BeanUtils.copyProperties(bean, entity);
		return entity;
	}
	
}
