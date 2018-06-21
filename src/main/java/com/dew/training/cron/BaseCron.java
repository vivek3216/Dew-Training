package com.dew.training.cron;

public abstract class BaseCron {
	
	public void executeCron() {

		try {
			execute();
		}catch (Exception e) {
			// TODO: handle exception
		}

	}
	protected abstract String getCronName();

	protected abstract void execute() throws Exception;
}
