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
import myway.Entities.Utilisateur;
import myway.Utils.MyDB;
import java.sql.PreparedStatement;

/**
 *
 * @author 9naydel
 */
public class ServiceUtilisateur  {

    Connection cnx;
    private Statement ste;

    
    public void add(Utilisateur t) {
        try {
            String qry = "INSERT INTO utilisateur(nom, prenom, e_mail, num_tel, motdepasse) VALUES ('" + t.getNom() + "','" + t.getPrenom() + "','" + t.getE_mail() + "','" + t.getNum_tel() + "','" + t.getMotdepasse() + "')";
            cnx = MyDB.getInstance().getCnx();

            Statement stm = cnx.createStatement();

            stm.executeUpdate(qry);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    
    public List<Utilisateur> afficher() {
        List<Utilisateur> utilisateurs = new ArrayList<>();
        try {
            String qry = "SELECT * FROM utilisateur ";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while (rs.next()) {
                Utilisateur p = new Utilisateur();
                p.setId(rs.getInt(1));
                p.setNom(rs.getString("nom"));
                p.setPrenom(rs.getString(3));
                p.setE_mail(rs.getString("e_mail"));
                p.setNum_tel(rs.getInt("num_tel"));
                // p.setIsActive(rs.getInt("isActive"));
                p.setIsActive(rs.getInt("isActive"));

                utilisateurs.add(p);
            }
            return utilisateurs;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return utilisateurs;

    }

    public List<Utilisateur> afficher2() {
        List<Utilisateur> utilisateurs = new ArrayList<>();
        try {
            String qry = "SELECT * FROM utilisateur ";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while (rs.next()) {
                Utilisateur p = new Utilisateur();

                p.setNum_tel(rs.getInt("num_tel"));
                p.setMotdepasse(rs.getString("motdepasse"));

                utilisateurs.add(p);
            }
            return utilisateurs;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return utilisateurs;

    }

    public List<Utilisateur> afficher3() {
        List<Utilisateur> utilisateurs = new ArrayList<>();
        try {
            String qry = "SELECT * FROM utilisateur WHERE isActive=0 ";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while (rs.next()) {
                Utilisateur p = new Utilisateur();

                p.setId(rs.getInt(1));
                p.setNom(rs.getString("nom"));
                p.setPrenom(rs.getString(3));
                p.setE_mail(rs.getString("e_mail"));
                p.setNum_tel(rs.getInt("num_tel"));
                // p.setIsActive(rs.getInt("isActive"));
                p.setIsActive(rs.getInt("isActive"));

                utilisateurs.add(p);
            }
            return utilisateurs;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return utilisateurs;

    }

    public List<Utilisateur> afficher4() {
        List<Utilisateur> utilisateurs = new ArrayList<>();
        try {
            String qry = "SELECT * FROM utilisateur WHERE isActive=1 ";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while (rs.next()) {
                Utilisateur p = new Utilisateur();

                p.setId(rs.getInt(1));
                p.setNom(rs.getString("nom"));
                p.setPrenom(rs.getString(3));
                p.setE_mail(rs.getString("e_mail"));
                p.setNum_tel(rs.getInt("num_tel"));
                // p.setIsActive(rs.getInt("isActive"));
                p.setIsActive(rs.getInt("isActive"));

                utilisateurs.add(p);
            }
            return utilisateurs;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return utilisateurs;

    }

    
    public void modifier(Utilisateur t) {
        try {
            String qry = "UPDATE utilisateur SET nom`='" + t.getNom() + "',prenom`='" + t.getPrenom() + "',`num_tel`='" + t.getNum_tel() + "',`role`='" + t.getRole() + "',`isActive`='" + t.getIsActive() + "',`motdepasse`='" + t.getMotdepasse() + "' WHERE `id`='" + t.getId() + "'";
            cnx = MyDB.getInstance().getCnx();

            Statement stm = cnx.createStatement();

            stm.executeUpdate(qry);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void modifier2(Utilisateur t) {

        //String sql = "UPDATE utilisateur SET num_tel= ?, motdepasse= ? WHERE id= ?";
        try {
            String qry = "UPDATE utilisateur SET num_tel ='" + t.getNum_tel() + "' ,e_mail ='" + t.getE_mail() + "',motdepasse ='" + t.getMotdepasse() + "' WHERE `id`='" + t.getId() + "'";
            cnx = MyDB.getInstance().getCnx();

            Statement stm = cnx.createStatement();

            stm.executeUpdate(qry);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    
    public void supprimer(Utilisateur t) {
        String qry = "UPDATE utilisateur SET isActive=0 WHERE `id`='" + t.getId() + "'";
        try {
            cnx = MyDB.getInstance().getCnx();

            Statement stm = cnx.createStatement();

            stm.executeUpdate(qry);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void supprimer2(Utilisateur t) {
        String qry = "UPDATE utilisateur SET isActive=1 WHERE `id`='" + t.getId() + "'";
        try {
            cnx = MyDB.getInstance().getCnx();

            Statement stm = cnx.createStatement();

            stm.executeUpdate(qry);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
    //update password where email
    public boolean updatePassword(String email, String password) {
        String sql = "UPDATE utilisateur SET motdepasse= ? WHERE e_mail= ?";
        try {
            cnx = MyDB.getInstance().getCnx();
            PreparedStatement statement = cnx.prepareStatement(sql);
            statement.setString(1, password);
            statement.setString(2, email);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing user was updated successfully!");
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public Utilisateur getUserById(int id) {
        String sql = "SELECT * FROM utilisateur WHERE id = ?";
        try {
            cnx = MyDB.getInstance().getCnx();
            PreparedStatement statement = cnx.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                Utilisateur user = new Utilisateur();
                user.setId(result.getInt(1));
                user.setNom(result.getString(2));
                user.setPrenom(result.getString(3));
                user.setE_mail(result.getString(4));
                user.setNum_tel(result.getInt(5));
                user.setRole(result.getString(6));
                user.setIsActive(result.getInt(7));
                user.setMotdepasse(result.getString(8));
                return user;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
