/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myway.Entities;

/**
 *
 * @author 9naydel
 */
public class Etablissement {
    private int id, id_trajet;
    private String nom, type;

    public Etablissement() {
    }

    public Etablissement(String nom, String type, int id_trajet) {
        this.nom = nom;
        this.type = type;
        this.id_trajet = id_trajet;
    }

    public int getId() {
        return id;
    }

    public int getId_trajet() {
        return id_trajet;
    }

    public String getNom() {
        return nom;
    }

    public String getType() {
        return type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId_trajet(int id_trajet) {
        this.id_trajet = id_trajet;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Etablissement{" + "id=" + id + ", id_trajet=" + id_trajet + ", nom=" + nom + ", type=" + type + '}';
    }
    
    
    
    
}
