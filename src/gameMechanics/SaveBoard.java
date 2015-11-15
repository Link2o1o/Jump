package gameMechanics;

public class SaveBoard {
	private Peg[][] thirdSave;
	private Peg[][] secondSave;
	private Peg[][] firstSave;
	private static int possibleUndo = 3;
	private static int count;

	/**
	 * Saves up to three boards whenever constructor is used.
	 * 
	 * @param board
	 */
	public SaveBoard(Peg[][] board) {
		count = 0;
		this.thirdSave = this.secondSave;
		this.secondSave = this.firstSave;
		this.firstSave = board;
	}

	/**
	 * For undoing last move up to three times possible.
	 */
	public void undo(Peg[][] board) {
		if (possibleUndo != 0) {
			switch (count) {
			case 0:
				board = this.firstSave;
				possibleUndo--;
				count++;
				break;
			case 1:
				board = this.secondSave;
				possibleUndo--;
				count++;
				break;
			case 2:
				board = this.thirdSave;
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
