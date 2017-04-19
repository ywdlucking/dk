package com.dk.ds.db.event;

import com.dk.ds.db.config.BeforeEventConfig;

public interface BeforeExtractEvent {

	/**
	 * 采集动作前操作
	 * @param config
	 * @return
	 */
	public boolean handle(BeforeEventConfig config);
	
}
