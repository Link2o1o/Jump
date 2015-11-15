package gameMechanics;

public class SquareBoard extends Board {

	public SquareBoard() {
		SquareBoard.length = 5;
		SquareBoard.height = 5;
		SquareBoard.board = new Peg[length][height];
	}

	/*
	 * Fills the Square board
	 */
	public void fillBoard() {

		for (int a = 0; a < SquareBoard.board.length; a++) {
			for (int b = 0; b < SquareBoard.board.length; b++) {
				SquareBoard.board[a][b] = new Peg();
				SquareBoard.board[a][b].setPlaced(true);
			}
		}
		SquareBoard.board[2][2].setPlaced(false);
	}

	/*
	 * Prints the Square board
	 */
	@Override
	public void printBoard() {

		// Prints column numbers
		System.out.print("  12345");

		for (int i = 0; i < SquareBoard.board.length; i++) {

			System.out.println();
			// Prints row letter
			if (i == 0)
				System.out.print("A ");
			else if (i == 1)
				System.out.print("B ");
			else if (i == 2)
				System.out.print("C ");
			else if (i == 3)
				System.out.print("D ");
			else if (i == 4)
				System.out.print("E ");

			for (int j = 0; j < SquareBoard.board.length; j++) {
				System.out.print(SquareBoard.board[i][j]);

			}

		}
	}

	/*
	 * returns the Board Length
	 */
	@Override
	public int getLength() {
		return SquareBoard.length;
	}

	/*
	 * returns the board height
	 */
	@Override
	public int getHeight() {
		return SquareBoard.height;
	}

	/*
	 * returns the board itself (These are kind of unnecessary)
	 */
	@Override
	public Peg[][] getBoard() {
		return SquareBoard.board;
	}

}