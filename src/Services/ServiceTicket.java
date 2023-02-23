/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entities.Reservation;
import Entities.Ticket;
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
public class ServiceTicket implements IServices<Ticket>{
Connection cnx = MyDB.getInstance().getCnx();

    @Override
    public void add(Ticket r) {
             try {
            String qry ="UPDATE `ticket` SET ,`prix_ticket`='"+r.getPrix_ticket()+"',`lieu_depart`='"+r.getLieu_depart()+"',`lieu_arrive`='"+r.getLieu_arrive()+"',`heure_depart`='"+r.getHeure_depart()+"',`heure_arrive`='"+r.getHeure_arrive()+"',`id_ticket`='"+r.getId_ticket()+"' WHERE `id_reservation`='"+r.getId_reservation()+"'";
      
            Statement stm =cnx.createStatement();
            
            stm.executeUpdate(qry);
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        
    }

    }

    @Override
    public List<Ticket> afficher() {
         List<Ticket> Tickets = new ArrayList<>();
        try {
            String qry ="SELECT * FROM `ticket`";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while(rs.next()){
                Ticket r =new Ticket();
                r.setId_reservation(rs.getInt(1));
                r.setPrix_ticket(rs.getFloat(2));
                r.setLieu_depart(rs.getString(3));
                r.setLieu_arrive(rs.getString(4));
                r.setHeure_depart(rs.getString(5));
                r.setHeure_arrive(rs.getString(6));
                r.setId_ticket(rs.getInt(6));


                Tickets.add(r);
            }
            return Tickets;
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return Tickets;
        
    }

    @Override
    public void modifier(Ticket r) {
        try {
            String qry ="UPDATE ticket SET prix_ticket`='"+r.getPrix_ticket()+"',lieu_depart`='"+r.getLieu_depart()+"',lieu_arrive`='"+r.getLieu_arrive()+"'heure_depart`='"+r.getHeure_depart()+"',heure_arrive`='"+r.getHeure_arrive()+"', id_reservation="+r.getId_reservation()+" WHERE`id_ticket`="+r.getId_ticket()+"'";    
            cnx = MyDB.getInstance().getCnx();
            Statement stm =cnx.createStatement();
            stm.executeUpdate(qry);
            
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
    }

    public void supprimer(int id_ticket) {
       try {
            String qry ="DELETE from ticket where id_ticket = "+id_ticket+";";
      cnx = MyDB.getInstance().getCnx();
      
            Statement stm =cnx.createStatement();
            
            stm.executeUpdate(qry);
            
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }   
    }

    @Override
    public void supprimer(Ticket r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
}
