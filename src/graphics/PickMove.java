package graphics;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mechanics.MovePiece;

public class PickMove implements ActionListener {
	public static boolean picking = true;

	@Override
	public void actionPerformed(ActionEvent e) {

		for (int i = 0; i < DrawBoard.board.length; i++)
			for (int j = 0; j < DrawBoard.board[0].length; j++) {
				int[] pegLoc = new int[2];
				pegLoc[0] = i;
				pegLoc[1] = j;
					if (e.getSource() == DrawBoard.board[i][j]) {
						if (picking) {
							String coord = MovePiece.parseLocToString(pegLoc);
							if (MovePiece.checkMoves(coord)) {
								Init.firstPick = pegLoc;
								picking = false;
								DrawBoard.board[i][j].setHighlights(true, PegButton.FULL);
								//DrawBoard.board[i][j].setHighlights(false, PegButton.CLEAR);
							}
						}
						else{
							if (pegLoc[0] != Init.firstPick[0] || pegLoc[1] != Init.firstPick[1]) {
								DrawBoard.board[i][j].setHighlights(false, PegButton.CLEAR);
								MovePiece.movePeg(MovePiece.parseLocToString(pegLoc));
								picking = true;
							}
						}
					}
					DrawBoard.board[i][j].repaint();
			}
		for (int i = 0; i < DrawBoard.board.length; i++)
			for (int j = 0; j < DrawBoard.board[i].length; j++) {
				int[] pegLoc = new int[2];
				pegLoc[0] = i;
				pegLoc[1] = j;
				if (MovePiece.getPossibleCoords().equals(pegLoc)) {
					if(DrawBoard.board[i][j].isHighlighted())
						DrawBoard.board[i][j].setHighlights(false);
					else
						DrawBoard.board[i][j].setHighlights(true, PegButton.EMPTY);
				}
			}
		if(mechanics.EndGame.gameOver()){
			DrawBoard.infoText.setText(mechanics.EndGame.gameOverMessage());
			DrawBoard.restart.setText("Would you like to play again? ");
			Init.south.setLayout(new FlowLayout(FlowLayout.LEFT));
			Init.frame.setSize(450,500);
			Init.south.add(DrawBoard.restart);
			Init.south.add(Init.start);
			Init.south.add(Init.quit);
		}
		Init.frame.setVisible(true);
	}

}
