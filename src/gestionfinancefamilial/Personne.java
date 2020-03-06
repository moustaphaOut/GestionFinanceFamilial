package gestionfinancefamilial;

import java.io.Serializable;

public class Personne implements Serializable {

    private String nom;
    private String prenom;
    private String date_de_naissance;
    private String etat_civil;
    private String sexe;
    private String nombre_enfant;

    @Override
    public String toString() {
        return nom + prenom + date_de_naissance + etat_civil + sexe + nombre_enfant;
    }

    public Personne() {

    }

    public Personne(String nom, String prenom, String date_de_naissance, String etat_civil, String sexe, String nombre_enfant) {
        this.nom = nom;
        this.prenom = prenom;
        this.date_de_naissance = date_de_naissance;
        this.etat_civil = etat_civil;
        this.sexe = sexe;
        this.nombre_enfant = nombre_enfant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDate_de_naissance() {
        return date_de_naissance;
    }

    public void setDate_de_naissance(String date_de_naissance) {
        this.date_de_naissance = date_de_naissance;
    }

    public String getEtat_civil() {
        return etat_civil;
    }

    public void setEtat_civil(String etat_civil) {
        this.etat_civil = etat_civil;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getNombre_enfant() {
        return nombre_enfant;
    }

    public void setNombre_enfant(String nombre_enfant) {
        this.nombre_enfant = nombre_enfant;
    }

}
