package gameMechanics;

public class SelectPeg {
	
	protected static int[] pegLoc;
	
	public SelectPeg(){
		SelectPeg.pegLoc = new int[2];
	}
	public int[] getPegLoc(){
		return SelectPeg.pegLoc;
	}
	public static void setSelected(int[] pegLoc){
		SelectPeg.pegLoc = pegLoc;
	}
}
