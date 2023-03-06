package gestionreservation;
import Services.ServiceReservation;
import Entities.Reservation;
import Utils.MyDB;
/**
 *
 * @author Slim
 */
public class GestionReservation {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        MyDB db =MyDB.getInstance();
        ServiceReservation sr = new ServiceReservation();
       /* Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, 2022);
            calendar.set(Calendar.MONTH, Calendar.DECEMBER);
            calendar.set(Calendar.DAY_OF_MONTH, 23);
            java.util.Date specifiedDate = calendar.getTime();
            Date sqlDate = new Date(specifiedDate.getTime());*/
       
     //  Reservation r= new Reservation("azz","dzd","zdd","zdzd");
    // Reservation r= new Reservation(1,"test test","non");

//      sr.add(r);

      System.out.println(sr.afficher());  
    //   sr.modifier(r);
     //  sr.supprimer(2);
       
        
    }

}
//SELECT* FROM `reservation` INNER JOIN `utilisateur` ON reservation.Id_utilisateur = utilisateur.Id_utilisateur; 