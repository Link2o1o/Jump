package gameMechanics;

public class SelectPeg {
	
	private static Peg selected;
	
	public SelectPeg(){
	}
	public Peg getSelected(){
		return SelectPeg.selected;
	}
	public static void setSelected(Peg selected){
		SelectPeg.selected = selected;
	}
}
