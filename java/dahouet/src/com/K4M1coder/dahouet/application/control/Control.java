package com.K4M1coder.dahouet.application.control;

import java.util.ArrayList;

import com.K4M1coder.dahouet.application.dao.OwnerDAO;
import com.K4M1coder.dahouet.application.dao.ShipDAO;
import com.K4M1coder.dahouet.application.methodes.model.Classe;
import com.K4M1coder.dahouet.application.methodes.model.Club;
import com.K4M1coder.dahouet.application.methodes.model.Proprietaire;
import com.K4M1coder.dahouet.application.methodes.model.Serie;
import com.K4M1coder.dahouet.application.methodes.model.Voilier;
import com.K4M1coder.dahouet.application.ui.UiValidated;
import com.K4M1coder.dahouet.application.ui.UiOwnerNew;
import com.K4M1coder.dahouet.application.ui.UiVoilierNew;
import com.K4M1coder.dahouet.application.ui.UiVoilier;

public class Control {

	public void initVoilierList() {
		try {
			UiVoilier frame1 = new UiVoilier();
			frame1.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void initVoilierNew() {
		try {
			UiVoilierNew frame2 = new UiVoilierNew();
			frame2.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void initOwnerNew() {
		try {
			UiOwnerNew frame3 = new UiOwnerNew();
			frame3.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void initConfirm() {
		try {
			UiValidated frame4 = new UiValidated();
			frame4.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Proprietaire> proprioInit() {
		ArrayList<Proprietaire> listOwner = new ArrayList<Proprietaire>();
		listOwner = OwnerDAO.getProprio();
		return listOwner;
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

	public void createVoilier(Voilier voilier, Classe classe,
			Proprietaire proprio) {

		ShipDAO.newVoilier(voilier, classe, proprio);

	}
}
