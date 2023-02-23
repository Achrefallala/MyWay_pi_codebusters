/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop3a24.Services;

import java.util.List;

/**
 *
 * @author Mohamed
 */
public interface IService<T> {
    public void add(T l);
    public List<T> afficher();
    public void modifier(T l);
    public void supprimer(T l);
    
}
