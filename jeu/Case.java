package jeu;

public abstract class Case {
	//Un attribut pour chaque valeur possible
	//(celle de la solution et celle du joueur) 
	protected char valeurSolution;
	protected char valeurJoueur;
		
	//Constructeur
	public Case (char lettre) {
		this.valeurSolution = lettre;
		if(lettre == 'x') {
			this.valeurJoueur = 'x';
		}else {
			this.valeurJoueur = ' ';
		}
	}
	
	//Gettter de la valeur solution
	public char getValeurSolution() {
		return valeurSolution;
	}
	
	//Getter et Setter de la valeur du joueur
	public char getValeurJoueur(){
		return valeurJoueur;
	}
	public void setValeurJoueur(char lettre) {
		this.valeurJoueur = java.lang.Character.toUpperCase(lettre);
	}
	
	public abstract String getCoordonnee();
	
	public abstract boolean getDirectionH();

	public abstract boolean getDirectionV();

	public abstract boolean getDirectionD();
	
	public abstract String verifTypeCase();

	public abstract void verifCase(int rep);
	
	//Méthode d'ajout et de vérification d'une lettre
	public boolean verifAjouterLettre() {
		if(this.getValeurJoueur() == 'x') {
			System.out.println("Vous ne pouvez pas insérer une lettre dans cette case car c'est une case noire.");
			return false;
		}else if(this.getValeurJoueur() != ' '){
			System.out.println("Vous avez déjà renseigné cette case par la lettre \"" + this.getValeurJoueur() + "\".");
			return false;
		}else {
			return true;
		}
	}
	
	//Méthode d'effacement et de vérification de la lettre d'une case
	public boolean verifEffacerLettre() {
		if(this.getValeurJoueur() == ' ') {
			System.out.println("Vous ne pouvez pas effacer cette case car vous n'avez encore renseigné aucune lettre.");
			return false;
		}else if(this.getValeurJoueur() == 'x') {
			System.out.println("Vous ne pouvez pas effacer cette case car c'est une case noire.");
			return false;
		}
		return true;
	}	
	
}
