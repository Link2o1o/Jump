package graphics;

import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class PegButton extends JButton {

	public static final int RED = 0;
	public static final int BLUE = 1;
	public static final int GREEN = 2;
	public static final int PINK = 3;
	public static final int YELLOW = 4;
	private boolean empty = false;
	private static ImageIcon redMarble = new ImageIcon("images/RedMarble.png");
	private static Image rMarble = redMarble.getImage();
	private static ImageIcon blueMarble = new ImageIcon("images/BlueMarble.png");
	private static Image bMarble = blueMarble.getImage();
	private static ImageIcon greenMarble = new ImageIcon("images/GreenMarble.png");
	private static Image gMarble = greenMarble.getImage();
	private static ImageIcon pinkMarble = new ImageIcon("images/PinkMarble.png");
	private static Image pMarble = pinkMarble.getImage();
	private static ImageIcon yellowMarble = new ImageIcon("images/YellowMarble.png");
	private static Image yMarble = yellowMarble.getImage();
	private boolean highlighted = false;
	private int colorType;
	private Graphics graphic;

	@Override
	protected void paintComponent(Graphics g) {
		graphic = g;
		super.paintComponent(g);

		if (!empty) {
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

			if (highlighted) {
				graphic.setColor(Color.CYAN);
				for (int i = 0; i < 20; i++)
					graphic.drawOval((int) (0 + i * .1), (int) (0 + i * .1), (int) (getWidth() - i * .2),
							(int) (getHeight() - i * .2));
			}
		}

	}

	public void setHighlights(boolean isHighlighted) {
		highlighted = isHighlighted;
		repaint();
	}

	public void setEmpty(boolean isEmpty) {
		empty = isEmpty;
		repaint();
	}

	public boolean isHighlighted() {
		// TODO Auto-generated method stub
		return highlighted;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return this.empty;
	}

	public void setColorType(int colorType) {
		this.colorType = colorType;
	}
}