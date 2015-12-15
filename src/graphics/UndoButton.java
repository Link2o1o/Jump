/* The mechanics behind undoing a move (eventually the button mechanics)
	Programmer: Michael
 */
package graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mechanics.SaveBoard;

public class UndoButton implements ActionListener{
	private int type;
	public UndoButton(int type){
		this.type = type;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(type){
		case 0:
			SaveBoard.undo();
		}
		DrawBoard.infoText.setText("Undo's Left: " + SaveBoard.possibleUndo);
	}
}
