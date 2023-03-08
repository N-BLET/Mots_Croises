package jeu;

public class CaseBlanche extends Case {
	//Attribut coordonn�es de la case
	protected String coordonnee;

	public CaseBlanche(char lettre, int ordonnee, int abscisse){
		super(lettre);
		char x = (char) (ordonnee + '1');
		char y = (char)((int)'A' + abscisse);
		this.coordonnee  = "" + y + x;
	}
	
	//Getter pour r�cup�rer les coordonn�es de la case.
	public String getCoordonnee() {
		return coordonnee;
	}
	
	//M�thode pour r�cup�rer la direction
	public boolean getDirectionH() {
		return false;
	}
	public boolean getDirectionV(){
		return false;
	}
	public boolean getDirectionD(){
		return false;
	}

	//M�thode pour v�rifier si cette case est de type CaseBlanche
	public String verifTypeCase() {
		return "CaseBlanche";
	}

	public void verifCase(int rep) {}
}
