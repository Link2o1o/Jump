package gameMechanics;

public class SquareBoard extends Board{
	
	public SquareBoard() {
		SquareBoard.boardLength = 5;
		SquareBoard.boardHeight = 5;
	}

	public void fillBoard() {
		
		for (int a = 0; a < board.length; a++) {
			for (int b = 0; b < board.length; b++) {
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
	public void printBoard(){
		
	}
	@Override
	public int getBoardLength(){
		return SquareBoard.boardLength;
	}
	@Override
	public int getBoardHeight(){
		return SquareBoard.boardHeight;
	}
	@Override
	public Peg[][] getBoard(){
		return Board.board;
	}

	public void makeMove() {
		
	}
}