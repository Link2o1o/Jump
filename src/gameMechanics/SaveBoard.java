package gameMechanics;

public class SaveBoard {
	private static Peg[][] thirdSave;
	private static Peg[][] secondSave;
	private static Peg[][] firstSave;
	private static int possibleUndo = 3;
	private static int count;
	
	/**
	 * no-arg constructor, currently used to make empty SaveBoard Objects
	 */
	public SaveBoard(){
		
	}
	/**
	 * Saves up to three boards whenever constructor is used.
	 * 
	 * @param board
	 */
	public SaveBoard(Peg[][] board) {
		count = 0;
		SaveBoard.thirdSave = SaveBoard.secondSave;
		SaveBoard.secondSave = SaveBoard.firstSave;
		SaveBoard.firstSave = board;
	}

	/**
	 * For undoing last move up to three times possible.
	 */
	public static void undo(Peg[][] board) {
		if (possibleUndo != 0) {
			switch (count) {
			case 0:
				board = SaveBoard.firstSave;
				possibleUndo--;
				count++;
				break;
			case 1:
				board = SaveBoard.secondSave;
				possibleUndo--;
				count++;
				break;
			case 2:
				board = SaveBoard.thirdSave;
				possibleUndo--;
				count++;
				break;
			default:
				System.out.println("You are out of UNDO's.");
				break;
			}
		}
		else
			System.out.println("You are out of UNDO's.");
	}

}
