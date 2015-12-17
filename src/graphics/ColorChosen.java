package graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorChosen implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == PickColorMarble.rMarble){
			CreateBoard.setBoardColor(PegButton.RED);
		}
		else if(e.getSource() == PickColorMarble.bMarble){
			CreateBoard.setBoardColor(PegButton.BLUE);
		}
		else if(e.getSource() == PickColorMarble.gMarble){
			CreateBoard.setBoardColor(PegButton.GREEN);
		}
		else if(e.getSource() == PickColorMarble.yMarble){
			CreateBoard.setBoardColor(PegButton.YELLOW);
		}
		else if(e.getSource() == PickColorMarble.pMarble){
			CreateBoard.setBoardColor(PegButton.PINK);
		}
	}

}
