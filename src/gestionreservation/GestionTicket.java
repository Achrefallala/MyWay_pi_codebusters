package gestionreservation;
import Entities.Ticket;
import Services.ServiceTicket;
import Utils.MyDB;
import Entities.Reservation;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Utils.MyDB;
import java.sql.Timestamp;
import java.util.Date;


/**
 *
 * @author Slim
 */
public class GestionTicket {
     public static void main(String[] args) {
        MyDB db =MyDB.getInstance();
        ServiceTicket st = new ServiceTicket();
       /* Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, 2022);
            calendar.set(Calendar.MONTH, Calendar.DECEMBER);
            calendar.set(Calendar.DAY_OF_MONTH, 23);
            java.util.Date specifiedDate = calendar.getTime();
            Date sqlDate = new Date(specifiedDate.getTime());*/
       //Ticket r= new Ticket(1,3.3f,"tunis","bizerte","20h30","22h");
         Ticket r= new Ticket(22,"modif","reussi","ok5","4z",6);

      // st.add(r);
  System.out.println(st.afficher());  
      st.modifier(r);
      //st.supprimer(4);

}
}
