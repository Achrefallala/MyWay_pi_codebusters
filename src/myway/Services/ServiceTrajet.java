/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myway.Services;


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
public class ServiceTrajet implements IServices<Trajet> {

    Connection cnx; 

    @Override
    public void add(Trajet t) {
        try {
            String qry = "INSERT INTO `trajet`( `depart`, `destination`, `etat`, `directions`, `image`) VALUES ('" + t.getDepart() + "','" + t.getDestination() + "','" + t.getEtat() + "','" + t.getDirections() + "','" + t.getImage() + "')";
            
            cnx = MyDB.getInstance().getCnx();
            
            Statement stm = cnx.createStatement();

            stm.executeUpdate(qry);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            
        }

    }

    @Override
    public List<Trajet> display() {
        List<Trajet> trajets = new ArrayList<>();
        try {
            String qry = "SELECT * FROM `trajet` ";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while (rs.next()) {
                Trajet t = new Trajet();
                t.setId(rs.getInt("id"));
                t.setDepart(rs.getString("depart"));
                t.setDestination(rs.getString("destination"));
                t.setEtat(rs.getString("etat"));
                t.setDirections(rs.getString("directions"));
                t.setImage(rs.getString("image"));
                trajets.add(t);
            }
            return trajets;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return trajets;

    }

    @Override
    public void update(Trajet t) {
        try {
            
            String qry = "UPDATE trajet SET " + "`depart` = '" + t.getDepart() + "'" + ", `destination` = '" + t.getDestination() + "'" + ", `etat` = \"" + t.getEtat() + "\"" + ", `directions` = \"" + t.getDirections() + "\"" + ", `image` = '" + t.getImage() + "'" + " WHERE id = " + t.getId();
            
            cnx = MyDB.getInstance().getCnx();

            Statement stm = cnx.createStatement();

            stm.executeUpdate(qry);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public void delete(Trajet t) {
        try {
            String qry = "DELETE FROM trajet WHERE id = " + t.getId();
            cnx = MyDB.getInstance().getCnx();

            Statement stm = cnx.createStatement();

            stm.executeUpdate(qry);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
    
    public Trajet findById(int id_trajet) {
        Trajet t = new Trajet();
        try {
            String qry = "SELECT * FROM `trajet` WHERE id = '" + id_trajet +"'";
            
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            
            while (rs.next()) {
                
                t.setId(rs.getInt("id"));
                t.setDepart(rs.getString("depart"));
                t.setDestination(rs.getString("destination"));
                t.setEtat(rs.getString("etat"));
                t.setDirections(rs.getString("directions"));
                t.setImage(rs.getString("image"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return t;

    }

    public Trajet findByDepartAndDestination(String depart, String destination) {
        Trajet t = new Trajet();
        try {
            String qry = "SELECT * FROM `trajet` WHERE depart = '" + depart + "' AND destination = '" + destination +"'";
            
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            
            while (rs.next()) {
                
                t.setId(rs.getInt("id"));
                t.setDepart(rs.getString("depart"));
                t.setDestination(rs.getString("destination"));
                t.setEtat(rs.getString("etat"));
                t.setDirections(rs.getString("directions"));
                t.setImage(rs.getString("image"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return t;

    }
    
    public Boolean exist(Trajet trajet){
        Trajet t= new Trajet();   
        try {
            
            String qry = "SELECT * FROM `trajet` WHERE depart = '" + trajet.getDepart() + "' AND destination = '"+ trajet.getDestination() + "'";
            
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            
            while (rs.next()) {
                t.setDepart(rs.getString("depart"));
            }
    
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            
        }
        if(t.getDepart() == null){
            return false;
        }else{
            return true;
        }
        
    }

}
