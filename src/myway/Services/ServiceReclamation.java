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
import myway.Entities.Reclamation;
import myway.Utils.MyDB;

/**
 *
 * @author 9naydel
 */
public class ServiceReclamation implements IServices<Reclamation> {

    Connection cnx;

    @Override
    public void add(Reclamation t) {
        try {
            String qry = "INSERT INTO reclamation( message, type,nom,prenom,categorie) VALUES ('" + t.getMessage() + "','" + t.getType() + "','" + t.getNom() + "','" + t.getPrenom() + "','" + t.getCategorie() + "')";
            cnx = MyDB.getInstance().getCnx();

            Statement stm = cnx.createStatement();

            stm.executeUpdate(qry);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public List<Reclamation> display() {
        List<Reclamation> Reclamation = new ArrayList<>();
        try {
            String qry = "SELECT * FROM Reclamation ";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while (rs.next()) {
                Reclamation p = new Reclamation();
                p.setId_rec(rs.getInt(1));
                p.setMessage(rs.getString("message"));
                p.setType(rs.getString(3));
                p.setNom(rs.getString(4));
                p.setPrenom(rs.getString(5));
                p.setCategorie(rs.getString(6));
                Reclamation.add(p);
            }
            return Reclamation;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return Reclamation;

    }

    @Override
    public void update(Reclamation t) {
        try {
            String qry = "UPDATE reclamation SET `message`= '" + t.getMessage() + "' ,`type`=' " + t.getType() + "' ,`nom`='  " + t.getNom() + "' ,`prenom`='  " + t.getPrenom() + "' ,`categorie`='  " + t.getCategorie() + "' WHERE `Id_rec`='" + t.getId_rec() + "'";
            cnx = MyDB.getInstance().getCnx();

            Statement stm = cnx.createStatement();

            stm.executeUpdate(qry);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void delete(Reclamation t) {
        try {
            String qry = "DELETE FROM reclamation WHERE `id_rec`='" + t.getId_rec() + "'";
            cnx = MyDB.getInstance().getCnx();

            Statement stm = cnx.createStatement();

            stm.executeUpdate(qry);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void supprimerByid(int tl) {
        try {
            String qry = "DELETE FROM reclamation WHERE id_rec='" + tl + "'";
            cnx = MyDB.getInstance().getCnx();

            Statement stm = cnx.createStatement();

            stm.executeUpdate(qry);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
