/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author Slim
 */
public class Guide {
   private int id;
   private String nom;
    private String prenom;
     private int age;
     private String langues;
     private String experiences;
//    private int etoiles; 

    public Guide() {
    }

    public Guide(String nom, String prenom, int age, String langues, String experiences) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.langues = langues;
        this.experiences = experiences;
    }

    
    
    

 
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLangues() {
        return langues;
    }

    public void setLangues(String langues) {
        this.langues = langues;
    }

    public String getExperiences() {
        return experiences;
    }

    public void setExperiences(String experiences) {
        this.experiences = experiences;
    }

//    public int getEtoiles() {
//        return etoiles;
//    }
//
//    public void setEtoiles(int etoiles) {
//        this.etoiles = etoiles;
//    }

    @Override
    public String toString() {
        return "Guide{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", age=" + age + ", langues=" + langues + ", experiences=" + experiences + '}';
    }



    
    
}
