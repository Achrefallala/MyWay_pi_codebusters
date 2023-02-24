/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myway.Entities;

/**
 *
 * @author 9naydel
 */
public class Trajet {
    private int id;
    private String depart, destination, etat, directions, image;
    
    public Trajet(){}

    public Trajet(String depart, String destination, String etat, String directions, String image) {
        this.depart = depart;
        this.destination = destination;
        this.etat = etat;
        this.directions = directions;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getDepart() {
        return depart;
    }

    public String getDestination() {
        return destination;
    }

    public String getEtat() {
        return etat;
    }

    public String getDirections() {
        return directions;
    }

    public String getImage() {
        return image;
    } 

    public void setId(int id) {
        this.id = id;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Trajet{" + "id=" + id + ", depart=" + depart + ", destination=" + destination + ", etat=" + etat + ", directions=" + directions + ", image=" + image + '}';
    }
    
    
}
