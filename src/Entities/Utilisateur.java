/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author Slim
 */
public class Utilisateur {
    private int id_utilisateur;
    private String nom;
    private String prenom;
    private int num_tel;

    public Utilisateur() {
    }

    public Utilisateur(int id_utilisateur, String nom, String prenom, int num_tel) {
        this.id_utilisateur = id_utilisateur;
        this.nom = nom;
        this.prenom = prenom;
        this.num_tel = num_tel;
    }

    public int getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(int id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
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

    public int getNum_tel() {
        return num_tel;
    }

    public void setNum_tel(int num_tel) {
        this.num_tel = num_tel;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "id_utilisateur=" + id_utilisateur + ", nom=" + nom + ", prenom=" + prenom + ", num_tel=" + num_tel + '}';
    }
    
}
