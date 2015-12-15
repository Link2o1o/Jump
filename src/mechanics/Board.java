/**
 * Allows for future expansion of boards
 * Programmer: Michael
 */
package mechanics;

public class Board {
	public static int length;
	public static int height;
	public static Peg[][] board = new Peg[length][height];
	
	public Board(){
	}
	//unused methods, to be overwritten.  (Used in SquareBoard)
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
