package gameMechanics;

public class Peg {
	private boolean placed;
	private boolean validPlacement;
	
	public Peg(){
		placed = false;
		validPlacement = true;
	}
	public boolean isPlaced(){
		return this.placed;
	}
	public void setPlaced(boolean placed){
		this.placed = placed;
	}
	public boolean isValid(){
		return this.validPlacement;
	}
	public void setValid(boolean validPlacement){
		this.validPlacement = validPlacement;
	}
}
