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
		requete = "TITRE what if OU bad boy II "
				+ "DE netflix OU universal "
				+ "AVEC will smith OU tonton bob "
				+ "PAYS us OU fr "
				+ "EN 2019 OU 2010 "
				+ "AVANT 2020 OU 2011 "
				+ "APRES 2018 OU 2009";
		
	     String test = cutrequete(requete);
	   ResultSet test2 = state.executeQuery("SELECT * FROM films where annee_sortie=1980;");
	   //ResultSet test3 = state.executeQuery("SELECT * FROM"+test+";");
	   

		while(test2.next()) {

			//System.out.println("Films :" + test2.getString("titre"));
		}
	   
	
		//System.out.println(test);

		
		return test.toString();
		
	}
	
	
	


	private String cutrequete(String requete) {
		// TODO Auto-generated method stub
		
		Prefab_request data = new Prefab_request();
		
		
		//String titre, de,avec,pays,avant,apres;
		data.titre = (requete.split("DE")[0]).split("TITRE")[1].replace("OU","OR");
		data.de = (requete.split("AVEC")[0]).split("DE")[1].replace("OU","OR");
		data.avec = (requete.split("PAYS")[0]).split("AVEC")[1].replace("OU","OR");
		data.pays= (requete.split("PAYS")[1]).split("EN")[0].replace("OU","OR");
		data.avant= (requete.split("AVANT")[1]).split("APRES")[0].replace("OU","OR");
		data.apres= (requete.split("APRES")[1]);
		//System.out.println(data.titre);
		String request = generatedRequest(data);
	return request;
		//String str2 = "{titre:"+titre+",DE:"+de+",avec:"+avec+",PAYS:"+pays+",avant:"+avant+"apres:"+apres+"}";

	}


	private String generatedRequest(Prefab_request data) {
		// TODO Auto-generated method stub

		
		StringBuilder query=new StringBuilder();

		query.append("SELECT * FROM generique");

		if ((data.titre!="") || (data.pays!="") || (data.avant !="") ||(data.apres !="")) {
			query.append(" , films");
			if ((data.de!="") || (data.avec!="")){
				query.append(" , personnes ");
			}
			query.append("WHERE");
			if(data.titre ==" ") { /* Titre non renseigner*/} else { String condTitre = data.titre.toString();query.append(" films.titre='"+condTitre+"'"); }// OR a gerer
			if(data.pays =="") { /* pays non renseigner*/} else { String condPays =  data.pays.toString();query.append(" films.pays='"+condPays+"'"); }
			if(data.avant ==" ") { /* avant non renseigner*/} else {String condAvant = data.avant.toString();query.append("films.annee_sortie<'"+condAvant+"'");} // il faut decouper au niveau du OU
			if(data.apres ==" ") { /* apres non renseigner*/}else {String condapres = data.apres.toString();query.append("films.annee_sortie>'"+condapres+"'");} // il faut decouper au niveau du OU
			if(data.de =="") { /* apres non renseigner*/}else {String condDe = data.de.toString();query.append(" personne.prenom='"+condDe+"'");} /// il faut bien decouper ici
			if(data.avec =="") { /* apres non renseigner*/}else {String condAvec = data.avec.toString();query.append("personne.prenom='"+condAvec+"'");} // Meme decoupage que celui en haut

			System.out.println(query.toString());

		} else {

		System.out.println("La requete est incorrecte");
		}

		
		
		
		
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
