package com.flipkart.exception;

public class SameColorAttackException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public SameColorAttackException() {
		super("Error: Same color attack");
	}
}
