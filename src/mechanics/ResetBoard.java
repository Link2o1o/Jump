/**
 * Resets the board to its start, StartButton resets undo's
 * Programmer: Michael
 */
package mechanics;

public class ResetBoard {
	public ResetBoard(int type){
		switch(type){
		case 0:
			SquareBoard.fillBoard();
		}
	}

}
