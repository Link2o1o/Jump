package graphics;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class CreateBoard extends JPanel{
	ImageIcon icon = new ImageIcon("images/Board.png");
	Image img = icon.getImage();
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.drawImage(img, 0, 0, getWidth(),getHeight(),this);
	}
}
