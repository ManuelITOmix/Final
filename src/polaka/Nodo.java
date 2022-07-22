/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package polaka;

/**
 *
 * @author parti
 */
public class Nodo{
/*****Propiedades**************/	
  	 public Object datos; 
     public Nodo siguiente;
     public Nodo anterior;
/*****Constructores************/	 
	public  Nodo (Object valor){ 
	 	datos =valor;
	  	siguiente =anterior= null;
	 }
/*****Inicio***METODOS*********/	 
	 public Object getElemento(){return datos;}
	 public Nodo getSig(){return siguiente;}
	 public Nodo getAnt(){return anterior; }
/*****Fin******METODOS*********/	 
}
 
