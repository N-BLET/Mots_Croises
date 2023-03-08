package jeu;
import java.util.InputMismatchException;
import java.util.Scanner;


public class MainTest {
	public static int menu(Scanner scan) {
		int rep = 0;
		System.out.println("1 : afficher la grille");
		System.out.println("2 : écrire une lettre dans une case");
		System.out.println("3 : effacer une lettre d’une case");
		System.out.println("4 : écrire un mot");
		System.out.println("5 : effacer un mot");
		System.out.println("6 : afficher la solution");
		System.out.println("7 : quitter");
		do {
			System.out.print("Votre choix : ");
			try {
				rep = scan.nextInt();
			}catch(InputMismatchException exc){
				System.out.println("Entrez un nombre compris entre 1 et 7");
			}
			scan.nextLine();
		}while(rep < 1 || rep > 7);
		return rep;
	}

	public static void main(String[] args) {
		//Déclaration des variables utilisées dans le main
		int rep;
		
		char[][] motcroise = new char[0][0];
		char[][] tab1 = { {'U','I', 'O', 'P'},{'Q','x', 'S', 'D'},{'T','F', 'G', 'x'}};
		char[][] tab2 = { { 'A', 'Z', 'E', 'R', 'T', 'Y' }, { 'U', 'x', 'I', 'O', 'P', 'Q' },
						  { 'S', 'D', 'F', 'x', 'G', 'H' }, { 'J', 'K', 'L', 'M', 'W', 'X' },
						  { 'C', 'x', 'V', 'B', 'N', 'A' },
						  { 'Z', 'E', 'R', 'x', 'T', 'Y' }, { 'U', 'I', 'O', 'P', 'Q', 'S' } };
		
		Scanner scan = new Scanner(System.in);
		// Déclarez ici la ou les variables contenant les objets de vos classes
		MotsCroises grille;
		
		if (Math.random() < 0.5) // tirage au sort du mot-croise utilisé pour le test.
			motcroise = tab1;
		else
			motcroise = tab2;
		
		grille = new MotsCroises(motcroise);

		do {
			rep = menu(scan);
			if (rep == 1) {
				grille.afficherGrille(rep);
			}else if (rep == 2) {
				grille.recupCoordonnee(rep, scan);
				grille.afficherGrille(1);
			}else if (rep == 3) {
				grille.recupCoordonnee(rep, scan);
				grille.afficherGrille(1);
			}else if (rep == 4){
				grille.recupCoordonnee(rep, scan);
				grille.afficherGrille(1);
			}else if(rep == 5){
				grille.recupCoordonnee(rep, scan);
				grille.afficherGrille(1);
			}else if(rep == 6) {
				grille.afficherGrille(rep);
			}
		}while(rep != 7);
		grille.calculFinal();
		scan.close();	
	}
	
}