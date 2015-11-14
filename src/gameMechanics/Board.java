package gameMechanics;

public class Board {
	protected static int length;
	protected static int height;
	protected static Peg[][] board = new Peg[length][height];
	
	public Board(){
	}
	
	public void fillBoard(){
		
	}
	public void printBoard(){
		
	}
	public int getBoardLength(){
		return Board.length;
	}
	public int getHeight(){
		return Board.height;
	}
	public Peg[][] getBoard(){
		return Board.board;
	}
}
