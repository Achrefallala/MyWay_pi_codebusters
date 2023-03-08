/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myway;

import myway.Entities.Utilisateur;
import myway.Services.ServiceUtilisateur;
import myway.Utils.MyDB;

/**
 *

 */
public class MyWay {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//     A a = A.getInstance();
//     A a1 =A.getInstance();
//        System.out.println(a.hashCode());
//        System.out.println(a1.hashCode());
//        MyDB a = MyDB.getInstance();
//        MyDB a1 = MyDB.getInstance();
//        System.out.println(a.hashCode());
//        System.out.println(a1.hashCode());

        Utilisateur p = new Utilisateur( 16,"abomaher+1", "Mohamed","user@user",3258475,"user",1,"jjfjfj");
        ServiceUtilisateur su = new ServiceUtilisateur();
        //su.add(p);
        su.modifier2(p);
        //ssu.supprimer(p);
        
        //System.out.println( su.afficher());
        
    }
    
}
