package graphics;

import java.awt.*;

import javax.swing.*;


public class Init {
	//Creates all the basic components needed for the whole game
	public static JFrame frame = new JFrame("Jump");
	public static DrawFrame innerFrame = new DrawFrame();
	public static BorderLayout frameLayout = new BorderLayout(20,20);
	public static JPanel north = new JPanel();
	public static JPanel south = new JPanel();
	public static JPanel east = new JPanel();
	public static JPanel west = new JPanel();
	public static JPanel center = new JPanel();
	public static JButton reset = new JButton("Reset");
	public static JButton undo = new JButton("Undo");
	public static JButton start = new JButton("Yes");
	public static JButton quit = new JButton("No");
	public static int[] firstPick = new int[2];
	
	public static void main(String[] args) {
		//Initializes the background displays layout
		innerFrame.setLayout(frameLayout);
		//Makes the frame, not resizeable
		frame.setResizable(false);
		firstPick = new int[]{0,0};
		
		//Creates local main screen components to gather components on initialization
		JPanel prompt = new JPanel();
		JTextArea startScreen = new JTextArea();
		
		//Adds action listeners to the "Yes" and "No" buttons, start and quit respectively
		quit.addActionListener(new Quit());
		start.addActionListener(new PickColorMarble());
		
		//Sets the prompts text size and makes it not editable
		startScreen.setText("                   Objective\n\n  Move one peg at a time to jump over an adjacent peg,"
				+ "\n  removing the peg that was jumped over and continue to do so"
				+ "\n  until there is only one peg left.  \n"
				+ "\n                   Instructions\n\n  Select a peg that you would like to move(via coordinates), once "
				+ "\n  the peg is selected, choose an empty spot(also coordinates) where you would like "
				+ "\n  to move it to. You can only move vertically or horizontally not "
				+ "\n  diagonally. There must be an adjacent peg next to the one "
				+ "\n  selected and an empty spot immediately following the peg that was"
				+ "\n  jumped over. You cannot move a peg one spot at a time, you must"
				+ "\n  jump another peg. If you run out of moves or there is only"
				+ "\n  one peg left over, the game is over.\n\n"
				+ "     Would you like to Play?");
		startScreen.setSize(800,800);
		startScreen.setEditable(false);
		
		//sets the layout of the prompt panel, makes it invisible and adds the "Yes" and "No" buttons
		prompt.setLayout(new FlowLayout(FlowLayout.LEFT));
		prompt.add(start);
		prompt.setOpaque(false);
		prompt.add(quit);
		
		//sets the layouts and visibility of the panels on the sides
		south.setOpaque(false);
		north.setLayout(new FlowLayout(FlowLayout.LEFT));
		north.setOpaque(false);
		center.setLayout(new FlowLayout(FlowLayout.LEFT));
		center.setOpaque(false);
		//west.setLayout(new GridLayout(1,1));
		west.setOpaque(false);
		//east.setLayout(new GridLayout(1,1));
		east.setOpaque(false);
		
		//Adds the startScreen and prompt to the Center panel
		center.add(startScreen);
		center.add(prompt);
		
		//adds all the border panels to the Background frame
		innerFrame.add(north, BorderLayout.NORTH);
		innerFrame.add(south, BorderLayout.SOUTH);
		innerFrame.add(east, BorderLayout.EAST);
		innerFrame.add(west, BorderLayout.WEST);
		innerFrame.add(center, BorderLayout.CENTER);

		//Sets the layout of the frame adds the background; also sets the size and all other setup needed for the frame.
		frame.setLayout(new GridLayout());
		frame.add(innerFrame);
		frame.setSize(450, 450);
		//frame.setSize(1000, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
