/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Myway.Entities;

/**
 *
 * @author mbark
 */
public class Reponse {
    private int id_rep ,id_rec;
    private String reponse ;
    
    public Reponse (){
    }
    public Reponse (int id_rec , String reponse){
        this.id_rec = id_rec;
        this.reponse = reponse;
    }
     public Reponse (String reponse){
        this.reponse = reponse;
    }
   
    public Reponse (int id_rep ,int id_rec , String reponse){
        this.id_rep = id_rep;
        this.id_rec = id_rec;
        this.reponse = reponse;
    }
    
    public void setId_reponse(int id_rep) {
        this.id_rep = id_rep;
    }

    public void setId_rec(int id_rec) {
        this.id_rec = id_rec;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    public int getId_reponse() {
        return id_rep;
    }

    public int getId_rec() {
        return id_rec;
    }

    public String getReponse() {
        return reponse;
    }
      @Override
    public String toString() {
        return "Reponse{" + "id_reponse=" + id_rep + ", id_rec=" + id_rec + ", reponse=" + reponse + '}';
    }

}

