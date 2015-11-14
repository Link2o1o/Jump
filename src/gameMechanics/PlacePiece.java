package gameMechanics;

import java.util.Scanner;

public class PlacePiece extends SelectPeg{
	private Scanner input = new Scanner(System.in);
	/**
	 * Prompts user a location to move to and tests it.
	 */
	public PlacePiece(){
		System.out.print("Enter a coordinate to move to (Letter then number): ");
		
	}
	/**
	 * Checks user input if it can be moved to.
	 */
	public static boolean checkMoves(String coord) {
		return true;
	}
}
