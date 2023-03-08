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
    private int id, num_tel, isActive;
    private String nom,prenom,role, motdepasse, e_mail;

    public Utilisateur() {
    }

    
    public Utilisateur(int id, String nom, String prenom,String e_mail,int num_tel, String role,int isActive, String motdepasse) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.num_tel= num_tel;
        this.role=role;
        this.isActive=isActive;
        this.motdepasse= motdepasse;
        this.e_mail= e_mail;
    }

    public Utilisateur( String nom, String prenom,String e_mail,int num_tel, String role,int isActive, String motdepasse) {
        this.nom = nom;
        this.prenom = prenom;
        this.num_tel= num_tel;
        this.role=role;
        this.isActive=isActive;
        this.motdepasse= motdepasse;
        this.e_mail= e_mail;

    }

    public Utilisateur(String text, String text0, String text1, String text2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Utilisateur(String text, String text0, String text1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Utilisateur(String nom, String prenom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Utilisateur(int id, int num_tel, String motdepasse, String e_mail) {
        this.id= id;
        this.num_tel= num_tel;
        this.motdepasse= motdepasse;
        this.e_mail= e_mail;

    }

    public Utilisateur(int id, String text, String text0, String utilisateur) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Utilisateur(int id, String ma, String md, int te) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
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

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

  

 
    
    
    

  
    @Override
    public String toString() {
        return "Utilisateur{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom +",e_mail="+e_mail+",num_tel=" + num_tel +
                ",role=" +role +",isActive=" +isActive +",motdepasse="+motdepasse+'}';
    }

   
    
    
}
