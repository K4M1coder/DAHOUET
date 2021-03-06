package com.K4M1coder.dahouet.application.ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.K4M1coder.dahouet.application.methodes.model.Commissaire;
import com.K4M1coder.dahouet.application.methodes.model.Licencie;
import com.K4M1coder.dahouet.application.methodes.model.Personne;
import com.K4M1coder.dahouet.application.methodes.model.Proprietaire;
import com.K4M1coder.dahouet.application.methodes.utils.Affiche;
import com.K4M1coder.dahouet.application.methodes.utils.Controls;
import com.K4M1coder.dahouet.application.methodes.utils.Lire;

public class ConsoleMenu {


	public static void menu() {

		boolean run = false;
		int mainAct;
		System.out.print("\nconsole de test pour dahouet\n");
		do {
			do {
				System.out.print("\n1- affiche propietaire\n"
						+ "2- affiche personne\n" + "3- affiche licencie\n"
						+ "4- affiche commissaire\n" + "5- FIN\n");
				mainAct = Lire.i();
			} while (!Controls.intchx(mainAct, 1, 5));
			switch (mainAct) {
			
			case 1:

				Proprietaire prop = null;
//				prop = new Proprietaire(1,"Thedrez", "cedric@thedrez.fr",
//						"Cedric", "0607080901", "29, rue des madières");
				System.out.println(Affiche.afficheProprietaire(prop));
				run = true;
				break;

			case 2:
				
				Personne pers = null;
//				pers = new Personne(1, "Thedrez", "cedric@thedrez.fr", "Cedric");
				System.out.println(Affiche.affichePersonne(pers));
				run = true;
				break;

			case 3:
				
				SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");
				String birthday = "1980/06/24";

				Licencie lic = null;

				try {
					lic = new Licencie(1, "Thedrez", "Cedric", "rue franc", 33601020304L, date.parse(birthday), "Cedric@Thedrez.fr", 1, 1, 1234, 2015, 249);
				} catch (ParseException e) {
					e.printStackTrace();
				}

				System.out.println(Affiche.afficheLicencie(lic));
				try {
					System.out.println("date : "+ date.parse(birthday));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				run = true;
				break;

			case 4:
				SimpleDateFormat date2 = new SimpleDateFormat("yyyy/MM/dd");
				String birthday2 = "1980/06/24";
				
				Commissaire com;
				try {
					com = new Commissaire(1, "Thedrez", "Cedric", "rue AG", 33601020304L, date2.parse(birthday2), "cedric@thedrez.fr", 1, 1, "Geeks Masters");
					System.out.println(Affiche.afficheCommissaire(com));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				run = true;
				break;
				
			case 5:
				
				run = false;
				break;
			}

		} while (run == true);

		System.exit(0);

	}

}
