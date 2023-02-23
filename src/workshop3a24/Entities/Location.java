/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop3a24.Entities;

/**
 *
 * @author Mohamed
 */
public class Location {
    private int id_location  ;
    private String nom,disponibilite,type,description;
   

    public Location() {
    }

    public Location( String nom, String disponibilite, String type ,String description) {
        
        this.nom = nom;
        this.disponibilite = disponibilite;
        this.type = type;
        this.description = description;
        
    }

    
    public Location( int id_location ,String nom, String disponibilite, String type ,String description) {
        this.id_location=id_location;
        this.nom = nom;
        this.disponibilite = disponibilite;
        this.type = type;
        this.description = description;
        
    }
   /* public Location(int i, String ferrari, String dispo, String voiture, String une_voiture_de_luxe) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/

    public int getId() {
        return id_location;
    }

    public void setId(int id_location) {
        this.id_location = id_location;
    }

   

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDisponibilite() {
        return disponibilite;
    }
     public void setDisponibilite(String disponibilite) {
        this.disponibilite = disponibilite;
    }

     public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Location{" + "id_location=" + id_location + ", nom=" + nom + ", disponibilite=" + disponibilite+ ",type=" + type+ ", description=" + description+ "\n}";
    }
    
    
}
