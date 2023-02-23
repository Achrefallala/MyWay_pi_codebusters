package gestionreservation;
import Entities.Ticket;
import Services.ServiceTicket;
import Utils.MyDB;


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
         Ticket r= new Ticket(1,5.8798f,"modif","reussi","ok5","4z",1);

      // st.add(r);
  System.out.println(st.afficher());  
      st.modifier(r);
      //st.supprimer(4);

}
}
