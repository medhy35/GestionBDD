package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.StringTokenizer;

import Database.Connexion;


public class RechercheFilm {
	
	private String DBPath="chemin";
	private Connection connexion = null;
	private Statement state =null;
	
	
	public RechercheFilm(String nomFicherSQLite) {
		// la constructeur ouvre la base
		DBPath = nomFicherSQLite;
		try {
			Class.forName("org.sqlite.JDBC");
			connexion = DriverManager.getConnection("jdbc:sqlite:"+DBPath);
			state = connexion.createStatement();
			System.out.println("Connexion a "+ DBPath+" avec succès");		
		} 
		catch(ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Erreur la librairie JDBC sqlite est manquante");
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Erreur de connexion à la base de donnée");
		}
	}
	
	
	public void fermeBase() {
		//Pour sortir proprement
		try {
			connexion.close();
			state.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	
	
	
	
	public String retrouve(String requete) throws SQLException {
		requete = "TITRE what if ou bad boy II "
				+ "DE netflix OU universal "
				+ "AVEC will smith OU tonton bob "
				+ "PAYS us OU fr "
				+ "EN 2019 OU 2010 "
				+ "AVANT 2020 OU 2011 "
				+ "APRES 2018 OU 2009";
		
	     String test = cutrequete(requete);
	   ResultSet test2 = state.executeQuery("SELECT * FROM generique;");
	   //ResultSet test3 = state.executeQuery("SELECT * FROM"+test+";");
	   
	   
	   
	
	   
		   
           System.out.println("Films :"+ test2.getString("id_personne"));
        

	   
	   
	   
	
		//System.out.println(test);

		
		return test.toString();
		
	}
	
	
	


	private String cutrequete(String requete) {
		// TODO Auto-generated method stub
		
		Prefab_request data = new Prefab_request();
		
		
		//String titre, de,avec,pays,avant,apres;
		data.titre = (requete.split("DE")[0]).replace("TITRE", "");
		data.de = (requete.split("AVEC")[0]).replace(data.titre.toString(), "");
		data.avec = (requete.split("Pays")[0]).replace(data.de.toString(), "");
		data.pays= (requete.split("EN")[0]).replace(data.avec.toString(), "");
		data.avant= (requete.split("APRES")[0]).replace(data.pays.toString(), "");
		data.apres= (requete.split("APRES")[1]);
		
		String request = generatedRequest(data);
	return request;
		//String str2 = "{titre:"+titre+",DE:"+de+",avec:"+avec+",PAYS:"+pays+",avant:"+avant+"apres:"+apres+"}";

	}


	private String generatedRequest(Prefab_request data) {
		// TODO Auto-generated method stub
		
		StringBuilder query=new StringBuilder();
		
		
		
		
		return query.toString();
	}


	public ResultSet query(String requete) {
		ResultSet resultat = null;	
		try {
			resultat = state.executeQuery(requete);
		} catch(SQLException e) {
			e.printStackTrace();
			System.out.println("Erreur dans la requete : "+ requete);		
		}
		
		
		return resultat;
		
	}
	
	public class Prefab_request {

		public String apres;
		public Object avant;
		public Object pays;
		public Object avec;
		public Object de;
		public String titre;
		
	}
	
	

	
	

}
