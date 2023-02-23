/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;
import java.sql.Timestamp;
import java.util.Date;


/**
 *
 * @author Slim
 */
public class Reservation {
   private int id_reservation;
    private int id_utilisateur;
    private String moyen_transport;
    private String disponibilite_r;

    public Reservation() {
    }

    public Reservation(int id_reservation, int id_utilisateur, String moyen_transport, String disponibilite_r) {
        this.id_reservation = id_reservation;
        this.id_utilisateur = id_utilisateur;
        this.moyen_transport = moyen_transport;
        this.disponibilite_r = disponibilite_r;
        
    }
      public Reservation(int id_utilisateur, String moyen_transport, String disponibilite_r) {
        this.id_utilisateur = id_utilisateur;
        this.moyen_transport = moyen_transport;
        this.disponibilite_r = disponibilite_r;
        
    }

    public int getId_reservation() {
        return id_reservation;
    }

    public void setId_reservation(int id_reservation) {
        this.id_reservation = id_reservation;
    }

    public int getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(int id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public String getMoyen_transport() {
        return moyen_transport;
    }

    public void setMoyen_transport(String moyen_transport) {
        this.moyen_transport = moyen_transport;
    }

    public String getDisponibilite_r() {
        return disponibilite_r;
    }

    public void setDisponibilite_r(String disponibilite_r) {
        this.disponibilite_r = disponibilite_r;
    }

    @Override
    public String toString() {
        return "Reservation{" + "id_reservation=" + id_reservation + ", id_utilisateur=" + id_utilisateur + ", moyen_transport=" + moyen_transport + ", disponibilite_r=" + disponibilite_r + '}';
    }

    

   
}


    

    

