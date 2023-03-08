
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
     private Statement ste;
    
    @Override
    public void add(Utilisateur t) {
         try {
        String qry ="INSERT INTO `utilisateur`(`nom`, `prenom`, `e_mail`, `num_tel`, `motdepasse`) VALUES ('"+t.getNom()+"','"+t.getPrenom()+"','"+t.getE_mail()+"','"+t.getNum_tel()+"','"+t.getMotdepasse()+"')";
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
            String qry ="SELECT * FROM `utilisateur` ";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while(rs.next()){
                Utilisateur p =new Utilisateur();
                
         
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
            String qry ="SELECT * FROM `utilisateur` WHERE isActive=0 ";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while(rs.next()){
                Utilisateur p =new Utilisateur();
                
         
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
            String qry ="SELECT * FROM `utilisateur` WHERE isActive=1 ";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while(rs.next()){
                Utilisateur p =new Utilisateur();
                
         
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
    
    public void modifier2( Utilisateur t) {
         
        //String sql = "UPDATE `utilisateur` SET num_tel= ?, motdepasse= ? WHERE id= ?";
        try {
            String qry ="UPDATE `utilisateur` SET `num_tel`='"+t.getNum_tel()+"' ,`e_mail`='"+t.getE_mail()+"',`motdepasse`='"+t.getMotdepasse()+"' WHERE `id`='"+t.getId()+"'";
      cnx = MyDB.getInstance().getCnx();
      
            Statement stm =cnx.createStatement();
            
            
            
            stm.executeUpdate(qry);
            
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
    
    }

      @Override
    public void supprimer(Utilisateur t) {
       String qry = "UPDATE `utilisateur` SET isActive=0 WHERE `id`='"+t.getId()+"'";
        try {
            cnx = MyDB.getInstance().getCnx();
      
            Statement stm =cnx.createStatement();
            
            stm.executeUpdate(qry);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

       
    public void supprimer2(Utilisateur t) {
       String qry = "UPDATE `utilisateur` SET isActive=1 WHERE `id`='"+t.getId()+"'";
        try {
            cnx = MyDB.getInstance().getCnx();
      
            Statement stm =cnx.createStatement();
            
            stm.executeUpdate(qry);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    /*public Utilisateur login(String email, String password) throws SQLException {
        Utilisateur p = new Utilisateur();
        try {
            String nom = null;
            String prenom = null;
            String sql = "SELECT * from Utilisateur WHERE nom ='" + nom + "' AND prenom='" + prenom + "'";

            PreparedStatement ps = cnx.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(sql);
            if (rs.next() == true) {
                int id = rs.getInt(1);
                String Username = rs.getString(2);
                String Email = rs.getString(3);
                String Password = rs.getString(4);
                String role = rs.getString(5);
                String Img = rs.getString(6);
                p = new Utilisateur( nom, prenom);
                System.out.println(" |||  user  authentifié  |||");
                System.out.println(p);
              
            } else {
                System.out.println("non trouvé");
            }
            

        } catch (SQLException ex) {
            Logger.getLogger(IService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;*/

   
}
    

   
   

