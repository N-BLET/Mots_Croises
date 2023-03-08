package jeu;
import java.util.Scanner;

public class MotsCroises {
	//Les attributs
	protected Case[][] motsCroises;
	protected int tailleAbscisse, tailleOrdonnee;
	
	//Constructeur
	public MotsCroises(char [][] motcroise) {
		this.tailleAbscisse = motcroise.length;
		this.tailleOrdonnee = motcroise[0].length;
		this.motsCroises = new Case[tailleAbscisse][tailleOrdonnee];
		for (int i = 0; i < tailleAbscisse; i++) {
			for (int j = 0; j < tailleOrdonnee; j++) {	
				if(motcroise[i][j] == 'x') {
					motsCroises[i][j] = new CaseNoire(motcroise[i][j], i, j);
				}else if(i == 0 && j == 0){
					 premiereCase(motcroise, i, j);
				}else if((i == tailleAbscisse-1 && j == 0) || (i == 0 && j == tailleOrdonnee-1) || (i == tailleAbscisse-1 && j == tailleOrdonnee-1) ){
					angle(motcroise, i, j);
				}else if(i == 0 && j < tailleOrdonnee) {
					premiereLigne(motcroise, i, j);
				}else if(j == 0 && i < tailleAbscisse) {
					premiereColonne(motcroise, i, j);
				}else if(i != 0 && j == tailleOrdonnee-1) {
					derniereColonne(motcroise, i, j);
				}else if(i == tailleAbscisse-1 && j != 0) {
					derniereLigne(motcroise, i, j);
				}else if(i !=0 && i < tailleAbscisse-1 && j!= 0 && j < tailleOrdonnee-1) {
					autresCases(motcroise, i, j);
				}else if(motcroise[i][j] != 'x'){
					this.motsCroises[i][j] = new CaseBlanche(motcroise[i][j], i, j);
				}
			}
		}
	}
	
	//Méthode pour le cas particulier de la première case de la grille
	public void premiereCase(char [][] motcroise, int i, int j) {
		if(motcroise[i+1][j] != 'x' && motcroise[i][j+1] != 'x') {
			this.motsCroises[i][j] = new CaseDebut(motcroise[i][j], i, j, true, true);
		}else if(motcroise[i+1][j] == 'x') {
			this.motsCroises[i][j] = new CaseDebut(motcroise[i][j], i, j, true, false);
		}else if(motcroise[i][j+1] == 'x') {
			this.motsCroises[i][j] = new CaseDebut(motcroise[i][j], i, j, false, true);
		}
	}
	
	//Méthode pour les autres angles de la grille
	public void angle(char [][] motcroise, int i, int j) {
		if(i == 0 && j == tailleOrdonnee-1) {
			this.motsCroises[i][j] = new CaseDebut(motcroise[i][j], i, j, false, true);
		}else if(i== tailleAbscisse-1 && j == 0) {
			this.motsCroises[i][j] = new CaseDebut(motcroise[i][j], i, j, true, false);
		}else {
			this.motsCroises[i][j] = new CaseBlanche(motcroise[i][j], i, j);
		}
	}
	
	//Méthode pour le cas particulier de la première ligne
	public void premiereLigne(char [][] motcroise, int i, int j) {
		if(motcroise[i+1][j] == 'x' && motsCroises[i][j-1].verifTypeCase() != "CaseNoire") {
			this.motsCroises[i][j] = new CaseBlanche(motcroise[i][j], i, j);
		}else if(motsCroises[i][j-1].verifTypeCase() == "CaseNoire" && motcroise[i][j+1] != 'x' && motcroise[i+1][j] == 'x') {
			this.motsCroises[i][j] = new CaseDebut(motcroise[i][j], i, j, true, false);
		}else if(motsCroises[i][j-1].verifTypeCase() == "CaseNoire" && motcroise[i][j+1] != 'x' && motcroise[i+1][j] != 'x') {
			this.motsCroises[i][j] = new CaseDebut(motcroise[i][j], i, j, true, true);
		}else {
			this.motsCroises[i][j] = new CaseDebut(motcroise[i][j], i, j, false, true);
		}
	}
	
