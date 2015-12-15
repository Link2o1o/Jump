/**
 * Prompts for Peg selection, returns if piece can be moved then if so prompts for location to move to.
 * Then checks if location to move to is valid and possible, Makes move if so.
 * Programmer: Michael
 */
package mechanics;

import java.util.ArrayList;
import java.util.Scanner;

import graphics.ResetButton;
import graphics.UndoButton;

public class MovePiece{
	private static ArrayList<String> possibleCoords = new ArrayList<String>();
	private Scanner input = new Scanner(System.in);
	private static int[] selected = new int[2];

	/**
	 * Runs the prompt for picking a peg to move, and tests it.
	 */
	public MovePiece() {
		String coord;
		while (true) {
			if(possibleCoords.isEmpty()){
			System.out.print("\nEnter a set of coordinates (Letter then number): ");
			coord = input.next();
			}
			else{
				System.out.print("\nEnter a set of coordinates (Letter then number)(Undo: \"U\" Reset: \"R\"): ");
				coord = input.next();
			}
			if (coord.equalsIgnoreCase("r")) {
				new ResetButton(0);
				break;
			} else if (coord.equalsIgnoreCase("u")) {
				new UndoButton(0);
				break;
			} else {
				if (checkMoves(coord)) {
					System.out.print("Enter coordinates to move to (Letter then Number): ");
					String moveCoord = input.next();
					moveCoord.toUpperCase();

					movePeg(moveCoord);
					break;
				} else
					System.out.println("That piece cannot be moved.  Try again.");
			}
		}
	}

	private void movePeg(String moveCoord) {
		if (possibleCoords.contains(moveCoord)) {
			int[] pegLoc = parseStringToLoc(moveCoord);
			// Set the location moved to, to true.(Peg is there)
			SquareBoard.board[pegLoc[0]][pegLoc[1]].setPlaced(true);
			// Checks for removing the peg jumped over
			int firstTemp = 0, secondTemp = 0;
			if (selected[0] > pegLoc[0]) {
				firstTemp = selected[0] - 1;
			} else if (selected[0] < pegLoc[0]) {
				firstTemp = pegLoc[0] - 1;
			} else
				firstTemp = selected[0];
			if (selected[1] > pegLoc[1]) {
				secondTemp = selected[1] - 1;
			} else if (selected[1] < pegLoc[1]) {
				secondTemp = pegLoc[1] - 1;
			} else
				secondTemp = selected[1];
			int[] temp = new int[2];
			temp[0] = firstTemp;
			temp[1] = secondTemp;
			//Removes the starting location's peg and the peg jumped over
			SquareBoard.board[firstTemp][secondTemp].setPlaced(false);
			SquareBoard.board[selected[0]][selected[1]].setPlaced(false);
			//saves the move
			SaveBoard.save(parseLocToString(pegLoc), parseLocToString(temp), parseLocToString(selected));
		}
		// Returns if what you put is an invalid move.
		else{
			System.out.println("\nInvalid move, try again.\n");
		}
		possibleCoords.clear();
	}

