/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myway;

/**
 *

 */
public class A {
   
    private static A instance;
    private A(){
        
    }
    
  public static  A getInstance (){
      if(instance == null)
          instance = new A();
        return instance;
    }
}
