/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myway.Entities;

/**
 *
 * @author 9naydel
 */
public class Reclamation {
    private int id_rec;
    private String message,type,nom,prenom,categorie;
    
    public Reclamation() {
    }
    public Reclamation( String message, String type, String nom, String prenom,String categorie) { 
        this.message = message;
        this.type = type;
        this.nom = nom;
        this.prenom = prenom;
        this.categorie = categorie;
    }
     public Reclamation( String message,String nom, String prenom,String categorie) { 
        this.message = message;
        this.nom = nom;
        this.prenom = prenom;
        this.categorie = categorie;
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
    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
    @Override
    public String toString() {
        return "Reclamation{" + "id=" + id_rec + ", message=" + message + ", type=" + type + "\n}";
    }
    
    
}
