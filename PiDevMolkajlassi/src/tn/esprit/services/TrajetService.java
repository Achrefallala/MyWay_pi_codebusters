/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import tn.esprit.entity.Trajet;
import tn.esprit.tools.MaConnection;

/**
 *
 * @author Admin
 */
public class TrajetService implements InterfaceService<Trajet> {
    Connection cnx;
      public TrajetService() {
        cnx = MaConnection.getInstance().getCnx();
    }

    @Override
    public void ajouter(Trajet t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Trajet> getAll() {
         List<Trajet> m;
          m = new ArrayList<>();
           try {
            String sql;
            sql="select * from trajet";
            Statement ste = cnx.prepareStatement(sql);
            
            ResultSet rs= ste.executeQuery(sql);
            while(rs.next()){
                Trajet l =new Trajet(rs.getInt("id"),rs.getString("depart"),rs.getString("destination"),rs.getString("etat"),rs.getString("directions"),rs.getString("image"));
                m.add(l);
            }
        } catch (SQLException ex) {
        
            
        }
    return m;
    }

    @Override
    public List<Trajet> findByMatricule(String matricule) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Trajet> findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void supprimer(Trajet t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
