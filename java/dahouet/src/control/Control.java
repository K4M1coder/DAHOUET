package control;

import java.util.ArrayList;

import com.K4M1coder.dahouet.application.dao.proprioDAO;
import com.K4M1coder.dahouet.application.dao.voilierDAO;
import com.K4M1coder.dahouet.application.methodes.model.Classe;
import com.K4M1coder.dahouet.application.methodes.model.Club;
import com.K4M1coder.dahouet.application.methodes.model.Proprietaire;
import com.K4M1coder.dahouet.application.methodes.model.Serie;
import com.K4M1coder.dahouet.application.methodes.model.Voilier;
import com.K4M1coder.dahouet.application.ui.UiConfirmation;
import com.K4M1coder.dahouet.application.ui.UiOwnerNew;
import com.K4M1coder.dahouet.application.ui.UiVoilierNew;
import com.K4M1coder.dahouet.application.ui.UiVoilierList;

public class Control {

	public void initVoilierList() {
		try {
			UiVoilierList frame1 = new UiVoilierList();
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
			UiConfirmation frame4 = new UiConfirmation();
			frame4.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Proprietaire> proprioInit() {
		ArrayList<Proprietaire> listOwner = new ArrayList<Proprietaire>();
		listOwner = proprioDAO.getProprio();
		return listOwner;
	}

	public ArrayList<Serie> serieInit() {
		ArrayList<Serie> listSerie = new ArrayList<Serie>();
		listSerie = voilierDAO.getSerie();
		return listSerie;
	}

	public ArrayList<Classe> classeInit(Serie serie) {
		ArrayList<Classe> listClasse = new ArrayList<Classe>();
		listClasse = voilierDAO.getClasse(serie);
		return listClasse;
	}

	public ArrayList<Club> clubInit() {
		ArrayList<Club> listClub = new ArrayList<Club>();
		listClub = proprioDAO.getClub();
		return listClub;
	}

	public void createProprio(Proprietaire proprio, Club club) {

		proprioDAO.newProprio(proprio, club);
	}

	public void createVoilier(Voilier voilier, Classe classe,
			Proprietaire proprio) {

		voilierDAO.newVoilier(voilier, classe, proprio);

	}
}
