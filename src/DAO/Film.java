package DAO;

public class Film {
    private int FilmId;
    private String Titre;
    private String Pays;
    private int  Annee;
    private int Duree;

    public Film(int _idfilm,String _titre, String _pays, int _annee,int _duree){
        FilmId=_idfilm;
        Titre= _titre;
        Pays=_pays;
        Annee=_annee;
        Duree=_duree;
    }

    public int getFilmId() {
        return FilmId;
    }

    public void setFilmId(int filmId) {
        FilmId = filmId;
    }

    public String getTitre() {
        return Titre;
    }

    public void setTitre(String titre) {
        Titre = titre;
    }

    public String getPays() {
        return Pays;
    }

    public void setPays(String pays) {
        Pays = pays;
    }

    public int getAnnee() {
        return Annee;
    }

    public void setAnnee(int annee) {
        Annee = annee;
    }

    public int getDuree() {
        return Duree;
    }

    public void setDuree(int duree) {
        Duree = duree;
    }

}
