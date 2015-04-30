package com.K4M1coder.dahouet.application.methodes.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.K4M1coder.dahouet.application.methodes.utils.Calcul;

public class Licencie extends Personne {

	// Déclaration des variables
	private int numeroLicence;
	private double pointsFFV;
	private Date dateNaissance;
	private int anneeLicence;

	// Mise en place du constructeur
	public Licencie(String nom, String mail, String prenom, int numeroLicence,
			double pointsFFV, Date dateNaissance, int anneeLicence) {
		super(nom, mail, prenom);
		this.numeroLicence = numeroLicence;
		this.pointsFFV = pointsFFV;
		this.dateNaissance = dateNaissance;
		this.anneeLicence = anneeLicence;

	}

	// Mise en place des getters/setters
	public int getNumeroLicence() {
		return numeroLicence;
	}

	public void setNumeroLicence(int numeroLicence) {
		this.numeroLicence = numeroLicence;
	}

	public double getPointsFFV() {
		return pointsFFV;
	}

	public void setPointsFFV(double pointsFFV) {
		this.pointsFFV = pointsFFV;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public int getAnneeLicence() {
		return anneeLicence;
	}

	public void setAnneeLicence(int anneeLicence) {
		this.anneeLicence = anneeLicence;
	}

	// mise en place String to String pour retour affichage
	@Override
	public String toString() {
		DateFormat format = new SimpleDateFormat("yyyy/MM/dd");

		return "Licencie " + nom + " " + prenom + ":\nnumeroLicence = "
				+ numeroLicence + "\npointsFFV = " + pointsFFV
				+ "\ndateNaissance = " + format.format(dateNaissance)
				+ "\nâge = " + Calcul.calculAge(dateNaissance)
				+ "\nanneeLicence = " + anneeLicence + "\nmail = " + mail;
	}
}
