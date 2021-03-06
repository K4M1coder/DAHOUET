package com.K4M1coder.dahouet.application.control;

import java.util.ArrayList;

import com.K4M1coder.dahouet.application.dao.OwnerDAO;
import com.K4M1coder.dahouet.application.dao.PersDAO;
import com.K4M1coder.dahouet.application.dao.ShipDAO;
import com.K4M1coder.dahouet.application.methodes.model.Classe;
import com.K4M1coder.dahouet.application.methodes.model.Club;
import com.K4M1coder.dahouet.application.methodes.model.Personne;
import com.K4M1coder.dahouet.application.methodes.model.Proprietaire;
import com.K4M1coder.dahouet.application.methodes.model.Serie;
import com.K4M1coder.dahouet.application.methodes.model.Voilier;
import com.K4M1coder.dahouet.application.ui.UiOwner;
import com.K4M1coder.dahouet.application.ui.UiValidated;
import com.K4M1coder.dahouet.application.ui.UiVoilier;


public class Control {
	
	private UiVoilier frameShips;
	private UiOwner frameOwners;
	private UiValidated frameValidation;
	
	public static String ctMail(String email) {
		String result = "mail conforme";
		if (email.matches("^[a-zA-Z0-9._-]{2,}+@[a-zA-Z0-9._-]{2,}\\.[a-z]{2,4}$"));
		else
		{ result="Adresse mail invalide"; }
		return result;
	}

	public void initUIVoilier() {
		try {
			frameShips = new UiVoilier();
			frameShips.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void initUIOwner() {
		try {
			frameOwners = new UiOwner();
			frameOwners.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void initUIConfirm() {
		try {
			frameValidation = new UiValidated();
			frameValidation.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Proprietaire> proprioInit() {
		ArrayList<Proprietaire> listOwner = new ArrayList<Proprietaire>();
		listOwner = OwnerDAO.getProprio();
		return listOwner;
	}
	
	public ArrayList<Personne> persInit(){
		
		ArrayList<Personne> listPers = new ArrayList<Personne>();
		listPers = PersDAO.getPers();
		return listPers;
	}
	
	public ArrayList<Personne> listPersNotOwner() {
		
		ArrayList<Personne> listPers = persInit();
		ArrayList<Proprietaire> listOwner = proprioInit();
		
		for (int j=listPers.size()-1;j>=0;j=j-1){
			Personne pers = listPers.get(j);
					for (int i=listOwner.size()-1;i>=0;i=i-1){
						Proprietaire owner = listOwner.get(i);
						if (pers.getIdPersonne()==owner.getIdPersonne()){
							listPers.remove(pers);
							i=-1;
						}
			}
		}

		return listPers;
	} 
	
	public ArrayList<Voilier> voilierInit() {
		ArrayList<Voilier> listVoiliers = new ArrayList<Voilier>();
		listVoiliers = ShipDAO.getVoiliers();
		return listVoiliers;
	}


	public ArrayList<Serie> serieInit() {
		ArrayList<Serie> listSerie = new ArrayList<Serie>();
		listSerie = ShipDAO.getSerie();
		return listSerie;
	}

	public ArrayList<Classe> classeInit() {
		ArrayList<Classe> listClasse = new ArrayList<Classe>();
		listClasse = ShipDAO.getClasse();
		return listClasse;
	}

	public ArrayList<Club> clubInit() {
		ArrayList<Club> listClub = new ArrayList<Club>();
		listClub = OwnerDAO.getClub();
		return listClub;
	}

	public void createProprio(Proprietaire proprio, Club club, int createMode) {

		
		OwnerDAO.newProprio(proprio, club, createMode);

	}

	public void createVoilier(Voilier voilier, Proprietaire proprio) {

		ShipDAO.newVoilier(voilier, proprio);

	}
}
