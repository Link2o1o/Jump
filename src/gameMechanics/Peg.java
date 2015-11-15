package gameMechanics;

public class Peg {
	private boolean placed;
	private boolean validPlacement;
	/*
	 * creates a default peg, not placed but place able.
	 */
	public Peg(){
		placed = false;
		validPlacement = true;
	}
	/*
	 * Returns whether or not its placed
	 */
	public boolean isPlaced(){
		return this.placed;
	}
	/*
	 * Sets if its placed or not
	 */
	public void setPlaced(boolean placed){
		this.placed = placed;
	}
	/**
	 * returns whether or not its a valid placement  (For different shaped boards)
	 */
	public boolean isValid(){
		return this.validPlacement;
	}
	/**
	 * sets whether or not its a valid placement (For different shaped boards)
	 */
	public void setValid(boolean validPlacement){
		this.validPlacement = validPlacement;
	}
	/**
	 * To print the peg if its placed or not placed.  If its not a valid placement it puts a blank space.
	 */
	@Override
	public String toString(){
		if(this.placed && this.validPlacement){
			return "+";
		}
		else if(!this.placed && this.validPlacement)
			return "O";
		else
			return " ";
	}
}
