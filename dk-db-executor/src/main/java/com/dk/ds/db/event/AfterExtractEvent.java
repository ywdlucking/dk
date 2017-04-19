package com.dk.ds.db.event;

import com.dk.ds.db.config.AfterEventConfig;

public interface AfterExtractEvent {
	
	/**
	 * 采集动作后操作
	 * @param config
	 * @return
	 */
	public boolean handle(AfterEventConfig config);

}
