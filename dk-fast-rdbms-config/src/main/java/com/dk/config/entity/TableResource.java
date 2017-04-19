package com.dk.config.entity;

import java.util.List;

public class TableResource {

	/**
	 * ID
	 */
	private Long id;

	/**
	 * 数据库ID
	 */
	private Long dsId;

	/**
	 * 表名称
	 */
	private String tableName;

	/**
	 * 字段定义
	 */
	private List<FieldDefinition> fieldDefinitions;
	
	public TableResource() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getDsId() {
		return dsId;
	}

	public void setDsId(Long dsId) {
		this.dsId = dsId;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public List<FieldDefinition> getFieldDefinitions() {
		return fieldDefinitions;
	}

	public void setFieldDefinitions(List<FieldDefinition> fieldDefinitions) {
		this.fieldDefinitions = fieldDefinitions;
	}

}
