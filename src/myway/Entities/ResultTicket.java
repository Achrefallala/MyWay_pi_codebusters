/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myway.Entities;
import java.sql.Date;

/**
 *
 * @author 9naydel
 */

public class ResultTicket {
 
    private int id;
    private String nom;
    private double prix;
    private String depart;
    private String destination;
    private  Date dateticket;
    private String type;

    public ResultTicket() {
    }

    public ResultTicket(String nom, double prix, String depart, String destination, Date dateticket, String type) {
        this.nom = nom;
        this.prix = prix;
        this.depart = depart;
        this.destination = destination;
        this.dateticket = dateticket;
        this.type = type;
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

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
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

    public Date getDateticket() {
        return dateticket;
    }

    public void setDateticket(Date dateticket) {
        this.dateticket = dateticket;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ResultTicket{" + "id=" + id + ", nom=" + nom + ", prix=" + prix + ", depart=" + depart + ", destination=" + destination + ", dateticket=" + dateticket + ", type=" + type + '}';
    }

    
    
}

