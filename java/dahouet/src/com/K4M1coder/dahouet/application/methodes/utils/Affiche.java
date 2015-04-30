package com.K4M1coder.dahouet.application.methodes.utils;

import com.K4M1coder.dahouet.application.methodes.model.Commissaire;
import com.K4M1coder.dahouet.application.methodes.model.Licencie;
import com.K4M1coder.dahouet.application.methodes.model.Personne;
import com.K4M1coder.dahouet.application.methodes.model.Proprietaire;

public class Affiche {

	public static String afficheLicencie(Licencie lic) {

		return lic.toString();
	}

	public static String afficheProprietaire(Proprietaire prop) {

		return prop.toString();
	}

	public static String afficheCommissaire(Commissaire com) {

		return com.toString();
	}

	public static String affichePersonne(Personne pers) {

		return pers.toString();
	}
}
