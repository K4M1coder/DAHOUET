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
				String nom = new String(rs.getString("NOM_SERIE"));
				int id = rs.getInt("NUM_SERIE");
				Serie serie = new Serie(nom, id);
				serieList.add(serie);
			}
			rs.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return serieList;

	}

	public static ArrayList<Classe> getClasse(Serie serie) {
		c = connectDAO.cConnect();
		ArrayList<Classe> classeList = new ArrayList<>();
		// test avec select
		Statement stm;

		try {
			stm = c.createStatement();

			String sql = "select * from classe INNER join serie on serie.NUM_SERIE = classe.NUM_SERIE where serie.NUM_SERIE ='"
					+ serie.getIdSerie() + "'";
			ResultSet rs = stm.executeQuery(sql);

			while (rs.next()) {
				String nomclasse = new String(rs.getString("NOM_CLASSE"));
				int idClasse = rs.getInt("NUM_CLASSE");
				Classe classe = new Classe(serie.getNomSerie(),
						serie.getIdSerie(), nomclasse, idClasse);

				classeList.add(classe);
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
			stm.setInt(1, classe.getIdClasse());
			stm.setInt(2, proprio.getIdPersonne());
			stm.setString(3, voilier.getNom());
			stm.setDouble(4, voilier.getCoef());
			stm.executeUpdate();
			stm.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}

	}
}