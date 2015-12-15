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
		g.drawOval(0, 0,(int)(getWidth()*.98), (int)(getHeight()*.98));
		g.setColor(Color.BLUE);
		g.fillOval(0, 0,(int)(getWidth()*.98), (int)(getHeight()*.98));
	}
}
