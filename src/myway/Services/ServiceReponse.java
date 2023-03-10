/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myway.Services;

import myway.Entities.Reponse;
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
public class ServiceReponse implements IServices<Reponse> {

    Connection cnx;

    @Override
    public void add(Reponse t) {
        try {
            String qry = "INSERT INTO reponse( Id_rec, reponse) VALUES ('" + t.getId_rec() + "','" + t.getReponse() + "')";
            System.out.println(qry);

            cnx = MyDB.getInstance().getCnx();

            Statement stm = cnx.createStatement();

            stm.executeUpdate(qry);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public List<Reponse> display() {
        List<Reponse> Reponse = new ArrayList<>();
        try {
            String qry = "SELECT * FROM Reponse ";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while (rs.next()) {
                Reponse p = new Reponse();
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
    public void update(Reponse t) {
        try {
            String qry = "UPDATE reponse SET Id_rec`= '" + t.getId_rec() + "' ,reponse`='  " + t.getReponse() + "' WHERE `id_rep`='" + t.getId_reponse() + "'";
            cnx = MyDB.getInstance().getCnx();

            Statement stm = cnx.createStatement();

            stm.executeUpdate(qry);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void delete(Reponse t) {
        try {
            String qry = "DELETE FROM reponse WHERE `id_rep`='" + t.getId_reponse() + "'";
            cnx = MyDB.getInstance().getCnx();

            Statement stm = cnx.createStatement();

            stm.executeUpdate(qry);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void supprimerByid(int tl) {
        try {
            String qry = "DELETE FROM reponse WHERE id_rep='" + tl + "'";
            cnx = MyDB.getInstance().getCnx();

            Statement stm = cnx.createStatement();

            stm.executeUpdate(qry);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
