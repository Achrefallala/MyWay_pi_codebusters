/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myway.Services;

import myway.Entities.Etablissement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import myway.Entities.Trajet;
import myway.Utils.MyDB;


/**
 *
 * @author 9naydel
 */
public class ServiceEtablissement implements IServices<Etablissement> {

    Connection cnx;

    @Override
    public void add(Etablissement e) {
        try {
            String qry = "INSERT INTO `etablissement`( `nom`, `type`, `description`, `id_trajet`) VALUES ('" + e.getNom() + "','" + e.getType() + "','" + e.getDescription() + "','" + e.getTrajet().getId() + "')";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            stm.executeUpdate(qry);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public List<Etablissement> display() {
        List<Etablissement> etablissements = new ArrayList<>();
        try {
            String qry = "SELECT * FROM `etablissement` ";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while (rs.next()) {
                Etablissement e = new Etablissement();
                e.setId(rs.getInt("id"));
                e.setNom(rs.getString("nom"));
                e.setType(rs.getString("type"));
                e.setDescription(rs.getString("description"));
                
                ServiceTrajet st = new ServiceTrajet();
                e.setTrajet(st.findById(rs.getInt("id_trajet")));

                etablissements.add(e);
            }
            return etablissements;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return etablissements;

    }

    @Override
    public void update(Etablissement e) {
        try {
            String qry = "UPDATE etablissement SET " + "`nom` = '" + e.getNom() + "'" + ", `type` = '" + e.getType() + "'" + ", `description` = '" + e.getDescription() + "'" + ", `id_trajet` = '" + e.getTrajet().getId() + "'" + " WHERE id = " + e.getId();
            
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            stm.executeUpdate(qry);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public void delete(Etablissement e) {
        try {
            String qry = "DELETE FROM etablissement WHERE id = " + e.getId();
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            stm.executeUpdate(qry);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
    
    public Etablissement findById(int id) {
        Etablissement e = new Etablissement();
        try {
            String qry = "SELECT * FROM `etablissement` WHERE id = '" + id + "'";
            
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            
            while (rs.next()) {
  
                e.setId(rs.getInt("id"));
                e.setNom(rs.getString("nom"));
                e.setType(rs.getString("type"));
                e.setDescription(rs.getString("description"));
                
                ServiceTrajet st = new ServiceTrajet();
                e.setTrajet(st.findById(rs.getInt("id_trajet"))); 
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return e;

    }

    public List<Etablissement> findByName(String nom) {
        
        List<Etablissement> etablissements = new ArrayList<>();
        try {
            String qry = "SELECT * FROM `etablissement` WHERE nom = '" + nom + "'";
            
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            
            while (rs.next()) {
                Etablissement e = new Etablissement();
                e.setId(rs.getInt("id"));
                e.setNom(rs.getString("nom"));
                e.setType(rs.getString("type"));
                e.setDescription(rs.getString("description"));
                
                ServiceTrajet st = new ServiceTrajet();
                e.setTrajet(st.findById(rs.getInt("id_trajet")));
                
                etablissements.add(e);
            }
            return etablissements;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return etablissements;

    }
    
    public List<Etablissement> findByTrajet(Trajet trajet) {
        List<Etablissement> etablissements = new ArrayList<>();
        try {
            String qry = "SELECT * FROM `etablissement` WHERE id_trajet = '" + trajet.getId() + "'";
            
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            
            while (rs.next()) {
                Etablissement e = new Etablissement();
                e.setId(rs.getInt("id"));
                e.setNom(rs.getString("nom"));
                e.setType(rs.getString("type"));
                e.setDescription(rs.getString("description"));
                
                ServiceTrajet st = new ServiceTrajet();
                e.setTrajet(st.findById(rs.getInt("id_trajet")));
                
                etablissements.add(e);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return etablissements;

    }
    
    public Boolean exist(Etablissement e){
        Etablissement etab= new Etablissement();   
        try {
            String qry = "SELECT * FROM `etablissement` WHERE nom = '" + e.getNom() + "' AND id_trajet = '" + e.getTrajet().getId() +"'";
            
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            
            while (rs.next()) {
                etab.setNom(rs.getString("nom"));
            }
    
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            
        }
        return etab.getNom() != null;
        
    }

}
