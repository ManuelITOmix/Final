/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package polaka;

/**
 *
 * @author parti
 */
import java.util.LinkedList;
import java.util.*;
public class AnalizadorIP{  
	private LinkedList PROCEDENCIA; 
    private  Pila pila;
    public AnalizadorIP() {
    	  Operador ope;
          PROCEDENCIA=new LinkedList();
          ope=new Operador("^",4,5);PROCEDENCIA.add(ope);
          ope=new Operador("%",3,4);PROCEDENCIA.add(ope);
          ope=new Operador("*",2,2);PROCEDENCIA.add(ope);
          ope=new Operador("/",2,2);PROCEDENCIA.add(ope);
          ope=new Operador("+",1,1);PROCEDENCIA.add(ope);
          ope=new Operador("-",1,1);PROCEDENCIA.add(ope);
          ope=new Operador("(",0,5);PROCEDENCIA.add(ope);//inicial y maximo
          pila=new Pila();
    }
    public boolean valExpre(String expre){
    	 Pila p=new Pila();
    	 for(int i=0;i<expre.length();i++){
       	      char x=expre.charAt(i);
       	       if(x=='(' | x=='[' | x=='{')
       	       	  p.apilar(x);
       	       else{
       	       	  if(x==')' | x==']' | x=='}')
       	       	     { if(p.vacia()==true) return false;
       	       	        char c=p.desApilar().toString().charAt(0);
       	       	        if( (x==')' & c!='(') | (x==']' & c!='[') | (x=='}' & c!='{'))
       	       	           return false;   
       	       	       }
       	          }    
       	   }
       	return p.vacia();  
    }
    public String aPostfija(String expre)
     { LinkedList expPostfija=new LinkedList();
       if(valExpre(expre)==false) return null;
       for(int c=0;c<expre.length();c++){
       	    char x;int hcer=-1;
       	    x=expre.charAt(c);
       	    if(operador(x)==true) hcer=323;//si es operador direcciona al caso
       	    if(x==')' ) hcer=324;//si es de cierre, 
       	    switch(hcer){
       	    	   case 323:
       	    	           while(pila.vacia()==false) {
       	      	     	      if(pdp(pila.tope.datos)>=pfp(x))
       	      	     	         expPostfija.add(pila.desApilar());
       	      	     	      else
       	      	     	        break;   
       	      	            } 
       	      	        pila.apilar(x);     
       	    	   break;
       	    	   case 324:
       	    	           while(pila.tope.datos.toString().charAt(0)!='(' )
       	      	     	           expPostfija.add(pila.desApilar()); 
       	      	            pila.desApilar(); //para q ignore el parentesis (
       	    	   break;
       	    	   default:
       	    	         expPostfija.add(x);
       	        }
       	    } 
       	  while(pila.vacia()==false) 
       	  	  expPostfija.add(pila.desApilar());
 
       	return cnvCad(expPostfija);  
     }
    public boolean operador(Object c ) {
    	  for(int i=0;i<PROCEDENCIA.size();i++){
    	  	   Operador op=(Operador)PROCEDENCIA.get(i);
    	  	    if(op.OPE.equals(c.toString())) return true;
    	  }
    	  return false;
     }
     public int pdp(Object c ) {
    	  for(int i=0;i<PROCEDENCIA.size();i++){
    	  	   Operador op=(Operador)PROCEDENCIA.get(i);
    	  	   if(op.OPE.equals(c.toString())) return op.PDP;	
 
    	    }
    	  return -1;
     }
     public int pfp(Object c ) {
    	  for(int i=0;i<PROCEDENCIA.size();i++){
    	  	   Operador op=(Operador)PROCEDENCIA.get(i);
    	  	   if(op.OPE.equals(c.toString())) return op.PFP;
    	  }
    	  return -1;
     }
    private String cnvCad(LinkedList ls){
    	 String cad="";
    	 for(int i=0;i<ls.size();i++)
	        cad=cad+ls.get(i).toString().charAt(0);
	     return cad;   
      }
    private static void imprimirLs(LinkedList ls)
     { for(int i=0;i<ls.size();i++)
	        System.out.print(ls.get(i).toString().charAt(0));
	        System.out.println(" ");
      }  
public static void main(String Args[])
  { 
	Scanner ent=new Scanner(System.in);
	System.out.println("Inserte la exprecion en infijo: ");
    String expresion=ent.next();
	    AnalizadorIP AS = new AnalizadorIP();
	    System.out.println("La sentencia es: "+AS.valExpre(expresion));
	    String expPostfija=AS.aPostfija(expresion);
	    if(expPostfija==null)
	      System.out.println("Expresion invalida...");
	    else
	   	  System.out.println(" En PostFijo es: "+expPostfija);
	  }
 
}
