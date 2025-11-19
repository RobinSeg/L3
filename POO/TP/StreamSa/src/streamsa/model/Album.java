package streamsa.model;

import java.util.*;

public class Album {
    private String titre;
    private int annee;
    private String genre;
    private List<Morceau> trackList;
    private List<Artiste> artistes;
    private String type; // studio, live, compilation, EP

    public Album(String titre, int annee, String genre, List<Artiste> artistes, String type) {
        this.titre = titre;
        this.annee = annee;
        this.genre = genre;
        this.artistes = artistes;
        this.type = type;
        this.trackList = new ArrayList<>();
    }

    public void ajouterMorceau(Morceau m) {
        trackList.add(m);
    }

    public List<Morceau> getTrackList() {
        return trackList;
    }

    public int getNbEcoutes() {
        int total = 0;
        for (Morceau m : trackList) total += m.getNbEcoutes();
        return total;
    }
}
