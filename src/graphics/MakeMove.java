package graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mechanics.MovePiece;

public class MakeMove implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i < DrawBoard.board.length; i++)
			for (int j = 0; j < DrawBoard.board[i].length; j++) {
				if (e.getSource() == DrawBoard.board[i][j]) {
					System.out.println("runs MakeMove");
					int[] pegLoc = new int[2];
					pegLoc[0] = i;
					pegLoc[1] = j;
					if (!pegLoc.equals(Init.firstPick)) {
						if (MovePiece.getPossibleCoords().contains(MovePiece.parseLocToString(pegLoc))) {
							DrawBoard.board[i][j] = new PegButton();
							MovePiece.movePeg(MovePiece.parseLocToString(pegLoc));

						}
					}
					DrawBoard.board[i][j].removeActionListener(PickMove.makeMoveListener);
					DrawBoard.board[i][j].addActionListener(DrawBoard.pickMoveListener);
				}
			}
		Init.frame.setVisible(true);
	}

}
