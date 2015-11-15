package gameMechanics;

public class Board {
	protected static int length;
	protected static int height;
	protected static Peg[][] board = new Peg[length][height];
	
	public Board(){
	}
	//unused methods, to be overwritten.
	public static void fillBoard(){
		
	}
	public static void printBoard(){
		
	}
	public int getLength(){
		return Board.length;
	}
	public int getHeight(){
		return Board.height;
	}
	public Peg[][] getBoard(){
		return Board.board;
	}
}
