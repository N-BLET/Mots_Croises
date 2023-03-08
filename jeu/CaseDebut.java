package jeu;

public class CaseDebut extends Case{
	//Attributs coordonnées et direction de la case début
	//"A1" est la seule case à initier un mot dans chaque direction
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
	
	//Getter pour récupérer les coordonnées de la case.
	public String getCoordonnee() {
		return coordonnee;
	}
	
	//Méthode pour récupérer la direction
	public boolean getDirectionH(){
		return directionH;
	}
	public boolean getDirectionV(){
		return directionV;
	}
	public boolean getDirectionD(){
			return directionD;
	}

	//Méthode pour vérifier si cette case est de type CaseDebut
	public String verifTypeCase() {
		return "CaseDebut";
	}

	public void verifCase(int rep) {
		if(rep == 4 || rep == 5) {
			if(!this.verifTypeCase().equalsIgnoreCase("CaseDebut")){
				System.out.println("Les coordonnées que vous avez saisies n'indiquent pas une case correspondant au début d'un mot de cette grille.");
				throw new IllegalArgumentException();
			}
		}
	}
}
