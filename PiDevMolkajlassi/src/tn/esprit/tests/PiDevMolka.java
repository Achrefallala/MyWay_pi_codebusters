/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import tn.esprit.entity.Linge;
import tn.esprit.entity.Moyentp;
import tn.esprit.services.LingeService;
import tn.esprit.services.MoyentpService;
import tn.esprit.tools.MaConnection;

/**
 *
 * @author Molka
 */
public class PiDevMolka{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MoyentpService ps = new MoyentpService();
        LingeService ls = new LingeService();
        Moyentp p1;
        Linge l0;
        Linge l1;
         //Moyentp p3 = new Moyentp("34tunis356","train",4,3,"20h","metro6");
         // Moyentp p3;
        //p3 = new Moyentp("44tunis444","metro",5,8,"21h");
          //p1 = new Moyentp("30tunis356","train",4,3,"20h");
           //l0 = new Linge(1,"30tunis356",1);
           //l1 = new Linge(2,"44tunis444",1);
        //ps.ajouter(p3);
        //ls.ajouter(l0);
        //ls.ajouter(l1);
       // ps.ajouter(p3);
       //ls.supprimer(l1);
      // ps.modifier("bus",9,5,"4h","molka", p3);
       //ls.modifier(2, l0);
        System.out.println(ls.getAll());
        //System.out.println(ps.getAll());
        
        
        
    }

}
