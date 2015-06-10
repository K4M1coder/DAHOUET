package com.K4M1coder.dahouet.application.methodes.model;

public class Voilier {

	protected int idvoilier;
	protected int owner;
	protected double coef;
	protected String classe;
	protected String name;
	protected int num;

	/**
	 * @param idvoilier
	 * @param owner
	 * @param coef
	 * @param classe
	 * @param name
	 * @param num
	 */
	public Voilier(int idvoilier, int owner, double coef, String classe, String name, int num) {
		super();
		this.idvoilier = idvoilier;
		this.owner = owner;
		this.coef = coef;
		this.classe = classe;
		this.name = name;
		this.num = num;
	}

	public void setIdvoilier(int idvoilier) {
		this.idvoilier = idvoilier;
	}

	public int getIdvoilier() {
		return idvoilier;
	}

	public int getOwner() {
		return owner;
	}

	public void setOwner(int owner) {
		this.owner = owner;
	}

	public double getCoef() {
		return coef;
	}

	public void setCoef(double coef) {
		this.coef = coef;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	@Override
	public String toString() {
		return  idvoilier+" : "+ name + ", classe " + classe + ", voile N°" + num;
	}

	
}
