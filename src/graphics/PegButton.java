package graphics;

import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class PegButton extends JButton {

	boolean empty = false;
	ImageIcon imageIcon = new ImageIcon("images/RedMarble.png");
	Image marble = imageIcon.getImage();
	Graphics graphic;

	@Override
	protected void paintComponent(Graphics g) {
		graphic = g;
		super.paintComponent(g);
		
		if(!empty)
			graphic.drawImage(marble, 0, 0, getWidth(), getHeight(), this);
	}

	public void setHighlights() {
		graphic.setColor(Color.YELLOW);
	}

	public void setEmpty(boolean isEmpty) {
		empty = isEmpty;
		repaint();
	}
}