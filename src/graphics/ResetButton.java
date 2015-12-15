/**The mechanics behind restarting the game. (eventually the button mechanics)
 * Programmer: Michael
 */
package graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mechanics.ResetBoard;
import mechanics.SaveBoard;

public class ResetButton implements ActionListener{
	private int type;
	public ResetButton(int type){
		this.type = type;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		new ResetBoard(type);
		new DrawBoard();
		new SaveBoard();
	}
}
