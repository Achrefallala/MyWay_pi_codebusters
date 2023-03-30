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
public interface IServices <R>{
    public void add(R r);
    public List<R> afficher();
   public void modifier(R r);
   public void supprimer(R r);
    
}
