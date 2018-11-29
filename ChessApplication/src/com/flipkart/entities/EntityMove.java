package com.flipkart.entities;

import com.flipkart.domain.ChessSquare;
import com.flipkart.domain.Position;

public interface EntityMove {

	public boolean isValidMove(ChessSquare[][] chessBoard, Position initialPosition, Position finalPosition);

}
