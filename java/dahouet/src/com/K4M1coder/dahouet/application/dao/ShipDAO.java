package com.K4M1coder.dahouet.application.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.K4M1coder.dahouet.application.methodes.model.Classe;
import com.K4M1coder.dahouet.application.methodes.model.Proprietaire;
import com.K4M1coder.dahouet.application.methodes.model.Serie;
import com.K4M1coder.dahouet.application.methodes.model.Voilier;

public class ShipDAO {
	private static Connection c;

	public static ArrayList<Voilier> getVoiliers() {
		c = connectDAO.cConnect();

		ArrayList<Voilier> voilierList = new ArrayList<>();
		Statement stm;

		try {
			stm = c.createStatement();
			String sql = "select * from voilier";
			ResultSet rs_voilierList = stm.executeQuery(sql);
			while (rs_voilierList.next()) {
				int idVoilier = rs_voilierList.getInt("ID_VOILIER");
				int idPropVoilier = rs_voilierList.getInt("ID_PROPR");
				double coefVoilier = rs_voilierList.getDouble("COEFF");
				String classeVoilier = new String (rs_voilierList.getString("CLASSE"));
				String nomVoilier = new String (rs_voilierList.getString("NOM_VOILIER"));
				int nuVoile = rs_voilierList.getInt("NUM_VOILE");
				Voilier voilier = new Voilier(idVoilier, idPropVoilier, coefVoilier, classeVoilier, nomVoilier, nuVoile);
				voilierList.add(voilier);
			}
			rs_voilierList.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return voilierList;

	}

	public static ArrayList<Serie> getSerie() {

		c = connectDAO.cConnect();

		ArrayList<Serie> serieList = new ArrayList<>();
		// test avec select
		Statement stm;

		try {
			stm = c.createStatement();

			String sql = "select * from serie";
			ResultSet rs = stm.executeQuery(sql);

			while (rs.next()) {
				String nom = new String(rs.getString("SERIE"));
				Serie serie = new Serie(nom);
				serieList.add(serie);
			}
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return serieList;

	}

	public static ArrayList<Classe> getClasse() {
		c = connectDAO.cConnect();
		ArrayList<Classe> classeList = new ArrayList<>();
		// test avec select
		Statement stm;

		try {
			stm = c.createStatement();

			String sql = "select * from classe";
			ResultSet rs = stm.executeQuery(sql);

			while (rs.next()) {
				String nomClasse = new String(rs.getString("CLASSE"));
				String serieClasse = new String(rs.getString("SERIE"));
				Classe classe = new Classe(serieClasse, nomClasse);

				classeList.add(classe);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return classeList;
	}

	public static void newVoilier(Voilier voilier, Classe classe,
			Proprietaire proprio) {

		Connection c = connectDAO.cConnect();

		PreparedStatement stm;
		try {
			stm = c.prepareStatement("insert into voilier(NUM_CLASSE,NUM_PROPR,NOM_VOILE,COEFF) VALUES(?,?,?,?)");
			stm.setString(1, classe.getNomClasse());
			stm.setInt(2, proprio.getIdPersonne());
			stm.setString(3, voilier.getName());
			stm.setDouble(4, voilier.getCoef());
			stm.executeUpdate();
			stm.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}

	}
}