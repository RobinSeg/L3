package Musique;

import java.util.*;

public class Morceau {
    private int id;
    private String titre;
    private double duree;
    private String genre;
    private int annee;
    private List<Artiste> artistes;
    private int nbEcoutes;
    private String qualite;
    
    public int getId() {
        return id;
    }


    public Morceau(int id, String titre, double duree, String genre, int annee, String qualite, List<Artiste> artistes) {
        this.id = id;
        this.titre = titre;
        this.duree = duree;
        this.genre = genre;
        this.annee = annee;
        this.qualite = qualite;
        this.artistes = artistes;
        this.nbEcoutes = 0;
    }

    public void ajouterEcoute() {
        nbEcoutes++;
        for (Artiste a : artistes) {
            a.ajouterEcoute(1);
        }
    }

    public List<Artiste> getArtistes() { return artistes; }
    public int getNbEcoutes() { return nbEcoutes; }
    public String getTitre() { return titre; }
    
 // ajoute ceci à la fin de Morceau.java
    public double getDuree() {
        return duree;
    }

}

