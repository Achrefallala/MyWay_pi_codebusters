package Services;

import Entities.Reservation;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Utils.MyDB;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;
//import java.sql.Date;

/**
 *
 * @author Slim
 */
public class ServiceReservation implements IServices<Reservation> {

    Connection cnx;

    @Override
    public void add(Reservation r) {
        try {
            String qry = "INSERT INTO `reservation`( `id_utilisateur`, `moyen_transport`, `disponibilite_r`) VALUES ('" + r.getId_utilisateur() + "','" + r.getMoyen_transport() + "','" + r.getDisponibilite_r() + "')";
            cnx = MyDB.getInstance().getCnx();

            Statement stm = cnx.createStatement();

            stm.executeUpdate(qry);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public List<Reservation> afficher() {
        List<Reservation> Reservations = new ArrayList<>();
        try {
            String qry = "SELECT * FROM `reservation`";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while (rs.next()) {
                Reservation r = new Reservation();
                r.setId_reservation(rs.getInt(1));
                r.setId_utilisateur(rs.getInt(2));
                r.setMoyen_transport(rs.getString(3));
                r.setDisponibilite_r(rs.getString(4));
                Reservations.add(r);
            }
            return Reservations;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return Reservations;

    }

    public ObservableList<Reservation> getDataRes() {
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

    }

    @Override
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
    }

    @Override
    public void supprimer(Reservation r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
