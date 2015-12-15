package graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Quit implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		Init.frame.dispose();
		
	}

}
