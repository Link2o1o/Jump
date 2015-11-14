package gameMechanics;

public class SaveBoard {
	private Peg[][] thirdSave;
	private Peg[][] secondSave;
	private Peg[][] firstSave;
	private boolean firstEmpty;
	private boolean secondEmpty;
	private boolean thridEmpty;
	public SaveBoard(Peg[][] board){
		this.thirdSave = this.secondSave;
		this.secondSave = this.firstSave;
		this.firstSave = board;
	}
	
	public void undo(Peg[][] board){
		if(board == this.firstSave && board == this.secondSave)
		board = this.firstSave;
	}
	
}
