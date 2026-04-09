/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author j.bonnafe
 */
public class Utilisateur {
    private int id ;
    private int idUtilisateurCommune;

    private String prenom;
    private String nom;
    private String identifiant;
    private String motdepasse;
    
    public Utilisateur(int id, int idUtilisateurCommune, String prenom, String nom, String identifiant, String motdepasse) {
        this.id = id;
        this.idUtilisateurCommune = idUtilisateurCommune;
        this.prenom = prenom;
        this.nom = nom;
        this.identifiant = identifiant;
        this.motdepasse = motdepasse;
    }

    public int getId() {
        return id;
    }

    public int getIdUtilisateurCommune() {
        return idUtilisateurCommune;
    }
    
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getMotdepasse() {
        return motdepasse;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }
    @Override
    public String toString() {
        return identifiant ;
    }
    
    
}
