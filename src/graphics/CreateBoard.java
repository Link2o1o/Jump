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
		new SquareBoard();
		SquareBoard.fillBoard();
		
		CreateBoard.board = new PegButton[SquareBoard.board.length][SquareBoard.board[0].length];
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);;
		
		Init.north.removeAll();
		Init.south.removeAll();
		Init.east.removeAll();
		Init.west.removeAll();
		Init.center.removeAll();

		Init.north.add(Init.reset);
		Init.north.add(Init.undo);
		infoText.setText("Undo's Left: 3");
		Init.north.add(infoText);
		Init.reset.addActionListener(new CreateBoard());
		Init.undo.addActionListener(new UndoButton(0));
		Init.center.setLayout(new GridLayout(1, 1, -15, -15));
		
		DrawBoard boardPanel = new DrawBoard();
		Init.center.add(boardPanel);
		boardPanel.setLayout(new BorderLayout());
		
		JPanel southPlaceholder = new JPanel();
		JPanel northPlaceholder = new JPanel();
		JPanel eastPlaceholder = new JPanel();
		JPanel westPlaceholder = new JPanel();
		
		southPlaceholder.setOpaque(false);
		northPlaceholder.setOpaque(false);
		eastPlaceholder.setOpaque(false);
		westPlaceholder.setOpaque(false);
		
		boardPanel.add(southPlaceholder, BorderLayout.SOUTH);
		boardPanel.add(northPlaceholder, BorderLayout.NORTH);
		boardPanel.add(eastPlaceholder, BorderLayout.EAST);
		boardPanel.add(westPlaceholder, BorderLayout.WEST);
		boardPanel.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(6,6,10,10));
		
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
		
		CreateBoard.board[2][3].setEmpty(true);

		Init.frame.setVisible(true);
	}
	
	public static void setBoardColor(int boardColor) {
		CreateBoard.boardColor = boardColor;
	}
}
