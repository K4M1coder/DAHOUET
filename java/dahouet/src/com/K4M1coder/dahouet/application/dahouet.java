package com.K4M1coder.dahouet.application;

public class dahouet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				
		boolean run = false;
		int mainAct;
		do {
			mainAct = mainAction();
			switch (mainAct) {
			case 1:
				
				run = true;
				break;
			case 2:
				
				run = true;
				break;
			case 3:
				
				run = true;
				break;
			case 4:
				
				run = true;
				break;
			case 5:
				
				run = true;
				break;
			case 6:
				
				run = true;
				break;
			case 7:
				run = false;
				break;
			case 8:
				
				run = true;
				break;
			}
		} while (run == true);
		System.exit(0);
	}

	

/**
 * menu principal
 * 
 * @return renvoi un entier corespondant à la selection choisie
 *
 *         1 : creation villes & capitales. 2 : liste de toutes les villes
 *         et capitales. 3 : liste des villes et capitales d'un pays. 4 :
 *         liste des pays. 5 : sauvegarde liste villes 6 : restauration
 *         liste villes 7 : fin du programme.
 */
public static int mainAction() {
	int chx;
	do {
		String prop = "\n1- Création de villes et capitales\n"
				+ "2- Liste des villes et capitales des pays\n"
				+ "3- Liste des villes et capitales d'un pays\n"
				+ "4- Liste des pays\n" + "5- sauvegarde liste\n"
				+ "6- restaure liste\n" + "7- FIN\n";
		ui.Console.console(prop);
		chx = Lire.i();
	} while (!Test.intchx(chx, 1, 8)); // je boucle tant que c'est faux
	return chx;
}

/**
 * je test si l'entier est dans des parametres aceptables
 * 
 * @param chx
 *            : est l'entier a tester
 * @param min
 *            : est la valeure minimale
 * @param max
 *            : est la valeure maximale
 * @return : revois vrai ou faux
 */
public static boolean intchx(int chx, int min, int max) {
	if ((chx < min) || (chx > max)){
		Affichage.console("choix invalide\n");
	}
	return ((chx >= min) && (chx <= max));
}

}


