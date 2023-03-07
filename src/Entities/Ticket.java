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
public class Ticket {

    private int id_ticket;
    private Reservation reservation; //id_reservation;
    private Utilisateur utilisateur; //id_utilisateur
    private LigneTransport ligne;
    private Date dateticket; //currentdate

    public Ticket() {
    }

    public Ticket(Reservation reservation, Utilisateur utilisateur, LigneTransport ligne, Date dateticket) {
        this.reservation = reservation;
        this.utilisateur = utilisateur;
        this.ligne = ligne;
        this.dateticket = dateticket;
    }

    public int getId_ticket() {
        return id_ticket;
    }

    public void setId_ticket(int id_ticket) {
        this.id_ticket = id_ticket;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public LigneTransport getLigne() {
        return ligne;
    }

    public void setLigne(LigneTransport ligne) {
        this.ligne = ligne;
    }

    public Date getDateticket() {
        return dateticket;
    }

    public void setDateticket(Date dateticket) {
        this.dateticket = dateticket;
    }

    @Override
    public String toString() {
        return "Ticket{" + "id_ticket=" + id_ticket + ", reservation=" + reservation + ", utilisateur=" + utilisateur + ", ligne=" + ligne + ", dateticket=" + dateticket + '}';
    }

}
