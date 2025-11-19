package streamsa.model;

public abstract class Utilisateur {
    protected int id;
    protected String nom;
    protected String prenom;
    protected String email;

    public Utilisateur(int id, String nom, String prenom, String email) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
    }

    public abstract void afficherInfo();

    public int getId() { return id; }
    public String getNom() { return nom; }
    public String getPrenom() { return prenom; }
    public String getEmail() { return email; }
}
