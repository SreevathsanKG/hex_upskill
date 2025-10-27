package com.hex.ecomcs.enums;

public enum Offer {
	DISCOUNT_10(10),
	DISCOUNT_20(20),
	DISCUNT_30(30);
	
	private final int value;
	
	public int getValue() {
		return value;
	}
	
	Offer(int value) {
		this.value = value;
	}

	
}
