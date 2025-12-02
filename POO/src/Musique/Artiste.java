package Musique;

import java.util.*;

import Utilisateur.Utilisateur;

public class Artiste extends Utilisateur {
    private String genre;
    private int followers;
    private int totalEcoutes;
    private double royaltiesCarriere;
    private String statut; // emergent, confirme, vedette
    private List<Artiste> collaborations;

    public Artiste(int id, String nom, String prenom, String email, String genre) {
        super(id, nom, prenom, email);
        this.genre = genre;
        this.followers = 0;
        this.totalEcoutes = 0;
        this.royaltiesCarriere = 0.0;
        this.statut = "emergent";
        this.collaborations = new ArrayList<>();
    }

    public void publierMorceau(Morceau m) {
        m.getArtistes().add(this);
    }

    public void collaborer(Artiste autre) {
        if ("vedette".equals(this.statut) && "vedette".equals(autre.statut)) {
            collaborations.add(autre);
        } else {
            System.out.println("Collaboration impossible : statut non vedette.");
        }
    }

    public void ajouterEcoute(int nb) {
        totalEcoutes += nb;
        miseAJourStatut();
    }

    private void miseAJourStatut() {
        // logique des seuils cachés
        if (totalEcoutes > 1000) statut = "confirme";
        if (totalEcoutes > 5000) statut = "vedette";
    }

    public void ajouterRoyalties(double montant) {
        royaltiesCarriere += montant;
    }

    public String getStatut() { return statut; }

    public double getRoyaltiesCarriere() { return royaltiesCarriere; }

    public void afficherInfo() {
        System.out.println(nom + " " + prenom + " (" + statut + ") - Ecoutes: " + totalEcoutes + " - Royalties: " + royaltiesCarriere);
    }
}
