/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myway.Entities;

/**
 *
 * @author 9naydel
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class ResultReservation {

    private int id;
    private String nom;
    private String type;
    private String depart;
    private String destination;
    private Double prix;

    public ResultReservation() {
    }

    public ResultReservation(String nom, String type, String depart, String destination) {
        this.nom = nom;
        this.type = type;
        this.depart = depart;
        this.destination = destination;
    }

    public ResultReservation(String nom, String type, String depart, String destination, Double prix) {
        this.nom = nom;
        this.type = type;
        this.depart = depart;
        this.destination = destination;
        this.prix = prix;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    @Override
    public String toString() {
        return "ResultReservation{" + "id=" + id + ", nom=" + nom + ", type=" + type + ", depart=" + depart + ", destination=" + destination + ", prix=" + prix + '}';
    }

  

}