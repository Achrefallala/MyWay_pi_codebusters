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
public class Ticket {
private int id_reservation;
private float prix_ticket;
private String lieu_depart; 
private String lieu_arrive;
private String heure_depart;
private String heure_arrive;
private int id_ticket;


    public Ticket() {
    }

    public Ticket(int id_reservation, float prix_ticket, String lieu_depart, String lieu_arrive, String heure_depart, String heure_arrive, int id_ticket) {
        this.id_reservation = id_reservation;
        this.prix_ticket = prix_ticket;
        this.lieu_depart = lieu_depart;
        this.lieu_arrive = lieu_arrive;
        this.heure_depart = heure_depart;
        this.heure_arrive = heure_arrive;
        this.id_ticket = id_ticket;
    } 

    public Ticket(int id_reservation, float prix_ticket, String lieu_depart, String lieu_arrive, String heure_depart, String heure_arrive) {
        this.id_reservation = id_reservation;
        this.prix_ticket = prix_ticket;
        this.lieu_depart = lieu_depart;
        this.lieu_arrive = lieu_arrive;
        this.heure_depart = heure_depart;
        this.heure_arrive = heure_arrive;
    }

   
    public int getId_reservation() {
        return id_reservation;
    }

    public void setId_reservation(int id_reservation) {
        this.id_reservation = id_reservation;
    }

    public float getPrix_ticket() {
        return prix_ticket;
    }

    public void setPrix_ticket(float prix_ticket) {
        this.prix_ticket = prix_ticket;
    }

    public String getLieu_depart() {
        return lieu_depart;
    }

    public void setLieu_depart(String lieu_depart) {
        this.lieu_depart = lieu_depart;
    }

    public String getLieu_arrive() {
        return lieu_arrive;
    }

    public void setLieu_arrive(String lieu_arrive) {
        this.lieu_arrive = lieu_arrive;
    }

    public String getHeure_depart() {
        return heure_depart;
    }

    public void setHeure_depart(String heure_depart) {
        this.heure_depart = heure_depart;
    }

    public String getHeure_arrive() {
        return heure_arrive;
    }

    public void setHeure_arrive(String heure_arrive) {
        this.heure_arrive = heure_arrive;
    }

    public int getId_ticket() {
        return id_ticket;
    }

    public void setId_ticket(int id_ticket) {
        this.id_ticket = id_ticket;
    }

    @Override
    public String toString() {
        return "Ticket{" + "id_reservation=" + id_reservation + ", prix_ticket=" + prix_ticket + ", lieu_depart=" + lieu_depart + ", lieu_arrive=" + lieu_arrive + ", heure_depart=" + heure_depart + ", heure_arrive=" + heure_arrive + ", id_ticket=" + id_ticket + '}';
    }

  
    }

   


