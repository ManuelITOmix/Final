/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package polaka;

/**
 *
 * @author parti
 */
public class Operador
{  public String OPE;//operador que se esta representando
   public int PDP;//prioridad dentro de la pila
   public int PFP;//prioridad fuera de la pila
   public Operador(String ope,int pd,int pf){
   	     OPE=ope;
   	     PDP=pd;
   	     PFP=pf;
     }	
 
}