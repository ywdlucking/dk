package com.dk.config.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dk.config.base.impl.HibernateBaseDaoImpl;
import com.dk.config.dao.TableResourceDao;
import com.dk.config.entity.TableResource;

@Repository
@Transactional
public class TableResourceDaoImpl extends HibernateBaseDaoImpl<TableResource, Long> implements TableResourceDao{

	public TableResourceDaoImpl(Class<TableResourceDao> entityClass) {
		super(TableResource.class);
	}

}
