package com.K4M1coder.dahouet.application.methodes.model;

public class Classe {

	protected String nomClasse;
	protected String serieClasse;

	public Classe(String serieClasse, String nomClasse) {
		this.serieClasse = serieClasse;
		this.nomClasse = nomClasse;

	}

	public String getNomClasse() {
		return nomClasse;
	}

	public void setNomClasse(String nomClasse) {
		this.nomClasse = nomClasse;
	}

	public String getSerieClasse() {
		return serieClasse;
	}

	public void setSerieClasse(String serieClasse) {
		this.serieClasse = serieClasse;
	}

	@Override
	public String toString() {
		return serieClasse + " : " + nomClasse;
	}
}