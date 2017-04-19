package com.dk.config.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dk.config.base.impl.HibernateBaseDaoImpl;
import com.dk.config.dao.TaskDefinitionDao;
import com.dk.config.entity.TaskDefinition;

@Repository
@Transactional
public class TaskDefinitionDaoImpl extends HibernateBaseDaoImpl<TaskDefinition, Long> implements TaskDefinitionDao{

	public TaskDefinitionDaoImpl(Class<TaskDefinition> entityClass) {
		super(TaskDefinition.class);
	}

}
