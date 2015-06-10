package com.K4M1coder.dahouet.application.methodes.model;

public class Classe {

	protected String nomClasse;
	protected String serieClasse;

	/**
	 * @param serieClasse
	 * @param nomClasse
	 */
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

	public String affiche(){
		return serieClasse + " : " + nomClasse;
	}
	
	@Override

	public String toString() {
		return nomClasse;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((nomClasse == null) ? 0 : nomClasse.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Classe other = (Classe) obj;
		if (nomClasse == null) {
			if (other.nomClasse != null)
				return false;
		} else if (!nomClasse.equals(other.nomClasse))
			return false;
		return true;
	}
	
	
}