package streamsa.model;

import java.util.List;

public class RoyaltiesManager {

    public void calculerRoyalties(Morceau m) {
        double montant = 0.10 / m.getArtistes().size();
        for (Artiste a : m.getArtistes()) {
            if ("confirme".equals(a.getStatut()) || "vedette".equals(a.getStatut())) {
                a.ajouterRoyalties(montant);
            }
        }
    }
}
