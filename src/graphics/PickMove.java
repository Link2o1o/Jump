package graphics;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mechanics.MovePiece;

public class PickMove implements ActionListener {
	public static boolean picking = true;

	@Override
	public void actionPerformed(ActionEvent e) {

		for (int i = 0; i < CreateBoard.board.length; i++)
			for (int j = 0; j < CreateBoard.board[0].length; j++) {
				int[] pegLoc = new int[2];
				pegLoc[0] = i;
				pegLoc[1] = j;
				if (CreateBoard.board[i][j].isHighlighted())
					CreateBoard.board[i][j].setHighlights(false);
				else if(e.getSource() == CreateBoard.board[i][j])
					CreateBoard.board[i][j].setHighlights(true, PegButton.FULL);
				if (e.getSource() == CreateBoard.board[i][j]) {
					if (picking) {
						String coord = MovePiece.parseLocToString(pegLoc);
						if (MovePiece.checkMoves(coord)) {
							Init.firstPick = pegLoc;
							picking = false;
						}
					} else {
						if (pegLoc[0] != Init.firstPick[0] || pegLoc[1] != Init.firstPick[1]) {
							CreateBoard.board[i][j].setHighlights(false, PegButton.CLEAR);
							MovePiece.movePeg(MovePiece.parseLocToString(pegLoc));
							picking = true;
						}
					}
				}
				if(CreateBoard.board[i][j].isEmpty() && MovePiece.getPossibleCoords().contains(MovePiece.parseLocToString(pegLoc)))
					CreateBoard.board[i][j].setHighlights(true, PegButton.EMPTY);
				CreateBoard.board[i][j].repaint();
			}
		if (mechanics.EndGame.gameOver()) {
			CreateBoard.infoText.setText(mechanics.EndGame.gameOverMessage());
			CreateBoard.restart.setText("Would you like to play again? ");
			Init.south.setLayout(new FlowLayout(FlowLayout.LEFT));
			Init.frame.setSize(450, 500);
			Init.south.add(CreateBoard.restart);
			Init.south.add(Init.start);
			Init.south.add(Init.quit);
		}
		Init.frame.setVisible(true);
	}

}
