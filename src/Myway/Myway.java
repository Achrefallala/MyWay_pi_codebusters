/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Myway;

import Myway.Entities.Reclamation;
import Myway.Services.ServiceReclamation;
import Myway.Utils.MyDB;
import Myway.Entities.Reponse;
import Myway.Services.ServiceReponse;


public class Myway {

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

       Reclamation R = new Reclamation("achref", "hjvjh","safa3","mbarki2");
       ServiceReclamation sp = new ServiceReclamation();
        sp.add(R);
       // sp.modifier(R);
       //sp.supprimer(R);
        //System.out.println( sp.afficher());
       // Reponse R1 = new Reponse (200, 155,"hjbjqdbqjdv");
        //ServiceReponse sp2 = new ServiceReponse();
        //System.out.println( sp2.afficher());
        //sp2.add(R1);
        
    }
    
}
