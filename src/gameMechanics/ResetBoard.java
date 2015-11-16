/**
 * Resets the board to its start, StartButton resets undo's
 * Programmer: Michael
 */
package gameMechanics;

public class ResetBoard {
	public ResetBoard(int type){
		switch(type){
		case 0:
			SquareBoard.fillBoard();
		}
	}

}
