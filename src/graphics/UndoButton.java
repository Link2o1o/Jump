/* The mechanics behind undoing a move (eventually the button mechanics)
	Programmer: Michael
 */
package graphics;

import mechanics.SaveBoard;

public class UndoButton {
	public UndoButton(int type){
		switch(type){
		case 0:
			SaveBoard.undo();
		}
	}
}
