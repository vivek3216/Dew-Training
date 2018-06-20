package com.dew.training.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum Preference {
	

FULL_TIME(1),PART_TIME(2),INTERNSHIP(3);
	
	private static final Map<Integer, Preference> lookup = new HashMap<Integer, Preference>();
	private int val;

	static {
		for (Preference s : EnumSet.allOf(Preference.class))
			lookup.put(s.getValue(), s);
	}

	private Preference(int val) {
		this.val = val;
	}

	public int getValue() {
		return this.val;
	}

	public static Preference get(int code) {
		return lookup.get(code);
	}
}
