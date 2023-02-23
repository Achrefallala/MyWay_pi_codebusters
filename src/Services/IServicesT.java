/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;
import java.util.List;
/**
 *
 * @author Slim
 */
public interface IServicesT<T> {
    public void add(T r);
    public List<T> afficher();
    public void modifier(T r);
    public void supprimer(T r);
    
}
