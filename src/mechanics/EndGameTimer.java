package mechanics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import graphics.CreateBoard;

public class EndGameTimer implements ActionListener{
	private int count = 0;
	private String text;

	@Override
	public void actionPerformed(ActionEvent e) {
		if(count == 0){
			text = CreateBoard.timer.getText();
			CreateBoard.timer.setText("        ");
			count = 1;
		}
		else{
			CreateBoard.timer.setText(text);
			count = 0;
		}
	}

}
