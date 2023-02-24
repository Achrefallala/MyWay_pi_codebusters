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
            String qry = "INSERT INTO `etablissement`( `nom`, `type`, `id_trajet`) VALUES ('" + e.getNom() + "','" + e.getType() + "','" + e.getId_trajet() + "')";
            cnx = MyDB.getInstance().getCnx();

            Statement stm = cnx.createStatement();

            stm.executeUpdate(qry);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public List<Etablissement> afficher() {
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
                e.setId_trajet(rs.getInt("id_trajet"));

                etablissements.add(e);
            }
            return etablissements;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return etablissements;

    }

    @Override
    public void modifier(Etablissement e, String colonne, String valeur) {
        try {
            String qry = "UPDATE etablissement SET " + "`" + colonne + "` = " + "'" + valeur + "'" + " WHERE id = " + e.getId();
            System.out.println(qry);
            cnx = MyDB.getInstance().getCnx();

            Statement stm = cnx.createStatement();

            stm.executeUpdate(qry);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public void supprimer(Etablissement e) {
        try {
            String qry = "DELETE FROM etablissement WHERE id = " + e.getId();
            cnx = MyDB.getInstance().getCnx();

            Statement stm = cnx.createStatement();

            stm.executeUpdate(qry);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public Etablissement findByName(String nom) {
        Etablissement e = new Etablissement();
        try {
            String qry = "SELECT * FROM `etablissement` WHERE nom = '" + nom + "'";
            
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            
            while (rs.next()) {
  
                e.setId(rs.getInt("id"));
                e.setNom(rs.getString("nom"));
                e.setType(rs.getString("type"));
                e.setId_trajet(rs.getInt("id_trajet"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return e;

    }
    
    public List<Etablissement> findById_trajet(int id_trajet) {
        List<Etablissement> etablissements = new ArrayList<>();
        try {
            String qry = "SELECT * FROM `etablissement` WHERE id_trajet = '" + id_trajet + "'";
            
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            
            while (rs.next()) {
                Etablissement e = new Etablissement();
                e.setId(rs.getInt("id"));
                e.setNom(rs.getString("nom"));
                e.setType(rs.getString("type"));
                e.setId_trajet(rs.getInt("id_trajet"));
                etablissements.add(e);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return etablissements;

    }

}
