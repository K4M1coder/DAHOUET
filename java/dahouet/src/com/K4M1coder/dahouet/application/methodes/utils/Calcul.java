package com.K4M1coder.dahouet.application.methodes.utils;

import java.util.Date;

import org.joda.time.Period;

import com.K4M1coder.dahouet.application.methodes.model.Licencie;

public class Calcul {

	// Calcule de l'àge en utilisant le Framework JodaTime
	public static int calculAge(Date dn) {
		Date currentDate = new Date();
		if (dn.before(currentDate)) {

			Period age = new Period(dn.getTime(),
					currentDate.getTime());
			return age.getYears();
		} else {
			return 0;
		}
	}

	// Calcul des points suivant le cahier des charges
	public static String calculPoints(double pts, int currentAnnee,
			Licencie calcul) {

		String result = null;
		int yearLicence = (currentAnnee - calcul.getDateLicence());
		if (yearLicence == 0) {
			double FFV = calcul.getPtsFFV();
			double r = new Double(FFV + pts);
			result = String.valueOf(r);
		} else
			result = "Problème Licence, MAJ impossible";

		return result;

	}
}
