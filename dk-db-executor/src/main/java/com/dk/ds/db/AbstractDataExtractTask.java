package com.dk.ds.db;

import com.dk.ds.Task;

public abstract class AbstractDataExtractTask implements Task{
	
	public String instanceId;

	public String getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}
	
}
