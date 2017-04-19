package com.dk.config.entity;

public class TaskDefinition {
	/**
	 * ID
	 */
	private Long id;

	/**
	 * 状态 0:未运行;1:正在运行;2:异常;3:完成
	 */
	private int status;

	/**
	 * 策略 1:全表;2:增量
	 */
	private int strategy;

	/**
	 * 增量计数
	 */
	private long increment;

	/**
	 * 任务定义
	 */
	private String content;
	
	public TaskDefinition() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getStrategy() {
		return strategy;
	}

	public void setStrategy(int strategy) {
		this.strategy = strategy;
	}

	public long getIncrement() {
		return increment;
	}

	public void setIncrement(long increment) {
		this.increment = increment;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
