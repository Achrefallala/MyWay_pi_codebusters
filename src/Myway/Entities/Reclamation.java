/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Myway.Entities;


public class Reclamation {
    private int id_rec;
    private String message,type,nom,prenom;
    
    public Reclamation() {
    }
    public Reclamation( String message, String type, String nom, String prenom) { 
        this.message = message;
        this.type = type;
        this.nom = nom;
        this.prenom = prenom;
    }
     public Reclamation( String message,String nom, String prenom) { 
        this.message = message;
        this.nom = nom;
        this.prenom = prenom;
    }
   

    public Reclamation(int id_rec, String message, String type, String nom, String prenom) {
        this.id_rec = id_rec;
        this.message = message;
        this.type = type;
        this.nom = nom;
        this.prenom = prenom;
    }

    public int getId_rec() {
        return id_rec;
    }

    public void setId_rec(int id_rec) {
        this.id_rec = id_rec;
    }

  

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
     public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
     public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    @Override
    public String toString() {
        return "Reclamation{" + "id=" + id_rec + ", message=" + message + ", type=" + type + "\n}";
    }
    
    
}
