/**A helper class design to bridge the peg class from the mechanics and buttons
 * Programmer: Michael and Jonas
 */
package graphics;

import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class PegButton extends JButton {
	//Initializes colors and marbles
	public static final int RED = 0;
	public static final int BLUE = 1;
	public static final int GREEN = 2;
	public static final int PINK = 3;
	public static final int YELLOW = 4;
	private boolean empty = false;
	private static ImageIcon redMarble = new ImageIcon("src/images/RedMarble.png");
	private static Image rMarble = redMarble.getImage();
	private static ImageIcon blueMarble = new ImageIcon("src/images/BlueMarble.png");
	private static Image bMarble = blueMarble.getImage();
	private static ImageIcon greenMarble = new ImageIcon("src/images/GreenMarble.png");
	private static Image gMarble = greenMarble.getImage();
	private static ImageIcon pinkMarble = new ImageIcon("src/images/PinkMarble.png");
	private static Image pMarble = pinkMarble.getImage();
	private static ImageIcon yellowMarble = new ImageIcon("src/images/YellowMarble.png");
	private static Image yMarble = yellowMarble.getImage();
	private boolean highlighted = false;
	private int colorType;
	private Graphics graphic;

	@Override
	//Paints the button according to color and if its highlighted, also removes the marble's icon
	protected void paintComponent(Graphics g) {
		graphic = g;
		super.paintComponent(g);

		//Checks if there is a marble there or not
		if (!empty) {
			//Takes the color and returns the image of the appropriate color
			switch (colorType) {
			case 0:
				graphic.drawImage(rMarble, 0, 0, getWidth(), getHeight(), this);
				break;
			case 1:
				graphic.drawImage(bMarble, 0, 0, getWidth(), getHeight(), this);
				break;
			case 2:
				graphic.drawImage(gMarble, 0, 0, getWidth(), getHeight(), this);
				break;
			case 3:
				graphic.drawImage(pMarble, 0, 0, getWidth(), getHeight(), this);
				break;
			case 4:
				graphic.drawImage(yMarble, 0, 0, getWidth(), getHeight(), this);
				break;
			}
			//Highlights the button selected
			if (highlighted) {
				graphic.setColor(Color.CYAN);
				for (int i = 0; i < 20; i++)
					graphic.drawOval((int) (0 + i * .1), (int) (0 + i * .1), (int) (getWidth() - i * .2),
							(int) (getHeight() - i * .2));
			}
		}

	}
	
	//Used to set if the button is highlighted or not
	public void setHighlights(boolean isHighlighted) {
		highlighted = isHighlighted;
		repaint();
	}

	//Used to set if the marble is there or not
	public void setEmpty(boolean isEmpty) {
		empty = isEmpty;
		repaint();
	}

	//returns its state, if highlighted
	public boolean isHighlighted() {
		// TODO Auto-generated method stub
		return highlighted;
	}
	
	//returns its state, if empty or not
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return this.empty;
	}

	//Used to set the type of Color to be used for the marbles
	public void setColorType(int colorType) {
		this.colorType = colorType;
	}
}