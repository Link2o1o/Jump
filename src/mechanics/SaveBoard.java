/**	Programmer: Michael
 *	SaveBoard saves moves to an ArrayList and then retrieves each move and performs the opposite action.
 */
package mechanics;

import java.util.ArrayList;

import graphics.CreateBoard;

public class SaveBoard {
	static ArrayList<String> moves = new ArrayList<String>();
	public static int possibleUndo = 3;
	private static int index = 0;
	public static String undoMessage;

	/**
	 * no-arg constructor, currently used to make empty SaveBoard Objects
	 */
	public SaveBoard() {
		moves.clear();
	}
	/**
	 * Saves an entire move to an ArrayList to be retrieved later.
	 * @param movedTo
	 * @param jumpedOver
	 * @param movedFrom
	 */
	public static void save(String movedTo, String jumpedOver, String movedFrom) {
			moves.add(movedTo);
			moves.add(jumpedOver);
			moves.add(movedFrom);
			index = moves.size()-1;
	}

	/**
	 * For undoing last move up to three times possible.
	 */
	public static void undo() {
		int[] firstMove, secondMove, thirdMove;
		//limits three moves
		if (possibleUndo != 0) {
			//Retrieves the last move and reverses it.
				firstMove = MovePiece.parseStringToLoc(moves.get(index-2));
				SquareBoard.board[firstMove[0]][firstMove[1]].setPlaced(false);
				CreateBoard.board[firstMove[0]][firstMove[1]].setEmpty(true);
				secondMove = MovePiece.parseStringToLoc(moves.get(index-1));
				SquareBoard.board[secondMove[0]][secondMove[1]].setPlaced(true);
				CreateBoard.board[secondMove[0]][secondMove[1]].setEmpty(false);
				thirdMove = MovePiece.parseStringToLoc(moves.get(index));
				SquareBoard.board[thirdMove[0]][thirdMove[1]].setPlaced(true);
				CreateBoard.board[thirdMove[0]][thirdMove[1]].setEmpty(false);
				moves.remove(index-2);
				moves.remove(index-2);
				moves.remove(index-2);
				index = index - 3;
				possibleUndo--;
		} else
			undoMessage = ""+possibleUndo;

	}
	
	public static void resetUndo(){
		CreateBoard.undoText.setText("Undo's left: 3");
		SaveBoard.moves.clear();
		SaveBoard.index = 0;
		SaveBoard.possibleUndo = 3;
	}

}
