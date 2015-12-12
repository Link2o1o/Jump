/**The mechanics behind restarting the game. (eventually the button mechanics)
 * Programmer: Michael
 */
package gameGraphics;

import gameMechanics.ResetBoard;
import gameMechanics.SaveBoard;

public class ResetButton {
	public ResetButton(int type){
		new ResetBoard(type);
		new SaveBoard();
	}
}
