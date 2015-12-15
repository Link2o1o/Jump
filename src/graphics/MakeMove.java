package graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mechanics.MovePiece;

public class MakeMove implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i = 0; i < DrawBoard.board.length; i++)
			for(int j = 0; j < DrawBoard.board[i].length; j++){
				if(e.getSource() == DrawBoard.board[i][j]){
					int[] pegLoc = new int[2];
					pegLoc[0] = i;
					pegLoc[1] = j;
					if(!pegLoc.equals(Init.firstPick)){
						
					}
				}
			}
	}

}
