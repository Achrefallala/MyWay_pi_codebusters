/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.LigneTransport;
import Entities.MoyenTransport;
import Entities.Reservation;
import Entities.Ticket;
import Entities.Trajet;
import Entities.Utilisateur;
import Utils.MyDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Slim
 */
public class ServiceTicket implements IServicesT<Ticket> {

    Connection cnx = MyDB.getInstance().getCnx();

    @Override
    public List<Ticket> afficher() {
        System.out.println("begin Afficher");

        List<Ticket> listTic = new ArrayList<>();
        ServiceUtilisateur uService = new ServiceUtilisateur();
        System.out.println("begin Try");

        String qry = "SELECT ticket.id, utilisateur.nom, moyen_transport.prix, trajet.depart, trajet.destination, ticket.dateticket, moyen_transport.type FROM ticket INNER JOIN utilisateur ON ticket.id_utilisateur = utilisateur.id INNER JOIN ligne_transport ON ticket.id_ligne = ligne_transport.id INNER JOIN trajet ON ligne_transport.id_trajet = trajet.id INNER JOIN moyen_transport ON ligne_transport.id_moyentp = moyen_transport.id;";

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
                Ticket tic = new Ticket();
                tic.setId(rs.getInt("id"));
                u.setNom(rs.getString("nom"));
                mt.setPrix(rs.getDouble("prix"));
                t.setDepart(rs.getString("depart"));
                t.setDestination(rs.getString("destination"));

                tic.setDateticket(rs.getDate("dateticket"));
                mt.setType(rs.getString("type"));

                lt.setTrajet(t);
                lt.setMoyentransport(mt);
                tic.setUtilisateur(u);
                tic.setLigne(lt);
                tic.setReservation(r);
                System.out.println("nom :" + u.getNom());
                System.out.println("prix :" + mt.getPrix());
                System.out.println("Depart :" + lt.getTrajet().getDepart());
                System.out.println("Depart :" + lt.getTrajet().getDestination());
                System.out.println("Date Ticket :" + tic.getDateticket());
                System.out.println("Type :" + mt.getType());

                r.setUtilisateur(u);
                r.setLigne(lt);
                

                System.out.println("R" + r.toString());
                listTic.add(tic);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return listTic;
    }

    /* public void modifier(Ticket r) {
        try {
            cnx = MyDB.getInstance().getCnx();
            PreparedStatement pst = cnx.prepareStatement(UPDATE_);
            pst.setFloat(1, r.getPrix_ticket());
            pst.setString(2, r.getLieu_depart());
            pst.setString(3, r.getLieu_arrive());
            pst.setString(4, r.getHeure_depart());
            pst.setString(5, r.getHeure_arrive());
            pst.setInt(6, r.getId_ticket());

            // String qry ="UPDATE ticket SET prix_ticket`='"+r.getPrix_ticket()+"',lieu_depart`='"+r.getLieu_depart()+"',lieu_arrive`='"+r.getLieu_arrive()+"'heure_depart`='"+r.getHeure_depart()+"',heure_arrive`='"+r.getHeure_arrive()+"', id_reservation="+r.getId_reservation()+" WHERE`ticket`.`id_ticket`="+r.getId_ticket()+"'";    
            // Statement stm =cnx.createStatement();
            pst.executeUpdate();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
     */
    public void supprimer(int id) {
//        try {
//            String qry = "DELETE from ticket where id_ticket = " + id_ticket + ";";
//            cnx = MyDB.getInstance().getCnx();
//
//            Statement stm = cnx.createStatement();
//
//            stm.executeUpdate(qry);
//
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
    }

    @Override
    public void supprimer(Ticket r) {
//        try {
//            String qry = "DELETE from ticket where id_ticket = " + r.getId_ticket() + ";";
//            cnx = MyDB.getInstance().getCnx();
//
//            Statement stm = cnx.createStatement();
//
//            stm.executeUpdate(qry);
//
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
    }

    /* public List<Integer> afficherIDRESERVATION() {
        List<Integer> Tickets = new ArrayList<>();
        try {
            String qry = "SELECT id_reservation  FROM `reservation`";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while (rs.next()) {
                int r = 1;
                r=rs.getInt(1);
                
                Tickets.add(r);
            }
            return Tickets;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return Tickets;

    }*/
    @Override
    public void add(Ticket r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modifier(Ticket r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
