package graphics;

import java.awt.*;

import javax.swing.*;

import mechanics.SquareBoard;

public class Init {
	public static JFrame frame = new JFrame("Jump");
	public static BorderLayout frameLayout = new BorderLayout(20,20);
	public static JPanel north = new JPanel();
	public static JPanel south = new JPanel();
	public static JPanel east = new JPanel();
	public static JPanel west = new JPanel();
	public static JPanel center = new JPanel();
	public static JButton reset = new JButton("Reset");
	public static JButton undo = new JButton("Undo");
	public static int[] firstPick = new int[2];
	public static void main(String[] args) {
		frame.setLayout(frameLayout);
		firstPick = new int[]{0,0};
		
		new SquareBoard();
		SquareBoard.fillBoard();
		
		JButton start = new JButton("Yes");
		JButton quit = new JButton("No");
		JPanel prompt = new JPanel();
		DrawBoard listener = new DrawBoard();
		JTextArea startScreen = new JTextArea();
		
		start.addActionListener(listener);
		
		startScreen.setText("Objective: Move one peg at a time to jump over an adjacent peg,"
				+ " \nremoving the peg that was jumped over and continue to do so"
				+ " \nuntil there is only one peg left.  \n"
				+ "\nInstructions: Select a peg that you would like to move(via coordinates), once "
				+ "\nthe peg is selected, choose an empty spot(also coordinates) where you would like "
				+ "\nto move it to. You can only move vertically or horizontally not "
				+ "\ndiagonally. There must be an adjacent peg next to the one "
				+ "\nselected and an empty spot immediately following the peg that was"
				+ " \njumped over. You cannot move a peg one spot at a time, you must"
				+ " \njump another peg. If you run out of moves or there is only"
				+ " \none peg left over, the game is over.\n\n"
				+ "   Would you like to Play?");
		startScreen.setSize(800,800);
		startScreen.setEditable(false);
		prompt.setLayout(new FlowLayout(FlowLayout.LEFT));
		prompt.add(start);
		prompt.add(quit);
		
		
		north.setLayout(new FlowLayout(FlowLayout.LEFT));
		center.setLayout(new FlowLayout(FlowLayout.LEFT));
		west.setLayout(new GridLayout(1,1));
		east.setLayout(new GridLayout(1,1));
		
		center.add(startScreen);
		center.add(prompt);
		east.add(new JPanel());
		west.add(new JPanel());
		
		frame.add(north, BorderLayout.NORTH);
		frame.add(south, BorderLayout.SOUTH);
		frame.add(east, BorderLayout.EAST);
		frame.add(west, BorderLayout.WEST);
		frame.add(center, BorderLayout.CENTER);

		frame.setSize(450, 450);
		//frame.setSize(1000, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
