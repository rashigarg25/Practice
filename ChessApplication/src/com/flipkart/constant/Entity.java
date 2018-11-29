package com.flipkart.constant;

public enum Entity {

	QUEEN("Q"), HORSE("H"), PAWN("P"), ROOK("R"), BISHOP("B"), KING("K");

	private String symbol;

	private Entity(String symbol) {
		this.symbol = symbol;
	}

	public String getSymbol() {
		return this.symbol;
	}

}