	//Méthode pour le cas particulier de la première colonne
	public void premiereColonne(char [][] motcroise, int i, int j) {
		if(motsCroises[i-1][j].verifTypeCase() == "CaseNoire" && motcroise[i+1][j] != 'x' && motcroise[i][j+1] != 'x') {
			this.motsCroises[i][j] = new CaseDebut(motcroise[i][j], i, j, true, true);
		}else if(motsCroises[i-1][j].verifTypeCase() == "CaseNoire" && motcroise[i+1][j] != 'x' && motcroise[i][j+1] == 'x') {
			this.motsCroises[i][j] = new CaseDebut(motcroise[i][j], i, j, false, true);
		}else if(motsCroises[i-1][j].verifTypeCase() == "CaseNoire" && motcroise[i+1][j] == 'x' && motcroise[i][j+1] != 'x') {
			this.motsCroises[i][j] = new CaseDebut(motcroise[i][j], i, j, true, false);
		}else {
			this.motsCroises[i][j] = new CaseDebut(motcroise[i][j], i, j, true, false);
		}
	}
	
	//Méthode pour le cas particulier de la dernière colonne
	public void derniereColonne(char [][] motcroise, int i, int j) {
		if(motsCroises[i-1][j].verifTypeCase() == "CaseNoire" && motcroise[i+1][j] != 'x') {
			this.motsCroises[i][j] = new CaseDebut(motcroise[i][j], i, j, false, true);
		}else if(motcroise[i][j] != 'x'){
			this.motsCroises[i][j] = new CaseBlanche(motcroise[i][j], i, j);
		}
	}
	
	//Méthode pour la cas de la dernière ligne
	public void derniereLigne(char [][] motcroise, int i, int j) {
		if(motsCroises[i][j-1].verifTypeCase() == "CaseNoire" && motcroise[i][j+1] != 'x') {
			this.motsCroises[i][j] = new CaseDebut(motcroise[i][j], i, j, true, false);
		}else if(motcroise[i][j] != 'x'){
			this.motsCroises[i][j] = new CaseBlanche(motcroise[i][j], i, j);
		}
	}
	
	//Méthode pour tous les autres cas
	public void autresCases(char [][] motcroise, int i, int j) {
		if(motsCroises[i][j-1].verifTypeCase() == "CaseNoire" && motsCroises[i-1][j].verifTypeCase() == "CaseNoire" && motcroise[i][j+1] != 'x' && motcroise[i+1][j] == 'x') {
			this.motsCroises[i][j] = new CaseDebut(motcroise[i][j], i, j, true, false);
		}else if(motsCroises[i][j-1].verifTypeCase() == "CaseNoire" && motsCroises[i-1][j].verifTypeCase() == "CaseNoire" && motcroise[i][j+1] == 'x' && motcroise[i+1][j] != 'x') {
			this.motsCroises[i][j] = new CaseDebut(motcroise[i][j], i, j, false, true);
		}else if(motsCroises[i][j-1].verifTypeCase() == "CaseNoire" && motsCroises[i-1][j].verifTypeCase() == "CaseNoire" && motcroise[i][j+1] != 'x' && motcroise[i+1][j] != 'x'){
			this.motsCroises[i][j] = new CaseDebut(motcroise[i][j], i, j, true, true);
		}else if(motsCroises[i][j-1].verifTypeCase() == "CaseNoire" && motcroise[i][j+1] != 'x' && motsCroises[i-1][j].verifTypeCase() != "CaseNoire") {
			this.motsCroises[i][j] = new CaseDebut(motcroise[i][j], i, j, true, false);
		}else if(motsCroises[i-1][j].verifTypeCase() == "CaseNoire" && motcroise[i+1][j] != 'x' && motsCroises[i][j-1].verifTypeCase() != "CaseNoire") {
			this.motsCroises[i][j] = new CaseDebut(motcroise[i][j], i, j, false, true);
		}else if(motcroise[i][j] != 'x'){
			this.motsCroises[i][j] = new CaseBlanche(motcroise[i][j], i, j);
		}
	}
	
	
	//Getter de chaque attribut
	public int getTailleAbscisse() {
		return tailleAbscisse;
	}
	
