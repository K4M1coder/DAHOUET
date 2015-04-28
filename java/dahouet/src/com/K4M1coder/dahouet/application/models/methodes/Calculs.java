package com.K4M1coder.dahouet.application.models.methodes;

import java.util.Date;

import org.joda.time.Period;

import com.K4M1coder.dahouet.application.models.Licencie;

public class Calculs {

	// Calcule de l'âge en utilisant le Framework JodaTime
	public static int calculAge(Date dateNaissance) {
		Date currentDate = new Date();
		if (dateNaissance.before(currentDate)) {

			Period age = new Period(dateNaissance.getTime(),
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
		int yearLicence = (currentAnnee - calcul.getAnneeLicence());
		if (yearLicence == 0) {
			double FFV = calcul.getPointsFFV();
			double r = new Double(FFV + pts);
			result = String.valueOf(r);
		} else
			result = "Problème Licence, MAJ impossible";

		return result;

	}
}
