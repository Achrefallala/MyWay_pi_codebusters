/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Myway.Services;

import Myway.Entities.Reclamation;
import Myway.Entities.Reponse;
import Myway.Utils.MyDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mbark
 */
public class ServiceReponse implements IService<Reponse>{
     Connection cnx;
    @Override
    public void add(Reponse t) {
         try {
        String qry ="INSERT INTO `reponse`( `Id_rec`, `reponse`) VALUES ('"+t.getId_rec()+"','"+t.getReponse()+"')";
        cnx = MyDB.getInstance().getCnx();
      
            Statement stm =cnx.createStatement();
            
            stm.executeUpdate(qry);
            
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
    
    }
      @Override
    public List<Reponse> afficher() {
        List<Reponse> Reponse = new ArrayList<>();
        try {
            String qry ="SELECT * FROM `Reponse` ";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while(rs.next()){
                Reponse p =new Reponse();
                p.setId_reponse(rs.getInt(1));
                p.setId_rec(rs.getInt(2));
                p.setReponse(rs.getString("reponse"));
               // System.out.println(rs.getInt(1));
                Reponse.add(p);
            }
            return Reponse;
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return Reponse;
        
    }
     @Override
     public void modifier(Reponse t) {
        try {
        String qry ="UPDATE `reponse` SET `Id_rec`= '"+ t.getId_rec()+ "' ,`reponse`='  "+ t.getReponse() + "' WHERE `id_rep`='"+t.getId_reponse()+"'";
        cnx = MyDB.getInstance().getCnx();
      
            Statement stm =cnx.createStatement();
            
            stm.executeUpdate(qry);
            
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
      }
     @Override
       public void supprimer(Reponse t) {
               try {
        String qry ="DELETE FROM `reponse` WHERE `id_rep`='" + t.getId_reponse()+ "'";
        cnx = MyDB.getInstance().getCnx();
      
            Statement stm =cnx.createStatement();
            
            stm.executeUpdate(qry);
            
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        } 
         }
         public void supprimerByid(int tl) {
        try {
        String qry ="DELETE FROM `reponse` WHERE id_rep='" + tl+ "'";
        cnx = MyDB.getInstance().getCnx();
      
            Statement stm =cnx.createStatement();
            
            stm.executeUpdate(qry);
            
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        } 
         }
    
    
}
