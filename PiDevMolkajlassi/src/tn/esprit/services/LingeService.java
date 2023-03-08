/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import tn.esprit.entity.Linge;
import tn.esprit.entity.Moyentp;
import tn.esprit.tools.MaConnection;

/**
 *
 * @author Admin
 */
public class LingeService implements InterfaceService<Linge>{
    Connection cnx;
      public LingeService() {
        cnx = MaConnection.getInstance().getCnx();
    }
    @Override
    public void ajouter(Linge t) {
        try {
            String sql;
            sql = "insert into ligne (id,id_moyentp,id_trajet) values (?,?,?)";
            PreparedStatement ste = cnx.prepareStatement(sql);
            ste.setInt(1, t.getId());
            ste.setString(2, t.getId_moyentp());
            ste.setInt(3, t.getId_trajet());
           
      
            ste.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     *
     * @return
     */
    @Override
    public List<Linge> getAll() {
       List<Linge> m;
        m = new ArrayList<>();
        try {
            String sql;
            sql="select * from ligne";
            Statement ste = cnx.prepareStatement(sql);
            
            ResultSet rs= ste.executeQuery(sql);
            while(rs.next()){
                Linge l =new Linge(rs.getInt("id"),rs.getString("id_moyentp"),rs.getInt("id_trajet"));
                m.add(l);
            }
        } catch (SQLException ex) {
        
            
        }
    return m;
    }

    @Override
    public List<Linge> findByMatricule(String matricule) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void supprimer(Linge t) {
        try {
            String sql="delete from ligne where id=?";
            PreparedStatement ste = cnx.prepareStatement(sql);
            ste.setInt(1, t.getId());
            ste.executeUpdate();
        } catch (SQLException ex) {
           System.out.println(ex.getMessage());
        }
    }
public void modifier(int id_trajet,Linge l) {
        String sql = "update ligne set id_trajet=? where id=?";
        try {
            PreparedStatement ste = cnx.prepareStatement(sql);
            
            ste.setInt(1,id_trajet);
            ste.setInt(2,l.getId());
            ste.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
    @Override
    public List<Linge> findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
