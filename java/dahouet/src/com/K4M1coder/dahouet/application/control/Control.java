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
import com.K4M1coder.dahouet.application.ui.UiOwnerNew;
import com.K4M1coder.dahouet.application.ui.UiValidated;
import com.K4M1coder.dahouet.application.ui.UiVoilier;

public class Control {

//	 public UiVoilier frameShips;
//	 public UiOwnerNew frameOwners;
//	 public UiValidated frameValidation;
	
	public void initUIVoilier() {
		try {
			UiVoilier frameShips = new UiVoilier();
			frameShips.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void initUIOwner() {
		try {
			UiOwnerNew frameOwners = new UiOwnerNew();
			frameOwners.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void initUIConfirm() {
		try {
			UiValidated frameValidation = new UiValidated();
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
		
		ArrayList<Personne> listPers = new ArrayList<Personne>();
		ArrayList<Personne> listNotOwner = new ArrayList<Personne>();
		listPers = persInit();
		ArrayList<Proprietaire> listOwner = new ArrayList<Proprietaire>();
		listOwner = proprioInit();
		listNotOwner = listPers;
		return listNotOwner;
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

	public void createProprio(Proprietaire proprio, Club club) {

		OwnerDAO.newProprio(proprio, club);
	}

	public void createVoilier(Voilier voilier, Proprietaire proprio) {

		ShipDAO.newVoilier(voilier, proprio);

	}
}
