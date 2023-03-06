/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.MoyenTransport;
import Entities.Ticket;
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
//    private int id_ticket;
//    private Utilisateur utilisateur; // ID UTILISATEUR
//    private MoyenTransport moyentransport;//matricule
////prix_ticket
//    private Date dateticket;
    Connection cnx = MyDB.getInstance().getCnx();
 
       Utilisateur u = new Utilisateur();
    MoyenTransport m = new MoyenTransport();
    
    static final String UPDATE_ = "UPDATE `ticket` SET `id_ticket` =?, `u.id_utilisateur` = ?, `m.moyentransport` = ?, `dateticket` = ?,  WHERE `ticket`.`id_ticket` = ?";

    
    @Override
    public List<Ticket> afficher() {
  List<Ticket> Tickets = new ArrayList<>();
//      
//        try {
//            String qry = "SELECT id_ticket,u.id_utilisateur,m.moyentransport,dateticket FROM `ticket`";
//            cnx = MyDB.getInstance().getCnx();
//            Statement stm = cnx.createStatement();
//            ResultSet rs = stm.executeQuery(qry);
//            while (rs.next()) {
//                Ticket r = new Ticket();
//                r.setId_reservation(rs.getInt(1));
//                r.setPrix_ticket(rs.getInt(2));
//                r.setLieu_depart(rs.getString(3));
//                r.setLieu_arrive(rs.getString(4));
//                r.setHeure_depart(rs.getString(5));
//                r.setHeure_arrive(rs.getString(6));
//                r.setId_ticket(rs.getInt(7));
//
//                Tickets.add(r);
//            }
//            return Tickets;
//
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
      return Tickets;

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
    public void supprimer(int id_ticket) {
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
