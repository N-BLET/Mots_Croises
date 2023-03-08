package jeu;

public class CaseNoire extends Case{
	//Attribut coordonnées de la case
	protected String coordonnee;
	
	//Constructeur
	public CaseNoire(char lettre, int ordonnee, int abscisse){
		super(lettre);
		char x = (char) (ordonnee + '1');
		char y = (char)((int)'A' + abscisse);
		this.coordonnee  = "" + y + x;
	}
	
	//Getter pour récupérer les coordonnées de la case.
	public String getCoordonnee() {
		return coordonnee;
	}
	
	//Méthode pour récupérer la direction
	public boolean getDirectionH() {
		return false;
	}
	public boolean getDirectionV(){
		return false;
	}
	public boolean getDirectionD(){
		return false;
	}
	
	//Méthode pour vérifier si cette case est de type CaseNoire
	public String verifTypeCase() {
		return "CaseNoire";
	}
	
	public void verifCase(int rep) {
		if(this.verifTypeCase().equalsIgnoreCase("CaseNoire")) {
			if(rep == 2) {
				System.out.println("Vous ne pouvez pas insérer une lettre dans cette case car c'est une case noire.");
				throw new IllegalArgumentException();
			}else if(rep == 3) {
				System.out.println("Vous ne pouvez pas effacer de lettre dans cette case car c'est une case noire.");
				throw new IllegalArgumentException();
			}else if(rep == 4) {
				System.out.println("Vous ne pouvez pas insérer un mot à partir de cette case car c'est une case noire.");
				throw new IllegalArgumentException();
			}else if(rep == 5) {
				System.out.println("Vous ne pouvez pas effacer un mot à partir de cette case car c'est une case noire.");
				throw new IllegalArgumentException();
			}
		}
	}

}