	public int getTailleOrdonnee() {
		return tailleOrdonnee;
	}
	
	//Récupération du 1er caractère des coordonnées (lettre)
	public int recupLettreCoordonnee(String caseCoord) {
		char l = java.lang.Character.toUpperCase(caseCoord.charAt(0));
		return (int) l - (int) 'A';
	}
	
	//Récupération du 2ème caractère des coordonnées (chiffre)
	public int recupChiffreCoordonnee(String caseCoord) {
		return Integer.parseInt(caseCoord.substring(1, 2))-1;
	}
	
	//Méthode pour récupérer les coordonnées saisie par l'utilisateur en fonction du choix du menu
	public String recupCoordonnee(int rep, Scanner scan) {
		String casecoord = "";
		int x, y, direction = 0;
		boolean saisieOk = true;
		do {
			try {
				saisieOk = true;
				if(rep == 2) {	//Insérer une lettre
					System.out.print("Entrez les coordonnées de la case où écrire la lettre : ");
				}else if (rep == 3) {	//Effacer une lettre
					System.out.print("Entrez les coordonnées de la case dont vous voulez effacer la lettre : ");
				}else if (rep == 4) {	//Insérer un mot
					System.out.print("Entrez les coordonnées de la première case de votre mot : ");					
				}else if(rep == 5) {	//Effacer un mot
					System.out.print("Entrez les coordonnées de la première case du mot que vous voulez effacer : ");
				}
				casecoord = scan.nextLine();
				verifCaseCoord(casecoord, tailleAbscisse, tailleOrdonnee);
				y = recupLettreCoordonnee(casecoord);
				x = recupChiffreCoordonnee(casecoord);
				motsCroises[x][y].verifCase(rep);
				direction = recupDirection(motsCroises[x][y], rep, scan);
				gestionReponse(rep, casecoord, x, y, direction, scan);
			}catch(IllegalArgumentException e1) {
				System.out.println("e1: " + e1);
				saisieOk = false;
			}catch(ArrayIndexOutOfBoundsException e2) {
				saisieOk = false;
			}
		}while(!saisieOk);
		return casecoord;
	}
	
	//Méthode pour vérifier les coordonnées saisies par l'utilisateur 
	public static void verifCaseCoord(String caseCoord, int tailleOrdonneeMotcroise, int tailleAbscisseMotcroise){
		if(caseCoord.equals("")) {
			System.out.println("Vous n'avez saisi aucunes coordonnées. Rappel du format: (Ex: A3)");
			throw new IllegalArgumentException();
		}else if(caseCoord.length() != 2) {
			System.out.println("Les coordonnées que vous avez saisies \"" + caseCoord + "\" ne correspondent pas au format une lettre et un chiffre. Rappel du format: (Ex: A3)");
			throw new IllegalArgumentException();	
		}else if(!((caseCoord.charAt(0) >= 'A' && caseCoord.charAt(0) <= 'Z') || (caseCoord.charAt(0) >= 'a' && caseCoord.charAt(0) <= 'z'))){
			System.out.println("Vos coordonnées \"" + caseCoord + "\" sont invalides car votre premier caractère n'est pas une lettre. Rappel du format: (Ex: A3)");
			throw new IllegalArgumentException();
		}else if((int)java.lang.Character.toUpperCase(caseCoord.charAt(0)) < (int) 'A'|| ((int)java.lang.Character.toUpperCase(caseCoord.charAt(0)) - (int) 'A'+ 1) > tailleAbscisseMotcroise) {
			System.out.println("La lettre des coordonnées que vous avez saisies \"" + caseCoord.charAt(0) + "\" n'est pas correcte. Elle devrait être comprise entre \"A\" et \"" + ((char)(tailleAbscisseMotcroise + (int)'A' - 1)) + "\".");
			throw new ArrayIndexOutOfBoundsException();
		}else if(!Character.isDigit(caseCoord.charAt(1))) {
			System.out.println("Vos coordonnées \"" + caseCoord + "\" sont invalides car votre deuxième caractère n'est pas un chiffre. Rappel du format: (Ex: A3)");
			throw new IllegalArgumentException();
		}else if(Integer.parseInt(caseCoord.substring(1, 2))-1 < 0 || Integer.parseInt(caseCoord.substring(1, 2)) > tailleOrdonneeMotcroise) {
			System.out.println("Le chiffre des coordonnées que vous avez saisies \"" + caseCoord.substring(1, 2) + "\" n'est pas correct. Il devrait être compris entre 1 et " + tailleOrdonneeMotcroise);
			throw new ArrayIndexOutOfBoundsException();
		}
	}
	
