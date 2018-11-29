package com.flipkart.factory;

import com.flipkart.constant.Entity;
import com.flipkart.entities.EntityMove;
import com.flipkart.entities.impl.Horse;
import com.flipkart.entities.impl.Pawn;
import com.flipkart.entities.impl.Queen;

//FactoryClass
public class EntityFactory {

	public EntityMove getEntityMove(Entity entity) {

		switch (entity) {

		case PAWN:
			return new Pawn();
		case HORSE:
			return new Horse();
		case QUEEN:
			return new Queen();
		default:
			return null;

		}
	}

}
