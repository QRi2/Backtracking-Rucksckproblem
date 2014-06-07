import java.util.ArrayList;


public class Test {

	public static void main(String[] args) {
		
		ArrayList<Integer> gesamtMenge = new ArrayList<Integer>();
		gesamtMenge.add(7);
		gesamtMenge.add(2);
		gesamtMenge.add(10);
		gesamtMenge.add(9);
		
		Backtracker backTrack = new Backtracker(13, gesamtMenge);
		backTrack.backtracking(1);
		
		backTrack.optimumAusgeben();
		
	}

}
