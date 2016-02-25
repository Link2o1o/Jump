package mechanics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import graphics.CreateBoard;

public class GameTimer implements ActionListener{
	private int minutes = 0;
	private int seconds = 0;

	@Override
	public void actionPerformed(ActionEvent e) {
		seconds += 1;
		
		if(seconds == 60){
			minutes += 1;
			CreateBoard.timer.setText(minutes + ":00");
			seconds = 0;
		}
		else if(seconds > 9)
			CreateBoard.timer.setText(minutes + ":" + seconds);
		else
			CreateBoard.timer.setText(minutes + ":0" + seconds);
	}
}
