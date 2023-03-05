package workshop3a24.Entities;

import java.sql.Date;

/**
 *
 * @author Mohamed
 */
public class contrat_location {
    //private Location location;
    private int id_location ;
 Float prix;
    Date debut ,fin;

    public contrat_location(Float prix, Date debut, Date fin) {
        this.prix = prix;
        this.debut = debut;
        this.fin = fin;
    }
    

    public int getId_location() {
        return id_location;
    }

    public void setId_location(int id_location) {
        this.id_location = id_location;
    }
    
    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    public Date getDebut() {
        return debut;
    }

    public void setDebut(Date debut) {
        this.debut = debut;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    public contrat_location() {
    }

    public contrat_location(int id_location, Float prix, Date debut, Date fin) {
        this.id_location = id_location;
        this.prix = prix;
        this.debut = debut;
        this.fin = fin;
    }

    @Override
    public String toString() {
        return "contrat_location{" + "id_location=" + id_location + ", prix=" + prix + ", debut=" + debut + ", fin=" + fin + '}';
    }
    

      
}

