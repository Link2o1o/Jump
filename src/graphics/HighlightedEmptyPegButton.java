package graphics;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class HighlightedEmptyPegButton extends JButton {

	@Override
	protected void paintComponent(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.YELLOW);
		g.fillOval((int) (getWidth() * .1), (int) (getHeight() * .4), (int) (getWidth() * .8),
				(int) (getHeight() * .5));
		g.setColor(Color.DARK_GRAY);
		g.fillOval((int) (getWidth() * .15), (int) (getHeight() * .45), (int) (getWidth() * .75),
				(int) (getHeight() * .45));
	}
}
