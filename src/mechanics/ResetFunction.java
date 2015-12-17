/**The mechanics behind restarting the game. (eventually the button mechanics)
 * Programmer: Michael
 */
package mechanics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResetFunction implements ActionListener{
	private int type;
	public ResetFunction(int type){
		this.type = type;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		new ResetBoard(type);
		new SaveBoard();
	}
}
