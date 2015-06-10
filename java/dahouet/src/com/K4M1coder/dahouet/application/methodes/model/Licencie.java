package com.K4M1coder.dahouet.application.methodes.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.K4M1coder.dahouet.application.methodes.utils.Calcul;

public class Licencie extends Personne {

	// Déclaration des variables
	private int idMarin;
	private int idPers;
	private long numLicence;
	private int dateLicence;
	private int ptsFFV;

	// Mise en place du constructeur
	/**
	 * @param idPersonne
	 * @param nom
	 * @param prenom
	 * @param addresse
	 * @param telephone
	 * @param dateN
	 * @param mail
	 * @param idMarin
	 * @param idPers
	 * @param numLicence
	 * @param dateLicence
	 * @param ptsFFV
	 */
	public Licencie(int idPersonne, String nom, String prenom, String addresse, long telephone, Date dateN,
			String mail, int idMarin, int idPers, long numLicence, int dateLicence, int ptsFFV) {
		super(idPersonne, nom, prenom, addresse, telephone, dateN, mail);
		this.idMarin = idMarin;
		this.idPers = idPers;
		this.numLicence = numLicence;
		this.dateLicence = dateLicence;
		this.ptsFFV = ptsFFV;
	}

	// Mise en place des getters/setters


	public int getIdMarin() {
		return idMarin;
	}

	public void setIdMarin(int idMarin) {
		this.idMarin = idMarin;
	}

	public int getIdPers() {
		return idPers;
	}

	public void setIdPers(int idPers) {
		this.idPers = idPers;
	}

	public long getNumLicence() {
		return numLicence;
	}

	public void setNumLicence(long numLicence) {
		this.numLicence = numLicence;
	}

	public int getDateLicence() {
		return dateLicence;
	}

	public void setDateLicence(int dateLicence) {
		this.dateLicence = dateLicence;
	}

	public int getPtsFFV() {
		return ptsFFV;
	}

	public void setPtsFFV(int ptsFFV) {
		this.ptsFFV = ptsFFV;
	}

	// mise en place String to String pour retour affichage
	@Override
	public String toString() {
		DateFormat format = new SimpleDateFormat("yyyy/MM/dd");

		return "Licencie " + nom + " " + prenom + ":\nnumeroLicence = "
				+ numLicence + "\npointsFFV = " + ptsFFV
				+ "\ndateNaissance = " + format.format(dateN)
				+ "\nàge = " + Calcul.calculAge(dateN)
				+ "\nanneeLicence = " + dateLicence + "\nmail = " + mail;
	}
}
