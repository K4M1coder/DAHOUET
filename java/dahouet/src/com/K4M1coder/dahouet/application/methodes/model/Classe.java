package com.K4M1coder.dahouet.application.methodes.model;

public class Classe extends Serie {

	protected String nomClasse;
	protected int idClasse;

	public Classe(String nomSerie, int idSerie, String nomClasse, int idClasse) {
		super(nomSerie, idSerie);
		this.nomClasse = nomClasse;
		this.idClasse = idClasse;
	}

	public String getNomClasse() {
		return nomClasse;
	}

	public void setNomClasse(String nomClasse) {
		this.nomClasse = nomClasse;
	}

	public int getIdClasse() {
		return idClasse;
	}

	public void setIdClasse(int idClasse) {
		this.idClasse = idClasse;
	}

	@Override
	public String toString() {
		return idClasse + " : " + nomClasse;
	}

}