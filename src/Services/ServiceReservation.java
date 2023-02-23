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
import java.util.Date;

/**
 *
 * @author Slim
 */
public class ServiceReservation implements IServices<Reservation>{
    Connection cnx;
    @Override
    public void add(Reservation r) {
         try {
String qry ="INSERT INTO `reservation`(`id_utilisateur`, `moyen_transport`, `date_reservation` ,`prix_ticket` , `disponibilite_r`) VALUES ('"+r.getId_utilisateur()+"','"+r.getMoyen_transport()"','"+r.getDate_reservation+"','"+r.getPrix_ticket+"','"+r.getDisponibilite_r"')";
      cnx = MyDB.getInstance().getCnx();
      
            Statement stm =cnx.createStatement();
            
            stm.executeUpdate(qry);
            
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
    
    }

    @Override
    public List<Reservation> afficher() {
        List<Reservation> Reservations = new ArrayList<>();
        try {
            String qry ="SELECT * FROM `reservation` ";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while(rs.next()){
                Reservation r =new Reservation();
                r.setId_reservation(rs.getInt(11));
                r.setId_utilisateur(rs.getInt(11));
                r.setMoyen_transport(rs.getString(30));
                r.setDate_reservation(rs.getDate());
                r.setPrix_ticket(rs.getFloat(255));
                r.setDisponibilite_r(rs.getBoolean(3));
                Reservation.add(r);
            }
            return Reservations;
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return Reservations;
        
    }

   
    @Override
    public void modifier(Reservation r) {
 try {
            String qry ="UPDATE reservation SET date`='"+r.getDate_reservation()+"',disponibilite_r`='"+r.getDisponibilite_r()+"' WHERE id_reservation="+r.getId_reservation()+";";    
            cnx = MyDB.getInstance().getCnx();
      
            Statement stm =cnx.createStatement();
            
            stm.executeUpdate(qry);
            
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
        }

    //@Override
    public void supprimer(int ide) {
try {
            String qry ="DELETE from reservation where id_reservation = "+id_reservation+";";
      cnx = MyDB.getInstance().getCnx();
      
            Statement stm =cnx.createStatement();
            
            stm.executeUpdate(qry);
            
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }    }

    @Override
    public void supprimer(Reservation r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}
    

