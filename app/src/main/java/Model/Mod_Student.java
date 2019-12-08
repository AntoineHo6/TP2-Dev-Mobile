package Model;

public class Mod_Student {
    private String nom;
    private String prenom;


    public Mod_Student(String nom, String prenom){
        this.nom = nom;
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }
}
