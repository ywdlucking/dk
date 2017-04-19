package com.dk.config.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dk.config.base.impl.HibernateBaseDaoImpl;
import com.dk.config.dao.FieldDefinitionDao;
import com.dk.config.entity.FieldDefinition;

@Repository
@Transactional
public class FieldDefinitionDaoImpl extends HibernateBaseDaoImpl<FieldDefinition, Long> implements FieldDefinitionDao{

	public FieldDefinitionDaoImpl(Class<FieldDefinition> entityClass) {
		super(FieldDefinition.class);
	}

}
