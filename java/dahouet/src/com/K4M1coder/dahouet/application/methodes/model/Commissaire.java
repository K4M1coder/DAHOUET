package com.K4M1coder.dahouet.application.methodes.model;

import java.util.Date;

public class Commissaire extends Personne {

	protected int idCommissaire;
	protected int idPersonne;
	protected String comite;

	/**
	 * @param idPersonne
	 * @param nom
	 * @param prenom
	 * @param addresse
	 * @param telephone
	 * @param dateN
	 * @param mail
	 * @param idCommissaire
	 * @param idPersonne2
	 * @param comite
	 */
	public Commissaire(int idPersonne, String nom, String prenom, String addresse, long telephone, Date dateN,
			String mail, int idCommissaire, int idPersonne2, String comite) {
		super(idPersonne, nom, prenom, addresse, telephone, dateN, mail);
		this.idCommissaire = idCommissaire;
		idPersonne = idPersonne2;
		this.comite = comite;
	}

	public int getIdCommissaire() {
		return idCommissaire;
	}

	public void setIdCommissaire(int idCommissaire) {
		this.idCommissaire = idCommissaire;
	}

	public int getIdPersonne() {
		return idPersonne;
	}

	public void setIdPersonne(int idPersonne) {
		this.idPersonne = idPersonne;
	}

	public String getComite() {
		return comite;
	}

	public void setComite(String comite) {
		this.comite = comite;
	}

	// mise en place String to String pour retour affichage
	@Override
	public String toString() {
		return "Commissaire " + nom + " " + prenom + " :\ncomite = " + comite + "\nmail = " + mail;
	}

}