	//Méthode pour proposer le choix de la direction lorsqu'une case possède les 2 sens
	public int choixDirection(Scanner scan) {
		boolean testOk;
		int choixDirection = 0;
		do {
			testOk = true;
			try {
				System.out.print("Veuillez choisir la direction de votre mot.\nTapez \"1\" pour horizontal ou bien \"2\" pour vertical: ");
				 while ( !scan.hasNextInt() ) {
					 System.out.print("Veuillez choisir la direction de votre mot.\nTapez \"1\" pour horizontal ou bien \"2\" pour vertical: ");
					 System.out.println("Vous n'avez pas saisi un chiffre.");
					 scan.nextLine(); // vidage saisie incorrect
				    }
				choixDirection = scan.nextInt();
				scan.nextLine();
				if(!(choixDirection == 1 || choixDirection == 2)) {
					throw  new IllegalArgumentException();
				}
			}catch(IllegalArgumentException e) {
				System.out.println("Votre réponse \"" + choixDirection + "\" est différente des possibilités attendues \"1\" ou \"2\"");
				testOk = false;
			}
		}while(!testOk);
		return choixDirection;
	}
	
	//Méthode pour récupérer la direction
	public int recupDirection(Case caseDebMot, int rep, Scanner scan) {
		int direction = 0;
		if(caseDebMot.getDirectionD() && rep != 2 && rep != 3) {	//cas particulier pour sens multiples
			direction = choixDirection(scan);
		}else if(caseDebMot.getDirectionH()) {
			direction = 1;
		}else if(caseDebMot.getDirectionV()) {
			direction = 2;
		}
		
		return direction;
	}
		
	//Méthode pour effectuer les actions en fonction de la réponse de l'utilisateur
	public void gestionReponse(int rep, String casecoord, int x, int y, int direction, Scanner scan) {
		String mot = "";
		if(rep == 2 || rep == 3) {
			verifCaseDejaRempli(rep, x, y);
		}
		if(rep == 2) {
			char lettre = recupCaractere(casecoord, scan);
			ajoutLettreUtilisateur(lettre, casecoord, x, y);
		}else if(rep == 3) {
			effacerLettre(rep, casecoord, x, y);
		}
		if(rep == 4) {
			verifMotDejaInsere(casecoord, rep, x, y, direction);
			mot = recupMot(casecoord, x, y, direction, scan);
			ajoutMot(mot, casecoord, x, y, direction);
		}else if(rep == 5) {
			verifMotDejaInsere(casecoord, rep, x, y, direction);
			effacerMot(casecoord, x, y, direction);					
		}
	}
	
	
	//Méthode pour vérifier et récupérer le caractère saisi par l'utilisateur
	public char recupCaractere(String caseCoord, Scanner scan) {
		char caractere = ' ';
		boolean saisieOk = true;
		do {
			try {
				saisieOk = true;
				System.out.print("Entrez la lettre à écrire : ");
				caractere = scan.nextLine().charAt(0);
				caractere = java.lang.Character.toUpperCase(caractere);
				verifCaractere(caractere);
			}catch(IllegalArgumentException e) {
				saisieOk = false;
			}
		}while(!saisieOk);
		return caractere;
	}
	
	//Méthode pour vérifier si le caractère renseigné par l'utilisateur est valide
	public void verifCaractere(char caractere) {
		if(!((caractere >= 'A' && caractere <= 'Z') || (caractere >= 'a' && caractere <= 'z'))){
			System.out.println("La lettre que vous avez saisie \"" + caractere + "\" n'est pas une lettre de l'alphabet.");	
			throw new IllegalArgumentException();
		}
	}
	
