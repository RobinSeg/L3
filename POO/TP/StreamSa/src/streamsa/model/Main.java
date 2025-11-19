package streamsa.model;

import streamsa.model.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        // --- Création des artistes ---
        Artiste a1 = new Artiste(1, "Dupont", "Jean", "jean.dupont@email.com", "Pop");
        Artiste a2 = new Artiste(2, "Martin", "Claire", "claire.martin@email.com", "Rock");

        // --- Création des morceaux ---
        Morceau m1 = new Morceau(1, "Hit Pop", 3.5, "Pop", 2023, "MP3", Arrays.asList(a1));
        Morceau m2 = new Morceau(2, "Rock Anthem", 4.0, "Rock", 2022, "FLAC", Arrays.asList(a2));
        Morceau m3 = new Morceau(3, "Collab Song", 4.5, "Pop/Rock", 2024, "Hi-Res", Arrays.asList(a1, a2));

        // --- Création d'un album ---
        Album album1 = new Album("Best Hits", 2024, "Pop", Arrays.asList(a1), "studio");
        album1.ajouterMorceau(m1);
        album1.ajouterMorceau(m3);

        // --- Création d'un auditeur Premium ---
        Premium p1 = new Premium(101, "Durand", "Luc", "luc.durand@email.com", new Date());

        // --- Création d'un auditeur Family ---
        Family f1 = new Family(102, "Famille", "Smith", "family.smith@email.com", new Date());
        f1.ajouterMembre(p1);

        // --- Création de playlists ---
        Playlist pl1 = new Playlist("Mes favoris", "Top morceaux", p1, true);
        pl1.ajouterMorceau(m1);
        pl1.ajouterMorceau(m2);

        // --- Écoutes ---
        p1.ecouterMorceau(m1);
        p1.ecouterMorceau(m3);
        f1.ecouterMorceau(m2);

        // --- Gestion des royalties ---
        RoyaltiesManager rm = new RoyaltiesManager();
        rm.calculerRoyalties(m1);
        rm.calculerRoyalties(m2);
        rm.calculerRoyalties(m3);

        // --- Affichage infos ---
        a1.afficherInfo();
        a2.afficherInfo();
        p1.afficherInfo();
        f1.afficherInfo();

        // Affichage playlist historique
        System.out.println("Historique de " + p1.getNom() + " :");
        for (Morceau m : p1.getHistorique().getMorceaux()) {
            System.out.println("- " + m.getTitre());
        }

        System.out.println("Historique de " + f1.getNom() + " :");
        for (Morceau m : f1.getHistorique().getMorceaux()) {
            System.out.println("- " + m.getTitre());
        }

        // Affichage du nombre d'écoutes album
        System.out.println("Album " + album1.getTrackList().get(0).getTitre() + " a été écouté " + album1.getNbEcoutes() + " fois.");
    }
}
