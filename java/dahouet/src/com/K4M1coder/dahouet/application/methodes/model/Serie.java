package com.K4M1coder.dahouet.application.methodes.model;

public class Serie {

	protected String nomSerie;

	/**
	 * @param nomSerie
	 */
	public Serie(String nomSerie) {
		super();
		this.nomSerie = nomSerie;
	}

	public String getNomSerie() {
		return nomSerie;
	}

	public void setNomSerie(String nomSerie) {
		this.nomSerie = nomSerie;
	}

	@Override
	public String toString() {
		return nomSerie;
	}

}
