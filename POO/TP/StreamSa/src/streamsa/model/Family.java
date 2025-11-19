package streamsa.model;

import java.util.*;

public class Family extends Auditeur {
    private List<Premium> membres;

    public Family(int id, String nom, String prenom, String email, Date dateNaissance) {
        super(id, nom, prenom, email, dateNaissance);
        membres = new ArrayList<>();
    }

    public void ajouterMembre(Premium p) {
        if (membres.size() < 6) {
            membres.add(p);
        } else {
            System.out.println("Limite de 6 membres atteinte.");
        }
    }

    public List<Premium> getMembres() {
        return membres;
    }

    public void afficherInfo() {
        System.out.println(nom + " " + prenom + " (Family) - Membres: " + membres.size());
    }
}
