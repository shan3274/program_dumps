package com.accenture.lkm.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;
import com.accenture.lkm.business.bean.EventBean;
import com.accenture.lkm.business.bean.RegisterBean;
import com.accenture.lkm.entity.EventEntity;
import com.accenture.lkm.entity.RegisterEntity;

@Repository
@Transactional
public class RegisterDAO {

	@PersistenceContext
	EntityManager em;
	
	public List<EventBean> getEventDetails()
	{
		Query q = em.createQuery("select k from EventEntity k");
		List<EventEntity> eelist = q.getResultList();
		
		List<EventBean> eblist = new ArrayList<EventBean>();
		for(EventEntity ee : eelist)
		{
			EventBean eb = new EventBean();
			BeanUtils.copyProperties(ee, eb);
			eblist.add(eb);
		}
		
		return eblist;
	}
	
	public EventBean getEventById(String eventId)
	{
		EventEntity ee = em.find(EventEntity.class, eventId);
		
		EventBean eb = new EventBean();
		BeanUtils.copyProperties(ee, eb);
		
		return eb;
	}
	
	public int registerForEvent(RegisterBean bean)
	{
		RegisterEntity re = new RegisterEntity();
		
		BeanUtils.copyProperties(bean, re);
		em.persist(re);
		
		return re.getRegistrationId();
	}
}