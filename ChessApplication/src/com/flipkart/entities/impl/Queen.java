package com.flipkart.entities.impl;

import com.flipkart.domain.ChessSquare;
import com.flipkart.domain.Position;
import com.flipkart.entities.EntityMove;
import com.flipkart.exception.InvalidMoveException;
import com.flipkart.exception.SameColorAttackException;

public class Queen implements EntityMove {

	@Override
	public boolean isValidMove(ChessSquare[][] chessBoard, Position initialPosition, Position finalPosition) {
		boolean valid = false;
		int initalX = initialPosition.getX();
		int initalY = initialPosition.getY();
		int finalX = finalPosition.getX();
		int finalY = finalPosition.getY();

		ChessSquare initialSquare = chessBoard[initalX][initalY];
		ChessSquare finalSquare = chessBoard[finalX][finalY];

		if (initalX == finalX) {
			valid = true;
			int start = initalY;
			int end = finalY;
			if (initalY > finalY) {
				start = finalY;
				end = initalY;
			}
			for (int i = start; i < end; i++) {
				if (chessBoard[initalX][i] != null) {
					valid = false;
					break;
				}
			}
		}
		if (initalY == finalY) {
			valid = true;
			int start = initalX;
			int end = finalY;
			if (initalX > finalX) {
				start = finalX;
				end = initalX;
			}
			for (int i = start; i < end; i++) {
				if (chessBoard[i][initalY] != null) {
					valid = false;
					break;
				}
			}
		}
		if ((Math.abs(finalX - initalX) == Math.abs(finalY - finalX))) {

			valid = true;

		}
		if (!valid) {
			throw new InvalidMoveException();
		}
		if (valid && finalSquare != null && finalSquare.getColor() == initialSquare.getColor()) {
			throw new SameColorAttackException();
		}

		return valid;
	}

}
