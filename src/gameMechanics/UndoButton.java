/* The mechanics behind undoing a move (eventually the button mechanics)
 */
package gameMechanics;

public class UndoButton {
	public UndoButton(Peg[][] board,int type){
		switch(type){
		case 0:
			SaveBoard.undo(board);
		}
	}
}
