package Musique;

import java.util.*;

public class RoyaltiesManager {

    private Map<Integer, Double> royaltiesEnAttente = new HashMap<>();
    private Set<String> ecoutesPayees = new HashSet<>();

    private static final double MONTANT_ECOUTE = 0.10;


    // Enregistre une écoute du morceau pour les royalties.
    // Ne paie pas encore ! On cumule d’abord.

    public void enregistrerEcoute(Morceau m) {
        int numeroEcoute = m.getNbEcoutes();   // chaque écoute a un numéro unique
        String idEcoute = m.getId() + "#" + numeroEcoute;

        if (ecoutesPayees.contains(idEcoute)) {
            return; // écoute déjà comptée, ne rien faire
        }

        ecoutesPayees.add(idEcoute);

        List<Artiste> artistes = m.getArtistes();
        int nbArtistes = artistes.size();
        double part = MONTANT_ECOUTE / nbArtistes;

        for (Artiste a : artistes) {
            // On applique TA règle ici :
            if (!("confirme".equals(a.getStatut()) || "vedette".equals(a.getStatut()))) {
                continue; // l'artiste ne gagne rien
            }

            royaltiesEnAttente.put(
                a.getId(),
                royaltiesEnAttente.getOrDefault(a.getId(), 0.0) + part
            );
        }
    }

    // Verse toutes les royalties accumulées aux artistes concernés.

    public void declencherPaiementGlobal(List<Artiste> artistes) {
        for (Artiste a : artistes) {
            double gain = royaltiesEnAttente.getOrDefault(a.getId(), 0.0);
            if (gain > 0) {
                a.ajouterRoyalties(gain);
            }
        }
        royaltiesEnAttente.clear();
    }
}