	//Méthode pour vérifier si la case est déjà remplie
	public void verifCaseDejaRempli(int rep, int x, int y) {
		if(rep == 2) {
			if(!motsCroises[x][y].verifAjouterLettre()) {
				throw new IllegalArgumentException();
			}
		}else if(rep == 3) {
			if(!motsCroises[x][y].verifEffacerLettre()) {
				throw new IllegalArgumentException();
			}
		}
	}
	
	//Méthode pour ajouter la lettre de l'utilisateur
	public void ajoutLettreUtilisateur(char nouvLettre, String caseCoord, int x, int y) {
			motsCroises[x][y].setValeurJoueur(nouvLettre);
			System.out.println("La lettre de la case \"" + caseCoord + "\" a bien été insérée");
	}
	
	//Méthode pour effacer la lettre d'une case
	public void effacerLettre(int rep, String caseCoord, int x, int y) {
		motsCroises[x][y].setValeurJoueur(' ');
		System.out.println("La lettre de la case \"" + caseCoord + "\" a bien été effacée.");
	}
	
/*************************************
 *                                   *
 * MÉTHODES POUR LA GESTION DES MOTS *	
 *                                   *
 *************************************/
	
	//Méthode de calcul de la taille du mot
	public int tailleMot(String caseCoord, int x, int y, int direction) {
		int tailleMot = 0;
		if(motsCroises[x][y].getDirectionH() && !(motsCroises[x][y].getDirectionD() && direction == 2) || (motsCroises[x][y].getDirectionD() && direction == 1)) {
				for (int i = y; i < tailleOrdonnee; i++) {
					 if(motsCroises[x][i].getValeurJoueur() == 'x') break;
					 tailleMot++;
				}	
		}else if(motsCroises[x][y].getDirectionV() && !(motsCroises[x][y].getDirectionD() && direction == 1) || (motsCroises[x][y].getDirectionD() && direction == 2)) {
				for (int i = x; i < tailleAbscisse; i++) {
					if(motsCroises[i][y].getValeurJoueur() == 'x') break;
					tailleMot++;
				}	
		}
		return tailleMot;
	}
	
	//Méthode pour récupérer le mot saisi par l'utilisateur
	public String recupMot(String caseCoord, int x, int y, int direction, Scanner scan) {
		String mot = "";
		int tailleMot;
		boolean saisieOk = true;
		tailleMot = tailleMot(caseCoord, x, y, direction);
		do {
			if(motsCroises[x][y].getDirectionD()) {
				if(direction == 1) {
					System.out.print("Veuillez saisir un mot horizontal composé de " + tailleMot + " lettres: ");
				}else if(direction == 2) {
					System.out.print("Veuillez saisir un mot vertical composé de " + tailleMot + " lettres: ");
				}
			}
			else if(motsCroises[x][y].getDirectionH()) {
				System.out.print("Veuillez saisir un mot horizontal composé de " + tailleMot + " lettres: ");
			}else if(motsCroises[x][y].getDirectionV()) {
				System.out.print("Veuillez saisir un mot vertical composé de " + tailleMot + " lettres: ");
			}
			try {
				saisieOk = true;
				mot = scan.nextLine();
				verifInsertionMot(mot, verifMot(mot, tailleMot), x, y, direction);
			}catch(IllegalArgumentException e) {
				saisieOk = false;
			}
		}while(!saisieOk);
		return mot;
	}
	
	//Méthode pour vérifier si le mot de l'utilisateur est valide
	public int verifMot(String mot, int tailleMot) {
		if( mot.length() == 0) {
			System.out.println("Veuillez saisir un mot car vous n'avez pas renseigné ce dernier.");
			throw new IllegalArgumentException();
		}else if(mot.length() != tailleMot) {
			if(mot.length() > tailleMot) {
				System.out.println("Votre mot \"" + mot + "\" possède plus de " + tailleMot + " lettres.");
				throw new IllegalArgumentException();
			}else if(mot.length() < tailleMot) {
				System.out.println("Votre mot \"" + mot + "\" possède moins de " + tailleMot + " lettres.");
				throw new IllegalArgumentException();
			}
		}else {
			for (int i = 0; i < tailleMot; i++) {
				char c = mot.charAt(i);
				if(!(c >= 'A' && c <= 'Z') && !(c >= 'a' && c <= 'z')) {
					System.out.println("Votre mot \"" + mot + "\" n'est pas constitué que de lettres.");
					throw new IllegalArgumentException();
				}
			}
		}
		return tailleMot;
	}	
	
