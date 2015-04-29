package com.K4M1coder.dahouet.application.ui;

import com.K4M1coder.dahouet.application.methodes.Controls;
import com.K4M1coder.dahouet.application.utils.Lire;

public class Console {

	public static void menu() {

		boolean run = false;
		int mainAct;
		System.out.print("\nconsole de test pour dahouet\n");
		do {
			do {
				System.out.print("\n1- control format adresse mail\n"
						+ "2- calcule de points d'un licencie\n"
						+ "3- calcule age\n" + "4- affiche propietaire\n"
						+ "5- affiche personne\n" + "6- affiche licencie\n"
						+ "7- affiche commissaire\n" + "8- FIN\n");
				mainAct = Lire.i();
			} while (!Controls.intchx(mainAct, 1, 8));
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
				run = true;
				break;
			case 8:

				run = false;
				break;
			}

		} while (run == true);

		System.exit(0);

	}
	
	
}
