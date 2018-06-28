package com.dew.training.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum Start {
	
IMMEDIATELY(1), LATER_DATE(2);
	
	private static final Map<Integer, Start> lookup = new HashMap<Integer, Start>();
	private int val;

	static {
		for (Start s : EnumSet.allOf(Start.class))
			lookup.put(s.getValue(), s);
	}

	private Start(int val) {
		this.val = val;
	}

	public int getValue() {
		return this.val;
	}

	public static Start get(int code) {
		return lookup.get(code);
	}

}
