package com.K4M1coder.dahouet.application.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import com.K4M1coder.dahouet.application.methodes.model.Personne;

public class PersDAO {
	
	private static Connection c;
	
	public static ArrayList<Personne> getPers(){
		
		c = connectDAO.cConnect();

		ArrayList<Personne> persList = new ArrayList<Personne>();
		
		Statement stm;
		
		try{
			stm = c.createStatement();
			String sql="select* from Personne";
			ResultSet rs_persList = stm.executeQuery(sql);
			while (rs_persList.next()){
			int idPersonne = rs_persList.getInt("ID_PERS");
			String nom = new String (rs_persList.getString("NOM"));
			String prenom = new String (rs_persList.getString("PRENOM"));
			String addresse = new String (rs_persList.getString("ADDRESSE"));
			Long telephone = rs_persList.getLong("TELEPHONE");
			Date dateN = rs_persList.getDate("DATE_N");
			String mail = new String(rs_persList.getString("MAIL"));
			Personne pers = new Personne(idPersonne, nom, prenom, addresse, telephone, dateN, mail);
			persList.add(pers);
			}
			rs_persList.close();
			stm.close();
			c.close();
		} catch (SQLException e){
			e.printStackTrace();
		}
		return persList;		
	}
}
