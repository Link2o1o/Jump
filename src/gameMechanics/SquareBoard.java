package gameMechanics;

import java.util.Scanner;

public class SquareBoard {
	static int boardLength;
	static int boardHeight;
	static Peg[][] board = new Peg[boardLength][boardHeight];
	

	public SquareBoard() {
		SquareBoard.boardLength = 5;
		SquareBoard.boardHeight = 5;
	}

	public void fillBoard() {
		
		for (int a = 0; a < board.length; a++) {
			for (int b = 0; b < board.length; b++) {
				Peg temp = new Peg();
				temp.setCol(b);
				temp.setRow(a);
				board[a][b] = temp;
			}
		}

		for (int i = 0; i < board.length; i++) {

			System.out.println();

			for (int j = 0; j < board.length; j++) {
				System.out.print(board[i][j]);
			}
		}
	}
	public int length(){
		return SquareBoard.boardLength;
	}
	public int height(){
		return SquareBoard.boardHeight;
	}

}