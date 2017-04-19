package com.dk.config.entity;

public class FieldDefinition {
	/**
	 * ID
	 */
	private Long id;

	/**
	 * 表ID
	 */
	private Long tableId;

	/**
	 * 字段名名称
	 */
	private String fieldName;
	
	/**
	 * 字段类型
	 */
	private Integer typeInt;
	
	/**
	 * 字段类型
	 */
	private String type;
	
	public FieldDefinition() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTableId() {
		return tableId;
	}

	public void setTableId(Long tableId) {
		this.tableId = tableId;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public Integer getTypeInt() {
		return typeInt;
	}

	public void setTypeInt(Integer typeInt) {
		this.typeInt = typeInt;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
