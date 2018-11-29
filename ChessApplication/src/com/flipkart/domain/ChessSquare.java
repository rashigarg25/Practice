package com.flipkart.domain;

import com.flipkart.constant.Color;
import com.flipkart.constant.Entity;

public class ChessSquare {

	private Color color;
	private Entity entity;

	public ChessSquare(Color color, Entity entity) {
		super();
		this.color = color;
		this.entity = entity;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Entity getEntity() {
		return entity;
	}

	public void setEntity(Entity entity) {
		this.entity = entity;
	}

	@Override
	public String toString() {
		return color.getSymbol() + entity.getSymbol();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((entity == null) ? 0 : entity.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChessSquare other = (ChessSquare) obj;
		if (color != other.color)
			return false;
		if (entity != other.entity)
			return false;
		return true;
	}

}
