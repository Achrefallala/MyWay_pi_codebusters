
package myway.Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import myway.Entities.Utilisateur;
import myway.Utils.MyDB;

/**
 *

 */
public class ServiceUtilisateur implements IService<Utilisateur>{
    Connection cnx;
    @Override
    public void add(Utilisateur t) {
         try {
        String qry ="INSERT INTO `utilisateur`(`nom`, `prenom`, `num_tel`, `role`, `isActive`, `motdepasse`) VALUES ('"+t.getNom()+"','"+t.getPrenom()+"','"+t.getNum_tel()+"','"+t.getRole()+"','"+t.getIsActive()+"','"+t.getMotdepasse()+"')";
      cnx = MyDB.getInstance().getCnx();
      
            Statement stm =cnx.createStatement();
            
            stm.executeUpdate(qry);
            
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
    
    }

    @Override
    public List<Utilisateur> afficher() {
        List<Utilisateur> utilisateurs = new ArrayList<>();
        try {
            String qry ="SELECT * FROM `utilisateur` ";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while(rs.next()){
                Utilisateur p =new Utilisateur();
                p.setId(rs.getInt(1));
                p.setNom(rs.getString("nom"));
                p.setPrenom(rs.getString(3));
                p.setNum_tel(rs.getInt("num_tel"));
                p.setRole(rs.getString("role"));
                 p.setIsActive(rs.getBoolean("isActive"));
                 p.setMotdepasse(rs.getString("motdepasse"));
                utilisateurs.add(p);
            }
            return utilisateurs;
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return utilisateurs;
       
    }
  @Override
    public void modifier(Utilisateur t) {
         try {
        String qry ="UPDATE `utilisateur` SET `nom`='"+t.getNom()+"',`prenom`='"+t.getPrenom()+"',`num_tel`='"+t.getNum_tel()+"',`role`='"+t.getRole()+"',`isActive`='"+t.getIsActive()+"',`motdepasse`='"+t.getMotdepasse()+"' WHERE `id`='"+t.getId()+"'";
      cnx = MyDB.getInstance().getCnx();
      
            Statement stm =cnx.createStatement();
            
            stm.executeUpdate(qry);
            
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
    
    }
   

      @Override
    public void supprimer(Utilisateur t) {
       String qry = "DELETE FROM `utilisateur` WHERE `id`='"+t.getId()+"'";
        try {
            cnx = MyDB.getInstance().getCnx();
      
            Statement stm =cnx.createStatement();
            
            stm.executeUpdate(qry);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

   
    
   
   
}
