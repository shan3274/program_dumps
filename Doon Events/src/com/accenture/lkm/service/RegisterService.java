package com.accenture.lkm.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.accenture.lkm.business.bean.EventBean;
import com.accenture.lkm.business.bean.RegisterBean;
import com.accenture.lkm.dao.RegisterDAO;

@Service
public class RegisterService{
	
	@Autowired
	RegisterDAO dao;
	
	public List<EventBean> getEventDetails()
	{
		return dao.getEventDetails();
	}
	
	public int registerForEvent(RegisterBean bean) throws InvalidAgeException 
	{
		EventBean eb = dao.getEventById(bean.getEventId());
		
		int min_age = eb.getMinAge();
		int max_age = eb.getMaxAge();
		int age = bean.getAge();
		
		if(age>=min_age && age<=max_age)
		{
			return dao.registerForEvent(bean);
			
		}
		else
		{
			throw new InvalidAgeException();
		}	
	}
}