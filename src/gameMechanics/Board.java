package gameMechanics;

public class Board {
	protected static int boardLength;
	protected static int boardHeight;
	protected static Peg[][] board = new Peg[boardLength][boardHeight];
	
	public Board(){
	}
	
	public void fillBoard(){
		
	}
	public void printBoard(){
		
	}
	public int getBoardLength(){
		return Board.boardLength;
	}
	public int getBoardHeight(){
		return Board.boardHeight;
	}
	public Peg[][] getBoard(){
		return Board.board;
	}
}
