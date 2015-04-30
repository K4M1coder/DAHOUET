package com.K4M1coder.dahouet.application.methodes.model;

public class Proprietaire extends Personne {

	// Déclaration des variables
	private String telephone;
	private String adresse;

	// mise en place du constructeur
	public Proprietaire(String nom, String mail, String prenom,
			String telephone, String adresse) {
		super(nom, mail, prenom);
		this.telephone = telephone;
		this.adresse = adresse;
	}

	// Mise en place des getters/setters
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	// mise en place String to String pour retour affichage
	@Override
	public String toString() {
		return "Proprietaire " + nom + " " + prenom + " :\ntelephone = "
				+ telephone + "\nadresse = " + adresse + "\nmail = " + mail;
	}

}