	/**
	 * Checks for possible moves and returns true or false if the piece can be moved at all.
	 */
	public static boolean checkMoves(String coord) {
		// The location selected in the array
		int[] pegLoc = parseStringToLoc(coord);
		int possibleMoves = 0;
		// returns the number value for character inputted
		
		// saves current selection
		selected[0] = pegLoc[0];
		selected[1] = pegLoc[1];
		possibleMoves = checkPosMoves(pegLoc, true);
		System.out.println("Amount of possible moves for selected peg: " + possibleMoves);
		if (possibleMoves > 0)
			return true;
		else
			return false;
	}
	/**
	 * Runs a check for possible moves, returns an int of possible moves.
	 * Prevents moving outside the board and using pieces that cannot be moved.
	 * @param pegLoc
	 * @return
	 */
	public static int checkPosMoves(int[] pegLoc, boolean ifAdd) {
		/**
		 * This is where it begins testing the quadrants of the array
		 */
		int possibleMoves = 0;
		// Test upper left quadrant, 0-1
		if (pegLoc[0] < 2 && pegLoc[1] < 2) {
			// Tests for possible moves; down and right for these four spots
			if (!SquareBoard.board[pegLoc[0] + 2][pegLoc[1]].isPlaced()
					&& SquareBoard.board[pegLoc[0] + 1][pegLoc[1]].isPlaced()) {
				pegLoc[0] = pegLoc[0] + 2;
				possibleMoves++;
				if(ifAdd)
				possibleCoords.add(parseLocToString(pegLoc));
				pegLoc[0] = pegLoc[0] - 2;
			}
			if (!SquareBoard.board[pegLoc[0]][pegLoc[1] + 2].isPlaced()
					&& SquareBoard.board[pegLoc[0]][pegLoc[1] + 1].isPlaced()) {
				pegLoc[1] = pegLoc[1] + 2;
				possibleMoves++;
				if(ifAdd)
				possibleCoords.add(parseLocToString(pegLoc));
				pegLoc[1] = pegLoc[1] - 2;
			}
		}
		// Test bottom left quadrant; 0-1,4-5
		if (pegLoc[0] < 2 && pegLoc[1] > 3) {
			// Tests for possible move; up and right for these four
			if (!SquareBoard.board[pegLoc[0] + 2][pegLoc[1]].isPlaced()
					&& SquareBoard.board[pegLoc[0] + 1][pegLoc[1]].isPlaced()) {
				pegLoc[0] = pegLoc[0] + 2;
				possibleMoves++;
				if(ifAdd)
				possibleCoords.add(parseLocToString(pegLoc));
				pegLoc[0] = pegLoc[0] - 2;
			}
			if (!SquareBoard.board[pegLoc[0]][pegLoc[1] - 2].isPlaced()
					&& SquareBoard.board[pegLoc[0]][pegLoc[1] - 1].isPlaced()) {
				pegLoc[1] = pegLoc[1] - 2;
				possibleMoves++;
				if(ifAdd)
				possibleCoords.add(parseLocToString(pegLoc));
				pegLoc[1] = pegLoc[1] + 2;
			}
		}
		// Test bottom right quadrant; 4-5
		if (pegLoc[0] > 3 && pegLoc[1] > 3) {
			// Tests for Possible moves; up and left
			if (!SquareBoard.board[pegLoc[0] - 2][pegLoc[1]].isPlaced()
					&& SquareBoard.board[pegLoc[0] - 1][pegLoc[1]].isPlaced()) {
				pegLoc[0] = pegLoc[0] - 2;
				possibleMoves++;
				if(ifAdd)
				possibleCoords.add(parseLocToString(pegLoc));
				pegLoc[0] = pegLoc[0] + 2;
			}
			if (!SquareBoard.board[pegLoc[0]][pegLoc[1] - 2].isPlaced()
					&& SquareBoard.board[pegLoc[0]][pegLoc[1] - 1].isPlaced()) {
				pegLoc[1] = pegLoc[1] - 2;
				possibleMoves++;
				if(ifAdd)
				possibleCoords.add(parseLocToString(pegLoc));
				pegLoc[1] = pegLoc[1] + 2;
			}
		}
		if (pegLoc[0] > 3 && pegLoc[1] < 2) {
			if (!SquareBoard.board[pegLoc[0] - 2][pegLoc[1]].isPlaced()
					&& SquareBoard.board[pegLoc[0] - 1][pegLoc[1]].isPlaced()) {
				pegLoc[0] = pegLoc[0] - 2;
				possibleMoves++;
				if(ifAdd)
				possibleCoords.add(parseLocToString(pegLoc));
				pegLoc[0] = pegLoc[0] + 2;
			}
			if (!SquareBoard.board[pegLoc[0]][pegLoc[1] + 2].isPlaced()
					&& SquareBoard.board[pegLoc[0]][pegLoc[1] + 1].isPlaced()) {
				pegLoc[1] = pegLoc[1] + 2;
				possibleMoves++;
				if(ifAdd)
				possibleCoords.add(parseLocToString(pegLoc));
				pegLoc[1] = pegLoc[1] - 2;
			}
		}

		if (pegLoc[0] < 2 && pegLoc[1] > 1 && pegLoc[1] < 4) {
			if (!SquareBoard.board[pegLoc[0] + 2][pegLoc[1]].isPlaced()
					&& SquareBoard.board[pegLoc[0] + 1][pegLoc[1]].isPlaced()) {
				pegLoc[0] = pegLoc[0] + 2;
				possibleMoves++;
				if(ifAdd)
				possibleCoords.add(parseLocToString(pegLoc));
				pegLoc[0] = pegLoc[0] - 2;
			}
			if (!SquareBoard.board[pegLoc[0]][pegLoc[1] + 2].isPlaced()
					&& SquareBoard.board[pegLoc[0]][pegLoc[1] + 1].isPlaced()) {
				pegLoc[1] = pegLoc[1] + 2;
				possibleMoves++;
				if(ifAdd)
				possibleCoords.add(parseLocToString(pegLoc));
				pegLoc[1] = pegLoc[1] - 2;
			}
			if (!SquareBoard.board[pegLoc[0]][pegLoc[1] - 2].isPlaced()
					&& SquareBoard.board[pegLoc[0]][pegLoc[1] - 1].isPlaced()) {
				pegLoc[1] = pegLoc[1] - 2;
				possibleMoves++;
				if(ifAdd)
				possibleCoords.add(parseLocToString(pegLoc));
				pegLoc[1] = pegLoc[1] + 2;
			}
		}
		if (pegLoc[1] < 2 && pegLoc[0] > 1 && pegLoc[0] < 4) {
			if (!SquareBoard.board[pegLoc[0] - 2][pegLoc[1]].isPlaced()
					&& SquareBoard.board[pegLoc[0] - 1][pegLoc[1]].isPlaced()) {
				pegLoc[0] = pegLoc[0] - 2;
				possibleMoves++;
				if(ifAdd)
				possibleCoords.add(parseLocToString(pegLoc));
				pegLoc[0] = pegLoc[0] + 2;
			}
			if (!SquareBoard.board[pegLoc[0] + 2][pegLoc[1]].isPlaced()
					&& SquareBoard.board[pegLoc[0] + 1][pegLoc[1]].isPlaced()) {
				pegLoc[0] = pegLoc[0] + 2;
				possibleMoves++;
				if(ifAdd)
				possibleCoords.add(parseLocToString(pegLoc));
				pegLoc[0] = pegLoc[0] - 2;
			}
			if (!SquareBoard.board[pegLoc[0]][pegLoc[1] + 2].isPlaced()
					&& SquareBoard.board[pegLoc[0]][pegLoc[1] + 1].isPlaced()) {
				pegLoc[1] = pegLoc[1] + 2;
				possibleMoves++;
				if(ifAdd)
				possibleCoords.add(parseLocToString(pegLoc));
				pegLoc[1] = pegLoc[1] - 2;
			}
		}
		if (pegLoc[0] > 3 && pegLoc[1] > 1 && pegLoc[1] < 4) {
			if (!SquareBoard.board[pegLoc[0] - 2][pegLoc[1]].isPlaced()
					&& SquareBoard.board[pegLoc[0] - 1][pegLoc[1]].isPlaced()) {
				pegLoc[0] = pegLoc[0] - 2;
				possibleMoves++;
				if(ifAdd)
				possibleCoords.add(parseLocToString(pegLoc));
				pegLoc[0] = pegLoc[0] + 2;
			}
			if (!SquareBoard.board[pegLoc[0]][pegLoc[1] + 2].isPlaced()
					&& SquareBoard.board[pegLoc[0]][pegLoc[1] + 1].isPlaced()) {
				pegLoc[1] = pegLoc[1] + 2;
				possibleMoves++;
				if(ifAdd)
				possibleCoords.add(parseLocToString(pegLoc));
				pegLoc[1] = pegLoc[1] - 2;
			}
			if (!SquareBoard.board[pegLoc[0]][pegLoc[1] - 2].isPlaced()
					&& SquareBoard.board[pegLoc[0]][pegLoc[1] - 1].isPlaced()) {
				pegLoc[1] = pegLoc[1] - 2;
				possibleMoves++;
				if(ifAdd)
				possibleCoords.add(parseLocToString(pegLoc));
				pegLoc[1] = pegLoc[1] + 2;
			}
		}
		if (pegLoc[1] > 3 && pegLoc[0] < 4 && pegLoc[0] > 1) {
			if (!SquareBoard.board[pegLoc[0] + 2][pegLoc[1]].isPlaced()
					&& SquareBoard.board[pegLoc[0] + 1][pegLoc[1]].isPlaced()) {
				pegLoc[0] = pegLoc[0] + 2;
				possibleMoves++;
				if(ifAdd)
				possibleCoords.add(parseLocToString(pegLoc));
				pegLoc[0] = pegLoc[0] - 2;
			}
			if (!SquareBoard.board[pegLoc[0] - 2][pegLoc[1]].isPlaced()
					&& SquareBoard.board[pegLoc[0] - 1][pegLoc[1]].isPlaced()) {
				pegLoc[0] = pegLoc[0] - 2;
				possibleMoves++;
				if(ifAdd)
				possibleCoords.add(parseLocToString(pegLoc));
				pegLoc[0] = pegLoc[0] + 2;
			}
			if (!SquareBoard.board[pegLoc[0]][pegLoc[1] - 2].isPlaced()
					&& SquareBoard.board[pegLoc[0]][pegLoc[1] - 1].isPlaced()) {
				pegLoc[1] = pegLoc[1] - 2;
				possibleMoves++;
				if(ifAdd)
				possibleCoords.add(parseLocToString(pegLoc));
				pegLoc[1] = pegLoc[1] + 2;
			}
		}
		if (pegLoc[0] > 1 && pegLoc[0] < 4 && pegLoc[1] > 1 && pegLoc[1] < 4) {
			if (!SquareBoard.board[pegLoc[0] + 2][pegLoc[1]].isPlaced()
					&& SquareBoard.board[pegLoc[0] + 1][pegLoc[1]].isPlaced()) {
				pegLoc[0] = pegLoc[0] + 2;
				possibleMoves++;
				if(ifAdd)
				possibleCoords.add(parseLocToString(pegLoc));
				pegLoc[0] = pegLoc[0] - 2;
			}
			if (!SquareBoard.board[pegLoc[0]][pegLoc[1] + 2].isPlaced()
					&& SquareBoard.board[pegLoc[0]][pegLoc[1] + 1].isPlaced()) {
				pegLoc[1] = pegLoc[1] + 2;
				possibleMoves++;
				if(ifAdd)
				possibleCoords.add(parseLocToString(pegLoc));
				pegLoc[1] = pegLoc[1] - 2;
			}
			if (!SquareBoard.board[pegLoc[0]][pegLoc[1] - 2].isPlaced()
					&& SquareBoard.board[pegLoc[0]][pegLoc[1] - 1].isPlaced()) {
				pegLoc[1] = pegLoc[1] - 2;
				possibleMoves++;
				if(ifAdd)
				possibleCoords.add(parseLocToString(pegLoc));
				pegLoc[1] = pegLoc[1] + 2;
			}
			if (!SquareBoard.board[pegLoc[0] - 2][pegLoc[1]].isPlaced()
					&& SquareBoard.board[pegLoc[0] - 1][pegLoc[1]].isPlaced()) {
				pegLoc[0] = pegLoc[0] - 2;
				possibleMoves++;
				if(ifAdd)
				possibleCoords.add(parseLocToString(pegLoc));
				pegLoc[0] = pegLoc[0] + 2;
			}

		}
		
		return possibleMoves;
	}
	/**
	 * Converts the user's input into an integer array returns that array
	 * @param coord
	 * @return
	 */
	public static int[] parseStringToLoc(String coord){
		char[] coords = coord.toCharArray();
		int[] pegLoc = new int[2];
		// Switch checks what is in the array[index] against the case's
		switch (coords[0]) {
		case 'a':
			pegLoc[0] = 0;
			break;
		case 'A':
			pegLoc[0] = 0;
			break;
		case 'b':
			pegLoc[0] = 1;
			break;
		case 'B':
			pegLoc[0] = 1;
			break;
		case 'c':
			pegLoc[0] = 2;
			break;
		case 'C':
			pegLoc[0] = 2;
			break;
		case 'd':
			pegLoc[0] = 3;
			break;
		case 'D':
			pegLoc[0] = 3;
			break;
		case 'e':
			pegLoc[0] = 4;
			break;
		case 'E':
			pegLoc[0] = 4;
			break;
		case 'f':
		case 'F':
			pegLoc[0] = 5;
			break;
		}
		// returns the number 0-5
		pegLoc[1] = ((int) coords[1]) - 49;
		return pegLoc;
	}
	/**
	 * Converts an integer array into a String, returns that string.
	 * @param pegLoc
	 * @return
	 */
	public static String parseLocToString(int[] pegLoc) {
		String output = "";
		switch (pegLoc[0]) {
		case 0:
			output += "A";
			break;
		case 1:
			output += "B";
			break;
		case 2:
			output += "C";
			break;
		case 3:
			output += "D";
			break;
		case 4:
			output += "E";
			break;
		case 5:
			output += "F";
		}
		switch (pegLoc[1]) {
		case 0:
			output += "1";
			break;
		case 1:
			output += "2";
			break;
		case 2:
			output += "3";
			break;
		case 3:
			output += "4";
			break;
		case 4:
			output += "5";
			break;
		case 5:
			output += "6";
		}
		return output;
	}
	public static ArrayList<String> getPossibleCoords(){
		return possibleCoords;
	}

}
