/**
 *	Checks if the game can still be played, returns false if so.
 *	Programmer: Jonas
 */
package gameMechanics;

public class EndGame {

	private static boolean gameOver;
	private static int numberOfPegs;

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

	public static void gameOverMessage() {
		if(numberOfPegs > 3){
			System.out.println("Well done, you didn't quite remove all of them...  \nBetter luck next time.");
		}
		else if(numberOfPegs > 2)
			System.out.println("You got it down to three!  So close.");
		else if(numberOfPegs > 1)
			System.out.println("Just one left... You almost got it.");
		else if(numberOfPegs > 0)
			System.out.println("Congratulations!  You beat the game!");
		else
			System.out.println("Thats cheating...  How could you possibly get it like that...");
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