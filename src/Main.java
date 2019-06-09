import DAO.Film;
import DAO.Personne;
import Database.Connexion;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;

import static java.lang.Integer.parseInt;

public class Main {

    public static void main(String[] args) throws SQLException {

        System.out.println("Hello World!");

        // recuperer mon path depuis la racine
        String path=new File("").getAbsolutePath();
        String dbpath = path + "\\db\\filmdbfr.sqlite";

           /* if (Paths.get(dbpath).toFile().exists()) {
                System.out.println(dbpath); }
            else {
            System.out.println("fake");}*/

        Connexion connexion = new Connexion(dbpath);
        connexion.connect();
/*

        ResultSet resultSet = connexion.query("SELECT * FROM films");

        try{
            while(resultSet.next()){
                System.out.println("Films :"+ resultSet.getString("titre"));

            }
        } catch (SQLException e){
            e.printStackTrace();
        }

*/


       /* ResultSet lastIndex = connexion.query("SELECT id_personne FROM personnes ORDER BY id_personne DESC LIMIT 1");
        int idPersonne =  Integer.parseInt(lastIndex.getString("id_personne"))+1;

        Personne personne = new Personne(idPersonne,"Medhy35","Tour78e","M","1997",2000);

        connexion.addPersonne(personne);
        System.out.println(idPersonne);*/


        ResultSet lastIndex = connexion.query("SELECT id_film FROM films ORDER BY id_film DESC LIMIT 1");
        int idfilm =  Integer.parseInt(lastIndex.getString("id_film"))+1;

        Film film = new Film(idfilm,"Coup de foudre à Laval","fr",2019,105);
        connexion.addFilm(film);



        connexion.close();

    }
}