	//Méthode pour vérifier si un mot est déjà inséré dans la grille
	public boolean verifMotDejaInsere(String caseCoord, int rep, int x, int y, int direction) {
		//Nouvelle transformation des coordonnées dûe à la méthode "effacerMot"
		int y1 = recupLettreCoordonnee(caseCoord);
		int x1 = recupChiffreCoordonnee(caseCoord);
		if(motsCroises[x1][y1].getDirectionH() && !(motsCroises[x][y].getDirectionD() && direction == 2) || (motsCroises[x][y].getDirectionD() && direction == 1)) {
			return verifHorizontale(caseCoord, rep, x, y, direction, x1, y1);
			
		}else {
			return verifVerticale(caseCoord, rep, x, y, direction, x1, y1);
		}		
	}
	
	//Méthode pour vérifier avant la gestion de la réponse de l'utilisateur que les conditions sont bien remplies
	public boolean verifHorizontale(String caseCoord,int rep, int x, int y, int direction, int x1, int y1) {
		int countTaille = 0, countCase = 0;
		if(motsCroises[x1][y1].getDirectionH() && !(motsCroises[x][y].getDirectionD() && direction == 2) || (motsCroises[x][y].getDirectionD() && direction == 1)) {
			for (int i = 0; i < tailleOrdonnee-y1; i++) {
				countTaille++;
				if(motsCroises[x1][i+y1].getValeurJoueur() == 'x') {
					countTaille--;
					break;
				}else if((motsCroises[x1][i+y1].getValeurJoueur() != ' ')) {
					countCase++;
				}
			}
		}
		return gestionVerif(caseCoord, rep, countTaille, countCase);
	}
	
	//Méthode pour vérifier avant la gestion de la réponse de l'utilisateur que les conditions sont bien remplies
	public boolean verifVerticale(String caseCoord, int rep, int x, int y, int direction, int x1, int y1) {
		int countTaille = 0, countCase = 0;
		if(motsCroises[x1][y1].getDirectionV() && !(motsCroises[x][y].getDirectionD() && direction == 1) || (motsCroises[x][y].getDirectionD() && direction == 2)) {
			for (int i = 0; i < tailleAbscisse-x1; i++) {
				countTaille++;
				if(motsCroises[i+x1][y1].getValeurJoueur() == 'x') {
					countTaille--;
					break;
				}else if(motsCroises[i+x1][y1].getValeurJoueur() != ' ') {
					countCase++;
				}
			}
		}
		return gestionVerif(caseCoord, rep, countTaille, countCase);
	}
	
	//Méthode pour vérifier avant la gestion de la réponse de l'utilisateur que les conditions sont bien remplies
	public boolean gestionVerif(String caseCoord, int rep, int countTaille, int countCase) {
		if(countTaille == countCase && countTaille > 1) {
			if(rep == 4) {
				System.out.println("Un mot est déjà inséré depuis la case \"" + caseCoord + "\".");
				throw new IllegalArgumentException();
			}
			return true;
		}else {
			if(rep == 5) {
				System.out.println("Aucun mot n'est déjà inséré depuis la case \"" + caseCoord + "\".");
				throw new IllegalArgumentException();
			}
		return false;
		}
	}

	
	//Méthode pour vérifier l'insertion d'un mot dans la grille
	public void verifInsertionMot(String mot, int tailleMot, int x, int y, int direction) {
		mot =  mot.toUpperCase();
		if((motsCroises[x][y].getDirectionD() && direction == 1) || (motsCroises[x][y].getDirectionH() && !motsCroises[x][y].getDirectionD())) {
			for (int i = 0; i < tailleMot; i++) {
				if(motsCroises[x][i+y].getValeurJoueur() != ' ' && motsCroises[x][i+y].getValeurJoueur() != mot.charAt(i)) {
					System.out.println("Vous ne pouvez pas inscrire votre mot \"" + mot + "\" car la lettre à la position \""
					+ (i+1)	+ "\" ne correspond pas à la lettre \"" + motsCroises[x][i+y].getValeurJoueur()
					+ "\" déjà renseignée.");
					throw new IllegalArgumentException();
				}
			}
		}else if((motsCroises[x][y].getDirectionD() && direction == 2) || (motsCroises[x][y].getDirectionV() && !motsCroises[x][y].getDirectionD())) {
			for (int i = 0; i < tailleMot; i++) {
				if(motsCroises[i+x][y].getValeurJoueur() != ' ' && motsCroises[i+x][y].getValeurJoueur() != mot.charAt(i)) {
					System.out.println("Vous ne pouvez pas inscrire votre mot \"" + mot + "\" car la lettre à la position \""
					+ (i+1)	+ "\" ne correspond pas à la lettre \"" + motsCroises[i+x][y].getValeurJoueur()
					+ "\" déjà renseignée.");
					throw new IllegalArgumentException();
				}
			}
		}
	}
	
