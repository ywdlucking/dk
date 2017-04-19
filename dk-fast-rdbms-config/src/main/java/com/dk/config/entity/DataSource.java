package com.dk.config.entity;

import java.util.Date;

import com.dk.config.helper.DBtype;

public class DataSource {
	
	/**
	 * ID
	 */
	private Long id;

	/**
	 * 数据源名称
	 */
	private String dsName;

	/**
	 * 数据源类型
	 */
	private DBtype type;
	
	/**
	 * 数据库ip
	 */
	private String ip;
	
	/**
	 * 数据源端口
	 */
	private int port;
	
	/**
	 * 数据库用户名
	 */
	private String username;
	
	/**
	 * 数据库密码
	 */
	private String password;
	
	/**
	 * 连接地址
	 */
	private String url;

	/**
	 * 创建时间
	 */
	private Date createTime;
	
	public DataSource() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDsName() {
		return dsName;
	}

	public void setDsName(String dsName) {
		this.dsName = dsName;
	}

	public DBtype getType() {
		return type;
	}

	public void setType(DBtype type) {
		this.type = type;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
