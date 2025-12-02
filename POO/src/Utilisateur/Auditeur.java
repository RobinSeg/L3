package Utilisateur;

import java.util.*;

import Musique.Morceau;
import streamsa.model.Playlist;

public abstract class Auditeur extends Utilisateur {
    protected Date dateNaissance;
    protected Playlist historique;

    public Auditeur(int id, String nom, String prenom, String email, Date dateNaissance) {
        super(id, nom, prenom, email);
        this.dateNaissance = dateNaissance;
        this.historique = new Playlist("Historique", "Écoutes récentes", this, true);
    }

    public void ecouterMorceau(Morceau m) {
        m.ajouterEcoute();
        historique.ajouterMorceau(m);
    }

    public Playlist getHistorique() {
        return historique;
    }
}
