package gameMechanics;

import java.util.Scanner;

public class PickPiece extends SelectPeg {
	private Scanner input = new Scanner(System.in);

	public PickPiece() {
		while (true) {
			System.out.print("\nEnter a set of coordinates (Letter then number): ");
			String coord = input.next();

			if (checkMoves(coord)) {
				break;
			}
			else
				System.out.println("That piece cannot be moved.  Try again.");
		}
	}

	public static boolean checkMoves(String coord) {
		char[] coords = coord.toCharArray();
		int possibleMoves = 0;
		switch(coords[0]){
		case 'a':
		case 'A':
			pegLoc[0] = 0;
			break;
		case 'b':
		case 'B':
			pegLoc[0] = 1;
			break;
		case 'c':
		case 'C':
			pegLoc[0] = 2;
			break;
		case 'd':
		case 'D':
			pegLoc[0] = 3;
			break;
		case 'e':
		case 'E':
			pegLoc[0] = 4;
			break;
		}
		pegLoc[1] = ((int)coords[1])-49;
		if(pegLoc[0] > 1 && pegLoc[1] > 1){
			if(!SquareBoard.board[pegLoc[0]-2][pegLoc[1]].isPlaced()){
				possibleMoves++;
			}
			else if(!SquareBoard.board[pegLoc[0]][pegLoc[1]-2].isPlaced()){
				possibleMoves++;
			}
		}
		if(pegLoc[0] < 3 && pegLoc[1] < 3){
			if(!SquareBoard.board[pegLoc[0]+2][pegLoc[1]].isPlaced()&&SquareBoard.board[pegLoc[0]+1][pegLoc[1]].isPlaced()){
				possibleMoves++;
			}
			else if(!SquareBoard.board[pegLoc[0]][pegLoc[1]+2].isPlaced()&&SquareBoard.board[pegLoc[0]][pegLoc[1]+1].isPlaced()){
				possibleMoves++;
			}
		}
		if(pegLoc[0] > 1 && pegLoc[1] < 3){
			if(!SquareBoard.board[pegLoc[0]-2][pegLoc[1]].isPlaced()){
				possibleMoves++;
			}
			else if(!SquareBoard.board[pegLoc[0]][pegLoc[1]+2].isPlaced()){
				possibleMoves++;
			}
		}
		if(pegLoc[0] < 3 && pegLoc[1] > 1){
			if(!SquareBoard.board[pegLoc[0]+2][pegLoc[1]].isPlaced()){
				possibleMoves++;
			}
			else if(!SquareBoard.board[pegLoc[0]][pegLoc[1]-2].isPlaced()){
				possibleMoves++;
			}
		}
		if(possibleMoves > 0)
			return true;
		else
			return false;
	}

}
