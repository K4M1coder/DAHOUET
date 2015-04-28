package com.dahouet.application.doa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectDAO {
	static Connection con = null;

	 public static Connection  cConnect () 
	 {
	      String url = "jdbc:mysql://localhost/gereville";

	      try
	      {
	    	  Class.forName("com.mysql.jdbc.Driver").newInstance();

	        //  On se connecte via la passerelle jdbc Oracle

	        return con = DriverManager.getConnection(url,"gereville_user","acbg4beee");
	      }
	        catch(SQLException sqlE)
	        {
	            System.out.println("Sql Erreur " + sqlE.getMessage());
	            return null;
	        }
	        catch(Exception e)
	        {
	           e.printStackTrace();
	            return null;
	        }
	 }
}
