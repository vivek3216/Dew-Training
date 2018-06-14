package com.dew.training.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum Gender {

	MALE(1),FEMALE(2),OTHER(3);
	
	private static final Map<Integer, Gender> lookup = new HashMap<Integer, Gender>();
	private int val;

	static {
		for (Gender s : EnumSet.allOf(Gender.class))
			lookup.put(s.getValue(), s);
	}

	private Gender(int val) {
		this.val = val;
	}

	public int getValue() {
		return this.val;
	}

	public static Gender get(int code) {
		return lookup.get(code);
	}
}
