package com.K4M1coder.dahouet.application.methodes.model;

public class Voilier {

	protected String nom;
	protected double coef;

	public Voilier(String nom, double coef) {
		super();
		this.nom = nom;
		this.coef = coef;

	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getCoef() {
		return coef;
	}

	public void setCoef(double coef) {
		this.coef = coef;
	}
}
