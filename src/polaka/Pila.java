/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package polaka;

/**
 *
 * @author parti
 */
public class Pila{
    public Nodo tope;   
	public Pila(){
		tope=null;
	}
	public boolean vacia (){
	 	return tope == null;//==hace la compararcion de primernodo con null 
	 }
	public void apilar(Object dato){
		     Nodo p=new Nodo(dato);
		     p.datos=dato;
		     p.siguiente=tope; 
		     tope=p;
	  }
    public Object desApilar(){
    	     //if(vacia()) return ' ';
    	     Object dat;   
    	     Nodo p=tope;
    	     dat=p.datos;  
		     tope=tope.siguiente;
		     p=null;
		     return dat;
	  }	 
    public void imprimir(){
	 	if (vacia()){
			System.out.println("La pila esta vacia...");
		}
		else{
			Nodo Actual=tope;
			do{ 
				System.out.print(Actual.getElemento().toString()+" ");	
				Actual=Actual.siguiente;
			}while(Actual != null);
			System.out.println();//imprime un salto de linea
		}
	 } 		   
//	public static void main(String[]args){
//		Pila p=new Pila();
//		p.apilar("1");
//		p.apilar("2");
//		p.apilar("3");
//		p.apilar("4");
//		p.imprimir();
//		p.desApilar();
//		p.imprimir();
//                  }
}