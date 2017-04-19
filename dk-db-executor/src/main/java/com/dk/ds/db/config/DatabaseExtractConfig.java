package com.dk.ds.db.config;

public class DatabaseExtractConfig {
	
	private boolean beforeEvent;
	
	private BeforeEventConfig beforeEventConfig;
	
	private boolean afterEvent;
	
	private AfterEventConfig aftereEventConfig;

	public boolean isBeforeEvent() {
		return beforeEvent;
	}

	public void setBeforeEvent(boolean beforeEvent) {
		this.beforeEvent = beforeEvent;
	}

	public BeforeEventConfig getBeforeEventConfig() {
		return beforeEventConfig;
	}

	public void setBeforeEventConfig(BeforeEventConfig beforeEventConfig) {
		this.beforeEventConfig = beforeEventConfig;
	}

	public boolean isAfterEvent() {
		return afterEvent;
	}

	public void setAfterEvent(boolean afterEvent) {
		this.afterEvent = afterEvent;
	}

	public AfterEventConfig getAftereEventConfig() {
		return aftereEventConfig;
	}

	public void setAftereEventConfig(AfterEventConfig aftereEventConfig) {
		this.aftereEventConfig = aftereEventConfig;
	}
	
	

}
