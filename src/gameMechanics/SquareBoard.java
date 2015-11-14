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
		
		for (int a = 0; a < board.length; a++) {
			for (int b = 0; b < board.length; b++) {
				board[a][b] = new Peg();
				board[a][b].setPlaced(true);
			}
		}
		board[2][2].setPlaced(false);
	}

	/*
	 * Prints the Square board
	 */
	@Override
	public void printBoard() {

		for (int i = 0; i < board.length; i++) {

			System.out.println();

			for (int j = 0; j < board.length; j++) {
				System.out.print(board[i][j]);
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
	 * returns the board itself  (These are kind of unnecessary)
	 */
	@Override
	public Peg[][] getBoard() {
		return SquareBoard.board;
	}

}