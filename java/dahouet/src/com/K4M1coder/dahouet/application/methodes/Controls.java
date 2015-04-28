package com.K4M1coder.dahouet.application.methodes;

public class Controls {

	public static String ctlMail(String mail) {
		
		String errorMess;
		
		// test avec expression regulière
		if (mail.matches("^[a-zA-Z0-9._-]{2,}+@[a-zA-Z0-9._-]{2,}\\.[a-z]{2,4}$")) {
			errorMess = null;
		}
		else {
			errorMess = "Adresse mail invalide"; 
		}
		
		/*
		// test avec operateurs logiques
		@SuppressWarnings("unused")
		boolean test = true;
		errorMess = null;

		if (mail.contains("@")) {
			test = true;
		}
		else {
			test = false;
			errorMess = "il manque le \"@\"";
			return errorMess;
		}
		if (mail.contains(".")) {
			test = true;
		}
		else {
			test = false;
			errorMess = "il manque un \".\"";
			return errorMess;
		}

		if (((mail.indexOf('@')) > 3)) {
			test = true;
		}
		else {
			test = false;
			errorMess = "il y a moins de 2 caractères avant le \"@\"";
			return errorMess;
		}
		if ((mail.lastIndexOf('.')) - (mail.indexOf('@')) >= 3) {
			test = true;
		}
		else {
			test = false;
			errorMess = "il y a moins de 2 caractères entre le \"@\" et le\".\"";
			return errorMess;
		}
		if (((mail.length()) - (mail.lastIndexOf('.'))) >= 3) {
			test = true;
		}
		else {
			test = false;
			errorMess = "il y a moins de 2 caractères après le dernier \".\"";
			return errorMess;
		}
		*/
		return errorMess;
	}
}
