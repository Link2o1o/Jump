package graphics;

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
							}
						}
						else{
							if (pegLoc[0] != Init.firstPick[0] || pegLoc[1] != Init.firstPick[1]) {
								MovePiece.movePeg(MovePiece.parseLocToString(pegLoc));
								//DrawBoard.board[i][j].setEmpty(false);
								//DrawBoard.board[]
								picking = true;
							}
						}
					}
			}
		for (int i = 0; i < DrawBoard.board.length; i++)
			for (int j = 0; j < DrawBoard.board[i].length; j++) {
				int[] pegLoc = new int[2];
				pegLoc[0] = i;
				pegLoc[1] = j;
				if (MovePiece.getPossibleCoords().equals(pegLoc)) {
					DrawBoard.board[i][j].setHighlights();
				}
			}
		if(mechanics.EndGame.gameOver())
			mechanics.EndGame.gameOverMessage();
		Init.frame.setVisible(true);
	}

}
