package com.accenture.lkm.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.lkm.entity.CustomerTypeEntity;

@RepositoryDefinition(idClass = String.class, domainClass = CustomerTypeEntity.class)
@Transactional(value = "txManager") 
public interface CustomerTypeDAO {      
	@Query(name = "GetCustomerTypesQuery") 
	List<String> getCustomerTypes(); 
}
