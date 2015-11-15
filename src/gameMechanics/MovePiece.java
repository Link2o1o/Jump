package gameMechanics;

import java.util.ArrayList;
import java.util.Scanner;

public class MovePiece extends SelectPeg {
	private static ArrayList<String> possibleCoords = new ArrayList<String>();
	private Scanner input = new Scanner(System.in);
	private static int[] temp = new int[2];

	/**
	 * Runs the prompt for picking a peg to move, and tests it.
	 */
	public MovePiece() {
		while (true) {
			System.out.print("\nEnter a set of coordinates (Letter then number): ");
			String coord = input.next();

			if (checkMoves(coord)) {
				System.out.print("Enter coordinates to move too (Letter then Number): ");
				String moveCoord = input.next();
				movePiece(moveCoord);
				break;
			} else
				System.out.println("That piece cannot be moved.  Try again.");
		}
	}

	private void movePiece(String moveCoord) {
		if (possibleCoords.contains(moveCoord)) {
			char[] coords = moveCoord.toCharArray();
			int[] pegLoc = new int[2];

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
			pegLoc[1] = ((int) coords[1]) - 49;
			SquareBoard.board[pegLoc[0]][pegLoc[1]].setPlaced(true);
			int firstTemp = 0, secondTemp = 0;
			if (temp[0] > pegLoc[0]) {
				firstTemp = temp[0] - 1;
			} else if (temp[0] < pegLoc[0]) {
				firstTemp = pegLoc[0] - 1;
			}
			else
				firstTemp = temp[0];
			if (temp[1] > pegLoc[1]) {
				secondTemp = temp[1] - 1;
			} else if (temp[1] < pegLoc[1]) {
				secondTemp = pegLoc[1] - 1;
			}
			else
				secondTemp = temp[1];
			SquareBoard.board[firstTemp][secondTemp].setPlaced(false);
			SquareBoard.board[temp[0]][temp[1]].setPlaced(false);
			possibleCoords.clear();
		}
	}

	/**
	 * Checks each pick to see if it can be moved or not. Then saves the
	 * selection into SelectPeg.
	 */
	public static boolean checkMoves(String coord) {
		char[] coords = coord.toCharArray();
		int[] pegLoc = new int[2];
		int possibleMoves = 0;
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
		pegLoc[1] = ((int) coords[1]) - 49;
		temp[0] = pegLoc[0];
		temp[1] = pegLoc[1];

		if (pegLoc[0] < 2 && pegLoc[1] < 2) {
			if (!SquareBoard.board[pegLoc[0] + 2][pegLoc[1]].isPlaced()
					&& SquareBoard.board[pegLoc[0] + 1][pegLoc[1]].isPlaced()) {
				pegLoc[0] = pegLoc[0] - 2;
				possibleMoves++;
				possibleCoords.add(parseLocToString(pegLoc));
			} else if (!SquareBoard.board[pegLoc[0]][pegLoc[1] + 2].isPlaced()
					&& SquareBoard.board[pegLoc[0]][pegLoc[1] + 1].isPlaced()) {
				pegLoc[1] = pegLoc[1] - 2;
				possibleMoves++;
				possibleCoords.add(parseLocToString(pegLoc));
			}
		}
		if (pegLoc[0] < 4 && pegLoc[1] < 4) {
			if (!SquareBoard.board[pegLoc[0] + 2][pegLoc[1]].isPlaced()
					&& SquareBoard.board[pegLoc[0] + 1][pegLoc[1]].isPlaced()) {
				pegLoc[0] = pegLoc[0] + 2;
				possibleMoves++;
				possibleCoords.add(parseLocToString(pegLoc));
			} else if (!SquareBoard.board[pegLoc[0]][pegLoc[1] + 2].isPlaced()
					&& SquareBoard.board[pegLoc[0]][pegLoc[1] + 1].isPlaced()) {
				pegLoc[1] = pegLoc[1] + 2;
				possibleMoves++;
				possibleCoords.add(parseLocToString(pegLoc));
			}
		}
		if (pegLoc[0] > 1 && pegLoc[1] < 4) {
			if (!SquareBoard.board[pegLoc[0] - 2][pegLoc[1]].isPlaced()
					&& SquareBoard.board[pegLoc[0] - 1][pegLoc[1]].isPlaced()) {
				pegLoc[0] = pegLoc[0] - 2;
				possibleMoves++;
				possibleCoords.add(parseLocToString(pegLoc));
			} else if (!SquareBoard.board[pegLoc[0]][pegLoc[1] + 2].isPlaced()
					&& SquareBoard.board[pegLoc[0]][pegLoc[1] + 1].isPlaced()) {
				pegLoc[1] = pegLoc[1] + 2;
				possibleMoves++;
				possibleCoords.add(parseLocToString(pegLoc));
			}
		}
		if (pegLoc[0] < 4 && pegLoc[1] > 1) {
			if (!SquareBoard.board[pegLoc[0] + 2][pegLoc[1]].isPlaced()
					&& SquareBoard.board[pegLoc[0] + 1][pegLoc[1]].isPlaced()) {
				pegLoc[0] = pegLoc[0] + 2;
				possibleMoves++;
				possibleCoords.add(parseLocToString(pegLoc));
			} else if (!SquareBoard.board[pegLoc[0]][pegLoc[1] - 2].isPlaced()
					&& SquareBoard.board[pegLoc[0]][pegLoc[1] - 1].isPlaced()) {
				pegLoc[1] = pegLoc[1] - 2;
				possibleMoves++;
				possibleCoords.add(parseLocToString(pegLoc));
			}
		}
		if (possibleMoves > 0)
			return true;
		else
			return false;
	}

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

}
