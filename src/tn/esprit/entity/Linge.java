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
     private int id,trajetid;
     private String moyentpid ;

    public Linge() {
    }

    
    public Linge(int id,String moyentpid,int trajetid) {
        this.id= id;
        this.moyentpid= moyentpid;
        this.trajetid = trajetid;
         
        
       
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMoyentpid() {
        return moyentpid;
    }

    public void setMoyentpid(String moyentpid) {
        this.moyentpid = moyentpid;
    }

    public int getTrajetid() {
        return trajetid;
    }

    public void setTrajetid(int trajetid) {
        this.trajetid = trajetid;
    }

   

   

    
    @Override
    public String toString() {
        return "Linge{" + "id=" + id + ", moyentpid=" + moyentpid + ", trajetid=" + trajetid  +'}';
    }
    
    
}
