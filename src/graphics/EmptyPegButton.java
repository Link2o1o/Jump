package graphics;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class EmptyPegButton extends JButton {

	@Override
	protected void paintComponent(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.BLACK);
		g.drawOval((int) (getWidth() * .1), (int) (getHeight() * .4), (int) (getWidth() * .8),
				(int) (getHeight() * .5));
		g.setColor(Color.DARK_GRAY);
		g.fillOval((int) (getWidth() * .1), (int) (getHeight() * .4), (int) (getWidth() * .8),
				(int) (getHeight() * .5));
	}
}
