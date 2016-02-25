package graphics;
/**Initiates and runs all the moves on the game board, redisplays changes
 * Programmer: Michael
 */
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import mechanics.EndGameTimer;
import mechanics.MovePiece;
import mechanics.SaveBoard;

public class PickMove implements ActionListener {
	public static boolean picking = true;

	@Override
	public void actionPerformed(ActionEvent e) {
		//Loops through the entire board
		for (int i = 0; i < CreateBoard.board.length; i++)
			for (int j = 0; j < CreateBoard.board[0].length; j++) {
				//Saves the location of each button
				int[] pegLoc = new int[2];
				pegLoc[0] = i;
				pegLoc[1] = j;
				
				//Highlights piece picked, also un-highlights unused pieces and buttons already used.
				if (CreateBoard.board[i][j].isHighlighted())
					CreateBoard.board[i][j].setHighlights(false);
				else if(e.getSource() == CreateBoard.board[i][j])
					CreateBoard.board[i][j].setHighlights(true);
				
				//Runs if its the button chosen performs the in-game logic
				if (e.getSource() == CreateBoard.board[i][j]) {
					//A private boolean to switch picking piece to move and then where its moved too.
					if (picking) {
						String coord = MovePiece.parseLocToString(pegLoc);
						//Checks all possible moves off piece selected using button location
						if (MovePiece.checkMoves(coord)) {
							Init.firstPick = pegLoc;
							picking = false;
						}
					} else {
						if (pegLoc[0] != Init.firstPick[0] || pegLoc[1] != Init.firstPick[1]) {
							CreateBoard.board[i][j].setHighlights(false);
							//Added graphic board moves to this method in MovePiece
							MovePiece.movePeg(MovePiece.parseLocToString(pegLoc));
							picking = true;
						}
					}
				}
				//Repaints the board after all changes are made
				CreateBoard.board[i][j].repaint();
			}
		//Checks for end game conditions then adds the end game message and prompts if user would like to play again
		if (mechanics.EndGame.gameOver() && SaveBoard.possibleUndo == 0) {
			CreateBoard.clock.stop();
			Timer t = new Timer(1000, new EndGameTimer());
			t.start();
			CreateBoard.undoText.setText(mechanics.EndGame.gameOverMessage());
			CreateBoard.restart.setText("Would you like to play again? ");
			Init.south.setLayout(new FlowLayout(FlowLayout.LEFT));
			Init.frame.setSize(450, 478);
			Init.south.add(CreateBoard.restart);
			Init.south.add(Init.start);
			Init.south.add(Init.quit);
		}
		//Redraws frame to show changes
		Init.frame.setVisible(true);
	}

}
