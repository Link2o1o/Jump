package graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mechanics.MovePiece;

public class PickMove implements ActionListener {
	public static MakeMove makeMoveListener = new MakeMove();
	public static boolean picking = true;
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (picking)
			for (int i = 0; i < DrawBoard.board.length; i++) {
				for (int j = 0; j < DrawBoard.board[0].length; j++) {

					int[] pegLoc = new int[2];
					pegLoc[0] = i;
					pegLoc[1] = j;
					if (MovePiece.getPossibleCoords().isEmpty())
						if (e.getSource() == DrawBoard.board[i][j]) {

							String coord = MovePiece.parseLocToString(pegLoc);
							if (MovePiece.checkMoves(coord)) {
								Init.firstPick = pegLoc;
								picking = false;
								System.out.println("The first pick is: " + pegLoc[0] + ", " +pegLoc[1]);
							}

						}
				}
			}
		for (int i = 0; i < DrawBoard.board.length; i++) {
			for (int j = 0; j < DrawBoard.board[i].length; j++) {
				int[] pegLoc = new int[2];
				pegLoc[0] = i;
				pegLoc[1] = j;
				if (MovePiece.getPossibleCoords().contains(MovePiece.parseLocToString(pegLoc))) {
					DrawBoard.board[i][j] = new HighlightedEmptyPegButton();
				}
			}
		}
		if (!picking)
			for (int i = 0; i < DrawBoard.board.length; i++)
				for (int j = 0; j < DrawBoard.board[i].length; j++) {
					if (e.getSource() == DrawBoard.board[i][j]) {
						int[] pegLoc = new int[2];
						pegLoc[0] = i;
						pegLoc[1] = j;
						System.out.println("The next pick is: " + pegLoc[0] + ", " +pegLoc[1]);
						if (pegLoc[0] != Init.firstPick[0] && pegLoc[1] != Init.firstPick[1]) {
							System.out.println("Is equal to FirstPick");
							if (MovePiece.getPossibleCoords().contains(MovePiece.parseLocToString(pegLoc))) {
								picking = true;
								System.out.println("Changes board");
								DrawBoard.board[i][j] = new PegButton();
								MovePiece.movePeg(MovePiece.parseLocToString(pegLoc));

							}
						}
					}
				}
		Init.frame.setVisible(true);
		System.out.println("Ends listener");
	}

}
