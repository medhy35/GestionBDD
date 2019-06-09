package DAO;

public class Personne {

    private int PersonneId;
    private String Nom;
    private String Prenom;
    private String Sexe;
    private String Naissance;
    private int Deces;

    public Personne(int _personneId,String _prenom,String _nom, String _sexe,String _naissance, int _deces) {
        super();
        PersonneId = _personneId;
        Nom = _nom;
        Prenom=_prenom;
        Sexe = _sexe;
        Naissance = _naissance;
        Deces=_deces;
    }



    public int getPersonneId() {
        return PersonneId;
    }

    public String getNom() {
        return Nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public String getSexe() {
        return Sexe;
    }

    public int getDeces() {
        return Deces;
    }

    public void setPersonneId(int personneId) {
        PersonneId = personneId;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }

    public void setSexe(String sexe) {
        Sexe = sexe;
    }

    public void setDeces(int deces) {
        Deces = deces;
    }

    public String getNaissance() {
        return Naissance;
    }

    public void setNaissance(String naissance) {
        Naissance = naissance;
    }

}
