/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;
import java.util.Date;

/**
 *
 * @author Slim
 */
public class Reservation {
    private int id_reservation ,id_utilisateur ;
    private String moyen_transport;
    private boolean disponibilite_r;
    private Date date_reservation;
    private float prix_ticket;

    public Reservation() {
    }

    public Reservation(int id_utilisateur ,String moyen_transport,Date date_reservation,float prix_ticket,boolean disponibilite_r){
        this.id_utilisateur = id_utilisateur;
        this.moyen_transport= moyen_transport;
        this.date_reservation= date_reservation;
        this.prix_ticket= prix_ticket;
        this.disponibilite_r= disponibilite_r;
 
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

    public Date getDate_reservation() {
        return date_reservation	;
    }

    public void setDate_reservation	(Date date_reservation) {
        this.date_reservation= date_reservation;
    }
        public float getPrix_ticket() {
        return prix_ticket;
    }

    public void setPrix_ticket	(float prix_ticket) {
        this.prix_ticket=prix_ticket;
    }
       public boolean getDisponibilite_r() {
        return disponibilite_r;
    }

    public void setDisponibilite_r(boolean disponibilite_r) {
        this.disponibilite_r= disponibilite_r;
    }

    @Override
    public String toString() {
        return "Reservation{" + "id_reservation=" + id_reservation + ", id_utilisateur=" + id_utilisateur + ", moyen_transport=" + moyen_transport + ", disponibilite_r=" + disponibilite_r + ", date_reservation=" + date_reservation + ", prix_ticket=" + prix_ticket + '}';
    }

    

    
}
