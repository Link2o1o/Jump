package graphics;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.*;

@SuppressWarnings("serial")
public class DrawFrame extends JPanel {
	
	ImageIcon imageIcon = new ImageIcon("images/Frame.png");
	Image frame = imageIcon.getImage();

	protected void paintComponent (Graphics g){

		g.drawImage(frame, 0, 0, getWidth(), getHeight(), this);

		
		
	}
	
	
}
