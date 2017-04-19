package com.dk.config.entity;

import java.util.Date;

public class TaskHistory {

	/**
	 * ID
	 */
	private Long id;

	/**
	 * 任务ID
	 */
	private Long taskId;

	/**
	 * 状态 0:未运行;1:正在运行;2:异常;3:完成
	 */
	private int status;

	/**
	 * 采集数量
	 */
	private long extarctCount;

	/**
	 * 采集异常
	 */
	private String extractException;

	/**
	 * 输出异常
	 */
	private String exprotException;

	/**
	 * 输出数量
	 */
	private long exportCount;

	/**
	 * 开始时间
	 */
	private Date startTime;

	/**
	 * 开始时间
	 */
	private Date endTime;
	
	public TaskHistory() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public long getExtarctCount() {
		return extarctCount;
	}

	public void setExtarctCount(long extarctCount) {
		this.extarctCount = extarctCount;
	}

	public String getExtractException() {
		return extractException;
	}

	public void setExtractException(String extractException) {
		this.extractException = extractException;
	}

	public String getExprotException() {
		return exprotException;
	}

	public void setExprotException(String exprotException) {
		this.exprotException = exprotException;
	}

	public long getExportCount() {
		return exportCount;
	}

	public void setExportCount(long exportCount) {
		this.exportCount = exportCount;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

}
