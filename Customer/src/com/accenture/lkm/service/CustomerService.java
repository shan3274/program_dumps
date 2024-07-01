package com.accenture.lkm.service;

import java.util.Date; 
import java.util.List;
import java.util.Map; 
import com.accenture.lkm.business.bean.CustomerBean; 

public interface CustomerService {        
	List<CustomerBean> getCustomerDetails(Date startDate, Date endDate) throws Exception;  
	Integer addCustomer(CustomerBean customerBean) throws Exception;   
	Map<String, String> getCustomerTypes() throws Exception; 
} 
