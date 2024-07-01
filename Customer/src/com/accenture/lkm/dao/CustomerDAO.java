package com.accenture.lkm.dao;

import java.util.Date; 
import java.util.List; 
import org.springframework.data.jpa.repository.Query; 
import org.springframework.data.repository.RepositoryDefinition; 
import org.springframework.transaction.annotation.Transactional; 
import com.accenture.lkm.entity.CustomerEntity; 

@RepositoryDefinition(idClass = Integer.class, domainClass = CustomerEntity.class)
@Transactional(value = "txManager") // name of TransactionManger can be any thing 
public interface CustomerDAO {       
	@Query(name = "GetCustomerDetailsQuery")       
	List<CustomerEntity> getCustomerDetails(Date startDate, Date endDate);
	//@Query(name = "DummyQuery")      
	//List<CustomerEntity> getCustomerDetailsWithin(Date startDate, Date endDate);  
}