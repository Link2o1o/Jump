package gameMechanics;

public class ResetBoard {
	public ResetBoard(int type){
		switch(type){
		case 0:
			SquareBoard.fillBoard();
		}
	}

}
