/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myway.Entities;

/**
 *
 * @author 9naydel
 */
public class MoyenTransport {
    private String matricule, organisation, type, icon, horaires;
    private int nbr_places;
    private double prix_ticket;

    public MoyenTransport() {
    }

    public MoyenTransport(String organisation, String type, String icone, String horaires, int nbr_places, double prix_ticket) {
        this.organisation = organisation;
        this.type = type;
        this.icon = icone;
        this.horaires = horaires;
        this.nbr_places = nbr_places;
        this.prix_ticket = prix_ticket;
    }

    public String getMatricule() {
        return matricule;
    }

    public String getOrganisation() {
        return organisation;
    }

    public String getType() {
        return type;
    }

    public String getIcon() {
        return icon;
    }

    public String getHoraires() {
        return horaires;
    }

    public int getNbr_places() {
        return nbr_places;
    }

    public double getPrix_ticket() {
        return prix_ticket;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public void setHoraires(String horaires) {
        this.horaires = horaires;
    }

    public void setNbr_places(int nbr_places) {
        this.nbr_places = nbr_places;
    }

    public void setPrix_ticket(double prix_ticket) {
        this.prix_ticket = prix_ticket;
    }

    @Override
    public String toString() {
        return "MoyenTransport{" + "matricule=" + matricule + ", organisation=" + organisation + ", type=" + type + ", icone=" + icon + ", horaires=" + horaires + ", nbr_places=" + nbr_places + ", prix_ticket=" + prix_ticket + '}';
    }
    
}
