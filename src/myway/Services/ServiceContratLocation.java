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
import myway.Entities.contrat_location;
import myway.Utils.MyDB;


/**
 *
 * @author 9naydel
 */
public class ServiceContratLocation  {

    Connection cnx;


    public void add(contrat_location cl) {
        try {
            String qry = "INSERT INTO contrat_location( id_location, prix, date_debut, date_fin) VALUES ('" + cl.getId_location() + "','" + cl.getPrix() + "','" + cl.getDebut() + "', '" + cl.getFin() + "')";
            cnx = MyDB.getInstance().getCnx();

            Statement stm = cnx.createStatement();

            stm.executeUpdate(qry);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    
    public List<contrat_location> afficher() {
        List<contrat_location> ContratLocations = new ArrayList<>();
        try {
            String qry = "SELECT * FROM Contrat_Location ";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while (rs.next()) {
                contrat_location cl = new contrat_location();
                cl.setId_location(rs.getInt(1));
                cl.setPrix(rs.getFloat("prix"));
                cl.setDebut(rs.getDate(3));
                cl.setFin(rs.getDate("date_fin"));

                ContratLocations.add(cl);
            }
            return ContratLocations;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return ContratLocations;

    }

    public List<contrat_location> afficherBYIDLocation(int i) {
        List<contrat_location> ContratLocations = new ArrayList<>();
        try {
            String qry = "SELECT * FROM Contrat_Location WHERE `id_location`=" + i + " ";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while (rs.next()) {
                contrat_location cl = new contrat_location();
                cl.setId_location(rs.getInt(1));
                cl.setPrix(rs.getFloat("prix"));
                cl.setDebut(rs.getDate(3));
                cl.setFin(rs.getDate("date_fin"));

                ContratLocations.add(cl);
            }
            return ContratLocations;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return ContratLocations;

    }

    
    public void modifier(contrat_location cl) {

        try {
            String qry = "UPDATE contrat_location SET  prix= '" + cl.getPrix() + "' , date_debut='  " + cl.getDebut() + "',  date_fin= '" + cl.getFin() + "'    WHERE id_location='" + cl.getId_location() + "'";
            cnx = MyDB.getInstance().getCnx();

            Statement stm = cnx.createStatement();

            stm.executeUpdate(qry);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    
    public void supprimer(contrat_location cl) {
        try {
            String qry = "DELETE FROM contrat_location WHERE id_location='" + cl.getId_location() + "'";
            cnx = MyDB.getInstance().getCnx();

            Statement stm = cnx.createStatement();

            stm.executeUpdate(qry);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void supprimerByid(int cl) {
        try {
            String qry = "DELETE FROM contrat_location WHERE id_location='" + cl + "'";
            cnx = MyDB.getInstance().getCnx();

            Statement stm = cnx.createStatement();

            stm.executeUpdate(qry);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
