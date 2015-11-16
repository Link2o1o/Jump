/**The mechanics behind restarting the game. (eventually the button mechanics)
 * Programmer: Michael
 */
package gameMechanics;

public class ResetButton {
	public ResetButton(int type){
		new ResetBoard(type);
		new SaveBoard();
	}
}
