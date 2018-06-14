package com.dew.training.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum UserRole {

	ROLE_USER(1),ROLE_ADMIN(2);
	private static final Map<Integer, UserRole> lookup = new HashMap<Integer, UserRole>();
	private int val;

	static {
		for (UserRole s : EnumSet.allOf(UserRole.class))
			lookup.put(s.getValue(), s);
	}

	private UserRole(int val) {
		this.val = val;
	}

	public int getValue() {
		return this.val;
	}

	public static UserRole get(int code) {
		return lookup.get(code);
	}

}
