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

import com.accenture.lkm.business.bean.CustomerBean;
import com.accenture.lkm.business.bean.CustomerTypeBean;
import com.accenture.lkm.entity.CustomerEntity;
import com.accenture.lkm.entity.CustomerTypeEntity;

@Repository 
@Transactional(value = "txManager")
public class CustomerDAOWrapper {
	@Autowired       
	private CustomerDAO customerDAO;       
	
	@Autowired       
	private CustomerTypeDAO customerTypeDAO;
	
	@PersistenceContext       
	private EntityManager entityManager;       
	
	public List<CustomerBean> getCustomerDetails(Date startDate, Date endDate) throws Exception{
		List<CustomerBean> beanList = null; 
		try {             
			List<CustomerEntity> entityList = customerDAO.getCustomerDetails(startDate, endDate);
			if(entityList!=null) {     
				beanList = new ArrayList<CustomerBean>(); 
				for(CustomerEntity entity : entityList) {    
					CustomerBean bean = convertEntityToBean(entity);  
					beanList.add(bean);                   
				}             
			}             
		}
		catch(Exception e) { 
			System.out.println(e.getMessage());            
		}             
		return beanList;
	}       
	
		public List<String> getCustomerTypes() throws Exception{
			List<String> list = null;             
			try{                
				list =  customerTypeDAO.getCustomerTypes();      
			}
			catch(Exception e) { 
				System.out.println(e.getMessage());          
			}             
			return list;       
		}       
		public CustomerTypeBean getCustomerTypeDetails(String customerType) throws Exception{ 
			CustomerTypeBean bean = null;       
			try {            
				Query query = entityManager.createQuery("select c from CustomerTypeEntity c where c.customerType=?1");  
				query.setParameter(1, customerType);        
				CustomerTypeEntity customerTypeEntity= (CustomerTypeEntity)query.getSingleResult();  
				bean = convertTypeEntityToTypeBean(customerTypeEntity);   
			}             
			catch(Exception e) {  
				System.out.println(e.getMessage());       
			}             
			return bean;       
		}       
		public Integer addCustomer(CustomerBean customerBean) throws Exception{ 
			CustomerEntity entity = new CustomerEntity();          
			Integer id = null;       
			try {                  
				entity = convertBeanToEntity(customerBean);    
				entityManager.persist(entity);      
				id = entity.getCustomerId();            
			}            
			catch(Exception e) {     
				System.out.println(e.getMessage());  
			}             
			return id; 
			
		}
     // Utility Methods.......      
		public static CustomerBean convertEntityToBean(CustomerEntity entity) { 
			CustomerBean customerBean = new CustomerBean();   
			BeanUtils.copyProperties(entity, customerBean);      
			return customerBean;       
		}       
		public static CustomerEntity convertBeanToEntity(CustomerBean bean) {  
			CustomerEntity entity = new CustomerEntity();    
			BeanUtils.copyProperties(bean, entity);          
			return entity;      
		}       
		public static CustomerTypeBean convertTypeEntityToTypeBean(CustomerTypeEntity entity) {  
			CustomerTypeBean customerTypeBean = new CustomerTypeBean(); 
			BeanUtils.copyProperties(entity, customerTypeBean);      
			return customerTypeBean;       
		}
	} 