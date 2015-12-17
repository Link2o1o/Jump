/**Creates the game board itself, adds all the buttons and images required.
 * Programmer: Michael
 */
package graphics;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import mechanics.SquareBoard;

public class CreateBoard implements ActionListener {
	public static PegButton[][] board;
	public static JLabel infoText = new JLabel();
	public static JLabel restart = new JLabel();
	private static int boardColor;
	@Override
	public void actionPerformed(ActionEvent arg0) {
		//Creates the mechanics side of the board
		new SquareBoard();
		SquareBoard.fillBoard();
		
		//Sets the boards size and layout
		CreateBoard.board = new PegButton[SquareBoard.board.length][SquareBoard.board[0].length];
		
		//Creates the panel to put the board in and makes it invisible
		JPanel panel = new JPanel();
		panel.setOpaque(false);;
		
		//Removes the previous components, from the last prompt
		Init.north.removeAll();
		Init.south.removeAll();
		Init.east.removeAll();
		Init.west.removeAll();
		Init.center.removeAll();
		
		//Adds the elements to the top of the screen and sets their action listeners
		Init.north.add(Init.reset);
		Init.north.add(Init.undo);
		infoText.setText("Undo's Left: 3");
		Init.north.add(infoText);
		Init.reset.addActionListener(new CreateBoard());
		Init.undo.addActionListener(new UndoButton(0));
		
		//Sets the Layout of the center for the board.
		Init.center.setLayout(new GridLayout(1, 1));
		
		//Creates a Panel that places the marbles into their appropriate locations on the board
		DrawBoard boardPanel = new DrawBoard();
		Init.center.add(boardPanel);
		boardPanel.setLayout(new BorderLayout());
		
		//Creates all the placeholder panels for the board panel
		JPanel southPlaceholder = new JPanel();
		JPanel northPlaceholder = new JPanel();
		JPanel eastPlaceholder = new JPanel();
		JPanel westPlaceholder = new JPanel();
		
		//makes all the placeholder panels invisible
		southPlaceholder.setOpaque(false);
		northPlaceholder.setOpaque(false);
		eastPlaceholder.setOpaque(false);
		westPlaceholder.setOpaque(false);
		
		//adds the placeholder panels to the boarder panel
		boardPanel.add(southPlaceholder, BorderLayout.SOUTH);
		boardPanel.add(northPlaceholder, BorderLayout.NORTH);
		boardPanel.add(eastPlaceholder, BorderLayout.EAST);
		boardPanel.add(westPlaceholder, BorderLayout.WEST);
		boardPanel.add(panel, BorderLayout.CENTER);
		
		//sets the layout for the marbles themselves
		panel.setLayout(new GridLayout(6,6,10,10));
		
		//adds all the buttons to the graphical board and panel
		for (int i = 0; i < SquareBoard.board.length; i++) {
			for (int j = 0; j < SquareBoard.board[i].length; j++) {
				PegButton temp = new PegButton();
				temp.setColorType(boardColor);
				temp.setOpaque(false);
				temp.setContentAreaFilled(false);
				temp.setBorderPainted(false);
				temp.setFocusPainted(false);
				
				CreateBoard.board[i][j] = temp;
				temp.addActionListener(new PickMove());
				panel.add(temp);
			}
		}
		//Sets the starting spot
		CreateBoard.board[2][3].setEmpty(true);
		//Redraws the frame
		Init.frame.setVisible(true);
	}
	
	//Used for setting the marble color
	public static void setBoardColor(int boardColor) {
		CreateBoard.boardColor = boardColor;
	}
}
