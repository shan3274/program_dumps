package com.accenture.lkm.dao;

import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.lkm.entity.PizzaOrderEntity;

@RepositoryDefinition(domainClass = PizzaOrderEntity.class, idClass = Integer.class)
@Transactional(value = "txManager")
public interface PizzaOrderDAO {
	PizzaOrderEntity save(PizzaOrderEntity entity);
}
