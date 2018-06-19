package com.dew.training.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum EducationType {
	REGULAR(1),correspondenceCORRESPONDENCE(2);
	
	private static final Map<Integer, EducationType> lookup = new HashMap<Integer, EducationType>();
	private int val;

	static {
		for (EducationType s : EnumSet.allOf(EducationType.class))
			lookup.put(s.getValue(), s);
	}

	private EducationType(int val) {
		this.val = val;
	}

	public int getValue() {
		return this.val;
	}

	public static EducationType get(int code) {
		return lookup.get(code);
	}
}
