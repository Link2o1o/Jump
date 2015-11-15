package gameMechanics;

public class SaveBoard {
	static Peg[][] thirdSave;
	static Peg[][] secondSave;
	static Peg[][] firstSave;
	private static int possibleUndo = 3;
	private static int timeSaved = 0;
	private static int count;

	/**
	 * no-arg constructor, currently used to make empty SaveBoard Objects
	 */
	public SaveBoard(Peg[][] board) {
		count = 0;
		SaveBoard.thirdSave = new Peg[board.length][board.length];
		SaveBoard.secondSave = new Peg[board.length][board.length];
		SaveBoard.firstSave = new Peg[board.length][board.length];
	}
	
	public static void save(){
		timeSaved++;
	}
	/**
	 * For undoing last move up to three times possible.
	 */
	public static void undo() {
		if (possibleUndo != 0) {
			switch (count) {
			case 2:
				SquareBoard.board = SaveBoard.firstSave;
				possibleUndo--;
				count++;
				break;
			case 1:
				SquareBoard.board = SaveBoard.secondSave;
				possibleUndo--;
				count++;
				break;
			case 0:
				SquareBoard.board = SaveBoard.thirdSave;
				possibleUndo--;
				count++;
				break;
			default:
				System.out.println("You are out of UNDO's.");
				break;
			}
		} else
			System.out.println("You are out of UNDO's.");
	}

}
