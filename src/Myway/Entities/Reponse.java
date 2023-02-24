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
    private String text ;
    
    public Reponse (){
    }
    public Reponse (int id_rec , String text){
        this.id_rec = id_rec;
        this.text = text;
    }
    public Reponse (int id_rep ,int id_rec , String text){
        this.id_rep = id_rep;
        this.id_rec = id_rec;
        this.text = text;
    }
    
    public void setId_reponse(int id_reponse) {
        this.id_rep = id_rep;
    }

    public void setId_rec(int id_rec) {
        this.id_rec = id_rec;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getId_reponse() {
        return id_rep;
    }

    public int getId_rec() {
        return id_rec;
    }

    public String getText() {
        return text;
    }
      @Override
    public String toString() {
        return "Reponse{" + "id_reponse=" + id_rep + ", id_rec=" + id_rec + ", text=" + text + '}';
    }

}

