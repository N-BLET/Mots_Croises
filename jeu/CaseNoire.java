package jeu;

public class CaseNoire extends Case{
	//Attribut coordonn�es de la case
	protected String coordonnee;
	
	//Constructeur
	public CaseNoire(char lettre, int ordonnee, int abscisse){
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
	
	//M�thode pour v�rifier si cette case est de type CaseNoire
	public String verifTypeCase() {
		return "CaseNoire";
	}
	
	public void verifCase(int rep) {
		if(this.verifTypeCase().equalsIgnoreCase("CaseNoire")) {
			if(rep == 2) {
				System.out.println("Vous ne pouvez pas ins�rer une lettre dans cette case car c'est une case noire.");
				throw new IllegalArgumentException();
			}else if(rep == 3) {
				System.out.println("Vous ne pouvez pas effacer de lettre dans cette case car c'est une case noire.");
				throw new IllegalArgumentException();
			}else if(rep == 4) {
				System.out.println("Vous ne pouvez pas ins�rer un mot � partir de cette case car c'est une case noire.");
				throw new IllegalArgumentException();
			}else if(rep == 5) {
				System.out.println("Vous ne pouvez pas effacer un mot � partir de cette case car c'est une case noire.");
				throw new IllegalArgumentException();
			}
		}
	}

}
