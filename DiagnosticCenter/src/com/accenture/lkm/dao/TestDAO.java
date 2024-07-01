package com.accenture.lkm.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.lkm.entity.TestEntity;

@RepositoryDefinition(idClass = Integer.class, domainClass = TestEntity.class)
@Transactional(value = "txManager")
// name of TransactionManger can be any thing
public interface TestDAO {
	@Query(name = "findAllTestDetails")
	List<TestEntity> findAllTestDetails();
}
