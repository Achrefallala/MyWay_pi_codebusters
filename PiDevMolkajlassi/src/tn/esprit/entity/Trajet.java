/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.entity;

/**
 *
 * @author Admin
 */
public class Trajet {
    
    private int id;
    private String depart;
    private String destination;
    private String etat;
    private String directions;
    private String image;
    
    public Trajet(int id, String depart, String destination, String etat, String directions, String image) {
        this.id = id;
        this.depart = depart;
        this.destination = destination;
        this.etat = etat;
        this.directions = directions;
        this.image = image;
    }

    // Getter and Setter methods for all attributes

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
}

