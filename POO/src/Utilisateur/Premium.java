package Utilisateur;

import java.util.Date;

public class Premium extends Auditeur {
    public Premium(int id, String nom, String prenom, String email, Date dateNaissance) {
        super(id, nom, prenom, email, dateNaissance);
    }

    // fonctionnalités premium : playlist personnalisée, téléchargement
    public void afficherInfo() {
        System.out.println(nom + " " + prenom + " (Premium)");
    }
}
