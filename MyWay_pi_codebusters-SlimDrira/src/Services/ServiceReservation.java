package Services;

import Entities.LigneTransport;
import Entities.MoyenTransport;
import Entities.Reservation;
import Entities.Trajet;
import Entities.Utilisateur;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Utils.MyDB;
import sun.util.logging.resources.logging;
//import java.sql.Date;

/**
 *
 * @author Slim
 */
public class ServiceReservation implements IServices<Reservation> {

    Connection cnx;

    @Override
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
                lt.setMoyentransport(mt);

                System.out.println("u :" + u.getNom());
                System.out.println("Moyentransport :" + lt.getMoyentransport());
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

    public List<Reservation> afficherByID(int id_ligne) {
        System.out.println("begin Afficher");
        List<Reservation> listRes = new ArrayList<>();
        ServiceUtilisateur uService = new ServiceUtilisateur();
        System.out.println("begin Try");

        String qry = "SELECT  utilisateur.nom, moyen_transport.prix, trajet.depart, trajet.destination, ticket.id, ticket.dateticket, moyen_transport.type FROM ticket INNER JOIN utilisateur ON ticket.id_utilisateur = utilisateur.id INNER JOIN ligne_transport ON ticket.id_ligne = ligne_transport.id INNER JOIN trajet ON ligne_transport.id_trajet = trajet.id INNER JOIN moyen_transport ON ligne_transport.id_moyentp = moyen_transport.id where ligne_transport.id=" + id_ligne;
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
                lt.setMoyentransport(mt);

                System.out.println("u :" + u.getNom());
                System.out.println("Moyentransport :" + lt.getMoyentransport());
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
    
    
    
    /*  public ObservableList<Reservation> getDataRes() {
        ObservableList<Reservation> list = FXCollections.observableArrayList();
        try {
            String qry = "SELECT * FROM reservation";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);

            while (rs.next()) {
                Reservation reservation = new Reservation(rs.getInt("id_reservation"),
                        rs.getInt("id_utilisateur"), rs.getString("moyen_transport"),
                        rs.getString("disponibilite_r"));
                list.add(reservation);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return list;

    }*/
 /* @Override
    public void modifier(Reservation r) {
        try {
            String qry = "UPDATE reservation SET moyen_transport='" + r.getMoyen_transport() + "',disponibilite_r='" + r.getDisponibilite_r() + "' WHERE `id_reservation`=" + r.getId_reservation() + " ;";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            stm.executeUpdate(qry);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void supprimer(int id_reservation) {
        try {
            String qry = "DELETE from reservation where id_reservation = " + id_reservation + ";";
            cnx = MyDB.getInstance().getCnx();

            Statement stm = cnx.createStatement();

            stm.executeUpdate(qry);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }*/

 /*  public List<String> afficherNOM() {
        List<String> Reservations = new ArrayList<>();
        try {
            String qry = "SELECT nom  FROM `utilisateur`";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while (rs.next()) {
                String r = null;
                r = rs.getString(1);

                Reservations.add(r);
            }
            return Reservations;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return Reservations;

    }*/
    @Override
    public void supprimer(Reservation r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(Reservation r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void findByIdUser() {
        //trajaaali reservations mtaa l user bel id mteou 
    }

    @Override
    public void modifier(Reservation r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object getUtilisateur() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
