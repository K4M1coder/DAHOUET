package com.K4M1coder.dahouet.application.methodes.model;

public class Personne {

	// Déclaration des variables
	protected String nom;
	protected String mail;
	protected String prenom;

	// Mise en place du constructeur
	public Personne(String nom, String mail, String prenom) {
		super();
		this.nom = nom;
		this.mail = mail;
		this.prenom = prenom;
	}

	// Mise en place des getters/setters
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	// mise en place String to String pour retour affichage
	@Override
	public String toString() {
		return "nom = " + nom + "\nmail = " + mail + "\nprenom = " + prenom
				+ "]";
	}

}
