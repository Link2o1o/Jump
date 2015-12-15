package graphics;

import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class PegButton extends JButton {

	public static final int FULL = 0;
	public static final int EMPTY = 1;
	public static final int CLEAR = 2;
	private int type;
	private boolean empty = false;
	ImageIcon imageIcon = new ImageIcon("images/RedMarble.png");
	Image marble = imageIcon.getImage();
	private boolean highlighted = false;
	Graphics graphic;

	@Override
	protected void paintComponent(Graphics g) {
		graphic = g;
		super.paintComponent(g);

		if (!empty) {
			graphic.drawImage(marble, 0, 0, getWidth(), getHeight(), this);
			switch (type) {
			case 0:
				if (highlighted) {
					graphic.setColor(Color.GREEN);
					graphic.drawOval(0, 0, getWidth(), getHeight());
				}
				break;
			case 1:
				if (highlighted)
					graphic.setColor(Color.YELLOW);
				graphic.drawOval(0, 0, getWidth(), getHeight());
				break;
			}
		}

	}

	public void setHighlights(boolean isHighlighted, int type) {
		highlighted = isHighlighted;
		this.type = type;
		repaint();
	}

	public void setHighlights(boolean isHighlighted) {
		highlighted = isHighlighted;
		repaint();
	}

	public void setEmpty(boolean isEmpty) {
		empty = isEmpty;
		repaint();
	}

	public boolean isHighlighted() {
		// TODO Auto-generated method stub
		return highlighted;
	}
}