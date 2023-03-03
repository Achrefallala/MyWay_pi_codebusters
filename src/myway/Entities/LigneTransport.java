/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myway.Entities;

/**
 *
 * @author 9naydel
 */
public class LigneTransport {
    private int id;
    private MoyenTransport moyenTransport;
    private Trajet trajet;

    public LigneTransport() {
    }

    public LigneTransport(MoyenTransport moyenTransport, Trajet trajet) {
        this.moyenTransport = moyenTransport;
        this.trajet = trajet;
    }

    public int getId() {
        return id;
    }

    public MoyenTransport getMoyenTransport() {
        return moyenTransport;
    }

    public Trajet getTrajet() {
        return trajet;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMoyenTransport(MoyenTransport moyenTransport) {
        this.moyenTransport = moyenTransport;
    }

    public void setTrajet(Trajet trajet) {
        this.trajet = trajet;
    }

    @Override
    public String toString() {
        return "LigneTransport{" + "id=" + id + ", moyenTransport=" + moyenTransport + ", trajet=" + trajet + '}';
    }
    
    
    
}
