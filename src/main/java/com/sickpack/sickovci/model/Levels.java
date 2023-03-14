package com.sickpack.sickovci.model;

public enum Levels {
	ROOKIE("ROOKIE"),
	INTERMEDIATE("INTERMEDIATE"),
	PRO("PRO");
	
    private Levels(String value) {
        this.value = value;
    }

    private final String value;

    public String getValue() {
        return value;
    }
}
