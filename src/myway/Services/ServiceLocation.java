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
import myway.Entities.Location;
import myway.Utils.MyDB;


/**
 *
 * @author 9naydel
 */
public class ServiceLocation {

    Connection cnx;

    public void add(Location l) {
        try {
            String qry = "INSERT INTO `location`( nom, disponibilite, type,`description`) VALUES ('" + l.getNom() + "','" + l.getDisponibilite() + "','" + l.getType() + "', '" + l.getDescription() + "')";
            
            cnx = MyDB.getInstance().getCnx();

            Statement stm = cnx.createStatement();

            stm.executeUpdate(qry);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public List<Location> afficher() {
        List<Location> locations = new ArrayList<>();
        try {
            String qry = "SELECT * FROM location ";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while (rs.next()) {
                Location l = new Location();
                l.setId(rs.getInt(1));
                l.setNom(rs.getString("nom"));
                l.setDisponibilite(rs.getString(3));
                l.setType(rs.getString("type"));
                l.setDescription(rs.getString(5));
                locations.add(l);
            }
            return locations;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return locations;

    }

    public void modifier(Location l) {

        try {
            String qry = "UPDATE location SET  nom= '" + l.getNom() + "' , disponibilite='  " + l.getDisponibilite() + "',  type= '" + l.getType() + "' ,  description= '" + l.getDescription() + "'    WHERE `id_location`='" + l.getId() + "'";
            
            cnx = MyDB.getInstance().getCnx();

            Statement stm = cnx.createStatement();

            stm.executeUpdate(qry);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void supprimer(Location l) {
        try {
            String qry = "DELETE FROM location WHERE id_location='" + l.getId() + "'";
            cnx = MyDB.getInstance().getCnx();

            Statement stm = cnx.createStatement();

            stm.executeUpdate(qry);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void supprimerBYid(int l) {
        try {
            String qry = "DELETE FROM location WHERE id_location='" + l + "'";
            cnx = MyDB.getInstance().getCnx();

            Statement stm = cnx.createStatement();

            stm.executeUpdate(qry);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
