package com.dk.config.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dk.config.base.impl.HibernateBaseDaoImpl;
import com.dk.config.dao.DataSourceDao;
import com.dk.config.entity.DataSource;

@Repository
@Transactional
public class DataSourceDaoImpl extends HibernateBaseDaoImpl<DataSource,Long> implements DataSourceDao{

	public DataSourceDaoImpl(Class<DataSource> entityClass) {
		super(DataSource.class);
	}

}
