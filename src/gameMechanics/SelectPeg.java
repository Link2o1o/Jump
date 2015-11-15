package gameMechanics;

public class SelectPeg {
	
	private static int[] selected;
	
	public SelectPeg(){
	}
	public static int[] getSelected(){
		return SelectPeg.selected;
	}
	public static void setSelected(int[] selected){
		SelectPeg.selected = selected;
	}
}
