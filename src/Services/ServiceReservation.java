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
//import java.sql.Date;

/**
 *
 * @author Slim
 */
public class ServiceReservation implements IServices<Reservation> {

    Connection cnx;

    /*
    public void add(Reservation r, Utilisateur u, LigneTransport l) {
        try {
            String qry = "INSERT INTO `reservation`( `id_utilisateur`,`id_ligne` `moyen_transport`, `disponibilite_r`) VALUES ('" + u.getId_utilisateur() + "','" + l.getId_ligne() + "','" + r.getMoyen_transport() + "','" + r.getDisponibilite_r() + "')";
            cnx = MyDB.getInstance().getCnx();

            Statement stm = cnx.createStatement();

            stm.executeUpdate(qry);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
 
    }
     */
    
    
    /*
    String query = "SELECT u.nom, mt.type, t.depart, t.destination "
            + "FROM reservation r "
            + "INNER JOIN utilisateur u ON r.utilisateur_id = u.id_utilisateur "
            + "INNER JOIN lignetransport lt ON r.ligne_id = lt.id_ligne "
            + "INNER JOIN moyentransport mt ON lt.moyentransport_id = mt.id_moyentransport "
            + "INNER JOIN trajet t ON lt.trajet_id = t.id_trajet";
    PreparedStatement statement = conn.prepareStatement(query);

    // Exécution de la requête SQL
    ResultSet resultSet = statement.executeQuery();

    // Création des colonnes du tableau
    TableColumn<Reservation, String> nomColumn = new TableColumn<>("Nom");

    nomColumn.setCellValueFactory (
    new PropertyValueFactory<>("nom"));
            TableColumn<Reservation, String> moyenTransportColumn = new TableColumn<>("Moyen de transport");

    moyenTransportColumn.setCellValueFactory (
    new PropertyValueFactory<>("moyenTransport"));
            TableColumn<Reservation, String> departColumn = new TableColumn<>("Départ");

    departColumn.setCellValueFactory (
    new PropertyValueFactory<>("depart"));
            TableColumn<Reservation, String> destinationColumn = new TableColumn<>("Destination");

    destinationColumn.setCellValueFactory (

    new PropertyValueFactory<>("destination"));

            // Ajout des colonnes au tableau
    tableView.getColumns ()

    .addAll(nomColumn, moyenTransportColumn, departColumn, destinationColumn);

            // Remplissage du tableau avec les données de la requête SQL
          
  
*/
    
    @Override
        public List<Reservation> afficher() {

        List<Reservation> listRes = new ArrayList<>();
        ServiceUtilisateur uService = new ServiceUtilisateur();
        try {


    String qry ="SELECT u.nom, mt.type, t.depart, t.destination \n" +
"            FROM reservation r \n" +
"            INNER JOIN utilisateur u ON r.id_utilisateur = u.id_utilisateur \n" +
"            INNER JOIN ligne_transport lt ON r.id_ligne = lt.id_ligne \n" +
"            INNER JOIN moyen_transport mt ON lt.id_moyentp = mt.id_moyentp\n" +
"            INNER JOIN trajet t ON lt.id_trajet = t.id_trajet";


            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while (rs.next()) {
                Reservation r = new Reservation();
                Utilisateur u = new Utilisateur();
                MoyenTransport mt = new MoyenTransport();
                Trajet t = new Trajet();
                LigneTransport lt = new LigneTransport();
                
                
                
                u.setNom(rs.getString(1));
               lt.getMoyentransport().setType(rs.getString(2));
                lt.getTrajet().setDepart(rs.getString(3));
                lt.getTrajet().setDestination(rs.getString(4));


//                r.getUtilisateur().setNom(rs.getString(1));
//                 //  lt.setMoyentransport().;
//                r.getLigne().getMoyentransport().setType(rs.getString(2));
//                r.getLigne().getTrajet().setDepart(rs.getString(3));
//                r.getLigne().getTrajet().setDestination(rs.getString(4));
                  System.out.println(r);
                listRes.add(r);
            }
            return listRes;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
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


}
