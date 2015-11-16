/* The mechanics behind restarting the game. (eventually the button mechanics)
 */
package gameMechanics;

public class ResetButton {
	public ResetButton(int type){
		new ResetBoard(type);
		new SaveBoard();
	}
}
