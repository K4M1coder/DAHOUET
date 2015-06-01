package com.K4M1coder.dahouet.application.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.K4M1coder.dahouet.application.methodes.model.Club;
import com.K4M1coder.dahouet.application.methodes.model.Proprietaire;

public class OwnerDAO {
	private static Connection c;

	public static ArrayList<Proprietaire> getProprio() {

		c = connectDAO.cConnect();

		ArrayList<Proprietaire> proprioList = new ArrayList<>();
		// test avec select
		Statement stm;

		try {
			stm = c.createStatement();
			String sql = "select * from personne inner join proprietaire on personne.ID_PERS=proprietaire.ID_PERS";
			ResultSet rs_owner = stm.executeQuery(sql);
			while (rs_owner.next()) {
				int id = rs_owner.getInt("ID_PERS");
				String nom = new String(rs_owner.getString("NOM"));
				String prenom = new String(rs_owner.getString("PRENOM"));
				String mail = new String(rs_owner.getString("MAIL"));
				String tel = rs_owner.getString("TELEPHONE");
				String adresse = rs_owner.getString("ADDRESSE");
				Proprietaire proprio = new Proprietaire(id, nom, mail, prenom,
						tel, adresse);

				proprioList.add(proprio);
			}
			rs_owner.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return proprioList;

	}

	public static ArrayList<Club> getClub() {

		c = connectDAO.cConnect();

		ArrayList<Club> clubList = new ArrayList<>();
		// test avec select
		Statement stm;

		try {
			stm = c.createStatement();

			String sql = "select * from club";
			ResultSet rs = stm.executeQuery(sql);

			while (rs.next()) {

				int id = rs.getInt("NUM_CLUB");
				String nom = new String(rs.getString("NOM_CLUB"));
				Club club = new Club(id, nom);
				clubList.add(club);
			}
			rs.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return clubList;

	}

	public static void newProprio(Proprietaire proprio, Club club) {

		Connection c = connectDAO.cConnect();
		int numProprio = 0;
		PreparedStatement stm;
		try {
			stm = c.prepareStatement(
					"insert into personne(NOM_PERSONNE,PRENOM_PERS,MAIL) VALUES(?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			stm.setString(1, proprio.getNom());
			stm.setString(2, proprio.getPrenom());
			stm.setString(3, proprio.getMail());
			stm.executeUpdate();

			ResultSet rs = stm.getGeneratedKeys();
			rs.next();
			numProprio = rs.getInt(1);
			stm = c.prepareStatement("insert into proprietaire(NUM_PROPR,NUM_CLUB,ADRESSE_PROPR,TEL_PROPR) VALUES(?,?,?,?)");
			stm.setInt(1, numProprio);
			stm.setInt(2, club.getIdClub());
			stm.setString(3, proprio.getAdresse());
			stm.setString(4, proprio.getTelephone());
			stm.executeUpdate();

			stm.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}

	}

	public static int getNumProprio(Proprietaire proprio) {
		c = connectDAO.cConnect();
		String nomProprio = proprio.getNom();
		int numproprio = 0;
		Statement stm;

		try {
			stm = c.createStatement();

			String sql = "select ID_PERSONNE from personne where NOM_PERSONNE ='"
					+ nomProprio + "'";
			ResultSet rs = stm.executeQuery(sql);
			rs.next();
			numproprio = rs.getInt("ID_PERSONNE");

			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return numproprio;
	}
}