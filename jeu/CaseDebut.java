package jeu;

public class CaseDebut extends Case{
	//Attributs coordonn�es et direction de la case d�but
	//"A1" est la seule case � initier un mot dans chaque direction
	protected String coordonnee;
	protected boolean directionH, directionV, directionD;
	
	//Constructeur
	public CaseDebut(char lettre, int ordonnee, int abscisse, boolean directionH, boolean directionV){
		super(lettre);
		char x = (char) (ordonnee + '1');
		char y = (char)((int)'A' + abscisse);
		this.coordonnee  = "" + y + x;
		this.directionH = directionH;
		this.directionV = directionV;
		if(directionH && directionV) {
			this.directionD = true;
		}
	}
	
	//Getter pour r�cup�rer les coordonn�es de la case.
	public String getCoordonnee() {
		return coordonnee;
	}
	
	//M�thode pour r�cup�rer la direction
	public boolean getDirectionH(){
		return directionH;
	}
	public boolean getDirectionV(){
		return directionV;
	}
	public boolean getDirectionD(){
			return directionD;
	}

	//M�thode pour v�rifier si cette case est de type CaseDebut
	public String verifTypeCase() {
		return "CaseDebut";
	}

	public void verifCase(int rep) {
		if(rep == 4 || rep == 5) {
			if(!this.verifTypeCase().equalsIgnoreCase("CaseDebut")){
				System.out.println("Les coordonn�es que vous avez saisies n'indiquent pas une case correspondant au d�but d'un mot de cette grille.");
				throw new IllegalArgumentException();
			}
		}
	}
}
