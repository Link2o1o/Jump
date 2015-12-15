package graphics;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class PegButton extends JButton {

	@Override
	protected void paintComponent(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.BLACK);
		g.drawOval((int) (getWidth() * .1), (int) (getHeight() * .1), (int) (getWidth() * .8),
				(int) (getHeight() * .8));
		g.setColor(Color.BLUE);
		g.fillOval((int) (getWidth() * .1), (int) (getHeight() * .1), (int) (getWidth() * .8),
				(int) (getHeight() * .8));
	}
}
