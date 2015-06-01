package com.K4M1coder.dahouet.application.methodes.model;

public class Club {

	protected int idClub;
	protected String nomClub;
	protected String adrClub;
	protected int telClub;
	protected int presidentClub;

	public Club(int idClub, String nomClub, String adrClub, int telClub,
			int presidentClub) {
		super();
		this.idClub = idClub;
		this.nomClub = nomClub;
		this.adrClub = adrClub;
		this.telClub = telClub;
		this.presidentClub = presidentClub;
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

	public String getAdrClub() {
		return adrClub;
	}

	public void setAdrClub(String adrClub) {
		this.adrClub = adrClub;
	}

	public int getTelClub() {
		return telClub;
	}

	public void setTelClub(int telClub) {
		this.telClub = telClub;
	}

	public int getPresidentClub() {
		return presidentClub;
	}

	public void setPresidentClub(int presidentClub) {
		this.presidentClub = presidentClub;
	}

	@Override
	public String toString() {
		return idClub + " : " + nomClub;
	}
}