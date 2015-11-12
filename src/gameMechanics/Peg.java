package gameMechanics;

public class Peg {
	private int col;
	private int row;
	private boolean placed;
	public Peg(){
		col = 0;
		row = 0;
		placed = false;
	}
	public Peg(int col, int row){
		this.col = col;
		this.row = row;
	}
	public boolean isPlaced(){
		return this.placed;
	}
	public void setPlaced(boolean placed){
		this.placed = placed;
	}
	public int getCol(){
		return this.col;
	}
	public int getRow(){
		return this.row;
	}
	public void setCol(int col){
		this.col = col;
	}
	public void setRow(int row){
		this.row = row;
	}
}
