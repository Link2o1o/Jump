package graphics;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class PegButton extends JButton {

	ImageIcon imageIcon = new ImageIcon("images/RedMarble.png");
	Image marble = imageIcon.getImage();

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);

		g.drawImage(marble, 0, 0, getWidth(), getHeight(), this);
}
}