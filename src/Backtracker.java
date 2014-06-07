import java.util.ArrayList;


public class Backtracker {

	private ArrayList<Integer> elementeListe = new ArrayList<Integer>();
	private ArrayList<Integer> optimum = new ArrayList<Integer>();
	private ArrayList<Integer> gesamtMenge;
	private int yGrenze;
	
	public Backtracker(int yGrenze, ArrayList<Integer> gesamtMenge){
		
		this.gesamtMenge = gesamtMenge;
		this.yGrenze = yGrenze;
	}
	
	public int interneWerteZusammenzaehlen(ArrayList<Integer> liste){
		
		int zusammenzaehler = 0;
		
		for(int i = 0 ; i < liste.size() ; ++i){
			
			zusammenzaehler+=liste.get(i);
		}		
		return zusammenzaehler;
	}	
	
	public void elementHinzufügen(int element){
		
		elementeListe.add(element);
	}
	
	private ArrayList<Integer> elementListeKlonen(){
		
		ArrayList<Integer> clone = new ArrayList<Integer>();
		
		for(int i = 0 ; i < elementeListe.size() ; ++i){
			
			clone.add(elementeListe.get(i));
		}
		return clone;
	}
	
	public void letztesElementLoeschen(){
		
		elementeListe.remove(elementeListe.size()-1);
	}
	
	public void pruefeOptimum(){
		
		if(interneWerteZusammenzaehlen(elementeListe)<=yGrenze && interneWerteZusammenzaehlen(elementeListe)>interneWerteZusammenzaehlen(optimum)){
			
			optimum=elementListeKlonen();			
		}
	}
	
	public void backtracking(int runde){
		
		if(runde < gesamtMenge.size()-1){
			
			backtracking(runde + 1);
		}else{
			
			pruefeOptimum();
		}
		
		elementHinzufügen(gesamtMenge.get(runde));
		
		if(runde < gesamtMenge.size()-1){
			
			backtracking(runde + 1);
			
		}else{
			
			pruefeOptimum();			
		}
		
		letztesElementLoeschen();
	}
	
	public void optimumAusgeben(){
		
		if(optimum.size()==0){
			
			System.out.println("Ich hab keine Elemente in mir!");
			
		}else{
		
			for(int i = 0 ; i < optimum.size() ; ++i){
				
				System.out.println(optimum.get(i));
			}
		}
	}
}
