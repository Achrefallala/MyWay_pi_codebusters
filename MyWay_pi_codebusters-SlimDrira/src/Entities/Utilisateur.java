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
    private int id;
    private String nom;
    private String prenom;
    private int num_tel;

    public Utilisateur() {
    }

    public Utilisateur(int id, String nom, String prenom, int num_tel) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.num_tel = num_tel;
    }

    public Utilisateur(String nom, String prenom, int num_tel) {
        this.nom = nom;
        this.prenom = prenom;
        this.num_tel = num_tel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return "Utilisateur{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", num_tel=" + num_tel + '}';
    }

    

    
}
