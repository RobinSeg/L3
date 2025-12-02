package streamsa.model;

import java.util.*;

import Musique.Morceau;
import Utilisateur.Auditeur;

public class Playlist {
    private String titre;
    private String description;
    private Auditeur proprietaire;
    private boolean publique;
    private List<Morceau> morceaux;

    public Playlist(String titre, String description, Auditeur proprietaire, boolean publique) {
        this.titre = titre;
        this.description = description;
        this.proprietaire = proprietaire;
        this.publique = publique;
        this.morceaux = new ArrayList<>();
    }

    public void ajouterMorceau(Morceau m) {
        morceaux.add(m);
    }

    public double getDureeTotale() {
        double total = 0;
        for (Morceau m : morceaux) total += m.getDuree();
        return total;
    }

    public List<Morceau> getMorceaux() {
        return morceaux;
    }
}
