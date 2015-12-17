/**Creates a new screen that prompts for the user to pick a color and then continue
 * Programmer: Michael
 */
package graphics;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PickColorMarble implements ActionListener {
	public static JRadioButton rMarble = new JRadioButton();
	public static JRadioButton bMarble = new JRadioButton();
	public static JRadioButton gMarble = new JRadioButton();
	public static JRadioButton pMarble = new JRadioButton();
	public static JRadioButton yMarble = new JRadioButton();

	@Override
	public void actionPerformed(ActionEvent e) {
		//Clears the frame and all its components
		Init.north.removeAll();
		Init.south.removeAll();
		Init.east.removeAll();
		Init.west.removeAll();
		Init.center.removeAll();
		
		Init.frame.setSize(450,450);

		//Creates three panels to be displayed in a GridLayout
		JPanel radioPanel = new JPanel();
		radioPanel.setOpaque(false);
		JPanel imgPanel = new JPanel();
		imgPanel.setOpaque(false);
		JPanel promptPanel = new JPanel();
		promptPanel.setOpaque(false);
		
		//Creates each of the Marbles to display for picking color.
		//RedMarble.png
		ColorOption rm = new ColorOption();
		rm.setOpaque(false);
		rm.setColor("Red");
		//BlueMarble.png
		ColorOption bm = new ColorOption();
		bm.setOpaque(false);
		bm.setColor("Blue");
		//GreenMarble.png
		ColorOption gm = new ColorOption();
		gm.setOpaque(false);
		gm.setColor("Green");
		//PinkMarble.png
		ColorOption pm = new ColorOption();
		pm.setOpaque(false);
		pm.setColor("Pink");
		//YellowMarble.png
		ColorOption ym = new ColorOption();
		ym.setOpaque(false);
		ym.setColor("Yellow");
		
		//The panel that is set in a GridLayout so the components stack on top of each other.
		JPanel outerPanel = new JPanel();
		outerPanel.setOpaque(false);
		
		//The continue button to create the board with desired color
		JButton createBoard = new JButton("Press to Continue");
		createBoard.addActionListener(new CreateBoard());
		
		//ButtonGroup so that the Radio Buttons work together.
		ButtonGroup group = new ButtonGroup();
		
		//Creates each of the radio buttons
		//Radio Button for the Red Marble
		rMarble.setMnemonic('R');
		rMarble.addActionListener(new ColorChosen());
		rMarble.setOpaque(false);
		rMarble.setHorizontalAlignment(SwingConstants.CENTER);
		
		//Radio Button for the Blue Marble
		bMarble.setMnemonic('B');
		bMarble.addActionListener(new ColorChosen());
		bMarble.setOpaque(false);
		bMarble.setHorizontalAlignment(SwingConstants.CENTER);
		
		//Radio Button for the Pink Marble
		pMarble.setMnemonic('P');
		pMarble.addActionListener(new ColorChosen());
		pMarble.setOpaque(false);
		pMarble.setHorizontalAlignment(SwingConstants.CENTER);
		
		//Radio Button for the Yellow Marble
		yMarble.setMnemonic('Y');
		yMarble.addActionListener(new ColorChosen());
		yMarble.setOpaque(false);
		yMarble.setHorizontalAlignment(SwingConstants.CENTER);
		
		//Radio Button for the Green Marble
		gMarble.setMnemonic('G');
		gMarble.setOpaque(false);
		gMarble.setHorizontalAlignment(SwingConstants.CENTER);
		gMarble.addActionListener(new ColorChosen());
		
		//Sets the layout of all the panels
		outerPanel.setLayout(new GridLayout(6,1));
		imgPanel.setLayout(new GridLayout(1,5, 10, 10));
		radioPanel.setLayout(new GridLayout(1,5,0,0));
		promptPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		//Adds the JPanels that contain the marble color to the Image panel
		imgPanel.add(rm);
		imgPanel.add(bm);
		imgPanel.add(pm);
		imgPanel.add(ym);
		imgPanel.add(gm);
		
		//Adds createBoard button to the Prompt panel
		promptPanel.add(createBoard);
		
		//Creates a label to question user
		JLabel prompt = new JLabel("Select a color of Marble");
		
		//Adds all the elements/panels to display on the screen
		outerPanel.add(prompt);
		outerPanel.add(imgPanel);
		outerPanel.add(radioPanel);
		outerPanel.add(promptPanel);
		
		//Adds each marble to a ButtonGroup and the Radio Panel
		group.add(rMarble);
		radioPanel.add(rMarble);
		group.add(bMarble);
		radioPanel.add(bMarble);
		group.add(pMarble);
		radioPanel.add(pMarble);
		group.add(yMarble);
		radioPanel.add(yMarble);
		group.add(gMarble);
		radioPanel.add(gMarble);
		
		//Sets the Layout of the border that this screen will be displayed in and adds it to it
		Init.center.setLayout(new GridLayout(1,1));
		Init.center.add(outerPanel);

		//refreshes the screen to display all the new components.
		Init.frame.setVisible(true);
	}

}
