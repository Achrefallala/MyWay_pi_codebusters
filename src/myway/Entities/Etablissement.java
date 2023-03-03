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
    private int id;
    private Trajet trajet;
    private String nom, type, description;

    public Etablissement() {
    }

    public Etablissement(String nom, String type, String description, Trajet trajet) {
        this.nom = nom;
        this.type = type;
        this.trajet = trajet;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public Trajet getTrajet() {
        return trajet;
    }

    public String getNom() {
        return nom;
    }
    
    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTrajet(Trajet trajet) {
        this.trajet = trajet;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Etablissement{" + "id=" + id + ", nom=" + nom + ", type=" + type + ", description=" + description + ", trajet=" + trajet + '}';
    }

    

    
}
