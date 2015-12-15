package graphics;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import mechanics.SquareBoard;

public class JumpActions implements ActionListener {
	public static JButton[][] board = new JButton[SquareBoard.board.length][SquareBoard.board[0].length];

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Init.north.removeAll();
		Init.south.removeAll();
		Init.east.removeAll();
		Init.west.removeAll();
		Init.center.removeAll();

		Init.north.add(Init.reset);
		Init.north.add(Init.undo);
		Init.center.setLayout(new GridLayout(6, 6, 10, 10));

		for (int i = 0; i < SquareBoard.board.length; i++) {
			for (int j = 0; j < SquareBoard.board[i].length; j++) {
				JButton temp;
				if (SquareBoard.board[i][j].isPlaced()) {
					temp = new PegButton();
					//temp.setOpaque(false);
					//temp.setContentAreaFilled(false);
					//temp.setBorderPainted(false);
					//temp.setFocusPainted(false);
				} else {
					temp = new EmptyPegButton();
					//temp.setOpaque(false);
					//temp.setContentAreaFilled(false);
					//temp.setBorderPainted(false);
					//temp.setFocusPainted(false);
				}
				board[i][j] = temp;
				Init.center.add(temp);
			}
		}

		Init.frame.setVisible(true);
	}

}
