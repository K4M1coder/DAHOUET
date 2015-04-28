package com.K4M1coder.dahouet.application.models;

public class Commissaire extends Personne {

	// Déclaration variable locale
	private String comite;
	
	// Mise en place du constructeur
	public Commissaire(String nom, String mail, String prenom) {
		super(nom, mail, prenom);

	}
	
	// Mise en place getters/setters
	public String getComite() {
		return comite;
	}

	public void setComite(String comite) {
		this.comite = comite;
	}

	

	// mise en place String to String pour retour affichage
	public String toString() {
		return "Commissaire [comite=" + comite + "]";
	}

}
