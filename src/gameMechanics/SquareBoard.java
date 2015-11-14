package gameMechanics;

public class SquareBoard extends Board {

	public SquareBoard() {
		SquareBoard.length = 5;
		SquareBoard.height = 5;
		SquareBoard.board = new Peg[length][height];
	}

	public void fillBoard() {
		
		for (int a = 0; a < board.length; a++) {
			for (int b = 0; b < board.length; b++) {
			if (a ==2 && b ==2){
			    board[a][b] = new Peg();
				board[a][b].setPlaced(false);
			}
			else				
				board[a][b] = new Peg();
				board[a][b].setPlaced(true);
		
			}
		}

		for (int i = 0; i < board.length; i++) {

			System.out.println();

			for (int j = 0; j < board.length; j++) {
				System.out.print(board[i][j]);
			}
		}
	}

	@Override
	public void printBoard() {

	}

	@Override
	public int getBoardLength() {
		return SquareBoard.length;
	}

	@Override
	public int getHeight() {
		return SquareBoard.height;
	}

	@Override
	public Peg[][] getBoard() {
		return Board.board;
	}

	public void makeMove() {

	}
}