# Mots_Croises
Projet de jeu de Mots Croisés en POO. Notions abordées : classe, objet, héritage.

## PROJET MOTS CROISÉS

### 1 Objectif du projet
Le projet consiste à réaliser un logiciel de mots croisés. Ce jeu consiste à remplir les cases blanches d’une grille par des lettres de façon à constituer des mots par une lecture horizontale ou verticale. Si vous ne connaissez pas bien les mots croisés, consultez l’article de Wikipédia : https://fr.wikipedia.org/wiki/Mots_crois%C3%A9s

Le logiciel lira la spécification d’une grille avec ses définitions et ses solutions qui sera lue dans un fichier ou sur le web, via une classe qui vous sera fournie. Il utilisera pour son interface utilisateur les conventions utilisées sur le site du journal 20 minutes (https://www.20minutes.fr/services/mots-croises).

La grille est présentée avec des cases blanches, des cases noires ; les colonnes sont identifiées par une lettre majuscule et les lignes par un nombre.

![Modèle grille](https://github.com/N-BLET/Mots_Croises/blob/master/Grille_Vide.png)

On voit par exemple la case en haut à gauche a les coordonnées A1 (colonne A, ligne 1) et la dernière case en bas à droite est H12 (colonne H, ligne 12).

### 2 Étapes de réalisation du projet
Le projet fera l’objet de 3 étapes successives, avec à chaque étape, la remise d’un code Java. À l’issue de la deuxième étape, une soutenance aura lieu. Voici quelles sont les étapes :
- TP 1 : mise en place d’une architecture générale du projet.

- TP 2 : mise en œuvre de l’héritage et ajout de fonctionnalités.

- TP 3 : remise du projet termine, suivi de la soutenance.

Le projet est individuel : chaque élève doit le réaliser et doit en écrire seul chacune des lignes de code. Lors de la soutenance, l’élève doit justifier les choix qu’il a fait.
Pendant la période de préparation du projet, vous pouvez demander l’aide de votre tuteur. Vous pouvez lui poser toutes les questions et lui soumettre tous vos problèmes. 


### 3 Détail de l’étape 1
Vous devez proposer un ensemble de plusieurs classes permettant de représenter une grille de mots croisés, avec la possibilité d’inscrire une lettre dans une case et d’effacer une case contenant une lettre. Pour ces deux opérations, la case concernée sera désignée au moyen d’une chaine de caractère comportant une lettre majuscule suivie d’un numéro de ligne. Une classe de test doit permettre de tester quelques éléments du code produit.
Le mot-croise à représenter sera donne sous forme d’un tableau de caractères à deux dimensions dans lequel les cases contenant des lettres contiendront une lettre non accentuée en majuscule et les cases noires contiendront un x minuscule. Un tableau de char de ce genre sera passe en paramètre au constructeur d’une de vos classes. Les classes doivent s’adapter aux dimensions du tableau passe en paramètre.

### 4 Éléments d’architecture
Dans ce projet, on vous demande de séparer complètement deux types de classes : d’un côté, les classes qui représentent les données, de l’autre les classes d’interface qui permettent l’interaction avec l’utilisateur. Cette façon de faire est habituelle et permet de séparer des problèmes largement indépendants.
Les classes de représentation des données ne devront faire aucun affichage. En cas d’erreur, les constructeurs et méthodes doivent lever des exceptions.
Les classes attendues pour l’étape 1 sont des classes de représentation des données, sauf la classe de test qui contiendra un « main ».
Nous vous proposons le squelette suivant pour la classe de test, à compléter pour utiliser les classes que vous écrirez.

```Java
import java.util.InputMismatchException;
import java.util.Scanner;
public class MainTest {
  public static int menu(Scanner scan) {
  int rep=0;
  System.out.println("1 : afficher la grille");
  System.out.println("2 : ecrire une lettre dans une case");
  System.out.println("3 : effacer une lettre d’une case");
  System.out.println("4 : quitter");
  do {
    System.out.print("Votre choix : ");
  try {
    rep = scan.nextInt();
  }catch(InputMismatchException exc){
    System.out.println("Entrez un nombre compris entre 1 et 4");
  }
  scan.nextLine();
  }while(rep<1 || rep>4);
  return rep;
} 

public static void main(String[] args) {
  int rep;
  String casecoord;
  char lettre;
  char[][] motcroise;
  char[][] tab1 = {{’U’,’I’, ’O’, ’P’},{’Q’,’x’, ’S’, ’D’},{’T’,’F’, ’G’, ’x’}};
  char[][] tab2 = { { ’A’, ’Z’, ’E’, ’R’, ’T’, ’Y’ }, { ’U’, ’x’, ’I’, ’O’, ’P’, ’Q’ },
  { ’S’, ’D’, ’F’, ’x’, ’G’, ’H’ }, { ’J’, ’K’, ’L’, ’M’, ’W’, ’X’ },
  { ’C’, ’x’, ’V’, ’B’, ’N’, ’A’ },
  { ’Z’, ’E’, ’R’, ’x’, ’T’, ’Y’ }, { ’U’, ’I’, ’O’, ’P’, ’Q’, ’S’ } };

  Scanner scan = new Scanner(System.in);
  // Declarez ici la ou les variables contenant les objets de vos classes

  if (Math.random() < 0.5) // tirage au sort du mot-croise utilise pour le test.
  motcroise = tab1;
  else
  motcroise = tab2;

  // instanciez ici le ou les objets de vos classes initialises avec la grille
  // contenue dans la variable motcroise

  do {
    rep = menu(scan);
    if (rep == 1) {
     // A COMPLETER
    }else if (rep == 2) {
      System.out.print("Entrez les coordonnées de la case ou écrire la lettre : ");
      casecoord = scan.nextLine();
      System.out.print("Entrez la lettre à écrire : ");
      lettre = scan.nextLine().charAt(0);
      // A COMPLETER
    }else if (rep == 3) {
      System.out.print("Entrez les coordonnées de la case ou écrire la lettre : ");
      casecoord = scan.nextLine();
      // A COMPLETER
    }
  }while(rep !=4);
  }
}
```


### 5 Raffinement de la description des cases
Il y a plusieurs types de cases :
- Les cases noires, dans lesquelles on ne peut pas écrire ni probablement lire de lettre.

- Les cases blanches dans lesquelles on peut lire et écrire une lettre.

- Il est éventuellement possible de distinguer entre les cases qui commencent un mot et 	les autres, si c’est utile pour réaliser des opérations. Cela dépend de vos choix de 	représentation des données.
Pour ces différents types de cases, on vous propose d’utiliser des classes différentes en utilisant soit l’héritage soit une ou plusieurs interfaces qui permettent de donner un type commun à toutes les cases de la grille.

#### 6 Opérations spécifiques de chaque niveau
Dans le TP 1, trois opérations étaient demandées :
- L’affichage de la grille. Cette opération concerne la grille entière.

- L’inscription ou l’effacement d’une lettre dans une case. C’est une opération du   	 niveau des cases.
Pour jouer aux mot-croises, l’utilisateur va inscrire non pas des lettres, mais des mots qu’il pose sur la grille à partir d’une position – une case identifiée par ses coordonnées –, soit dans le sens horizontal, soit dans le sens vertical. L’opération d’écrire un mot dans la grille concerne plusieurs cases. Ce sera donc une méthode de la grille. Avant de commencer à écrire un mot, il faut vérifier plusieurs contraintes :

- Que la position choisie soit effectivement un début de mot dans la grille.

- Que le mot ait la longueur adaptée a l’emplacement désigne qu’il doit remplir complétement.

- Que le mot soit compatible avec les lettres déjà présentes à certains emplacements 	de la grille.
L’autre opération sur les mots, effacer un mot écrit, est complexe car il ne faut pas effacer le contenu des cases dont les lettres servent à un mot dans l’autre orientation. Cette opération n’est pas demandée dans cette étape du projet et sera à réaliser plus tard.

Dans cette dernière étape du projet, il s’agit de finaliser un jeu de mots-croises opérationnel.
Nous vous proposons d’ajouter l’opération d’effacement d’un mot au jeu. Cette opération ne consiste pas simplement à effacer toutes les lettres du mot, car certaines de ces lettres peuvent apparaitre dans un autre mot qu’il ne faut pas effacer. Par exemple, si l’on veut effacer un mot dans l’orientation horizontale, certaines lettres apparaissent dans des mots verticaux et il ne faut pas les effacer. Pour déterminer si une lettre appartient ou non à un mot vertical, il faut voir s’il reste des cases vides au-dessus ou en-dessous de la lettre.
 
Prenons un exemple. Voici un extrait de mot-croise.

![Modèle grille](https://github.com/N-BLET/Mots_Croises/blob/master/Exemple_Suppression.png)

Si l’on veut effacer le mot horizontal ligne 7, il faut effacer le I et le E, mais pas le R qui appartient au mot vertical ARE qui ne doit pas être efface. Ce qui fait la différence entre les deux situations, c’est qu’il y a des cases blanches dans les colonnes A et C, autour du mot à effacer (par exemple les cases A5, A8, C5 et C8 alors qu’il n’y a pas de cases blanches entre B5 et B9.

### 7 Fin de partie
Lors de la fin de partie sont affiches le nombre de lettres exactes dans la grille du joueur, le nombre de lettres fausses (le joueur a écrit une lettre différente de la solution) et le nombre de cases laissées blanches par le joueur.

### 8 Traitement des erreurs
Si une entrée de l’utilisateur est incorrecte, par exemple si un mot entre est trop long pour l’emplacement désigné par une case et une orientation, votre programme doit afficher un message dans la console Java, mais le jeu ne doit pas s’interrompre.
Le traitement d’erreur doit se faire en utilisant des exceptions. Si ce n’est pas le cas, le correcteur pensera que vous ne savez pas utiliser les exceptions.

### 9 Qualités attendues pour votre programme
Il doit être écrit dans le style oriente objet, avec un découpage en classes rationnel. Les méthodes doivent être incluses dans les bonnes classes. Les méthodes ne doivent pas être trop longues.
Les erreurs doivent être gérées avec des exceptions. Les données doivent être bien protégées et les objets garder leur cohérence.
Le programme doit être bien présenté, avec une indentation correcte.
Le programme doit montrer vos capacités à programmer. Pour cela, il faut privilégier les classes et méthodes que vous écrivez vous-même par rapport aux classes et méthodes de la librairie. Vous pouvez utiliser les classes de java.util (par exemple ArrayList) quand même.
Le programme devra être divise en méthodes de taille raisonnable (maximum 30 lignes). Cela vaut aussi pour la méthode « main » qui ne doit pas être trop longue.
