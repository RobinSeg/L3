package streamsa.model;

import Musique.*;
import Utilisateur.*;
import Stats.Classement;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        // --- Création des artistes ---
        Artiste a1 = new Artiste(1, "Lil", "Jean", "liljean@email.com", "Pop");
        Artiste a2 = new Artiste(2, "Martin", "Martin", "martin@email.com", "Rock");
        Artiste a3 = new Artiste(3, "Sophie", "Lemaire", "sophie@email.com", "Jazz");
        Artiste a4 = new Artiste(4, "Alex", "Durand", "alex@email.com", "Hip-Hop");
        Artiste a5 = new Artiste(5, "Clara", "Petit", "clara@email.com", "Electro");
        Artiste a6 = new Artiste(6, "David", "Moreau", "david@email.com", "Rock");

        List<Artiste> tousArtistes = Arrays.asList(a1, a2, a3, a4, a5, a6);

        // --- Création des morceaux ---
        Morceau m1 = new Morceau(1, "Hit Pop", 3.5, "Pop", 2023, "MP3", Arrays.asList(a1));
        Morceau m2 = new Morceau(2, "Rock Anthem", 4.0, "Rock", 2022, "FLAC", Arrays.asList(a2));
        Morceau m3 = new Morceau(3, "Collab Song", 4.5, "Pop/Rock", 2024, "Hi-Res", Arrays.asList(a1, a2));
        Morceau m4 = new Morceau(4, "Jazz Nights", 5.0, "Jazz", 2021, "MP3", Arrays.asList(a3));
        Morceau m5 = new Morceau(5, "Hip-Hop Vibes", 3.8, "Hip-Hop", 2024, "FLAC", Arrays.asList(a4));
        Morceau m6 = new Morceau(6, "Fusion Track", 4.2, "Pop/Jazz", 2024, "Hi-Res", Arrays.asList(a1, a3));
        Morceau m7 = new Morceau(7, "Electro Beat", 3.9, "Electro", 2024, "MP3", Arrays.asList(a5));
        Morceau m8 = new Morceau(8, "Rock Ballad", 4.1, "Rock", 2023, "FLAC", Arrays.asList(a2, a6));
        Morceau m9 = new Morceau(9, "Pop Jam", 3.7, "Pop", 2024, "Hi-Res", Arrays.asList(a1, a5));

        List<Morceau> tousMorceaux = Arrays.asList(m1, m2, m3, m4, m5, m6, m7, m8, m9);

        // --- Création des albums ---
        Album album1 = new Album("Beasty", 2024, "Pop", Arrays.asList(a1, a2), "studio");
        album1.ajouterMorceau(m1);
        album1.ajouterMorceau(m3);
        album1.ajouterMorceau(m9);

        Album album2 = new Album("Smooth Jazz", 2021, "Jazz", Arrays.asList(a3), "studio");
        album2.ajouterMorceau(m4);
        album2.ajouterMorceau(m6);

        Album album3 = new Album("Urban Beats", 2024, "Hip-Hop", Arrays.asList(a4, a1), "studio");
        album3.ajouterMorceau(m5);

        Album album4 = new Album("Electro Vibes", 2024, "Electro", Arrays.asList(a5), "studio");
        album4.ajouterMorceau(m7);
        album4.ajouterMorceau(m9);

        Album album5 = new Album("Rock Legends", 2023, "Rock", Arrays.asList(a2, a6), "studio");
        album5.ajouterMorceau(m2);
        album5.ajouterMorceau(m8);

        List<Album> tousAlbums = Arrays.asList(album1, album2, album3, album4, album5);

        // --- Création des auditeurs ---
        Premium p1 = new Premium(101, "Durand", "Luc", "luc@email.com", new Date());
        Premium p2 = new Premium(102, "Martin", "Alice", "alice@email.com", new Date());
        Premium p3 = new Premium(103, "Petit", "Leo", "leo@email.com", new Date());
        Family f1 = new Family(104, "Famille", "Smith", "family@email.com", new Date());
        f1.ajouterMembre(p1);
        f1.ajouterMembre(p2);
        f1.ajouterMembre(p3);

        // --- Création des playlists ---
        Playlist pl1 = new Playlist("Mes favoris", "Top morceaux", p1, true);
        pl1.ajouterMorceau(m1);
        pl1.ajouterMorceau(m2);
        pl1.ajouterMorceau(m6);

        Playlist pl2 = new Playlist("Jazz & Fusion", "Relax", p2, false);
        pl2.ajouterMorceau(m4);
        pl2.ajouterMorceau(m6);

        Playlist pl3 = new Playlist("Electro & Pop", "Fun", p3, true);
        pl3.ajouterMorceau(m7);
        pl3.ajouterMorceau(m9);

        // --- Gestion des royalties ---
        RoyaltiesManager rm = new RoyaltiesManager();

        // --- Écoutes ---
        // beaucoup d'écoutes pour faire évoluer le statut des artistes
        for (int i = 0; i < 3000; i++) { p1.ecouterMorceau(m1); rm.enregistrerEcoute(m1); }
        for (int i = 0; i < 6000; i++) { p2.ecouterMorceau(m3); rm.enregistrerEcoute(m3); }
        for (int i = 0; i < 2000; i++) { p3.ecouterMorceau(m9); rm.enregistrerEcoute(m9); }
        for (int i = 0; i < 500; i++)  { f1.ecouterMorceau(m4); rm.enregistrerEcoute(m4); }
        for (int i = 0; i < 700; i++)  { f1.ecouterMorceau(m5); rm.enregistrerEcoute(m5); }
        for (int i = 0; i < 1200; i++) { p1.ecouterMorceau(m6); rm.enregistrerEcoute(m6); }
        for (int i = 0; i < 900; i++)  { p2.ecouterMorceau(m7); rm.enregistrerEcoute(m7); }
        for (int i = 0; i < 800; i++)  { p3.ecouterMorceau(m8); rm.enregistrerEcoute(m8); }
        for (int i = 0; i < 1500; i++) { f1.ecouterMorceau(m2); rm.enregistrerEcoute(m2); }

        // --- Paiement global des royalties ---
        rm.declencherPaiementGlobal(tousArtistes);

        // --- Affichage des artistes ---
        System.out.println("\n--- Artistes ---");
        for (Artiste a : tousArtistes) a.afficherInfo();

        // --- Classement des artistes par revenus ---
        List<Artiste> topArtistes = Classement.artistesParRevenus(tousArtistes);
        System.out.println("\n--- Classement des artistes par revenus ---");
        for (Artiste a : topArtistes) {
            System.out.println(a.getNom() + " " + a.getPrenom() + " - Royalties: " + a.getRoyaltiesCarriere());
        }

        // --- Classement des morceaux les plus écoutés ---
        List<Morceau> topMorceaux = Classement.titresLesPlusEcoutes(tousMorceaux);
        System.out.println("\n--- Top morceaux les plus écoutés ---");
        for (Morceau m : topMorceaux) {
            System.out.println(m.getTitre() + " - Écoutes: " + m.getNbEcoutes());
        }

        // --- Album le plus écouté ---
        Album topAlbum = Classement.albumLePlusEcoute(tousAlbums);
        System.out.println("\n--- Album le plus écouté ---");
        System.out.println(topAlbum.getTitre() + " - Écoutes: " + topAlbum.getNbEcoutes());
    }
}
