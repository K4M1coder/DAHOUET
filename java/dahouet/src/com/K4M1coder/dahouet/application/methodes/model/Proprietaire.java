package com.K4M1coder.dahouet.application.methodes.model;

import java.util.Date;

public class Proprietaire extends Personne {

	// Déclaration des variables
	protected int idProprio;
	protected int idClub;
	protected int idPers;

	// mise en place du constructeur
	/**
	 * @param idPersonne
	 * @param nom
	 * @param prenom
	 * @param addresse
	 * @param telephone
	 * @param dateN
	 * @param mail
	 * @param idProprio
	 * @param idClub
	 * @param idPers
	 */
	public Proprietaire(int idPersonne, String nom, String prenom, String addresse, long telephone, Date dateN,
			String mail, int idProprio, int idClub, int idPers) {
		super(idPersonne, nom, prenom, addresse, telephone, dateN, mail);
		this.idProprio = idProprio;
		this.idClub = idClub;
		this.idPers = idPers;
	}




	// Mise en place des getters/setters


	public int getIdProprio() {
		return idProprio;
	}




	public void setIdProprio(int idProprio) {
		this.idProprio = idProprio;
	}




	public int getIdClub() {
		return idClub;
	}




	public void setIdClub(int idClub) {
		this.idClub = idClub;
	}




	public int getIdPers() {
		return idPers;
	}




	public void setIdPers(int idPers) {
		this.idPers = idPers;
	}




	// mise en place String to String pour retour affichage
	public String affiche() {
		return "Proprietaire " + nom + " " + prenom + " :\n\n-telephone = "
				+ telephone + "\n-adresse=" + addresse + "\n-mail=" + mail;
	}

	@Override
	public String toString() {
		return prenom + " " + nom;
	}

}