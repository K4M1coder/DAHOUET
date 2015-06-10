package com.K4M1coder.dahouet.application.methodes.model;

public class Club {

	protected int idClub;
	protected String nomClub;
	protected String adrClub;
	protected long telClub;
	protected int presidentClub;

	/**
	 * @param idClub
	 * @param nomClub
	 * @param adrClub
	 * @param telClub
	 * @param presidentClub
	 */
	public Club(int idClub, String nomClub, String adrClub, long telClub,
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

	public long getTelClub() {
		return telClub;
	}

	public void setTelClub(long telClub) {
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