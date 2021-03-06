/**The class that displays the color of marble to be selected, uses JPanel
 * Programmer: Michael
 */
package graphics;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ColorOption extends JPanel{
	
	ImageIcon imageIcon;
	Image panel;

	@Override
	protected void paintComponent (Graphics g){
		super.paintComponent(g);
		
		g.drawImage(panel, 0, 0, getWidth(), getHeight(), this);
	}

	public void setColor(String color) {
		imageIcon = new ImageIcon("src/images/"+color+"Marble.png");
		panel = imageIcon.getImage();
	}
}
