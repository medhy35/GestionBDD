package Database;


import DAO.Film;
import DAO.Personne;

import java.sql.*;

public class Connexion {

    private String DBPath = "Chemin de la DB sqlite";
    private Connection connection = null;
    private Statement statement= null;


    public Connexion(String dbPath) {
        DBPath = dbPath;
    }


    public void connect(){

        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:"+DBPath);
            statement = connection.createStatement();
            System.out.println("Connexion a "+ DBPath+" avec succès");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Erreur de connexion");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Erreur de connexion");
        }
    }

    public void close(){

        try {
            connection.close();
            statement.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet query(String requet){
        ResultSet resultat = null;

        try{
            resultat = statement.executeQuery(requet);

        } catch (SQLException e){
            e.printStackTrace();
            System.out.println("Erreur dans la requete : "+ requet);
        }

        return resultat;
    }


    public void addPersonne(Personne personne){
        String query = " ";
        query += "INSERT INTO personnes VALUES (";
        query += "'"+ personne.getPersonneId()+"', ";
        query += "'"+ personne.getPrenom()+"', ";
        query += "'"+ personne.getNom()+"', ";
        query += "'"+ personne.getSexe()+"', ";
        query += "'"+ personne.getNaissance()+"', ";
        query += "'"+ personne.getDeces()+"' ) ";

        try{
            statement.executeUpdate(query);
            System.out.println("Personne ajouter!!!");
        } catch (SQLException e){
            e.printStackTrace();

        }

    }

    public void addFilm(Film film){
        String query=" ";
        query += "INSERT INTO films VALUES (";
        query += "'"+ film.getFilmId()+"', ";
        query += "'"+ film.getTitre()+"', ";
        query += "'"+ film.getPays()+"', ";
        query += "'"+ film.getAnnee()+"', ";
        query += "'"+ film.getDuree()+"' ) ";
        try {
            statement.executeUpdate(query);
            System.out.println("Film ajuter!!!");
        }catch(SQLException e) {
            e.printStackTrace();
        }

    }





}
