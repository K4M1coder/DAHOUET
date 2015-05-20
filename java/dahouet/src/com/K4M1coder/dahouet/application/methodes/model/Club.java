package com.K4M1coder.dahouet.application.methodes.model;

public class Club {

	protected int idClub;
	protected String nomClub;

	public Club(int idClub, String nomClub) {
		super();
		this.idClub = idClub;
		this.nomClub = nomClub;
	}

	public int getIdClub() {
		return idClub;
	}

	public void setIdClub(int idClub) {
		this.idClub = idClub;
	}

	public String getNomClub() {
		return nomClub;
	}

	public void setNomClub(String nomClub) {
		this.nomClub = nomClub;
	}

	@Override
	public String toString() {
		return idClub + " : " + nomClub;
	}
}