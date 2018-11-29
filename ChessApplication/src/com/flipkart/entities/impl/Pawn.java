package com.flipkart.entities.impl;

import com.flipkart.constant.Color;
import com.flipkart.domain.ChessSquare;
import com.flipkart.domain.Position;
import com.flipkart.entities.EntityMove;
import com.flipkart.exception.InvalidMoveException;
import com.flipkart.exception.SameColorAttackException;

public class Pawn implements EntityMove {

	@Override
	public boolean isValidMove(ChessSquare[][] chessBoard, Position initialPosition, Position finalPosition) {

		// boolean isValid = false;
		boolean validX = false;
		boolean validY = false;
		int initalX = initialPosition.getX();
		int initalY = initialPosition.getY();
		int finalX = finalPosition.getX();
		int finalY = finalPosition.getY();

		ChessSquare initialSquare = chessBoard[initalX][initalY];
		ChessSquare finalSquare = chessBoard[finalX][finalY];

		if (chessBoard[initalX][initalY].getColor() == Color.BLACK) {
			if ((finalX + 1) == initalX) {
				validX = true;
			}
			if (initalY == finalY && chessBoard[finalX][finalY] == null) {
				validY = true;
			}
			int diff = Math.abs(finalY - initalY);
			if (diff == 1 && chessBoard[finalX][finalY] != null) {
				validY = true;
			}
		} else if (chessBoard[initalX][initalY].getColor() == Color.WHITE) {
			if ((finalX - 1) == initalX) {
				validX = true;
			}
			if (initalY == finalY && chessBoard[finalX][finalY] == null) {
				validY = true;
			}
			int diff = Math.abs(finalY - initalY);
			if (diff == 1 && chessBoard[finalX][finalY] != null) {
				validY = true;
			}
		}

		if (!validX || !validY)

		{
			throw new InvalidMoveException();
		}
		if (finalSquare != null && finalSquare.getColor() == initialSquare.getColor()) {
			throw new SameColorAttackException();
		}

		return validX && validY;

	}

}
