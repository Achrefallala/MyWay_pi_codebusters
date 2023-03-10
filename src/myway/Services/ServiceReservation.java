/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myway.Services;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import myway.Entities.LigneTransport;
import myway.Entities.MoyenTransport;
import myway.Entities.Reservation;
import myway.Entities.Trajet;
import myway.Entities.Utilisateur;
import myway.Utils.MyDB;

//import sun.util.logging.resources.logging;
//import java.sql.Date;

/**
 *
 * @author 9naydel
 */

public class ServiceReservation {

    Connection cnx;

    
    public List<Reservation> afficher() {
        System.out.println("begin Afficher");
        List<Reservation> listRes = new ArrayList<>();
        ServiceUtilisateur uService = new ServiceUtilisateur();
        System.out.println("begin Try");

        String qry = "SELECT reservation.id, utilisateur.nom as nom, moyen_transport.type as type, trajet.depart as depart, trajet.destination as destination FROM reservation INNER JOIN utilisateur ON reservation.id_utilisateur = utilisateur.id INNER JOIN ligne_transport ON reservation.id_ligne = ligne_transport.id INNER JOIN moyen_transport ON ligne_transport.id_moyentp = moyen_transport.id INNER JOIN trajet ON ligne_transport.id_trajet = trajet.id;";

        try {
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while (rs.next()) {
                Reservation r = new Reservation();
                Utilisateur u = new Utilisateur();
                Trajet t = new Trajet();
                LigneTransport lt = new LigneTransport();
                MoyenTransport mt = new MoyenTransport();
                r.setId(rs.getInt("id"));
                u.setNom(rs.getString("nom"));
                mt.setType(rs.getString("type"));
                t.setDepart(rs.getString("depart"));
                t.setDestination(rs.getString("destination"));
                lt.setTrajet(t);
                lt.setMoyenTransport(mt);

                System.out.println("u :" + u.getNom());
                System.out.println("Moyentransport :" + lt.getMoyenTransport());
                System.out.println("Depart :" + lt.getTrajet().getDepart());
                System.out.println("destination :" + u.getNom());

                r.setUtilisateur(u);
                r.setLigne(lt);

                System.out.println("R" + r.toString());
                listRes.add(r);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return listRes;
    }

    public List<Reservation> afficherByID(int id_user) {
        System.out.println("begin Afficher");
        List<Reservation> listRes = new ArrayList<>();
        ServiceUtilisateur uService = new ServiceUtilisateur();
        System.out.println("begin Try");

        String qry = "SELECT  utilisateur.nom, moyen_transport.prix, trajet.depart, trajet.destination, ticket.id, ticket.dateticket, moyen_transport.type FROM ticket INNER JOIN utilisateur ON ticket.id_utilisateur = utilisateur.id INNER JOIN ligne_transport ON ticket.id_ligne = ligne_transport.id INNER JOIN trajet ON ligne_transport.id_trajet = trajet.id INNER JOIN moyen_transport ON ligne_transport.id_moyentp = moyen_transport.id where utilisateur.id=" + id_user;
        System.out.println("c bon taadet");
        try {
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while (rs.next()) {
                Reservation r = new Reservation();
                Utilisateur u = new Utilisateur();
                Trajet t = new Trajet();
                LigneTransport lt = new LigneTransport();
                MoyenTransport mt = new MoyenTransport();
                r.setId(rs.getInt("id"));
                u.setNom(rs.getString("nom"));
                mt.setType(rs.getString("type"));
                t.setDepart(rs.getString("depart"));
                t.setDestination(rs.getString("destination"));
                lt.setTrajet(t);
                lt.setMoyenTransport(mt);

                System.out.println("u :" + u.getNom());
                System.out.println("Moyentransport :" + lt.getMoyenTransport());
                System.out.println("Depart :" + lt.getTrajet().getDepart());
                System.out.println("destination :" + u.getNom());

                r.setUtilisateur(u);
                r.setLigne(lt);

                System.out.println("R" + r.toString());
                listRes.add(r);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return listRes;
    }
    
    
    
    
    
    

    public void findByIdUser() {
        //trajaaali reservations mtaa l user bel id mteou 
    }

 

    public Object getUtilisateur() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
