package com.accenture.lkm.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.lkm.entity.BillEntity;

@RepositoryDefinition(domainClass = BillEntity.class, idClass = Integer.class)
@Transactional(value = "txManager")
public interface BillDAO {
	@Query(name = "save")
	BillEntity save(BillEntity entity);
}

