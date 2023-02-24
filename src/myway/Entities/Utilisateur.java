/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myway.Entities;

/**
 *
 
 */
public class Utilisateur {
    private int id, num_tel;
    private String nom,prenom,role, motdepasse;
    private Boolean isActive;

    public Utilisateur() {
    }

    
    public Utilisateur(int id, String nom, String prenom,int num_tel, String role,Boolean isActive, String motdepasse) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.num_tel= num_tel;
        this.role=role;
        this.isActive=isActive;
        this.motdepasse= motdepasse;
    }

    public Utilisateur( String nom, String prenom,int num_tel, String role,Boolean isActive, String motdepasse) {
        this.nom = nom;
        this.prenom = prenom;
        this.num_tel= num_tel;
        this.role=role;
        this.isActive=isActive;
        this.motdepasse= motdepasse;
    }

    public Utilisateur(String text, String text0, String text1, String text2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Utilisateur(String text, String text0, String text1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    public String getMotdepasse() {
        return motdepasse;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }

  

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNum_tel() {
        return num_tel;
    }

    public void setNum_tel(int num_tel) {
        this.num_tel = num_tel;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
    

 
    
    
    

  
    @Override
    public String toString() {
        return "Utilisateur{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom +",num_tel=" + num_tel +
                ",role=" +role +",isActive=" +isActive +",motdepasse="+motdepasse+'}';
    }
    
    
}
