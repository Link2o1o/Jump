package gameMechanics;

import java.util.Scanner;

public class PlacePiece extends SelectPeg {
	private Scanner input = new Scanner(System.in);

	/**
	 * Prompts user a location to move to and tests it.
	 */
	public PlacePiece() {
		System.out.print("Enter a coordinate to move to (Letter then number): ");
		String moveTo = input.next();

		if (checkMoves(moveTo)) {
		} else
			System.out.println("That piece cannot be moved.  Try again.");

	}

	/**
	 * Checks user input if it can be moved to.
	 */
	public static boolean checkMoves(String coord) {

		int a;
		int b;

		Character coordA = coord.charAt(0);
		Character coordB = coord.charAt(1);

		if (coordA.equals('a') || coordA.equals('A'))
			a = 0;

		if (coordA.equals('b') || coordA.equals('B'))
			a = 1;

		if (coordA.equals('c') || coordA.equals('c'))
			a = 2;

		if (coordA.equals('d') || coordA.equals('d'))
			a = 3;

		if (coordA.equals('e') || coordA.equals('e'))
			a = 4;

		if (coordB.equals('1'))
			b = 0;
		if (coordB.equals('2'))
			b = 1;
		if (coordB.equals('3'))
			b = 2;
		if (coordB.equals('4'))
			b = 3;
		if (coordB.equals('5'))
			b = 4;

		// SquareBoard board = new SquareBoard();
		// board.printBoard();
		// board[a][b].setPlaced(true);
		// If move horizontally
		// new int c = b-1
		// PickPiece will be .setPlaced(false)
		// board[a][c].setPlaced(false)
		// If user moves vertically
		// int d = a-1
		// board[d][b].setPlaced(false)

		return true;
	}
}
