/* The mechanics behind starting the game.  Currently text based, but eventually will be a Window.
 */
package gameMechanics;

import java.util.Scanner;

public class StartButton {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		//Prints the prompt to start giving objective and instructions
		System.out.println(
				"Objective: Move one peg at a time to jump over an adjacent peg,"
				+ " \nremoving the peg that was jumped over and continue to do so"
				+ " \nuntil there is only one peg left.  \n"
				+ "\nInstructions: Select a peg that you would like to move(via coordinates), once "
				+ "\nthe peg is selected, choose an empty spot(also coordinates) where you would like "
				+ "\nto move it to. You can only move vertically or horizontally not "
				+ "\ndiagonally. There must be an adjacent peg next to the one "
				+ "\nselected and an empty spot immediately following the peg that was"
				+ " \njumped over. You cannot move a peg one spot at a time, you must"
				+ " \njump another peg. If you run out of moves or there is only"
				+ " \none peg left over, the game is over.\n");
		
		System.out.print("Would you like to play? (Y/N): ");
		String choice = input.next();
		
		//Checks user prompt, runs game if Y
		if(choice.equalsIgnoreCase("y")){
			SquareBoard board = new SquareBoard();
			

			board.fillBoard();
			while(true){
				board.printBoard();
				new MovePiece();
			}
		}
		else
			System.out.println("Have a nice day!");
		
		input.close();
	}

}
