/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.entity;

/**
 *
 * @author Admin
 */
public class Linge {
     private int id,id_trajet;
     private String id_moyentp ;
     private Trajet trajet;
    public Linge() {
    }

    
    public Linge(int id,String id_moyentp,int id_trajet) {
        this.id= id;
        this.id_moyentp= id_moyentp;
        this.id_trajet = id_trajet;
         
        
       
    }

    public Trajet getTrajet() {
        return trajet;
    }

    public void setTrajet(Trajet trajet) {
        this.trajet = trajet;
    }

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getId_moyentp() {
        return id_moyentp;
    }

    public int getId_trajet() {
        return id_trajet;
    }

    public void setId_moyentp(String id_moyentp) {
        this.id_moyentp = id_moyentp;
    }

    public void setId_trajet(int id_trajet) {
        this.id_trajet = id_trajet;
    }

    
   

   

   

    
    @Override
    public String toString() {
        return "Linge{" + "id=" + id + ", id_moyentp=" + id_moyentp + ", id_trajet=" + id_trajet  +'}';
    }
    
    
}
