/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop3a24;

import java.sql.Date;
import workshop3a24.Entities.Location;
import workshop3a24.Entities.contrat_location;
import workshop3a24.Services.ServiceLocation;
import workshop3a24.Services.ServiceContratLocation;
import workshop3a24.Utils.MyDB;

/**
 *
 * @author Mohamed
 */
public class Workshop3A24 {

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

        Location l = new Location( "volkswagen passat", "oui", "voiture", "une voiture de travail...");
        ServiceLocation sp = new ServiceLocation();
        //sp.add(l);
       
       // Date dl = new Date(2023 - 1900, 13 - 01, 13);
               // contrat_location cl = new contrat_location( 3,99.99f, dl,dl);   
       // ServiceContratLocation spc = new ServiceContratLocation();
        //spc.add(cl);
        System.out.println( sp.afficher());
       //sp.modifier(l) ;  
       //sp.supprimer(l);
    }
    
}