	//Méthode pour insérer un mot
	public void ajoutMot(String mot, String caseCoord, int x, int y, int direction) {
		mot =  mot.toUpperCase();
		int longueurMot = mot.length();
		if(motsCroises[x][y].getDirectionH() && !motsCroises[x][y].getDirectionV() || motsCroises[x][y].getDirectionD() && direction == 1) {
				int j = 0;
				for (int i = y; i < longueurMot+y; i++) {
					motsCroises[x][i].setValeurJoueur(mot.charAt(j));
					j++;
				}
			}else if(!motsCroises[x][y].getDirectionH() && motsCroises[x][y].getDirectionV() || motsCroises[x][y].getDirectionD() && direction == 2) {
				int j = 0;
				for (int i = x; i < longueurMot+x; i++) {
					motsCroises[i][y].setValeurJoueur(mot.charAt(j));
					j++;
				}
			}
		System.out.println("Votre mot \"" + mot + "\" a bien été inséré dans la grille.");
	}
	
	//Méthode pour effacer un mot
	public void effacerMot(String caseCoord, int x, int y, int direction) {
		int tailleMot = tailleMot(caseCoord, x, y, direction);
		try {
			if(motsCroises[x][y].getDirectionV() && !(motsCroises[x][y].getDirectionD() && direction == 1) || (motsCroises[x][y].getDirectionD() && direction == 2)) {
				gestionVerticale(tailleMot, x, y, direction);
			}else if(motsCroises[x][y].getDirectionH() && !(motsCroises[x][y].getDirectionD() && direction == 2) || (motsCroises[x][y].getDirectionD() && direction == 1)) {
				gestionHorizontale(tailleMot, x, y, direction);
			}
		}catch(ArrayIndexOutOfBoundsException e) {}
		System.out.println("Le mot ayant pour première case \"" + caseCoord + "\" a bien été éffacé.");
	}
	
	//Méthode de retrait de chaque lettre d'un mot après vérification
	public void gestionVerticale(int tailleMot, int x, int y, int direction) {
		int coord;
		if(motsCroises[x][y].getDirectionV() && !(motsCroises[x][y].getDirectionD() && direction == 1) || (motsCroises[x][y].getDirectionD() && direction == 2)) {
			//Boucle partant de la case départ du mot et se terminant à la dernière lettre de celui-ci
			for (int i = x; i < x+tailleMot; i++) {
				coord = y;
				if(coord == 0 && i == 0) {
					if(!verifMotDejaInsere(motsCroises[i][coord].getCoordonnee(), 0, x, y, 1)) {
						motsCroises[i][coord].setValeurJoueur(' ');
					}	
				}else if(y == 0 && motsCroises[i-1][coord].verifTypeCase() == "CaseNoire" && motsCroises[i][coord+1].verifTypeCase() == "CaseNoire") {
					motsCroises[i][coord].setValeurJoueur(' ');
				}else {
					while(!(motsCroises[i][coord].verifTypeCase() == "CaseDebut" && (motsCroises[i][coord].getDirectionH() || motsCroises[i][coord].getDirectionD())|| motsCroises[i][coord].verifTypeCase() == "CaseNoire" || coord == 0)) {
						if(!(motsCroises[i][coord].verifTypeCase() == "CaseNoire")) {
							coord--;
						}
					} 
					if(!verifMotDejaInsere(motsCroises[i][coord].getCoordonnee(), 0, x, y, 1)) {
						motsCroises[i][y].setValeurJoueur(' ');
					}
				}
			}
		}
	}
	
