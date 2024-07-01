package com.accenture.lkm.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.lkm.entity.RegisterEntity;

public interface ReportDAO extends JpaRepository<RegisterEntity,Integer> 
{
	
}
