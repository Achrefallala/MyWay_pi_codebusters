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

    private int id;
    private LigneTransport ligne; // ligne.id_ligne; moyentp.type
    private Utilisateur utilisateur;
    private String disponibilite_r;

    public Reservation() {
    }

    public Reservation(LigneTransport ligne, Utilisateur utilisateur, String disponibilite_r) {
        this.ligne = ligne;
        this.utilisateur = utilisateur;
        this.disponibilite_r = disponibilite_r;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    

   
    public LigneTransport getLigne() {
        return ligne;
    }

    public void setLigne(LigneTransport ligne) {
        this.ligne = ligne;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public String getDisponibilite_r() {
        return disponibilite_r;
    }

    public void setDisponibilite_r(String disponibilite_r) {
        this.disponibilite_r = disponibilite_r;
    }

    @Override
    public String toString() {
        return "Reservation{" + "id=" + id + ", ligne=" + ligne + ", utilisateur=" + utilisateur + ", disponibilite_r=" + disponibilite_r + '}';
    }

    

    
}
