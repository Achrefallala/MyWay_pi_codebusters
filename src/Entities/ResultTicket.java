/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.sql.Date;

/**
 *
 * @author Slim
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
