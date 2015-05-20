package com.K4M1coder.dahouet.application.methodes.model;

public class Commissaire extends Personne {

	// Déclaration des variables
	private String comite;

	// Mise en place du constructeur
	public Commissaire(int idPersonne, String nom, String mail, String prenom,
			String comite) {
		super(idPersonne, nom, mail, prenom);
		this.comite = comite;
	}

	// Mise en place getters/setters
	public String getComite() {
		return comite;
	}

	public void setComite(String comite) {
		this.comite = comite;
	}

	// mise en place String to String pour retour affichage
	@Override
	public String toString() {
		return "Commissaire " + nom + " " + prenom + " :\ncomite = " + comite
				+ "\nmail = " + mail;
	}

}
