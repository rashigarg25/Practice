package com.flipkart;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.flipkart.constant.Color;
import com.flipkart.constant.Entity;
import com.flipkart.domain.ChessSquare;
import com.flipkart.domain.Position;
import com.flipkart.exception.InvalidInputException;
import com.flipkart.exception.InvalidMoveException;
import com.flipkart.exception.SameColorAttackException;
import com.flipkart.factory.EntityFactory;

public class ChessMain {

	public static void main(String[] args) {

		EntityFactory factory = new EntityFactory();

		ChessSquare[][] chessBoard = createChessBoard();
		printChess(chessBoard);

		List<String> inputs = takeInputForMoves();

		for (String input : inputs) {
			String[] in = input.split(" ");

			System.out.println();
			System.out.println("---------------------------------------------");
			System.out.println();
			try {
				Position initialPos = parsePosition(in[1]);
				Position finalPos = parsePosition(in[2]);
				ChessSquare entity = parseChessSquare(in[0]);
				validateInitalPosition(chessBoard[initialPos.getX()][initialPos.getY()], entity);
				factory.getEntityMove(entity.getEntity()).isValidMove(chessBoard, initialPos, finalPos);
				moveValues(chessBoard, initialPos, finalPos);
				printChess(chessBoard);

			} catch (InvalidInputException e) {
				System.out.println(e.getMessage());
			} catch (InvalidMoveException e) {
				System.out.println(e.getMessage());
			} catch (SameColorAttackException e) {
				System.out.println(e.getMessage());
			} catch (Exception e) {
				System.out.println("Invalid ----");
			}
		}

	}

	private static ChessSquare[][] moveValues(ChessSquare[][] chessBoard, Position initialPos, Position finalPos) {

		chessBoard[finalPos.getX()][finalPos.getY()] = chessBoard[initialPos.getX()][initialPos.getY()];
		chessBoard[initialPos.getX()][initialPos.getY()] = null;
		return chessBoard;

	}

	private static List<String> takeInputForMoves() {
		List<String> inputs = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		/*
		 * inputs.add("WP 12 22"); inputs.add("BP 60 64"); inputs.add("BH 71 50");
		 * inputs.add("WQ 03 30");
		 */
		System.out.println("No of inputs --> ");
		int input = sc.nextInt();

		System.out.println("Enter inputs --> ");
		while (input >= 0) {

			inputs.add(sc.nextLine());
			input--;
		}

		sc.close();
		inputs.remove(0);
		return inputs;

	}

	private static boolean validateInitalPosition(ChessSquare actual, ChessSquare input) {

		if (actual.equals(input)) {
			return true;
		}
		return false;

	}

	private static ChessSquare parseChessSquare(String s) throws InvalidInputException {

		char[] ch = s.trim().toCharArray();
		Color color = null;
		switch (ch[0]) {
		case 'B':
			color = Color.BLACK;
			break;
		case 'W':
			color = Color.WHITE;
			break;
		default:
			throw new InvalidInputException();
		}
		Entity entity = null;
		switch (ch[1]) {
		case 'H':
			entity = Entity.HORSE;
			break;
		case 'B':
			entity = Entity.BISHOP;
			break;
		case 'K':
			entity = Entity.KING;
			break;
		case 'Q':
			entity = Entity.QUEEN;
			break;
		case 'P':
			entity = Entity.PAWN;
			break;
		case 'R':
			entity = Entity.ROOK;
			break;
		default:
			throw new InvalidInputException();
		}

		return new ChessSquare(color, entity);

	}

	private static Position parsePosition(String s) {

		char[] ch = s.trim().toCharArray();
		int x = Character.getNumericValue(ch[0]);

		return new Position(x, Character.getNumericValue(ch[1]));

	}

	public static void printChess(ChessSquare[][] chessBoard) {

		for (int i = 0; i < chessBoard.length; i++) {
			for (int j = 0; j < chessBoard[i].length; j++) {

				String val = chessBoard[i][j] != null ? chessBoard[i][j].toString() : "--";
				System.out.print(val + "  ");
			}
			System.out.println();
		}

	}

	public static ChessSquare[][] createChessBoard() {

		ChessSquare[][] chessBoard = new ChessSquare[9][9];
		chessBoard[0][0] = new ChessSquare(Color.WHITE, Entity.ROOK);
		chessBoard[0][1] = new ChessSquare(Color.WHITE, Entity.HORSE);
		chessBoard[0][2] = new ChessSquare(Color.WHITE, Entity.BISHOP);
		chessBoard[0][3] = new ChessSquare(Color.WHITE, Entity.QUEEN);
		chessBoard[0][4] = new ChessSquare(Color.WHITE, Entity.KING);
		chessBoard[0][5] = new ChessSquare(Color.WHITE, Entity.BISHOP);
		chessBoard[0][6] = new ChessSquare(Color.WHITE, Entity.HORSE);
		chessBoard[0][7] = new ChessSquare(Color.WHITE, Entity.ROOK);
		chessBoard[1][0] = new ChessSquare(Color.WHITE, Entity.PAWN);
		chessBoard[1][1] = new ChessSquare(Color.WHITE, Entity.PAWN);
		chessBoard[1][2] = new ChessSquare(Color.WHITE, Entity.PAWN);
		chessBoard[1][3] = new ChessSquare(Color.WHITE, Entity.PAWN);
		chessBoard[1][4] = new ChessSquare(Color.WHITE, Entity.PAWN);
		chessBoard[1][5] = new ChessSquare(Color.WHITE, Entity.PAWN);
		chessBoard[1][6] = new ChessSquare(Color.WHITE, Entity.PAWN);
		chessBoard[1][7] = new ChessSquare(Color.WHITE, Entity.PAWN);

		chessBoard[6][0] = new ChessSquare(Color.BLACK, Entity.PAWN);
		chessBoard[6][1] = new ChessSquare(Color.BLACK, Entity.PAWN);
		chessBoard[6][2] = new ChessSquare(Color.BLACK, Entity.PAWN);
		chessBoard[6][3] = new ChessSquare(Color.BLACK, Entity.PAWN);
		chessBoard[6][4] = new ChessSquare(Color.BLACK, Entity.PAWN);
		chessBoard[6][5] = new ChessSquare(Color.BLACK, Entity.PAWN);
		chessBoard[6][6] = new ChessSquare(Color.BLACK, Entity.PAWN);
		chessBoard[6][7] = new ChessSquare(Color.BLACK, Entity.PAWN);
		chessBoard[7][0] = new ChessSquare(Color.BLACK, Entity.ROOK);
		chessBoard[7][1] = new ChessSquare(Color.BLACK, Entity.HORSE);
		chessBoard[7][2] = new ChessSquare(Color.BLACK, Entity.BISHOP);
		chessBoard[7][3] = new ChessSquare(Color.BLACK, Entity.QUEEN);
		chessBoard[7][4] = new ChessSquare(Color.BLACK, Entity.KING);
		chessBoard[7][5] = new ChessSquare(Color.BLACK, Entity.BISHOP);
		chessBoard[7][6] = new ChessSquare(Color.BLACK, Entity.HORSE);
		chessBoard[7][7] = new ChessSquare(Color.BLACK, Entity.ROOK);
		return chessBoard;

	}

}
