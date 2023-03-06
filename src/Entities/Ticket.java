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
    private Date dateticket; //currentdate
    

    public Ticket() {
    }

    public Ticket(Reservation reservation, Date dateticket) {
        this.reservation = reservation;
        this.dateticket = dateticket;
    }

   

}
