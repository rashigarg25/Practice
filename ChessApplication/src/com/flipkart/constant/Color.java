package com.flipkart.constant;

public enum Color {

	BLACK("B"), WHITE("W");

	private String symbol;

	private Color(String symbol) {
		this.symbol = symbol;
	}

	public String getSymbol() {
		return this.symbol;
	}

	public String getName(String s) {
		return this.getName(s);
	}

}
