/**
 *	Checks if the game can still be played, returns false if so.
 *	Programmer: Jonas
 */
package mechanics;

public class EndGame {

	private static boolean gameOver;
	private static int numberOfPegs;
	public static String gameOverMessage;
	private static final String MORE_THAN_THREE_LEFT = "Well done, you didn't quite remove all of them... ";
	private static final String THREE_LEFT = "You got it down to three!  So close.";
	private static final String TWO_LEFT = "Just one left... You almost got it.";
	private static final String ONE_LEFT = "Congratulations!  You beat the game!";
	private static final String ZERO_LEFT = "Thats cheating...  How could you possibly get rid of all the marbles...";

	public EndGame() {

	}

	public static boolean gameOver() {
		numberOfPegs = 0;
		int possMoves = 0;

		for (int i = 0; i < SquareBoard.board.length; i++) {

			for (int j = 0; j < SquareBoard.board.length; j++) {
				if (SquareBoard.board[i][j].isPlaced()) {
					
					int[] pegLoc = new int[2];
					pegLoc[0] = i;
					pegLoc[1] = j;
					numberOfPegs++;
					possMoves += MovePiece.checkPosMoves(pegLoc, false);
					if (possMoves > 0)
						gameOver = false;
					else
						gameOver = true;
				}
			}
		}
		return gameOver;
	}

	public static String gameOverMessage() {
		if(numberOfPegs > 3){
			return gameOverMessage = MORE_THAN_THREE_LEFT;
		}
		else if(numberOfPegs > 2)
			return gameOverMessage = THREE_LEFT;
		else if(numberOfPegs > 1)
			return gameOverMessage = TWO_LEFT;
		else if(numberOfPegs > 0)
			return gameOverMessage = ONE_LEFT;
		else
			return gameOverMessage = ZERO_LEFT;
	}
}

/*
 * public static boolean gameOver(){
 * 
 * for (int i = 0; i < SquareBoard.board.length; i++) {
 * 
 * for (int j = 0; j < SquareBoard.board.length; j++) {
 * 
 * if(SquareBoard.board[i][j].isPlaced()){ if
 * (SquareBoard.board[i+1][j].isPlaced() ||
 * SquareBoard.board[i-1][j].isPlaced()){ if
 * (!SquareBoard.board[i+2][j].isPlaced() ||
 * !SquareBoard.board[i-2][j].isPlaced()){ gameOver = false; } } } else
 * if(SquareBoard.board[i][j].isPlaced()){
 * if(SquareBoard.board[i][j].isPlaced()){ if
 * (SquareBoard.board[i][j+1].isPlaced() ||
 * SquareBoard.board[i][j-1].isPlaced()){ if
 * (!SquareBoard.board[i][j+2].isPlaced() ||
 * !SquareBoard.board[i][j-2].isPlaced()){ gameOver = false; } } } } else
 * gameOver = true; } } return gameOver; } }
 */