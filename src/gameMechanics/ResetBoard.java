package gameMechanics;

public class ResetBoard {
	public ResetBoard(Peg[][] board, int type){
		switch(type){
		case 0:
			SquareBoard newBoard = new SquareBoard();
			newBoard.fillBoard();
		}
	}

}
