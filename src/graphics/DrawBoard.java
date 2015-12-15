package graphics;

import java.awt.*;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class DrawBoard extends JPanel{
	
	@Override
	protected void paintComponent(Graphics g){
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, getWidth(), getHeight());
	}
}