	//Méthode de retrait de chaque lettre d'un mot après vérification (même chose dans l'autre sens)
	public void gestionHorizontale(int tailleMot, int x, int y, int direction) {
		int coord;
		if(motsCroises[x][y].getDirectionH() && !(motsCroises[x][y].getDirectionD() && direction == 2) || (motsCroises[x][y].getDirectionD() && direction == 1)) {
			for (int j = y; j < y+tailleMot; j++) {
				coord = x;
				if(coord == 0 && j == 0) {
					if(!verifMotDejaInsere(motsCroises[coord][j].getCoordonnee(), 0, x, y, 2)) {
						motsCroises[x][j].setValeurJoueur(' ');
					}
				}else if(x == 0 && motsCroises[coord][j-1].verifTypeCase() == "CaseNoire" && motsCroises[coord+1][j].verifTypeCase() == "CaseNoire") {
					motsCroises[x][j].setValeurJoueur(' ');
				}else {
					while(!(motsCroises[coord][j].verifTypeCase() == "CaseDebut" && (motsCroises[coord][j].getDirectionV() || motsCroises[coord][j].getDirectionD()) || motsCroises[coord][j].verifTypeCase() == "CaseNoire" || coord == 0)) {
						if(!(motsCroises[coord][j].verifTypeCase() == "CaseNoire")) {
							coord--;	
						}				
					}
					if(!verifMotDejaInsere(motsCroises[coord][j].getCoordonnee(), 0, x, y, 2)) {
						motsCroises[x][j].setValeurJoueur(' ');
					}
				}
			}
		}
	}
	
	//Méthode pour calculer le résultat du joueur
	public void calculFinal() {
		int solOk = 0;
		int solFaux = 0;
		int casesVides = 0;
		for (int i = 0; i < tailleAbscisse; i++) {
			for (int j = 0; j < tailleOrdonnee; j++) {
				if(motsCroises[i][j].getValeurJoueur() == ' ') {
					casesVides++;
				}else if(motsCroises[i][j].getValeurJoueur() == motsCroises[i][j].getValeurSolution() && motsCroises[i][j].getValeurJoueur() != 'x') {
					solOk++;
				}else if(motsCroises[i][j].getValeurJoueur() != motsCroises[i][j].getValeurSolution()){
					solFaux++;
				}
			}
		}
		if(solFaux == 0 && casesVides == 0) {
			System.out.println("Félicitation, vous avez rempli correctement toute la grille");
		}
		if(casesVides == 0) {
			System.out.println("Vous avez trouvé " + solOk + " cases de bonnes et vous avez " + solFaux + " case(s) de fausse(s)");
		}else if(solFaux != 0 || casesVides != 0){
			System.out.println("Vous avez " + solOk + " cases de bonnes, " + solFaux + " case(s) fausse(s) et vous avez " + casesVides + " case(s) de vide(s)");
		}
		System.out.println("Merci d'avoir joué à notre jeu de mots croisés !");
	}
	
	//Méthode pour afficher la grille 
	public void afficherGrille(int rep) {
		if(this.getTailleAbscisse() < 4) {
			System.out.print("  A  B  C  D");
		}else {
			System.out.print("  A  B  C  D  E  F");
			
		}		
		for (int i = 0; i < tailleAbscisse; i++) {
			if(i < tailleAbscisse) {
				System.out.print("\n" + (i+1));
			}
			for (int j = 0; j < tailleOrdonnee; j++) {
				if(rep == 1) {
					System.out.print("[" + motsCroises[i][j].getValeurJoueur() + "]");
				}else if(rep == 6) {
					System.out.print("[" + motsCroises[i][j].getValeurSolution() + "]");
				}
			}
		}
		System.out.println();
	}
	
}
