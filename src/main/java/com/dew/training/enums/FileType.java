package com.dew.training.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum FileType {

	IMAGE(1),RESUME(2),PASSPORT(3),AADHAR(4);

	private static final Map<Integer, FileType> lookup = new HashMap<Integer, FileType>();
	private int val;

	static {
		for (FileType s : EnumSet.allOf(FileType.class))
			lookup.put(s.getValue(), s);
	}

	private FileType(int val) {
		this.val = val;
	}

	public int getValue() {
		return this.val;
	}

	public static FileType get(int code) {
		return lookup.get(code);
	}
}
