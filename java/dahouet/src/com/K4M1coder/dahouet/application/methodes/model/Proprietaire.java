package com.K4M1coder.dahouet.application.methodes.model;

public class Proprietaire extends Personne {

	// D�claration des variables
	protected String telephone;
	protected String adresse;

	// mise en place du constructeur
	public Proprietaire(int idPersonne, String nom, String mail, String prenom,
			String string, String adresse) {
		super(idPersonne, nom, mail, prenom);
		this.telephone = string;
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
	public String affiche() {
		return "Proprietaire " + nom + " " + prenom + " :\n\n-telephone = "
				+ telephone + "\n-adresse=" + adresse + "\n-mail=" + mail;
	}

	@Override
	public String toString() {
		return prenom + " " + nom;
	}

}