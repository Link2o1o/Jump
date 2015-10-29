package gameMechanics;

import java.util.Scanner;

public class SquareBoard {

	char[][] board = new char[5][5];

	public SquareBoard() {
	}

	public void fillBoard() {
		for (int a = 0; a < board.length; a++) {
			for (int b = 0; b < board.length; b++) {
				board[a][b] = '*';

			}
		}

		for (int i = 0; i < board.length; i++) {

			System.out.println();

			for (int j = 0; j < board.length; j++) {
				System.out.print(board[i][j]);
			}
		}
	}

}