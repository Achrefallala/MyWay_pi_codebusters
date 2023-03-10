/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package myway.Services;

import java.util.List;

/**
 *
 * @author 9naydel
 * @param <T>
 */
public interface IServices<T> {
    public void add(T t);
    public List<T> display();
    public void update(T t);
    public void delete(T t);
   
}
