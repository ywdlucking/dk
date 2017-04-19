package com.dk.config.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dk.config.base.impl.HibernateBaseDaoImpl;
import com.dk.config.dao.TaskHistoryDao;
import com.dk.config.entity.TaskHistory;

@Repository
@Transactional
public class TaskHistoryDaoImpl extends HibernateBaseDaoImpl<TaskHistory, Long> implements TaskHistoryDao{

	public TaskHistoryDaoImpl(Class<TaskHistory> entityClass) {
		super(TaskHistory.class);
	}

}
