/**
 *	Checks if the game can still be played, returns false if so.
 *	Programmer: Jonas
 */
package gameMechanics;

public class EndGame {

	private static boolean gameOver;

	public EndGame() {

	}

	public static boolean gameOver() {
		
		int possMoves = 0;
		
		for (int i = 0; i < SquareBoard.board.length; i++) {

			for (int j = 0; j < SquareBoard.board.length; j++) {
				int[] pegLoc = new int[2];
				pegLoc[0] = i;
				pegLoc[1] = j;
				
				possMoves += MovePiece.checkPosMoves(pegLoc);
				if (possMoves>0)
					gameOver = false;
				else
					gameOver = true;				
			}
		}
		return gameOver;
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