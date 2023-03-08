/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package myway;

import myway.Entities.Etablissement;
import myway.Entities.MoyenTransport;
import myway.Entities.Trajet;
import myway.Services.ServiceEtablissement;
import myway.Services.ServiceMoyenTransport;
import myway.Services.ServiceTrajet;

/**
 *
 * @author 9naydel
 */
public class MyWay {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //ServiceTrajet st = new ServiceTrajet();
        ServiceMoyenTransport se = new ServiceMoyenTransport();
        se.display();
        //Trajet t = st.findById(11);
        //Etablissement e = new Etablissement("test", "test", t );
        //Etablissement e1 = se.findById(45);
        //e1.setNom("salla");
        //se.delete(e1);
        
        //se.add(e);
        
        //System.out.println(se.findById(1));
        
        //se.add(t0);
        //se.add(t1);
        //se.add(t2);
        
        //se.findById_trajet(10);
        //Trajet t = se.chercher("mourouj","dext0");
        //System.out.println(t.toString());
        
        //for(MoyenTransport e : se.findByIdTrajet(11)){System.out.println(e);}
        //se.modifier(e0, "nom", "roots");
        //System.out.println(e0.toString());
    }
    
}
