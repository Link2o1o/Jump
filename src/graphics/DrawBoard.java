package graphics;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import mechanics.SquareBoard;

public class DrawBoard implements ActionListener {
	public static PegButton[][] board = new PegButton[SquareBoard.board.length][SquareBoard.board[0].length];
	public static JTextArea infoText = new JTextArea();
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Init.north.removeAll();
		Init.south.removeAll();
		Init.east.removeAll();
		Init.west.removeAll();
		Init.center.removeAll();

		Init.north.add(Init.reset);
		Init.north.add(Init.undo);
		Init.reset.addActionListener(new ResetButton(0));
		Init.undo.addActionListener(new UndoButton(0));
		Init.center.setLayout(new GridLayout(6, 6, 10, 10));

		for (int i = 0; i < SquareBoard.board.length; i++) {
			for (int j = 0; j < SquareBoard.board[i].length; j++) {
				PegButton temp = new PegButton();
				temp.setOpaque(false);
				temp.setContentAreaFilled(false);
				temp.setBorderPainted(false);
				temp.setFocusPainted(false);
				
				board[i][j] = temp;
				temp.addActionListener(new PickMove());
				Init.center.add(temp);
			}
		}
		board[2][3].setEmpty(true);

		Init.frame.setVisible(true);
	}

}
