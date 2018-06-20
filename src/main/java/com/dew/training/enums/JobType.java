package com.dew.training.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum JobType {

	

PERMANENT(1),TEMPORARY(2),BOTH(3);
	
	private static final Map<Integer, JobType> lookup = new HashMap<Integer, JobType>();
	private int val;

	static {
		for (JobType s : EnumSet.allOf(JobType.class))
			lookup.put(s.getValue(), s);
	}

	private JobType(int val) {
		this.val = val;
	}

	public int getValue() {
		return this.val;
	}

	public static JobType get(int code) {
		return lookup.get(code);
	}

}
