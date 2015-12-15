package graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import mechanics.MovePiece;

public class PickMove implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i = 0; i < DrawBoard.board.length; i++)
			for(int j = 0; j < DrawBoard.board[0].length; j++){
				MakeMove newListener = new MakeMove();
				
				int[] pegLoc = new int[2];
				pegLoc[0] = i;
				pegLoc[1] = j;
				if(MovePiece.getPossibleCoords().isEmpty())
					if(e.getSource() == DrawBoard.board[i][j]){
						
						String coord = MovePiece.parseLocToString(pegLoc);
						if(MovePiece.checkMoves(coord)){
							Init.firstPick = pegLoc;
							DrawBoard.board[i][j].removeActionListener(new PickMove());
							DrawBoard.board[i][j].addActionListener(newListener);
						}
					}
			}
		for(int i = 0; i < DrawBoard.board.length; i++)
			for(int j = 0; j < DrawBoard.board[i].length; j++){
				int[] pegLoc = new int[2];
				pegLoc[0] = i;
				pegLoc[1] = j;
				if(MovePiece.getPossibleCoords().equals(pegLoc)){
					DrawBoard.board[i][j] = new HighlightedEmptyPegButton();
				}
			}
		Init.frame.setVisible(true);
	}

}
