/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.entity;

/**
 *
 * @author Molka
 */
public class Moyentp {
    private int nbreplace,prix_ticket;
    private String matricule,horaire,type;

    public Moyentp() {
    }

    
    public Moyentp(String matricule,String type,int nbreplace,int prix_ticket, String horaire) {
        this.matricule= matricule;
        this.type= type;
        this.nbreplace = nbreplace;
         this.prix_ticket = prix_ticket;
        this.horaire = horaire;
        
       
    }

   

    public String getType() {
        return type;
    }

    public String getHoraire() {
        return horaire;
    }

   

    public String getMatricule() {
        return matricule;
    }

    public int getNbreplace() {
        return nbreplace;
    }

    public int getPrix_ticket() {
        return prix_ticket;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setHoraire(String horaire) {
        this.horaire = horaire;
    }

   
    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public void setNbreplace(int nbreplace) {
        this.nbreplace = nbreplace;
    }

    public void setPrix_ticket(int prix_ticket) {
        this.prix_ticket = prix_ticket;
    }
     

    
    @Override
    public String toString() {
        return "Moyentp{" + "matricule=" + matricule + ", horaire=" + horaire + ", nbreplace=" + nbreplace + ", prix_ticket=" + prix_ticket +'}';
    }
    
    
}
