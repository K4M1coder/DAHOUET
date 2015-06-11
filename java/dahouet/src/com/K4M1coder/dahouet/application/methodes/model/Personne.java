package com.K4M1coder.dahouet.application.methodes.model;

import java.util.Date;

public class Personne {

	// D�claration des variables
	protected int idPersonne;
	protected String nom;
	protected String prenom;
	protected String addresse;
	protected long telephone;
	protected Date dateN;
	protected String mail;

	// Mise en place du constructeur
	/**
	 * @param idPersonne
	 * @param nom
	 * @param prenom
	 * @param addresse
	 * @param telephone
	 * @param dateN
	 * @param mail
	 */
	public Personne(int idPersonne, String nom, String prenom, String addresse, long telephone, Date dateN, String mail) {
		super();
		this.idPersonne = idPersonne;
		this.nom = nom;
		this.prenom = prenom;
		this.addresse = addresse;
		this.telephone = telephone;
		this.dateN = dateN;
		this.mail = mail;
	}

	// Mise en place des getters/setters

	public int getIdPersonne() {
		return idPersonne;
	}

	public void setIdPersonne(int idPersonne) {
		this.idPersonne = idPersonne;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAddresse() {
		return addresse;
	}

	public void setAddresse(String addresse) {
		this.addresse = addresse;
	}

	public long getTelephone() {
		return telephone;
	}

	public void setTelephone(long telephone) {
		this.telephone = telephone;
	}

	public Date getDateN() {
		return dateN;
	}

	public void setDateN(Date dateN) {
		this.dateN = dateN;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	// mise en place String to String pour retour affichage
	public String affiche(){
		return "nom = " + nom + "\nmail = " + mail + "\nprenom = " + prenom;
	}
	
	@Override
	public String toString() {
		return nom + " " + prenom;
	}

}
