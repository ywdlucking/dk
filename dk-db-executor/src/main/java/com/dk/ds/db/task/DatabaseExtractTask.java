package com.dk.ds.db.task;

import com.dk.ds.db.AbstractDataExtractTask;
import com.dk.ds.db.config.DatabaseExtractConfig;
import com.dk.ds.db.event.AfterExtractEvent;
import com.dk.ds.db.event.BeforeExtractEvent;

public class DatabaseExtractTask extends AbstractDataExtractTask {
	
	private DatabaseExtractConfig databaseExtractConfig;
	
	private BeforeExtractEvent beforeExtractEvent;
	
	private AfterExtractEvent afterExtractEvent;

	@Override
	public void excute() {
		//执行前操作
		if(databaseExtractConfig.isBeforeEvent()){
			beforeExtractEvent.handle(databaseExtractConfig.getBeforeEventConfig());
		}
		
		
		
		//执行后操作
		if(databaseExtractConfig.isAfterEvent()){
			afterExtractEvent.handle(databaseExtractConfig.getAftereEventConfig());
		}
	}

}
